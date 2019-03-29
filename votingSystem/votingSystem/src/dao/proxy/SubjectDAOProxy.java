package dao.proxy;

import java.sql.SQLException;
import java.util.List;
import dao.imp.SubjectDAOImpl;
import dao.inf.BaseQueryModel;
import dao.inf.ISubjectDao;
import util.Dbhelp;

public class SubjectDAOProxy implements ISubjectDao{

	private ISubjectDao iSubjectDao=null;
	public SubjectDAOProxy() throws SQLException {
	this.iSubjectDao=new SubjectDAOImpl(Dbhelp.getConnection());
	}
	@Override
	public int insert(Object data) throws Exception {
		return this.iSubjectDao.insert(data);
	}
	@Override
	public List<Object> findAll() throws Exception {
		return this.iSubjectDao.findAll();
	}
	@Override
	public Object findOne(int id) throws Exception {
		return this.iSubjectDao.findOne(id);
	}
	@Override
	public int delete(int id) throws Exception {
		return this.iSubjectDao.delete(id);
	}
	@Override
	public int update(Object object) throws Exception {
		return this.iSubjectDao.update(object);
	}
	@Override
	public List<Object> findByCondition(BaseQueryModel queryModel) throws Exception {
		return this.iSubjectDao.findByCondition(queryModel);
	}
	@Override
	public Long findLastAddId() throws Exception {
		
		return this.iSubjectDao.findLastAddId();
	}
	
	
}
