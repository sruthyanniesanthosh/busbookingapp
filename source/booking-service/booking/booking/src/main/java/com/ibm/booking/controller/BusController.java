package com.ibm.booking.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibm.booking.exception.BookingApplicationException;
import com.ibm.booking.model.Bus;
import com.ibm.booking.model.ResponseMessage;
import com.ibm.booking.model.User;
import com.ibm.booking.service.BusService;

@RestController
@CrossOrigin("*")
public class BusController {
	
	@Autowired
	BusService busService;

	@GetMapping(value="/bus",produces = {MediaType.APPLICATION_JSON_VALUE})
	@CrossOrigin("*")
	public List<Bus> getByLocation(@RequestParam("source") String source , @RequestParam("destination") String destination ){
	
		return busService.getByLocation(source,destination);
		
	}
	
	@PostMapping(value="/bus",consumes = { MediaType.APPLICATION_JSON_VALUE }) 
	@CrossOrigin("*")
	public ResponseEntity<ResponseMessage> createBus( @Valid @RequestBody Bus bus) throws BookingApplicationException
	{
		
		boolean x=busService.create(bus);
		ResponseMessage res;
		
		 if(x) {
		
		res = new ResponseMessage("Success", new String[] {"Bus added successfully"});
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(bus.get_id()).toUri();
		return ResponseEntity.created(location).body(res);
		 }
		 else
		 {
			 res = new ResponseMessage("Failure", new String[] {"User not added"});
				URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(bus.get_id()).toUri();
				return ResponseEntity.created(location).body(res);
		 }
		
		
	}
	
	
	@PutMapping(value="bus/{id}")
	@CrossOrigin("*")
	public ResponseEntity<ResponseMessage> updateBus(@PathVariable ObjectId id, @RequestBody Bus updatedBus) {
	updatedBus.set_id(id);
		System.out.println("update prop-"+updatedBus);
		busService.update(updatedBus);
		ResponseMessage res;
		res = new ResponseMessage("Success", new String[] {"Bus Updated successfully"});
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(id).toUri();
		return ResponseEntity.created(location).body(res);
		
	}
	
}

