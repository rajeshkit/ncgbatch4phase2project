package com.example.airticketreservation.controller;

import com.example.airticketreservation.entity.Flight;
import com.example.airticketreservation.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;
@RestController
@RequestMapping("/air-ticket")
public class FlightController {
    private final IFlightService flightService;

    @Autowired
    public FlightController(IFlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Flight>> searchFlights(
            @RequestParam("from")String from,
            @RequestParam("to")String to,
            @RequestParam("departureDate") Date departureDate)
    {
        List<Flight> availableFlights = flightService.searchFlights(from, to, departureDate);
        return availableFlights.isEmpty()?
                ResponseEntity.noContent().build():
                ResponseEntity.ok(availableFlights);
    }
}