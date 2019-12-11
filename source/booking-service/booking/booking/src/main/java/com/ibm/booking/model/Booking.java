package com.ibm.booking.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Booking {
	@Id
	private ObjectId _id;
    private String userName;
    private String busId;
    private String source;
    private String destination;
    private Date travelDate;
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBusId() {
		return busId;
	}
	public void setBusId(String busId) {
		this.busId = busId;
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
	public Date getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
	public Booking(ObjectId _id, String userName, String busId, String source, String destination, Date travelDate) {
		super();
		this._id = _id;
		this.userName = userName;
		this.busId = busId;
		this.source = source;
		this.destination = destination;
		this.travelDate = travelDate;
	}
    
    
    
    
    
	

}
