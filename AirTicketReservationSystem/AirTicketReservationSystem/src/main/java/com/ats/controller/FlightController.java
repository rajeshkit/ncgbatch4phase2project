package com.ats.controller;

import com.ats.entity.Flight;
import com.ats.exception.AdminException;
import com.ats.exception.FlightException;
import com.ats.service.IFlightService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ats")
public class FlightController {
    private final IFlightService flightService;
    private final Logger logger = LoggerFactory.getLogger(FlightController.class);

    @Autowired
    public FlightController(IFlightService flightService) {
        this.flightService = flightService;
    }

    //admin endpoints

    @PostMapping("/admin/flight/add")
    public ResponseEntity<Flight> addFlightHandler(@Valid @RequestBody Flight flight, @RequestParam(required = false) String key) throws FlightException, AdminException {
        logger.info("Received request to add flight with details: {}", flight);
        Flight newFlight = flightService.addFlight(flight, key);
        logger.info("Flight added successfully. Flight details: {}", newFlight);
        return new ResponseEntity<>(newFlight, HttpStatus.CREATED);
    }

    @PutMapping("/admin/flight/update")
    public ResponseEntity<Flight> updateFlightHandler(@Valid @RequestBody Flight flight, @RequestParam(required = false) String key) throws FlightException, AdminException {
        logger.info("Received request to update flight with details: {}", flight);
        Flight updatedFlight = flightService.updateFlight(flight, key);
        logger.info("Flight updated successfully. Updated flight details: {}", updatedFlight);
        return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
    }

    @DeleteMapping("/admin/flight/delete/{flightId}")
    public ResponseEntity<Flight> deleteFlightHandler(@PathVariable("flightId") Integer flightId, @RequestParam(required = false) String key) throws FlightException, AdminException {
        logger.info("Received request to delete flight with flightId: {}", flightId);
        Flight deletedFlight = flightService.deleteFlight(flightId, key);
        logger.info("Flight deleted successfully. Deleted flight details: {}", deletedFlight);
        return new ResponseEntity<>(deletedFlight, HttpStatus.OK);
    }

    //shared endpoints (user and admin both)
    @GetMapping("/flight/all")
    public ResponseEntity<List<Flight>> getAllFlightsHandler() throws FlightException {
        logger.info("Received request to get all flights.");
        List<Flight> allFlights = flightService.viewAllFlights();
        logger.info("Total flights: {}", allFlights.size());
        return new ResponseEntity<>(allFlights, HttpStatus.OK);
    }

    @GetMapping("/flight/{flightId}")
    public ResponseEntity<Flight> getFlightByIdHandler(@PathVariable("flightId") Integer flightId) throws FlightException {
        logger.info("Received request to get flight by id: {}", flightId);
        Flight flight = flightService.viewFlight(flightId);
        logger.info("Flight details: {}", flight);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @GetMapping("/flight/type/{flightType}")
    public ResponseEntity<List<Flight>> getFlightsByFlightTypeHandler(@PathVariable("flightType") String flightType) throws FlightException {
        logger.info("Received request to get flights by flight type: {}", flightType);
        List<Flight> flightList = flightService.viewFlightByFlightType(flightType);
        logger.info("Total flights of type {}: {}", flightType, flightList.size());
        return new ResponseEntity<>(flightList, HttpStatus.OK);
    }
}
