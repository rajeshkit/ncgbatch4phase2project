package com.example.airticketreservation.repository;

import com.example.airticketreservation.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRep extends JpaRepository<Airline,Long> {
}
