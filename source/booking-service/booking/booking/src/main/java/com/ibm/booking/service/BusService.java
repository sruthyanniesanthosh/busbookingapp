package com.ibm.booking.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ibm.booking.exception.BookingApplicationException;
import com.ibm.booking.model.Bus;
import com.ibm.booking.repository.BusRepository;

@Service
public class BusService {
	
	@Autowired
	BusRepository busRepo;

	public List<Bus> getByLocation(String source, String destination) {
		// TODO Auto-generated method stub
		return busRepo.getBySourceAndDestination(source,destination);
	}

	

	public boolean create(@Valid Bus bus) throws BookingApplicationException {
		// TODO Auto-generated method stub
		
		try{
			
			busRepo.insert(bus);
			return true;
			}
			catch(DataAccessException e){
				e.printStackTrace();
				throw new BookingApplicationException("User Not Found", e );
			}
		
	}



	public boolean update(Bus updatedBus) throws BookingApplicationException{
		// TODO Auto-generated method stub
		try {
		busRepo.save(updatedBus);
		return true;}
		
		catch(DataAccessException e) {
			e.printStackTrace();
			throw new BookingApplicationException("Bus Not Found", e );
			
		}
		
	}



	public Bus getById(ObjectId _id) {
		// TODO Auto-generated method stub
		return busRepo.getBy_id(_id);
	}

}
