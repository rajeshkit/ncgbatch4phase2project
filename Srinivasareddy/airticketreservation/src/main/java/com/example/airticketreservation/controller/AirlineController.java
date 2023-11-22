package com.example.airticketreservation.controller;

import com.example.airticketreservation.entity.Airline;
import com.example.airticketreservation.service.IAirlineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/air-ticket")
public class AirlineController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AirlineController.class);

    private final IAirlineService airlineService;

    @Autowired
    public AirlineController(IAirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping("/airlines")
    public ResponseEntity<List<Airline>> getAirlines() {
        LOGGER.info("Request received to get the list of airlines.");
        List<Airline> airlines = airlineService.getAirlines();
        if (airlines.isEmpty()) {
            LOGGER.warn("No airlines found.");
            return ResponseEntity.noContent().build();
        }
        LOGGER.info("Returning the list of airlines: {}", airlines);
        return ResponseEntity.ok(airlines);
    }
}