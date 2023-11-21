package com.ats.controller;

import com.ats.entity.Flight;
import com.ats.entity.Location;
import com.ats.exception.FlightIdNotFoundException;
import com.ats.exception.FlightNotFoundException;
import com.ats.service.FlightService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ats/flight-api")
public class FlightController {
    private FlightService flightService;

    Logger logger = LoggerFactory.getLogger(FlightController.class);

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }


    @PostMapping("/flight")
    public ResponseEntity<String> flightRegister(@RequestBody @Valid Flight flight){

        boolean isRegistered = flightService.flightRegister(flight);
        if (isRegistered) {
            logger.info("Flight registered");
            return ResponseEntity.ok("Flight registered successfully");
        } else {
            logger.error("Flight registered Fail");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
        }
    }

    @GetMapping("/flight/{id}")
    public Optional<Flight> flightSearchById(@PathVariable("id") long fId) throws FlightIdNotFoundException {
        if (flightService.flightSearchById(fId).isEmpty()){
            logger.error("Flight NotFound");
            throw new FlightIdNotFoundException("FlightId is not Found");
        }
        logger.info("Flight Found");
        return flightService.flightSearchById(fId);
    }

    @GetMapping("/flight/{src}/{dest}/{departDate}")
    public List<Flight> flightSearchBySrcAndDestAndDepartDate(@PathVariable("src") Location src, @PathVariable("dest") Location dest, @PathVariable("departDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date departDate) throws FlightNotFoundException {
        if (flightService.flightSearchBySrcAndDestAndDepartDate(src,dest,departDate).isEmpty()){
            logger.error("Flights not Found");
            throw new FlightNotFoundException("No Flight is available for given data");
        }
        logger.info("Flights Found");
        return flightService.flightSearchBySrcAndDestAndDepartDate(src,dest,departDate);
    }

    @GetMapping("/flights")
    public List<Flight> getAllFlights(){
        logger.info("AllFlights");
        return flightService.getAllFlights();
    }
}
