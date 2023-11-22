package com.example.airticketreservation.controller;

import com.example.airticketreservation.entity.Flight;
import com.example.airticketreservation.service.IFlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/air-ticket")
public class FlightController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

    private final IFlightService flightService;

    @Autowired
    public FlightController(IFlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Flight>> searchFlights(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("departureDate") Date departureDate) {
        LOGGER.info("Request received to search flights from {} to {} on {}", from, to, departureDate);

        List<Flight> availableFlights = flightService.searchFlights(from, to, departureDate);

        return ResponseEntity.ok(availableFlights);
    }
}
