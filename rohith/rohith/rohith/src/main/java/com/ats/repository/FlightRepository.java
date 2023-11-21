package com.ats.repository;

import com.ats.entity.Flight;
import com.ats.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Long> {
    List<Flight> findBySourceIdAndDestinationIdAndDepartDate(Location src, Location dest, Date departDate);
}
