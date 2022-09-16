package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PassengerDto;
import com.app.pojos.Passenger;
import com.app.service.passenger.IPassengerService;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	private IPassengerService passengerService;
	
	@GetMapping("/passenger-list")
	public ResponseEntity<List<PassengerDto>> getAllPassenger(){
		return ResponseEntity.ok(passengerService.getAllPassenger());
	}
	
	@GetMapping("/passengerId/{passergerId}")
	public ResponseEntity<PassengerDto> getPassengerById(@PathVariable Long passergerId){
		return ResponseEntity.ok(passengerService.getPassengerById(passergerId));
	}
	
	//register passenger
	
	@PostMapping("/register")
	public ResponseEntity<?> registerPassenger(@RequestBody Passenger passenger){
		System.out.println("In register new User");
		return new ResponseEntity<> (passengerService.registerPassenger(passenger),HttpStatus.CREATED);
	}
	
}
