package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.FlightBookingDto;
import com.app.service.flightbooking.IFlightBooking;

@RestController
@RequestMapping("flight-booking")
public class FlightBookingController {
	
	@Autowired
	private IFlightBooking flightBookingService;
	
	@GetMapping("/bookingid/{flightBookingId}")
	public ResponseEntity<FlightBookingDto> getFlightBookingById(@PathVariable Long flightBookingId)
	{
		return ResponseEntity.ok(flightBookingService.getFlightBookingById(flightBookingId));
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<FlightBookingDto>> getAllFlightsBooking(){
		return ResponseEntity.ok(flightBookingService.getAllFlightBooking());
	}

}
