package com.example.airticket.controller;

import com.example.airticket.service.ILocationService;
import com.example.airticket.entity.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/location-api")
public class LocationController {
    private final ILocationService locationService;
    Logger logger = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    public LocationController(ILocationService locationService){
        this.locationService = locationService;
    }

    @PostMapping(path = "/location_details")
    public Location addLocation(@RequestBody Location location){
        logger.info("To Add new Location");
        return locationService.addLocation(location);
    }

    @GetMapping(path = "/allLocation")
    public ResponseEntity<Object> getAllLocations() {
        logger.info("To get all location details");
        return locationService.getAllLocations();
    }

}
