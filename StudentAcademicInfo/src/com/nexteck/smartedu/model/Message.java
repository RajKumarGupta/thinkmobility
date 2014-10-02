package com.nexteck.smartedu.model;

public class Message {
	
	private Integer MessageId;
	private String UserType;
	private String userName;
	private String MessageHeader;
	private String Description;
	
	public Integer getMessageId() {
		return MessageId;
	}
	public void setMessageId(Integer messageId) {
		MessageId = messageId;
	}
	public String getUserType() {
		return UserType;
	}
	public void setUserType(String userType) {
		UserType = userType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMessageHeader() {
		return MessageHeader;
	}
	public void setMessageHeader(String messageHeader) {
		MessageHeader = messageHeader;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
	
}
