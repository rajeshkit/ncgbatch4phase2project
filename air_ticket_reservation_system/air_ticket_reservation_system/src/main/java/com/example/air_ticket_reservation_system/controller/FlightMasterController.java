package com.example.air_ticket_reservation_system.controller;

import com.example.air_ticket_reservation_system.entity.FlightMaster;
import com.example.air_ticket_reservation_system.serviceinterfaces.IFlightMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/flight-api")
public class FlightMasterController {
    @Autowired
    private IFlightMaster iFlightMaster;
    @PostMapping("/register-flight")
    public FlightMaster registerFlight(@RequestBody FlightMaster flightMaster){
        return iFlightMaster.registerFlight(flightMaster);
    }

    @PostMapping("/search")
    public Optional<FlightMaster> searchFlights(@PathVariable String searchCriteria) {
        return iFlightMaster.searchFlights(searchCriteria);
    }
}
