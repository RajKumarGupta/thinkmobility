package com.nexteck.smartedu.model;

public class Candidate {
	private Integer CandidateId;
	private String Name;
	private String Sex;
	private String DOB;
	private String Clas;
	private String RollNumber;
	private String CandidateAddress;
	private String Phone;
	private String Mobile;
	private String Email;
	
	public Integer getCandidateId() {
		return CandidateId;
	}
	public void setCandidateId(Integer candidateId) {
		CandidateId = candidateId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getClas() {
		return Clas;
	}
	public void setClas(String class1) {
		Clas = class1;
	}
	public String getRollNumber() {
		return RollNumber;
	}
	public void setRollNumber(String rollNumber) {
		RollNumber = rollNumber;
	}
	public String getCandidateAddress() {
		return CandidateAddress;
	}
	public void setCandidateAddress(String candidateAddress) {
		CandidateAddress = candidateAddress;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
}
