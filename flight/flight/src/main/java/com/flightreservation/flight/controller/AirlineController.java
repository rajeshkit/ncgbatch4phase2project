package com.flightreservation.flight.controller;

import com.flightreservation.flight.entity.Airline;
import com.flightreservation.flight.service.IAirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airline-api")

public class AirlineController {

    private final IAirlineService airlineService;
    @Autowired
    public AirlineController(IAirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @ResponseBody
    @GetMapping(path="/get")
    public List<Airline> getAllAirlines(){
        return airlineService.getAllAirlines();
    }
    @ResponseBody
    @GetMapping(path="/id")
    public Optional<Airline> getLocation(@RequestBody int id){
        return airlineService.getLocation(id);
    }


    @ResponseBody
    @PostMapping(path="/register")
    public Airline registerAirline(@RequestBody Airline airline) {
        return airlineService.registerAirline(airline);
    }
}
