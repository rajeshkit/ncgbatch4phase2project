package com.example.airticket.service;

import com.example.airticket.entity.Airline;
import org.springframework.http.ResponseEntity;


public interface IAirlineService {
    Airline createAirline(Airline airLine);

    ResponseEntity<Object> getAllAirlines();
}
