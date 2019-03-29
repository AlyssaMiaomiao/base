package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import bean.Subject;
import bean.SubjectQueryModel;
import dao.inf.BaseQueryModel;
import dao.inf.ISubjectDao;
import util.Dbhelp;

public class SubjectDAOImpl extends BaseDAOImpl implements ISubjectDao {

	private Connection connection=null;
	public SubjectDAOImpl(Connection connection) {
		super(connection);
		this.connection=connection;
	}
	@Override
	public String getInsertSql(Object data) {
		Subject subject=(Subject)data;
		String sql="insert into t_subject (title,number,starttime,endtime,userId) "
				+ "values('"+subject.getTitle()+"',"+subject.getNumber()+","+subject.getStartTime()+","+subject.getEndTime()+","+subject.getUserId()+")";
		return sql;
	}
	@Override
	public String getFindAllSql() {
		String sql="select * from t_subject";
		return sql ;
	}
	@Override
	public String getDeleteSql(Long id) {
		String sql="delete from t_subject where id="+id;
		return sql;
	}
	@Override
	public String getUpdateSql(Object object) {
		Subject subject=(Subject)object;
		String sql="update t_subject set title='"+subject.getTitle()+"',number="+subject.getNumber()+
				" ,starttime="+subject.getStartTime()+", endtime="+subject.getEndTime()+" , userId="+subject.getUserId()+" where id="+subject.getId();
		return sql;
	}
	@Override
	public String getFindByCondition(BaseQueryModel queryModel) {
		SubjectQueryModel qm = (SubjectQueryModel)queryModel;
		StringBuffer sb=new StringBuffer();
		sb.append("select * from t_subject");
		sb.append(" where 1=1 ");
		if(qm.getTitle()!=null&&qm.getTitle().trim().length()>0){
			sb.append(" and title='"+qm.getTitle()+"'");
		}
		if(qm.getNumber()!=null){
			sb.append(" and number="+qm.getNumber()+"");
		}
		if(qm.getStartTime()!=null){
			sb.append("and starttime="+qm.getStartTime());
		}
		if(qm.getEndTime()!=null){
			sb.append("and endtime="+qm.getEndTime());
		}
		if(qm.getUserId()!=null){
			sb.append("and userId="+qm.getUserId());
		}
		return sb.toString();
		
	}
	@Override
	public Object resToObject(ResultSet reSet) throws Exception {
		Subject subject=new Subject();
		
		subject.setId(reSet.getLong(1));
		subject.setTitle(reSet.getString(2));
		subject.setNumber(reSet.getInt(3));
		subject.setStartTime(reSet.getLong(4));
		subject.setEndTime(reSet.getLong(5));
		subject.setUserId(reSet.getLong(6));
		return subject;
	}
	@Override
	public int getUserCount(Long subjectId) throws Exception {
		int result = 0;
		
		String sql = "SELECT COUNT(DISTINCT userId) as count FROM t_record WHERE subjectId="+subjectId;
		PreparedStatement pst = connection.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
			result = rs.getInt("count");
		}
		Dbhelp.closeAll(null, rs, pst);
		return result;
	}


	
}
