package com.ibm.booking.exception;

public class BookingApplicationException extends Exception{
	
	public BookingApplicationException() {
		super();
	}
	
	public BookingApplicationException(String message,Throwable cause) {
		super(message, cause);
	}

}
