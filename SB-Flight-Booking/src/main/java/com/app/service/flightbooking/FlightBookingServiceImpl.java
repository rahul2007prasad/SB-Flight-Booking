package com.app.service.flightbooking;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.FlightBookingDto;
import com.app.exception.ResourceNotFoundException;
import com.app.pojos.FlightBooking;
import com.app.repo.FlightBookingRepository;

@Service
public class FlightBookingServiceImpl implements IFlightBooking{

	@Autowired
	private FlightBookingRepository flightBookingRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public FlightBookingDto getFlightBookingById(Long flightBookingId) {
		FlightBooking flightBooking = flightBookingRepo.findById(flightBookingId)
				.orElseThrow(()-> new ResourceNotFoundException("Flight Booking", "Flight Id", flightBookingId));
		
		return flightBookingToDto(flightBooking);
	}

	@Override
	public List<FlightBookingDto> getAllFlightBooking() {
		List<FlightBooking> flightBookings = flightBookingRepo.findAll();
		List<FlightBookingDto> flightBookingDtos = flightBookings.stream()
				.map(flightBooking -> flightBookingToDto(flightBooking)).collect(Collectors.toList());
		
		return flightBookingDtos;
	}
	
	
	public FlightBookingDto flightBookingToDto(FlightBooking flightBooking) {
		
		FlightBookingDto flightBookingDto = modelMapper.map(flightBooking, FlightBookingDto.class);
		return flightBookingDto;
		
	}

}
