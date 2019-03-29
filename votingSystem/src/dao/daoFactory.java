package dao;

import dao.inf.IOptionDao;
import dao.inf.IRecordDao;
import dao.inf.ISubjectDao;
import dao.inf.IUserDao;
import dao.proxy.OptionDAOProxy;
import dao.proxy.RecordDAOProxy;
import dao.proxy.SubjectDAOProxy;
import dao.proxy.UserDAOProxy;

public class daoFactory {
	public static IUserDao getIUserDAOInstance() throws Exception {
		return new UserDAOProxy();
	}

	public static IOptionDao getIOptionDAOInstance() throws Exception {
		return new OptionDAOProxy() ;
		
	}
	
	public static IRecordDao getIRecordDAOInstance() throws Exception{
		return new RecordDAOProxy() ;
		
	}
	
	public static ISubjectDao getISubjectDAOInstance() throws Exception{
		return new SubjectDAOProxy() ;
		
	}
}
