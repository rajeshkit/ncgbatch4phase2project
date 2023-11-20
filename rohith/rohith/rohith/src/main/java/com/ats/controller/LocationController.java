package com.ats.controller;

import com.ats.entity.Location;
import com.ats.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ats/location-api")
public class LocationController {

    Logger logger = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private LocationService locationService;

    @PostMapping("/location")
    public String locationRegister(@RequestBody Location location){
        logger.trace("Location registered");
        return locationService.locationRegister(location);
    }

    @GetMapping("/locations")
    public List<Location> getAllLocations(){
        logger.info("All Locations");
        return locationService.getAllLocations();
    }
}
