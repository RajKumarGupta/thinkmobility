package com.nexteck.smartedu.model;

public class Holidays {
	
	private Integer HolidayId;
	private String Holiday;
	private String FromDate;
	private String ToDate;
	private Integer SessionId;
	
	public Integer getHolidayId() {
		return HolidayId;
	}
	public void setHolidayId(Integer holidayId) {
		HolidayId = holidayId;
	}
	public String getHoliday() {
		return Holiday;
	}
	public void setHoliday(String holiday) {
		Holiday = holiday;
	}
	public String getFromDate() {
		return FromDate;
	}
	public void setFromDate(String fromDate) {
		FromDate = fromDate;
	}
	public String getToDate() {
		return ToDate;
	}
	public void setToDate(String toDate) {
		ToDate = toDate;
	}
	public Integer getSessionId() {
		return SessionId;
	}
	public void setSessionId(Integer sessionId) {
		SessionId = sessionId;
	}

	
}
