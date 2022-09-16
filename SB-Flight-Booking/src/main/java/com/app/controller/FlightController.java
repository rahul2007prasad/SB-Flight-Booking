package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.FlightDto;
import com.app.service.flight.IFlightService;

@RestController
@RequestMapping("/flights")
public class FlightController {
	
	@Autowired
	private IFlightService flightService;
	
	@GetMapping("/flight-list")
	public ResponseEntity<List<FlightDto>> getAllFlights(){
		return ResponseEntity.ok(flightService.getAllFlight());
	}
	
	@GetMapping("/flidghtId/{flightId}")
	public ResponseEntity<FlightDto> getFlightById(@PathVariable Long flightId){
		return ResponseEntity.ok(flightService.getFlightById(flightId));
	}
}
