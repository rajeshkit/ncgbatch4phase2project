package com.example.ticketbooking.service;

import com.example.ticketbooking.entity.Location;
import com.example.ticketbooking.repository.LocationReposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements ILocationService {

    private final LocationReposit locationRepository;
    @Autowired
    public LocationServiceImpl(LocationReposit locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
