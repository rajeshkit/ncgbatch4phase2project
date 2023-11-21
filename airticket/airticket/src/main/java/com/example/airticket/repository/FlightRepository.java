package com.example.airticket.repository;

import com.example.airticket.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Long> {

    List<Flight> findBySrcAndDestAndDate(String source, String destination, Date date);
}
