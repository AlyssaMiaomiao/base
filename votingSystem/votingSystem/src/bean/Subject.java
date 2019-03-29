package bean;

import java.util.ArrayList;
import java.util.List;

import util.DateFormatToView;
public class Subject {
	public static final int SINGLE=1;//单选
	public static final int MULTI=2 ;//多选
	
	private Long id;
	private String title;
	private Integer number;//投票的类型，1，是单选    2.是多选
	private Long startTime;
	private Long endTime;
	private Long userId;
	
	private User user;//外键的处理
	private List<Option> options;//选项
	//视图属性，用于显示的
	private String startTimeView;
	private String endTimeView;
	
	public Subject() {
		super();
		this.options=new ArrayList<Option>();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
		this.startTimeView=DateFormatToView.toViewDate(this.startTime);
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
		this.endTimeView=DateFormatToView.toViewDate(this.endTime);
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	public String getStartTimeView() {
		return startTimeView;
	}
	public String getEndTimeView() {
		return endTimeView;
	}
}
