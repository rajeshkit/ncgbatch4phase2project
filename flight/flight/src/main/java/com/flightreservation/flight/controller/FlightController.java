package com.flightreservation.flight.controller;

import com.flightreservation.flight.entity.Flight;
import com.flightreservation.flight.entity.Location;
import com.flightreservation.flight.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight-api")


public class FlightController {
    private final IFlightService flightService;
@Autowired
    public FlightController(IFlightService flightService) {
        this.flightService = flightService;
    }

    @ResponseBody
    @GetMapping(path="/getsource")
    public List<Flight> getFlightsBySource(@RequestBody Location source)  {
        return flightService.getFlightsBySource(source);
    }
    @ResponseBody
    @GetMapping(path="/getdest")
    public List<Flight> getFlightsByDestination(@RequestBody Location dest) {
        return flightService.getFlightsByDestination(dest);
    }
    @ResponseBody
    @GetMapping(path="/getall")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }



}
