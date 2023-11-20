package com.example.airticket.controller;

import com.example.airticket.service.IFlightService;
import com.example.airticket.entity.Flight;
import com.example.airticket.entity.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/flight-api")
public class FlightController {
    private final IFlightService flightService;
    Logger logger = LoggerFactory.getLogger(FlightController.class);
    @Autowired
    public FlightController(IFlightService flightService){
        this.flightService = flightService;
    }

    @PostMapping(path = "/flightDeatils")
    public Flight createFlight(@RequestBody Flight flight){
        logger.info("To register new flights");
        return flightService.createFlight(flight);
    }

    @GetMapping(path = "/find")
    public ResponseEntity<Object> searchAvailableFlights(@RequestParam Location source,@RequestParam Location destination,@RequestParam String date) {
        logger.info("To see avaliable flights from particular source and destination");
        return flightService.searchAvailableFlights(source, destination, date);
    }

    @GetMapping(path = "/getFlightById")
    @ResponseBody
    public ResponseEntity<Object> getFlightById(@RequestParam("id") long id){
        logger.info("Fetching details of particular id");
        return flightService.getFlightById(id);
    }

    @GetMapping(path="/all")
    public ResponseEntity<Object> getAllFlights(){
        logger.info("To get all flight deatils");
        return  flightService.getAllFlights();
    }
}
