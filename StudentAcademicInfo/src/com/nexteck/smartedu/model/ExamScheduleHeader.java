package com.nexteck.smartedu.model;

public class ExamScheduleHeader {
	private Integer ExamId;
	private String Name;
	private String StartDate;
	private String EndDate;
	private String Description;
	
	public Integer getExamId() {
		return ExamId;
	}
	public void setExamId(Integer examId) {
		ExamId = examId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
}
