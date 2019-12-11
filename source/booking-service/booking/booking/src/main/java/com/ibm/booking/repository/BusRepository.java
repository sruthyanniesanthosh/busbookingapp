package com.ibm.booking.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.booking.model.Bus;


public interface BusRepository extends  MongoRepository<Bus,ObjectId>{

	List<Bus> getBySourceAndDestination(String source, String destination);

	Bus getBy_id(ObjectId _id);

}
