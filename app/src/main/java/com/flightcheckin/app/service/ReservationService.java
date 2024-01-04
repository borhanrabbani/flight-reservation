package com.flightcheckin.app.service;

import com.flightcheckin.app.dto.ReservationRequest;
import com.flightcheckin.app.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
