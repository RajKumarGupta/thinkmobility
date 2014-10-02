package com.nexteck.smartedu.model;

public class Attandance {
	
	private Integer CandidateId;
	private String AttandenceDate;
	private Integer Presence;
	
	
	public Integer getCandidateId() {
		return CandidateId;
	}
	public void setCandidateId(Integer candidateId) {
		CandidateId = candidateId;
	}
	public String getAttandenceDate() {
		return AttandenceDate;
	}
	public void setAttandenceDate(String attandenceDate) {
		AttandenceDate = attandenceDate;
	}
	public Integer getPresence() {
		return Presence;
	}
	public void setPresence(Integer presence) {
		Presence = presence;
	}
	
	
}
