package com.app.pojos;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="flightbooking")
public class FlightBooking {
	
	@Id
	private Long id;
	
	@Override
	public String toString() {
		return "FlightBooking [id=" + id + ", passenger=" + passenger + ", flights=" + flights + "]";
	}

	public FlightBooking(Long id, Passenger passenger, Set<Flight> flights) {
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

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}

	@ManyToOne
	private Passenger passenger;
	
	@ManyToMany
	@JoinTable(name="booking_flights" , joinColumns = @JoinColumn(name = "booking_id"), inverseJoinColumns = @JoinColumn(name = "flight_id"))
	private Set<Flight> flights;
	

}
