package com.app.service.passenger;

import java.util.List;

import com.app.dto.PassengerDto;
import com.app.pojos.Passenger;


public interface IPassengerService {
	
	PassengerDto getPassengerById(Long passengerId);
	
	List<PassengerDto> getAllPassenger();
	
	PassengerDto registerPassenger(Passenger passenger);
	
	

}
