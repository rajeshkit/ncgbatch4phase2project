package com.example.airticket.controller;

import com.example.airticket.entity.Airline;
import com.example.airticket.service.IAirlineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/airline-api")
public class AirController {
    private  final IAirlineService airlineService;
    Logger logger = LoggerFactory.getLogger(AirController.class);

    @Autowired
    public AirController(IAirlineService airlineService){
        this.airlineService = airlineService;
    }


    @PostMapping(path = "/airlineDetails")
    public Airline createAirline(@RequestBody Airline airLine){
        logger.info("Registering new AirLine");
        return airlineService.createAirline(airLine);
    }


    @GetMapping(path = "/allAirLines")
    public ResponseEntity<Object> getAllLocations() {
        logger.info(("To Display all Flight details.."));
        return airlineService.getAllAirlines();
    }
}
