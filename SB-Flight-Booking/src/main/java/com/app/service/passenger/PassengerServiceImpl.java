package com.app.service.passenger;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.PassengerDto;
import com.app.exception.ResourceNotFoundException;
import com.app.pojos.Passenger;
import com.app.repo.PassengerRepository;

@Service
@Transactional
public class PassengerServiceImpl implements IPassengerService{

	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public PassengerDto getPassengerById(Long passengerId) {
		System.out.println("In getByPassengerId "+ passengerId);
		Passenger pid = passengerRepo.findById(passengerId).orElseThrow(
				()-> new ResourceNotFoundException("Passenger" , "Id" ,passengerId));
		System.out.println("Pasenger Details :" +pid);
		return passengerToDto(pid);
	}

	@Override
	public List<PassengerDto> getAllPassenger() {
		System.out.println("In getAllPassenger");
		List<Passenger > passengers = passengerRepo.findAll();
		List<PassengerDto> passengerDtos = passengers.stream()
				.map(passenger -> passengerToDto(passenger)).collect(Collectors.toList());
		
		
		
		return passengerDtos;
	}
	
	
	@Override
	public PassengerDto registerPassenger(Passenger passenger) {
		System.out.println("In register passenger");
		Passenger savePassenger = passengerRepo.save(passenger);
		
		return passengerToDto(savePassenger);
	}

	
	
	//Conversion of Passenger to PassengerDto
	
	public PassengerDto passengerToDto(Passenger passenger) {
		PassengerDto passengerDto = modelMapper.map(passenger, PassengerDto.class);
		return passengerDto;
	}

	
}
