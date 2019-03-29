package service.impl;

import java.util.Date;
import java.util.List;

import bean.Option;
import bean.OptionQueryModel;
import bean.Subject;
import bean.SubjectQueryModel;
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
	if (subject.getOptions()==null||subject.getTitle()==null||subject.getNumber()==null) {
		throw new RuleException("请填写完整的投票信息");
	}
	if (subject.getNumber()==2&&subject.getOptions().size()<=2) {
		throw new RuleException("请增加选项，不符合多选哦！");
	}if (subject.getOptions().size()<2) {
		throw new RuleException("请增加选项,无法进行投票哦！");
	}
	subject.setUserId(user.getId());
	long time= new Date().getTime();
	subject.setStartTime(time);
	subject.setEndTime(time+24*60*60*1000);
	this.subjectDao.insert(subject);
	subject.setId(this.optionDao.findLastAddId());
	int i=1;
		for (Option option : subject.getOptions()) {
			option.setIdx(i++);
			option.setSubjectId(subject.getId());
			this.optionDao.insert(option);
		}
	}
	@Override
	public List<Subject> getSubjectList() throws Exception {
	List<Subject> list=	(List<Subject>)(Object)subjectDao.findAll();
	if (list!=null&&list.size()>0) {
		for (Subject subject : list) {
			OptionQueryModel optionQueryModel=new OptionQueryModel();
			optionQueryModel.setSubjectId(subject.getId());
			subject.setOptions((List<Option>)(Object)optionDao.findByCondition(optionQueryModel));
			subject.setUserCount(subjectDao.getUserCount(subject.getId()));
		}
		
	}
	
		return list;
	}
	@Override
	public Subject getSubjectById(long id) throws Exception {
		Subject subject=(Subject) subjectDao.findOne(id);
		OptionQueryModel queryModel=new OptionQueryModel();
		queryModel.setSubjectId(id);
		subject.setOptions((List<Option>)(Object)optionDao.findByCondition(queryModel));
		subject.setUserCount(subjectDao.getUserCount(id));
		return subject;
	}
	@Override
	public List<Subject> getSubjectByUserId(long userId) throws Exception {
		SubjectQueryModel queryModel=new SubjectQueryModel();
		queryModel.setUserId(userId);
		List<Subject> list=	(List<Subject>)(Object)subjectDao.findByCondition(queryModel);
		if (list!=null&&list.size()>0) {
			for (Subject subject : list) {
				OptionQueryModel optionQueryModel=new OptionQueryModel();
				optionQueryModel.setSubjectId(subject.getId());
				subject.setOptions((List<Option>)(Object)optionDao.findByCondition(optionQueryModel));
				subject.setUserCount(subjectDao.getUserCount(subject.getId()));
			}
			
		}
		return  list;
	}
	@Override
	public void updateVote(Subject subject, User user) throws RuleException {
		if (subject.getOptions()==null||subject.getTitle()==null||subject.getNumber()==null) {
			throw new RuleException("请填写完整的投票信息");
		}
		if (subject.getNumber()==2&&subject.getOptions().size()<=2) {
			throw new RuleException("请增加选项，不符合多选哦！");
		}if (subject.getOptions().size()<2) {
			throw new RuleException("请增加选项,无法进行投票哦！");
		}
		try {
			int userCount=subjectDao.getUserCount(subject.getId());
			if (userCount!=0) {
				throw new RuleException("此投票已经有人参与，无法修改！");
			}else {
				subject.setUserId(user.getId());
				subjectDao.update(subject);
				optionDao.deleteOptions(subject.getId());
				int idx=1;
				for (Option option : subject.getOptions()) {
					option.setSubjectId(subject.getId());
					option.setIdx(idx++);
					optionDao.insert(option);
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
