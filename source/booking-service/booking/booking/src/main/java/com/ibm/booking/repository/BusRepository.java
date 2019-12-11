package com.ibm.booking.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.booking.model.Bus;


public interface BusRepository extends  MongoRepository<Bus,ObjectId>{

}
