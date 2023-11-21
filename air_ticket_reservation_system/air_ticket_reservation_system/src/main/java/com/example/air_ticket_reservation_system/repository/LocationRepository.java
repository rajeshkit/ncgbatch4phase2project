package com.example.air_ticket_reservation_system.repository;

import com.example.air_ticket_reservation_system.entity.LocationMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationMaster,Integer> {
}
