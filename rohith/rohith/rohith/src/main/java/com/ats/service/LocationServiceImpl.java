package com.ats.service;

import com.ats.entity.Location;
import com.ats.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    private LocationRepository locationRepository;
    @Override
    public String locationRegister(Location location) {
        Location loc = locationRepository.save(location);
        Optional<Location> ls = locationRepository.findById(loc.getLocationId());
        if (ls.isPresent()){
            return "Location Registered Successfully";
        }
        return "Location not Registered";
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
