package dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import bean.Option;
import bean.OptionQueryModel;
import dao.inf.BaseQueryModel;
import dao.inf.IOptionDao;

public class OptionDAOImpl extends BaseDAOImpl implements IOptionDao  {
	private Connection connection=null;
	
	public OptionDAOImpl(Connection connection) {
		super(connection);
		this.connection=connection;
	}

	@Override
	public String getInsertSql(Object data) {

		Option option =(Option)data;
		String sql="insert into t_user (content,idx,subjectId) values"
				+ "('"+option.getContent()+"',"+option.getIdx()+","+option.getSubjectId()+")";
		return sql ;
	}

	@Override
	public String getFindAllSql() {

		String sql="select * from t_option";
		return sql ;
	}

	@Override
	public String getDeleteSql(int id) {

		String sql="delete from t_option where id="+id;
		return sql;
	}

	@Override
	public String getUpdateSql(Object object) {
		
		Option option=(Option)object;
		String sql="update t_Option set content='"+option.getContent()+"',idx="+option.getIdx()+",subjectid="+option.getSubjectId()+"where id="+option.getId()+"";
		return sql;
	}

	@Override
	public String getFindByCondition(BaseQueryModel queryModel) {
	
		OptionQueryModel qm = (OptionQueryModel)queryModel;
		StringBuffer sb=new StringBuffer();
		sb.append("select * from t_option");
		sb.append(" where 1=1 ");
		if(qm.getContent()!=null&&qm.getContent().trim().length()>0){
			sb.append(" and content='"+qm.getContent()+"'");
		}
		if(qm.getIdx()>0){
			sb.append("and idx="+qm.getIdx());
		}
		if(qm.getSubjectId()>0){
			sb.append("and subjectId="+qm.getSubjectId());
		}
		return sb.toString();
		
	}

	@Override
	public Object resToObject(ResultSet reSet) throws Exception {
		Option option=new Option();
		option.setId(reSet.getLong(1));
		option.setContent(reSet.getString(2));
		option.setIdx(reSet.getInt(3));
		option.setSubjectId(reSet.getLong(4));
		return option;
	}

	
}
