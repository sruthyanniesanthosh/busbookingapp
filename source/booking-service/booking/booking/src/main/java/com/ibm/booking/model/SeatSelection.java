package com.ibm.booking.model;

import java.util.Date;

public class SeatSelection {
	
	int seatNo;
	Date date;
	
	
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	public SeatSelection(int seatNo, Date date) {
		super();
		this.seatNo = seatNo;
		this.date = date;
	}
	public SeatSelection() {
		super();
	}
	
	
	
	
	

}
