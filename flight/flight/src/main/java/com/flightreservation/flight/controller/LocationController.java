package com.flightreservation.flight.controller;

import com.flightreservation.flight.entity.Location;
import com.flightreservation.flight.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location-api")

public class LocationController {
    private final ILocationService locationService;
@Autowired
    public LocationController(ILocationService locationService) {
        this.locationService = locationService;
    }

    @ResponseBody
    @PostMapping(path="/get")
    public String findLocation() {
        return locationService.findLocation();
    }
    @ResponseBody
    @GetMapping(path="/get")
    public List<Location> getAllLocations(){
    return locationService.getAllLocations();
    }


}
