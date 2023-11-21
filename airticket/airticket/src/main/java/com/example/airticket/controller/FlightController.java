package com.example.airticket.controller;

import com.example.airticket.entity.Flight;

import com.example.airticket.exception.FlightNotFoundException;
import com.example.airticket.exception.RecordNotFoundException;
import com.example.airticket.service.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightServiceImpl flightService;
    @Autowired
    public FlightController(FlightServiceImpl flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Flight>> searchFlights(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam Date date) {

        List<Flight> availableFlights = flightService.searchAvailableFlights(source, destination, date);
        if (availableFlights.isEmpty()) {
            throw new FlightNotFoundException("Enter Valid Flight Details!");
        }
        return ResponseEntity.ok(availableFlights);
    }

    @GetMapping("/findBy-id")
    public ResponseEntity<List<Flight>> getFlightById(@RequestParam("id") int id) {
        Optional<Flight> flightObject = flightService.getFlightById(id);

        if (flightObject.isEmpty()) {
            throw new RecordNotFoundException("No Flight Data exists for given input");
        }

        Flight flight = flightObject.get();
        return new ResponseEntity<>(Collections.singletonList(flight), HttpStatus.OK);
    }
}
