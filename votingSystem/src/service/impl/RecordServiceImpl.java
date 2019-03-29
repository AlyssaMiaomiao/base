package service.impl;

import java.util.Date;
import java.util.List;

import bean.Record;
import bean.RecordQueryModel;
import bean.Subject;
import dao.daoFactory;
import dao.inf.IRecordDao;
import dao.inf.ISubjectDao;
import service.RecordService;
import service.exception.RuleException;

public class RecordServiceImpl implements RecordService {

	IRecordDao recordDao=null;
	ISubjectDao subjectDao=null;
		public RecordServiceImpl() throws Exception {
		recordDao=daoFactory.getIRecordDAOInstance();
		subjectDao=daoFactory.getISubjectDAOInstance();
		}
		@Override
		public void addRecord(Long subjectId, Long userId, String[] optionIds) throws Exception {
			if (optionIds==null) {
				throw new RuleException("你还没有选择！");
			}
			Subject subject=(Subject)subjectDao.findOne(subjectId);
			if (subject.getEndTime()>new Date().getTime()) {
				throw new RuleException("投票时间已过！");
			}
			RecordQueryModel recordQueryModel=new RecordQueryModel();
			recordQueryModel.setSubjectId(subjectId);
			recordQueryModel.setUserId(userId);
			List list=recordDao.findByCondition(recordQueryModel);
			if (list!=null) {
				throw new RuleException("您已经参加过投票啦，谢谢参与！");
			}
			for (String optionId : optionIds) {
				Record record=new Record();
				record.setOptionId(Long.parseLong(optionId));
				record.setSubjectId(subjectId);
				record.setUserId(userId);
				recordDao.insert(record);
			}
			
		}
	
	


}
