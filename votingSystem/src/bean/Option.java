package bean;

public class Option {
	private Long id;
	private String content;
	private Integer idx;
	private Long subjectId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getIdx() {
		return idx;
	}
	public void setIdx(Integer idx) {
		this.idx = idx;
	}
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	@Override
	public String toString() {
		return "Option [id=" + id + ", content=" + content + ", idx=" + idx + ", subjectId=" + subjectId + "]";
	}
	
	

}
