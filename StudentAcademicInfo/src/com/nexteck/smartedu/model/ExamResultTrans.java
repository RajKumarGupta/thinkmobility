package com.nexteck.smartedu.model;

public class ExamResultTrans {
	
	private Integer ExamId;
	private String Subject;
	private String MinMarks;
	private String MaxMarks;
	private String Marksgain;
	private String status;
	
	
	public Integer getExamId() {
		return ExamId;
	}
	public void setExamId(Integer examId) {
		ExamId = examId;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getMinMarks() {
		return MinMarks;
	}
	public void setMinMarks(String minMarks) {
		MinMarks = minMarks;
	}
	public String getMaxMarks() {
		return MaxMarks;
	}
	public void setMaxMarks(String maxMarks) {
		MaxMarks = maxMarks;
	}
	public String getMarksgain() {
		return Marksgain;
	}
	public void setMarksgain(String marksgain) {
		Marksgain = marksgain;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
