package com.example.airticket.service;

import com.example.airticket.entity.Flight;
import com.example.airticket.entity.Location;
import org.springframework.http.ResponseEntity;

public interface IFlightService {

    Flight createFlight(Flight flight);
    ResponseEntity<Object> searchAvailableFlights(Location source, Location destination, String date);

    ResponseEntity<Object> getFlightById(long flightNumber);

    ResponseEntity<Object> getAllFlights();
}
