package com.ibm.booking.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.booking.model.Booking;

public interface BookingRepository extends MongoRepository<Booking, ObjectId> {

	List <Booking> getByUserName(String name);
	

}
