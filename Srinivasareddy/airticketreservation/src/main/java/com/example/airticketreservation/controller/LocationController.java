package com.example.airticketreservation.controller;

import com.example.airticketreservation.entity.Location;
import com.example.airticketreservation.service.ILocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/air-ticket")
public class LocationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationController.class);

    private final ILocationService locationService;

    @Autowired
    public LocationController(ILocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/locations")
    public ResponseEntity<List<Location>> getLocations() {
        LOGGER.info("Request received to get the list of locations.");

        List<Location> locations = locationService.getLocations();

        if (locations.isEmpty()) {
            LOGGER.info("No locations found.");
            return ResponseEntity.noContent().build();
        } else {
            LOGGER.info("Returning {} locations.", locations.size());
            return ResponseEntity.ok(locations);
        }
    }
}
