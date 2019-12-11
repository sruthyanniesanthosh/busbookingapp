package com.ibm.booking.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ibm.booking.exception.BookingApplicationException;
import com.ibm.booking.model.User;
import com.ibm.booking.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	PasswordEncoder encoder;
	
	
	public boolean create(User user) throws BookingApplicationException
	{
		try{
		user.set_id(ObjectId.get());
		user.setPassword(encoder.encode(user.getPassword()));
		user.setSecurityqn(user.getSecurityqn());
		user.setAnswer(user.getAnswer());
		userRepo.save(user);
		return true;
		}
		catch(DataAccessException e){
			e.printStackTrace();
			throw new BookingApplicationException("User Not Found", e );
		}
		
	}
	
	
	public User getUser(String _id)
	{
		
		return userRepo.findByName(_id);
		
	}
	
	public boolean update(User updatedUser, ObjectId _id) throws BookingApplicationException {
	try {	
		updatedUser.set_id(_id);
		
		userRepo.save(updatedUser);
		return true;
	}
	catch(DataAccessException e) {
		e.printStackTrace();
		throw new BookingApplicationException("User Not Found", e );
		
	}
	}


	public boolean delete(String name) {
		// TODO Auto-generated method stub
		Long x = userRepo.deleteByName(name);
		return true;
	}
	
}


