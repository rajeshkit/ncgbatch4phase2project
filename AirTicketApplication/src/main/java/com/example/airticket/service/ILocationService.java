package com.example.airticket.service;

import com.example.airticket.entity.Location;
import org.springframework.http.ResponseEntity;

public interface ILocationService {
    Location addLocation(Location location);
    ResponseEntity<Object> getAllLocations();
}
