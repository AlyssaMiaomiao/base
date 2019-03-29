package dao.proxy;

import java.sql.SQLException;
import java.util.List;
import dao.imp.OptionDAOImpl;
import dao.inf.BaseQueryModel;
import dao.inf.IOptionDao;
import util.Dbhelp;

public class OptionDAOProxy implements IOptionDao {
	private IOptionDao iOptionDao=null;
	public OptionDAOProxy() throws SQLException {
		this.iOptionDao=new OptionDAOImpl(Dbhelp.getConnection());
	}
	@Override
	public int insert(Object data) throws Exception {
		return this.iOptionDao.insert(data);
	}
	@Override
	public List<Object> findAll() throws Exception {
		return this.iOptionDao.findAll();
	}
	@Override
	public Object findOne(Long id) throws Exception {
		return this.iOptionDao.findOne(id);
	}
	@Override
	public int delete(Long id) throws Exception {
		return this.iOptionDao.delete(id);
	}
	@Override
	public int update(Object object) throws Exception {
		return this.iOptionDao.update(object);
	}
	@Override
	public List<Object> findByCondition(BaseQueryModel queryModel) throws Exception {
		return this.iOptionDao.findByCondition(queryModel);
	}
	@Override
	public Long findLastAddId() throws Exception {
		
		return this.iOptionDao.findLastAddId();
	}
	@Override
	public void deleteOptions(Long Subjectid) throws Exception {
		this.iOptionDao.deleteOptions(Subjectid);
		
	}
	
}
