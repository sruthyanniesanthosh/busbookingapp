package com.ibm.booking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.booking.model.User;

public interface UserRepository extends MongoRepository<User,String> {
	User findBy_id(String _id);
	User findByName(String name);
    Long deleteByName(String name);

}
