package com.nexteck.smartedu.model;

public class Vaccination {
	private Integer Id;
	private String Name;
	private String DueOn;
	private String GivenOn;
	private Integer Weight;
	private String DoctorName;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDueOn() {
		return DueOn;
	}
	public void setDueOn(String dueOn) {
		DueOn = dueOn;
	}
	public String getGivenOn() {
		return GivenOn;
	}
	public void setGivenOn(String givenOn) {
		GivenOn = givenOn;
	}
	public Integer getWeight() {
		return Weight;
	}
	public void setWeight(Integer weight) {
		Weight = weight;
	}
	public String getDoctorName() {
		return DoctorName;
	}
	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
	}
	
	
}
