package com.example.airticketreservation.controller;

import com.example.airticketreservation.entity.Location;
import com.example.airticketreservation.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/air-ticket")
public class LocationController {
    private final ILocationService locationService;

    @Autowired
    public LocationController(ILocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/locations")
    public ResponseEntity<List<Location>> getLocations(){
        List<Location> locations=locationService.getLocations();
        if (locations.isEmpty()){
            return ResponseEntity.noContent().build();
        }return ResponseEntity.ok(locations);
    }
}