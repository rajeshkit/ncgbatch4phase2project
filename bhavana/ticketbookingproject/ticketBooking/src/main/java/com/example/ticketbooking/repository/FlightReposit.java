package com.example.ticketbooking.repository;

import com.example.ticketbooking.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface FlightReposit extends JpaRepository<Flight,Integer> {
    List<Flight> findBySourceAndDestinationAndDepartureDate(String source, String destination, Date departureDate);
}
