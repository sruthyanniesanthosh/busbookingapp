package com.ibm.booking.model;

import java.util.Date;

public class SeatSelection {
	
	String seatNo;
	Date date;
	String userName;
	
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	public SeatSelection(String seatNo, Date date) {
		super();
		this.seatNo = seatNo;
		this.date = date;
	}
	public SeatSelection() {
		super();
	}
	
	
	
	
	
	

}
