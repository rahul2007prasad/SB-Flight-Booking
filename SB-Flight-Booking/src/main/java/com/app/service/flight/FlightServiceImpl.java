package com.app.service.flight;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.FlightDto;
import com.app.exception.ResourceNotFoundException;
import com.app.pojos.Flight;
import com.app.repo.FlightRepository;

@Service
public class FlightServiceImpl implements IFlightService {
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public FlightDto getFlightById(Long flightId) {
		System.out.println("in getFlight By id" + flightId);
		Flight fId = flightRepo.findById(flightId).orElseThrow(
				()-> new ResourceNotFoundException("Flight", "ID", flightId));
		System.out.println("Flight details :" +fId);
		
		
				return flightToDto(fId);
	}

	@Override
	public List<FlightDto> getAllFlight() {
		System.out.println("in get all flight list");
		List<Flight> flights = flightRepo.findAll();
		List<FlightDto> flightDtos = flights.stream()
				.map(flight -> flightToDto(flight)).collect(Collectors.toList());
		
		return flightDtos;
	}
	
	public FlightDto flightToDto(Flight flight) {
		FlightDto flightDto =modelMapper.map(flight, FlightDto.class);
		return flightDto;
		
	}

}
