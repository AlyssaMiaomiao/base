package dao.imp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;
import bean.UserQueryModel;
import dao.inf.BaseQueryModel;
import dao.inf.IUserDao;

public class UserDAOImpl  extends BaseDAOImpl implements IUserDao {

	private Connection connection=null;
	
	public UserDAOImpl(Connection connection) {
	
		super(connection);
	 this.connection=connection;
	}

	@Override
	public String getInsertSql(Object data ) {
	
		User user =(User)data;
		String sql="insert into t_user (`NAME`,pwd,nickname,online) values"
				+ "('"+user.getName()+"' , '"+user.getPwd()+"' , '"+user.getNickname()+"',"+user.getOnLine()+")";
		return sql ;
	}

	@Override
	public String getFindAllSql() {
	
		String sql="select * from t_user";
		return sql ;
	}

	@Override
	public String getDeleteSql(int id) {

		String sql="delete from t_user where id="+id;
		return sql;
	}

	@Override
	public String getUpdateSql(Object object) {

		User user=(User)object;
		String sql="update t_user set `NAME` ='"+user.getName()+"' , pwd='"+user.getPwd()+"' ,nickname='"+user.getNickname()+"',online="+user.getOnLine()+" where id="+user.getId()+"";
		return sql;
	}

	@Override
	public String getFindByCondition(BaseQueryModel queryModel) {

		UserQueryModel userQueryModel=(UserQueryModel)queryModel;
		StringBuffer buffer=new StringBuffer();
		buffer.append("select * from t_user");
		buffer.append(" where 1=1 ");//保证sql语句中不出现多余的and
		if(userQueryModel.getName()!=null&&userQueryModel.getName().trim().length()>0)
		{
			buffer.append("and `NAME`='"+userQueryModel.getName()+"'");
		}
		
		if(userQueryModel.getPwd()!=null&&userQueryModel.getPwd().trim().length()>0)
		{
			buffer.append("and pwd='"+userQueryModel.getPwd()+"'");
		}
		if(userQueryModel.getOnLine()!=null)
		{
			buffer.append("and online="+userQueryModel.getOnLine()+"");
		}
		return buffer.toString();
	}

	@Override
	public Object resToObject(ResultSet reSet) throws Exception {
		User user=new User();
		user.setId(reSet.getLong(1));
		user.setName(reSet.getString(2));
		user.setPwd(reSet.getString(3));
		user.setNickname(reSet.getString(4));
		user.setOnLine(reSet.getInt(5));
		return user;
	}



	
	

}
