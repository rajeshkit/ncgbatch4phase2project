package com.example.atrs.service;

import com.example.atrs.dto.FlightFetch;
import com.example.atrs.entity.FlightMaster;
import com.example.atrs.entity.LocationMaster;

import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.util.List;

public interface FlightService {
     ResponseEntity<Object> registerFlight(FlightMaster flightMaster);
     FlightMaster searchFlightById(int flightId);
     ResponseEntity<Object> searchFlight(FlightFetch flightFetch);

    List<Object> searchFlight1(LocationMaster sourceId, LocationMaster destinationId, Date dprDate) ;
    List<FlightMaster> getAllFlight();

}
