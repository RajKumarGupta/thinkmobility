package com.nexteck.smartedu.model;

public class HealthCheckHeader {
	
	private Integer ContribuiterCheckID;
	private Integer ContributerTypeId;
	private String Name;
	private String CheckDateTime;
	private String Description;
	
	public Integer getContribuiterCheckID() {
		return ContribuiterCheckID;
	}
	public void setContribuiterCheckID(Integer contribuiterCheckID) {
		ContribuiterCheckID = contribuiterCheckID;
	}
	public Integer getContributerTypeId() {
		return ContributerTypeId;
	}
	public void setContributerTypeId(Integer contributerTypeId) {
		ContributerTypeId = contributerTypeId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCheckDateTime() {
		return CheckDateTime;
	}
	public void setCheckDateTime(String checkDateTime) {
		CheckDateTime = checkDateTime;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

	
}
