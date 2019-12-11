package com.ibm.booking.controller;

import java.net.URI;
import java.security.Principal;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibm.booking.exception.BookingApplicationException;
import com.ibm.booking.model.ResponseMessage;
import com.ibm.booking.model.User;
import com.ibm.booking.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	UserService userService;
	

	
	
//USER REGISTRATION
	@PostMapping(value="/user",consumes = { MediaType.APPLICATION_JSON_VALUE }) 
	@CrossOrigin("*")
	public ResponseEntity<ResponseMessage> createUser( @Valid @RequestBody User user) throws BookingApplicationException
	{
		
		boolean x=userService.create(user);
		ResponseMessage res;
		
		 if(x) {
		
		res = new ResponseMessage("Success", new String[] {"User added successfully"});
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(user.get_id()).toUri();
		return ResponseEntity.created(location).body(res);
		 }
		 else
		 {
			 res = new ResponseMessage("Failure", new String[] {"User not added"});
				URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(user.get_id()).toUri();
				return ResponseEntity.created(location).body(res);
		 }
		
		
	}
	
	
	@PostMapping(value="/user/auth")
	@CrossOrigin("*")
	public Principal authenticate(Principal user)
	{
//		log.debug("LoggedIn User: " + user);
		
		
		return user;
		
	}
	
		
	//USER LOGIN GET USER BY ID
	@GetMapping(value="/user/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public User getUserById(@PathVariable("id") String id) throws BookingApplicationException
	{
//		log.debug("In user login");
		return userService.getUser(id);
		
	}
	
	//USER EDIT
	@PutMapping(value="/user/{id}", produces = {MediaType.APPLICATION_JSON_VALUE} , consumes = {MediaType.APPLICATION_JSON_VALUE} )
	@CrossOrigin("*")
	public ResponseEntity<ResponseMessage> updateUser(@PathVariable ObjectId id, @RequestBody User updatedUser) throws BookingApplicationException {
		
		boolean x = userService.update(updatedUser, id);
		ResponseMessage res;
		
		 if(x) {
		
		res = new ResponseMessage("Success", new String[] {"User Updated successfully"});
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(id).toUri();
		return ResponseEntity.created(location).body(res);
		 }
		 else
		 {
			 res = new ResponseMessage("Failure", new String[] {"User not updated"});
				URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(id).toUri();
				return ResponseEntity.created(location).body(res);
		 }
	}
	
	
	@DeleteMapping(value="/user/{id}")
	@CrossOrigin("*")
	public boolean deleteUser(@PathVariable String id) {
		
		boolean x = userService.delete(id);
		 return x;
	
	}
	

}
