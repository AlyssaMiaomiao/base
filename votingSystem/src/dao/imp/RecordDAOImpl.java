package dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import bean.Record;
import bean.RecordQueryModel;
import dao.inf.BaseQueryModel;
import dao.inf.IRecordDao;

public class RecordDAOImpl extends BaseDAOImpl implements IRecordDao {
	private Connection connection=null;
	public RecordDAOImpl(Connection connection) {
		super(connection);
		this.connection=connection;
	}
	@Override
	public String getInsertSql(Object data) {
		Record record =(Record)data;
		String sql="insert into t_record (subjectId,optionId,userId)values("+record.getSubjectId()+","+record.getOptionId()+","+record.getUserId()+") ";
		return sql;
	}
	@Override
	public String getFindAllSql() {
		String sql="select * from t_record";
		return sql ;
	}
	@Override
	public String getDeleteSql(Long id) {
		String sql="delete from t_record where id="+id;
		return sql;
	}
	@Override
	public String getUpdateSql(Object object) {
		Record record =(Record)object;
		String sql="update t_record set subjectId="+record.getSubjectId()+",optionId="+record.getOptionId()+",userId="+record.getUserId()+"where id="+record.getId()+"";
		return sql;
	}
	@Override
	public String getFindByCondition(BaseQueryModel queryModel) {
		RecordQueryModel qm = (RecordQueryModel)queryModel;
		StringBuffer sb=new StringBuffer();
		sb.append("select * from t_record");
		sb.append(" where 1=1 ");
		if(qm.getSubjectId()!=null){
			sb.append(" and subjectId="+qm.getSubjectId()+"");
		}
		if(qm.getOptionId()!=null){
			sb.append(" and optionId="+qm.getOptionId()+"");
		}
		if(qm.getUserId()!=null){
			sb.append("and userId="+qm.getUserId());
		}
		return sb.toString();
	}
	@Override
	public Object resToObject(ResultSet reSet) throws Exception {
		Record record=new Record();
		record.setId(reSet.getLong(1));
		record.setSubjectId(reSet.getLong(2));
		record.setOptionId(reSet.getLong(3));
		record.setUserId(reSet.getLong(4));
		return record;
	}
	
}
