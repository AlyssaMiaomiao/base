package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;



public class Dbhelp {
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
	private static ThreadLocal<Connection> cons=new ThreadLocal<Connection>();
	
	public static Connection getConnection() throws SQLException {
		if (cons.get()==null) {
			cons.set(dataSource.getConnection());
		}
		return cons.get();
	}
	
	public static void closeAll (Connection con,ResultSet res, PreparedStatement pStatement) throws SQLException {
		if (res!=null) {
			res.close();
		}
		if (pStatement!=null) {
			pStatement.close();
		}
		if (con!=null) {
			con.close();
		}
	}
	
	public static void beginTransaction() throws Exception{
		getConnection().setAutoCommit(false);
	}
	
	public static void commitTransaction() throws Exception{
		getConnection().commit();
	}
	
	public static void rollbackTransaction() throws Exception{
		getConnection().rollback();
	}
	public static void removeTransaction() throws Exception {
		cons.remove();
	}
}
