package com.example.airticketreservation.repository;

import com.example.airticketreservation.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface FlightRep extends JpaRepository<Flight,Long> {
    @Query( value ="select * from Flight f where f.departureCity =:departureCity and f.arrivalCity =:arrivalCity and f.dateOfDeparture =:dateOfDeparture ", nativeQuery = true)
    List<Flight> findBySourceAndDestinationAndDate(@Param("departureCity")String from, @Param("arrivalCity")String to, @Param("dateOfDeparture")Date departureDate);
}