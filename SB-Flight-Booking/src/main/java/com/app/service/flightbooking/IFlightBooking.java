package com.app.service.flightbooking;

import java.util.List;

import com.app.dto.FlightBookingDto;

public interface IFlightBooking {
	
	FlightBookingDto getFlightBookingById(Long flightBookingId);
	
	List<FlightBookingDto> getAllFlightBooking();

}
