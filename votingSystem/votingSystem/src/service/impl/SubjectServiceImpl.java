package service.impl;

import bean.Option;
import bean.Subject;
import bean.User;
import dao.daoFactory;
import dao.inf.IOptionDao;
import dao.inf.ISubjectDao;
import service.SubjectService;
import service.exception.RuleException;

public class SubjectServiceImpl implements SubjectService {

	private ISubjectDao subjectDao=null;
	private IOptionDao optionDao=null;
	public SubjectServiceImpl() throws Exception {
		this.subjectDao=daoFactory.getISubjectDAOInstance();
		this.optionDao=daoFactory.getIOptionDAOInstance();
	}
	@Override
	public void addSubject(Subject subject, User user) throws Exception {
	if (user==null) {
		throw new RuleException("你还没有登录,请登录");
	}
	subject.setUserId(user.getId());
	this.subjectDao.insert(subject);
	subject.setId(this.optionDao.findLastAddId());
	int i=1;
		for (Option option : subject.getOptions()) {
			option.setIdx(i++);
			option.setSubjectId(subject.getId());
			this.optionDao.insert(option);
		}
	}

}
