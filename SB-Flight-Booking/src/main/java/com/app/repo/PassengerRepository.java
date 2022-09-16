package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Flight;
import com.app.pojos.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long>{

}
