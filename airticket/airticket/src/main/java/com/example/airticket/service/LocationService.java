package com.example.airticket.service;

import com.example.airticket.entity.Location;
import com.example.airticket.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationService implements LocationServiceImpl {
    private final LocationRepository locationRepository;
    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getLocationDetails() {

        return locationRepository.findAll();
    }

}
