package com.flightreservation.flight.repository;

import com.flightreservation.flight.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAirlineRepo extends JpaRepository<Airline,Integer> {
}
