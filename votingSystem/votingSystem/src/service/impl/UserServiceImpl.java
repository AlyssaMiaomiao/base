package service.impl;

import java.util.List;
import bean.User;
import bean.UserQueryModel;
import dao.daoFactory;
import dao.inf.IUserDao;
import service.UserService;
import service.exception.RuleException;
import util.Md5Class;

public class UserServiceImpl implements UserService {
	private IUserDao userDao=null;
	public UserServiceImpl() {
		try {
			userDao=daoFactory.getIUserDAOInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void register(User user) throws Exception{
		if (user.getName()==null||user.getName().trim().length()==0) {
			throw new RuleException("用户名不能为空");
		}
		if (!user.getPwd().equals(user.getConfirmPwd())) {
			throw new RuleException("两次输入的密码不一致");
		}
		
		if (this.getUserStatus(user.getName())!=-1) {
			throw new RuleException("用户名已经被注册");
		}
		user.setPwd(Md5Class.stringToMd5(user.getPwd()));
		user.setNickname(user.getName());
		user.setOnLine(1);
		userDao.insert(user);
	}


	public User login(User user) throws Exception {
		UserQueryModel qModel=new UserQueryModel();
		qModel.setName(user.getName());
		qModel.setPwd(Md5Class.stringToMd5(user.getPwd()));
		List list=userDao.findByCondition(qModel);
		if (list.size()==1) {
			user=(User) list.get(0);
			if (user.getOnLine()==User.ONLINE) {
				throw new RuleException("你已经登录！！");
			}
			user.setOnLine(user.ONLINE);
			userDao.update(user);
		}else {
			throw new RuleException("用户名不存在或密码错误");
		}
		return user;
	}


	@Override
	public int getUserStatus(String name) throws Exception {
		User user=new User();
		user.setName(name);
		List<Object> list=userDao.findByCondition((UserQueryModel)user);
		List<User> ulList= (List<User>)(Object)list;
		if(ulList.isEmpty())
		{
			return -1;
		}else {	
			return ulList.get(0).getOnLine();
		}
		
		
	}


	@Override
	public User getUserById(int id) throws Exception {
		return (User) userDao.findOne(id);
	}

}
