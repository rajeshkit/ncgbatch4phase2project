package com.ticket_booking.service;

import com.ticket_booking.entity.Airline;
import com.ticket_booking.entity.Flight;
import com.ticket_booking.entity.Location;
import org.springframework.http.ResponseEntity;

public interface AirlineServiceInterface {


    ResponseEntity<Object> register(Airline airline);

    ResponseEntity<Object> login(Airline airline);

    ResponseEntity<Object> addLocation(Location location);

    ResponseEntity<Object> addFlight(Flight flight);

    ResponseEntity<Object> getAllLocations();

    ResponseEntity<Object> getLocation(int locationId);

    ResponseEntity<Object> getLocation(String location);

    ResponseEntity<Object> getFlights();

    ResponseEntity<Object> logout();
}
