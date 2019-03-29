package service;

import bean.User;

public interface UserService {
	public void register(User user) throws Exception;
	public User login(User user) throws Exception;
	public int getUserStatus(String name)throws Exception;
	public User getUserById(int id)throws Exception;
}
