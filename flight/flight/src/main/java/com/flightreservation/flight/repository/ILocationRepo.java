package com.flightreservation.flight.repository;

import com.flightreservation.flight.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocationRepo extends JpaRepository<Location,Integer> {
}
