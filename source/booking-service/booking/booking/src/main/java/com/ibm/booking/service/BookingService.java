package com.ibm.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ibm.booking.exception.BookingApplicationException;
import com.ibm.booking.model.Booking;
import com.ibm.booking.model.Bus;
import com.ibm.booking.model.SeatSelection;
import com.ibm.booking.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	BookingRepository bookingRepo;
	
	public boolean create(Bus bus,SeatSelection seat) throws BookingApplicationException
	{
		try {
		Booking booking= new Booking();
		
		booking.setBusId(bus.get_id());
		booking.setDestination(bus.getDestination());
		booking.setSource(bus.getSource());
		booking.setTravelDate(seat.getDate());
		booking.setUserName(seat.getUserName());
		
		booking.setSeatNo(seat.getSeatNo());
		
		 bookingRepo.save(booking);
		
		
		
		
		return true;
	}
		
		catch(DataAccessException e){
			e.printStackTrace();
			throw new BookingApplicationException("Booking Not Found", e );
	
		}
	

}
}
