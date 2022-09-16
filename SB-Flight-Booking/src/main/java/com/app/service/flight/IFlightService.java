package com.app.service.flight;

import java.util.List;

import com.app.dto.FlightDto;

public interface IFlightService {
	
	FlightDto getFlightById(Long flightId);
	
	List<FlightDto> getAllFlight();

}
