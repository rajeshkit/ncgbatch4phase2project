package com.example.FlightBooking.repository;

import com.example.FlightBooking.entity.LocationMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineMasterRepository extends JpaRepository<LocationMaster,Long> {
}
