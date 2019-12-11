package com.ibm.booking.model;

import java.sql.Time;
import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Bus {
	//private attributes
	@Id
	private ObjectId _id;
	private String busName;
	private String source;
	private String destination;
	private Time departure;
	private Time arrival;
	private int totalSeats;
	private int availableSeats;
	private float price;
	
	
	  ArrayList <SeatSelection> seats= new ArrayList() ;
	
	
	
	
	
	
	
	//getters and setters
	
	public Time getDeparture() {
		return departure;
	}
	public void setDeparture(Time departure) {
		this.departure = departure;
	}
	public Time getArrival() {
		return arrival;
	}
	public void setArrival(Time arrival) {
		this.arrival = arrival;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public ArrayList<SeatSelection> getSeats() {
		return seats;
	}
	public void setSeats(SeatSelection seatObj) {
		System.out.println(seatObj.seatNo);
		this.seats.add(seatObj);
	}
	public String get_id() {
		return _id.toHexString();
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	
	//constructors
	
	
	public Bus(ObjectId _id, String busName, String source, String destination, int totalSeats, int availableSeats) {
		super();
		this._id = _id;
		this.busName = busName;
		this.source = source;
		this.destination = destination;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
	}
	
	
	public Bus() {
		super();
	}
	public Bus(ObjectId _id, String busName, String source, String destination, Time departure, Time arrival,
			int totalSeats, int availableSeats, float price) {
		super();
		this._id = _id;
		this.busName = busName;
		this.source = source;
		this.destination = destination;
		this.departure = departure;
		this.arrival = arrival;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.price = price;
	}
	
	
	
	
	
	
	

	

}
