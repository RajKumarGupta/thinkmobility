package com.nexteck.smartedu.model;

public class HealthCheckTrans {
	
	private Integer ContribuiterCheckID;
	private String Type;
	private String SubType;
	private Integer CurrentValue;
	private String Min;
	private Integer Max;
	private String HigherRiskValue;
	private Integer LowerRiskValue;
	
	public Integer getContribuiterCheckID() {
		return ContribuiterCheckID;
	}
	public void setContribuiterCheckID(Integer contribuiterCheckID) {
		ContribuiterCheckID = contribuiterCheckID;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getSubType() {
		return SubType;
	}
	public void setSubType(String subType) {
		SubType = subType;
	}
	public Integer getCurrentValue() {
		return CurrentValue;
	}
	public void setCurrentValue(Integer currentValue) {
		CurrentValue = currentValue;
	}
	public String getMin() {
		return Min;
	}
	public void setMin(String min) {
		Min = min;
	}
	public Integer getMax() {
		return Max;
	}
	public void setMax(Integer max) {
		Max = max;
	}
	public String getHigherRiskValue() {
		return HigherRiskValue;
	}
	public void setHigherRiskValue(String higherRiskValue) {
		HigherRiskValue = higherRiskValue;
	}
	public Integer getLowerRiskValue() {
		return LowerRiskValue;
	}
	public void setLowerRiskValue(Integer lowerRiskValue) {
		LowerRiskValue = lowerRiskValue;
	}
	
	
	
}
