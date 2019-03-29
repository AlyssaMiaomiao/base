package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dao.inf.BaseDao;
import dao.inf.BaseQueryModel;
import util.Dbhelp;


public abstract  class BaseDAOImpl implements BaseDao {

	private Connection connection=null;
	
	public BaseDAOImpl(Connection connection) {
		 this.connection=connection;
	}
	
	@Override
	public int insert(Object data) throws Exception {
		
		String sql=getInsertSql(data);
		PreparedStatement pStatement=this.connection.prepareStatement(sql);
		int rows= pStatement.executeUpdate();
		Dbhelp.closeAll(null, null, pStatement);
		return rows;
	}
	
	
	@Override
	public List<Object> findAll() throws Exception {
		PreparedStatement pStatement=this.connection.prepareStatement(getFindAllSql());
		ResultSet resultSet=pStatement.executeQuery();
		List<Object> list=new ArrayList<Object>();
		while (resultSet.next()) {
			list.add(resToObject(resultSet));
		}
		Dbhelp.closeAll(null, resultSet, pStatement);
		return list;
	}

	@Override
	public Object findOne(Long id) throws Exception {
		
		String sql=getFindAllSql()+" where id="+id;
		PreparedStatement pStatement=this.connection.prepareStatement(sql);
		ResultSet reSet=pStatement.executeQuery();
		Object object = null;
		if(reSet.next()) {
			 object=resToObject(reSet);
		}
		Dbhelp.closeAll(null, reSet, pStatement);
		return object;
	}
	
	@Override
	public int delete(Long id) throws Exception {
		
		String sql=getDeleteSql(id);
		PreparedStatement pStatement=this.connection.prepareStatement(sql);
		int rows=pStatement.executeUpdate();
		Dbhelp.closeAll(null, null, pStatement);
		return rows;
	}

		@Override
	public int update(Object object) throws Exception {
			String sql=getUpdateSql(object);
			PreparedStatement pStatement=this.connection.prepareStatement(sql);
			int rows=pStatement.executeUpdate();
			Dbhelp.closeAll(null, null, pStatement);
			return rows;
	}

	@Override
	public List<Object> findByCondition(BaseQueryModel queryModel) throws Exception {
		
		String sql=getFindByCondition(queryModel);
		PreparedStatement pStatement=this.connection.prepareStatement(sql);
		ResultSet resultSet=pStatement.executeQuery();
		List<Object> list=new ArrayList<Object>();
		while (resultSet.next()) {
			list.add(resToObject(resultSet));
		}
		Dbhelp.closeAll(null, resultSet, pStatement);
		return list;
	}

	
	public Long findLastAddId() throws Exception {
				String sql = "SELECT LAST_INSERT_ID() AS lastid";
				PreparedStatement pst = connection.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				Long result = null;
				if (rs.next()) {
					result = rs.getLong("lastid");
				}
				Dbhelp.closeAll(null,rs, pst);
				return result;
	}
	
	public abstract String getInsertSql(Object data);
	public abstract String getFindAllSql();
	public abstract String getDeleteSql(Long id);
	public abstract String getUpdateSql(Object object);
	public abstract String getFindByCondition(BaseQueryModel queryMode);
    public abstract Object resToObject(ResultSet reSet)throws Exception;
	
}
