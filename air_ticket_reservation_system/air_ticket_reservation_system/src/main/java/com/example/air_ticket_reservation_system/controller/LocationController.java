package com.example.air_ticket_reservation_system.controller;

import com.example.air_ticket_reservation_system.entity.LocationMaster;
import com.example.air_ticket_reservation_system.serviceinterfaces.ILocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("location-api")
public class LocationController {
    @Autowired
    private ILocation iLocation;

    @PostMapping("/add-location")
    public LocationMaster createLocation(@RequestBody LocationMaster locationMaster){
        return iLocation.createLocation(locationMaster);
    }
}
