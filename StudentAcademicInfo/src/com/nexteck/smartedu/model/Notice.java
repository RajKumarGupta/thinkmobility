package com.nexteck.smartedu.model;

public class Notice {
	
	private Integer NoticeId;
	private String Subject;
	private String Description;
	private String DisplayDate;
	private String ExpiryDate;
	
	public Integer getNoticeId() {
		return NoticeId;
	}
	public void setNoticeId(Integer noticeId) {
		NoticeId = noticeId;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getDisplayDate() {
		return DisplayDate;
	}
	public void setDisplayDate(String displayDate) {
		DisplayDate = displayDate;
	}
	public String getExpiryDate() {
		return ExpiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		ExpiryDate = expiryDate;
	}

	
}
