package com.app.service.airport;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.AirportDto;
import com.app.exception.ResourceNotFoundException;
import com.app.pojos.Airport;
import com.app.repo.AirportRepository;

@Service
public class AirportServiceImpl implements IAirportService {
	@Autowired
	private AirportRepository airportRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public AirportDto getAirportById(Long airportId) {
		Airport airport = airportRepo.findById(airportId).orElseThrow(
				()-> new ResourceNotFoundException("Airport", "Airport Id", airportId));
		
		return airportToDto(airport);
	}

	@Override
	public List<AirportDto> getAllAirport() {
		List<Airport> airports= airportRepo.findAll(); 
		List<AirportDto> airportDtos = airports.stream()
				.map(airport -> airportToDto(airport)).collect(Collectors.toList());
		return airportDtos;
	}
	
	public AirportDto airportToDto(Airport airport) {
		AirportDto airportDto = modelMapper.map(airport, AirportDto.class);
		return airportDto;
		
	}

}
