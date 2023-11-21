package com.example.airticket.service;

import com.example.airticket.entity.Location;
import com.example.airticket.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements ILocationService {
    private final LocationRepository locationRepository;
    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository){
        this.locationRepository=locationRepository;
    }

    @Override
    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public ResponseEntity<Object> getAllLocations() {
        List<Location> locations = locationRepository.findAll();
        if (locations.isEmpty()) {
            String msg = "Location table is empty";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        } else {
            return ResponseEntity.ok(locations);
        }
    }
}
