package com.example.air_ticket_reservation_system.repository;

import com.example.air_ticket_reservation_system.entity.FlightMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<FlightMaster,String> {
//    List<FlightMaster> findAllById(String flightId);
}
