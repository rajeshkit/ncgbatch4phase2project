package com.example.air_ticket_reservation_system.repository;

import com.example.air_ticket_reservation_system.entity.AirlineMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<AirlineMaster,String> {
}
