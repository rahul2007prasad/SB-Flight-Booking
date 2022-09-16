package com.app.service.airport;

import java.util.List;

import com.app.dto.AirportDto;

public interface IAirportService {
	AirportDto getAirportById(Long airportId);
	
	List<AirportDto> getAllAirport();

}
