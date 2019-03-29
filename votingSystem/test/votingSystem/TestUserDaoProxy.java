package votingSystem;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;

import bean.User;
import bean.UserQueryModel;
import dao.daoFactory;
import dao.imp.BaseDAOImpl;
import dao.imp.UserDAOImpl;
import dao.inf.BaseQueryModel;
import dao.inf.IUserDao;
import service.UserService;
import service.impl.UserServiceImpl;
import util.DateFormatToView;
import util.Dbhelp;

public class TestUserDaoProxy {
	@Test
	public void testFindAll() {
		User user =new User();
		User user1 =new User();
		user.setName("njnj");
		user.setNickname("sgdf");
		user.setOnLine(1);
		user.setPwd("123");
		IUserDao iUserDao = null;
		try {
			iUserDao = new UserDAOImpl(Dbhelp.getConnection());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			
			iUserDao.insert(user);
			iUserDao.insert(user1);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		//System.out.println(DateFormatToView.toViewDate(new Date().getTime()));
//		try {
//			List<User> list=(List<User>)(Object)daoFactory.getIUserDAOInstance().findAll();
//		System.out.println(list);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			User user=(User)daoFactory.getIUserDAOInstance().findOne((long)1);
//		System.out.println(user);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
//		}
//		User user=new User();
//		user.setName("ys");
//		user.setNickname("as");
//		user.setPwd("971017");
//		user.setOnLine(0);
//		 try {
//			daoFactory.getIUserDAOInstance().insert(user);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			daoFactory.getIUserDAOInstance().delete(2);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		User user=new User();
//		user.setName("ys");
//		user.setNickname("cs");
//		user.setPwd("971017");
//		user.setOnLine(0);
//		user.setId((long)2);
//	try {
//		daoFactory.getIUserDAOInstance().update(user);
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//		
//		UserQueryModel uqueryModel=new UserQueryModel();
//		uqueryModel.setName("ys1");
//		uqueryModel.setOnLine(2);
//		try {
//			List<User> list=(List<User>)(Object)daoFactory.getIUserDAOInstance().findByCondition(uqueryModel);
//			System.out.println(list);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
