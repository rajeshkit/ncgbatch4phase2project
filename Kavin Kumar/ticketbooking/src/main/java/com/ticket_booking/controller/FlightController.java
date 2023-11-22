package com.ticket_booking.controller;

import com.ticket_booking.entity.Flight;
import com.ticket_booking.extras.CreationValidation;
import com.ticket_booking.service.AirlineService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flight")
public class FlightController {

    private final AirlineService airlineService;

    public FlightController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @PostMapping("/flight")
    @Validated
    public ResponseEntity<Object> addFlight(@RequestBody @Validated(CreationValidation.class) Flight flight)
    {
        return airlineService.addFlight(flight);
    }
    @GetMapping("/flights")
    public ResponseEntity<Object> getFlights(){
        return airlineService.getFlights();
    }

}
