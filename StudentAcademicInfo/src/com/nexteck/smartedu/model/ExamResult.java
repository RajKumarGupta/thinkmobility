package com.nexteck.smartedu.model;

public class ExamResult {
	
	private Integer ExamId;
	private String Name;
	private String TotalMarks;
	private String Rank;
	private String Grade;
	private String Status;
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
	public String getTotalMarks() {
		return TotalMarks;
	}
	public void setTotalMarks(String totalMarks) {
		TotalMarks = totalMarks;
	}
	public String getRank() {
		return Rank;
	}
	public void setRank(String rank) {
		Rank = rank;
	}
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String grade) {
		Grade = grade;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

	
}
