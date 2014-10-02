package com.nexteck.smartedu.model;

public class FeesHeader {
	
	private Integer FeesId;
	private String Name;
	private String Amount;
	private String Description;
	private Integer Payment;
	
	public Integer getFeesId() {
		return FeesId;
	}
	public void setFeesId(Integer feesId) {
		FeesId = feesId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Integer getPayment() {
		return Payment;
	}
	public void setPayment(Integer payment) {
		Payment = payment;
	}
	
	
}
