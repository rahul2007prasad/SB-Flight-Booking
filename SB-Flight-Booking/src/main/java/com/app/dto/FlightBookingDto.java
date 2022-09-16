package com.app.dto;


import java.util.Set;


public class FlightBookingDto {
	

	private Long id;
	
	@Override
	public String toString() {
		return "FlightBooking [id=" + id + ", passenger=" + passenger + ", flights=" + flights + "]";
	}

	public FlightBookingDto(Long id, PassengerDto passenger, Set<FlightDto> flights) {
		super();
		this.id = id;
		this.passenger = passenger;
		this.flights = flights;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PassengerDto getPassenger() {
		return passenger;
	}

	public void setPassenger(PassengerDto passenger) {
		this.passenger = passenger;
	}

	public Set<FlightDto> getFlights() {
		return flights;
	}

	public void setFlights(Set<FlightDto> flights) {
		this.flights = flights;
	}


	private PassengerDto passenger;
	
	
	private Set<FlightDto> flights;
	

}
