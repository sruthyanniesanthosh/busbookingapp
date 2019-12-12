package com.ibm.booking.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibm.booking.exception.BookingApplicationException;
import com.ibm.booking.model.Bus;
import com.ibm.booking.model.ResponseMessage;
import com.ibm.booking.model.SeatSelection;
import com.ibm.booking.service.BookingService;
import com.ibm.booking.service.BusService;

@RestController
@CrossOrigin("*")
public class BookingController {
	@Autowired
	BusService busService;
	@Autowired
	BookingService bookingService;
	
	@PostMapping(value="/book/{id}",consumes = { MediaType.APPLICATION_JSON_VALUE ,MediaType.ALL_VALUE})
	@CrossOrigin("*")
	public ResponseEntity<ResponseMessage> bookSeat( @PathVariable ObjectId id, @RequestBody SeatSelection seat) throws BookingApplicationException
	{
		
				
		Bus bus = busService.getById(id);
		System.out.println(seat.getSeatNo());
		
		ArrayList <SeatSelection> list = bus.getSeats();
		System.out.println(list);
		boolean found = false ;
		
		 for(SeatSelection s : list){
		        if(s.getSeatNo().equals(seat.getSeatNo()) && s.getDate().compareTo(seat.getDate())==0)
		        	found=true;
		           //something here
		    }
		 boolean x = false;
		 int newSeat = 0;
		
		if(!found) {
		
		System.out.println(found);
		bus.setSeats(seat);
		System.out.println(bus.getAvailableSeats()-1);
		newSeat = bus.getAvailableSeats()-1;
		
		
		
		System.out.println(bus.getAvailableSeats());
		 x = busService.update(bus);
		
		
		
		
		}
		ResponseMessage res;
		
		if(x) {
			bus.setAvailableSeats(newSeat);
			 x = busService.update(bus);
			 
			 boolean y = bookingService.create(bus,seat);
			 
			 
			
			
		res = new ResponseMessage("Success", new String[] {"Seats added successfully"});
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(bus.get_id()).toUri();
		return ResponseEntity.created(location).body(res);
		}
		else
		{
			res = new ResponseMessage("Failure", new String[] {"Seats not added"});
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(id).toUri();
			return ResponseEntity.created(location).body(res);
		}
		
	}

}
