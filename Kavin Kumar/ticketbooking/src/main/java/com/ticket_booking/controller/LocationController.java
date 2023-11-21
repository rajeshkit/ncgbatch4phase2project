package com.ticket_booking.controller;

import com.ticket_booking.entity.Location;
import com.ticket_booking.service.AirlineService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/location/")
public class LocationController {

    private final AirlineService airlineService;

    public LocationController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @PostMapping("/location")
    public ResponseEntity<Object> addLocation(@RequestBody @Valid Location location){
        return airlineService.addLocation(location);
    }

    @GetMapping("/locations")
    public ResponseEntity<Object> getAllLocations(){
        return airlineService.getAllLocations();
    }
    @GetMapping("/location/id/{locationId}")
    public ResponseEntity<Object> getLocation(@PathVariable int locationId){
        return airlineService.getLocation(locationId);
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<Object> getLocation(@PathVariable String location){
        return airlineService.getLocation(location);
    }
}
