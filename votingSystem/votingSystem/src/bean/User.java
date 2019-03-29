package bean;

public class User {
	public static final int ONLINE=2;
	public static final int OFFLINE=1;
	public static final String SESSION_NAME="CurrentUser";
	private Long id;
	private String name;
	private String pwd;
	private String confirmPwd;
	private String nickname;
	private Integer onLine;
	
	
	public Integer getOnLine() {
		return onLine;
	}
	public void setOnLine(Integer onLine) {
		this.onLine = onLine;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + ", nickname=" + nickname + ", onLine=" + onLine
				+ "]";
	}

	
	
	
	
	
}
