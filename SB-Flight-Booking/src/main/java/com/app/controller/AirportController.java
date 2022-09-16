package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AirportDto;
import com.app.service.airport.IAirportService;

@RestController
@RequestMapping("/airports")
public class AirportController {
	
	@Autowired
	private IAirportService airportService;
	
	
	@GetMapping("/airportid/{airportId}")
	public ResponseEntity<AirportDto> getAirportById(@PathVariable Long airportId){
		return ResponseEntity.ok(airportService.getAirportById(airportId));
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<AirportDto>> getAllAirports(){
		return ResponseEntity.ok(airportService.getAllAirport());
	}

}
