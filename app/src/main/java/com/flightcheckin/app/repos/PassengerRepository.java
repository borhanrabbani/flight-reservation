package com.flightcheckin.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightcheckin.app.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
