package com.ticket_booking.repository;

import com.ticket_booking.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Airline,Integer> {
    boolean existsByAirlineId(int airlineId);
    Airline findAirlineByAirlineId(int airlineId);

    boolean existsByAirlineName(String airlineName);

    boolean existsByAirlineIdAndPassword(int airlineId, String password);
}
