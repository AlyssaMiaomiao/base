package dao.proxy;

import java.sql.SQLException;
import java.util.List;
import dao.imp.UserDAOImpl;
import dao.inf.BaseQueryModel;
import dao.inf.IUserDao;
import util.Dbhelp;

public class UserDAOProxy implements IUserDao {
	
	private IUserDao iUserDao=null;
	public UserDAOProxy() throws SQLException {
	
		this.iUserDao=new UserDAOImpl(Dbhelp.getConnection());
	}
	@Override
	public int insert(Object data) throws Exception {

		return this.iUserDao.insert(data);
	}
	@Override
	public List<Object> findAll() throws Exception {
	
		return this.iUserDao.findAll();
	}
	@Override
	public Object findOne(int id) throws Exception {

		return this.iUserDao.findOne(id);
	}
	@Override
	public int delete(int id) throws Exception {

		return this.iUserDao.delete(id);
	}
	@Override
	public int update(Object object) throws Exception {

		return this.iUserDao.update(object);
	}
	@Override
	public List<Object> findByCondition(BaseQueryModel queryModel) throws Exception {

		return this.iUserDao.findByCondition(queryModel);
	}
	@Override
	public Long findLastAddId() throws Exception {
		
		return this.iUserDao.findLastAddId();
	}

	
}
