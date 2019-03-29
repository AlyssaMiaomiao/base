package util.copy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;



public class Dbhelp {
	//定义c3p0的数据库连接池对象
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
	//这条语句是创建了一个线程槽
	//保证同一次请求处理过程中DAO，Filter获取的是同一个连接对象
	//连接对象在线程中应该是唯一的
	//ThreadLocal线程槽：用于在线程中保存数据的集合
	private static ThreadLocal<Connection> cons=new ThreadLocal<Connection>();
	//这个方法用于向数据库获得连接
	
	public static Connection getConnection() throws SQLException {
		if (cons.get()==null) {
			cons.set(dataSource.getConnection());
		}
		
		return cons.get();
	}
	//这个方法用于关闭连接
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
