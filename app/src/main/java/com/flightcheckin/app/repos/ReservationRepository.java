package com.flightcheckin.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightcheckin.app.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
