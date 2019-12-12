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
	
	public boolean update(User updatedUser, ObjectId objectId) throws BookingApplicationException {
	try {	
		updatedUser.set_id(objectId);
		
		userRepo.save(updatedUser);
		return true;
	}
	catch(DataAccessException e) {
		e.printStackTrace();
		throw new BookingApplicationException("User Not Found", e );
		
	}
	}


	public boolean delete(String name) throws BookingApplicationException {
		try {
		// TODO Auto-generated method stub
		Long x = userRepo.deleteByName(name);
		if(x!=null)
		return true;
		else
			return false;
	}
		catch(DataAccessException e) {
			e.printStackTrace();
			throw new BookingApplicationException("User Not Found", e );
			
		}
	}


	public boolean updatePassword(String name, String password) throws BookingApplicationException{
		// TODO Auto-generated method stub
		try {
		User user = userRepo.findByName(name);
		user.setPassword(encoder.encode(password));
		userRepo.save(user);
		return true;
	}
		
		
		catch(DataAccessException e) {
			e.printStackTrace();
			throw new BookingApplicationException("User Not Found", e );
			
		}
	
}
}


