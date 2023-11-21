package com.example.airticketreservation.repository;

import com.example.airticketreservation.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface FlightRep extends JpaRepository<Flight,Long> {
    @Query( value ="select * from Flight f where f.departure_city =:departureCity and f.arrival_city =:arrivalCity and f.date_of_departure =:dateOfDeparture ", nativeQuery = true)
    List<Flight> findBySourceAndDestinationAndDateIn(@Param("departureCity")String from, @Param("arrivalCity")String to, @Param("dateOfDeparture")Date departureDate);
}