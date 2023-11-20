package com.ats.controller;

import com.ats.entity.Airline;
import com.ats.service.AirlineService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ats/airline-api")
public class AirlineController {

    Logger logger = LoggerFactory.getLogger(AirlineController.class);
    @Autowired
    private AirlineService airlineService;

    @PostMapping("/airline")
    public ResponseEntity<String> airlineRegister(@RequestBody @Valid Airline airline){
        boolean isRegistered = airlineService.airlineRegister(airline);
        if (isRegistered) {
            logger.info("Airline registered");
            return ResponseEntity.ok("Airline registered successfully");
        } else {
            logger.error("Airline register Fail");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
        }
    }


    @GetMapping("/airlines")
    public List<Airline> getAllAirlines(){
        logger.info("All Airlines");
        return airlineService.getAllAirlines();
    }
}
