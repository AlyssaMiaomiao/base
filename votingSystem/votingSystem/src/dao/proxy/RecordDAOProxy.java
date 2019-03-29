package dao.proxy;

import java.sql.SQLException;
import java.util.List;
import dao.imp.RecordDAOImpl;
import dao.inf.BaseQueryModel;
import dao.inf.IRecordDao;
import util.Dbhelp;


public class RecordDAOProxy implements IRecordDao {
	private IRecordDao iRecordDao=null;
	public RecordDAOProxy() throws SQLException {
	this.iRecordDao=new RecordDAOImpl(Dbhelp.getConnection());
	}
	@Override
	public int insert(Object data) throws Exception {
		return this.iRecordDao.insert(data);
	}
	@Override
	public List<Object> findAll() throws Exception {
		return this.iRecordDao.findAll();
	}
	@Override
	public Object findOne(int id) throws Exception {
		return this.iRecordDao.findOne(id);
	}
	@Override
	public int delete(int id) throws Exception {
		return this.iRecordDao.delete(id);
	}
	@Override
	public int update(Object object) throws Exception {
		return this.iRecordDao.update(object);
	}
	@Override
	public List<Object> findByCondition(BaseQueryModel queryModel) throws Exception {
		return this.iRecordDao.findByCondition(queryModel);
	}
	@Override
	public Long findLastAddId() throws Exception {
	
		return this.iRecordDao.findLastAddId();
	}
}
