package votingSystem;

import java.util.List;

import org.junit.Test;

import bean.User;
import bean.UserQueryModel;
import dao.daoFactory;
import dao.imp.BaseDAOImpl;
import dao.inf.BaseQueryModel;

public class TestUserDaoProxy {
	@Test
	public void testFindAll() {
		try {
			List<User> list=(List<User>)(Object)daoFactory.getIUserDAOInstance().findAll();
		System.out.println(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			User user=(User)daoFactory.getIUserDAOInstance().findOne(1);
		System.out.println(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
