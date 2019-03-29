package service;

import java.util.List;

import bean.Subject;
import bean.User;

public interface SubjectService {

	public void addSubject(Subject subject,User user)throws Exception;//添加投票项目
	public List<Subject> getSubjectList() throws Exception;
	public Subject getSubjectById(long id) throws Exception;
	public List<Subject> getSubjectByUserId(long userId) throws Exception;
	public void updateVote(Subject subject, User user)throws Exception;
}
