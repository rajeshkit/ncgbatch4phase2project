package com.flightreservation.flight.repository;

import com.flightreservation.flight.entity.Flight;
import com.flightreservation.flight.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFlightRepo extends JpaRepository<Flight,Integer> {
    List<Flight> findBySource(Location source);

    List<Flight> findByDestination(Location dest);

    boolean existsBySource(Location source);
}
