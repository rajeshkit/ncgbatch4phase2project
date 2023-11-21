package com.example.airticketreservation.service;

import com.example.airticketreservation.entity.Location;
import com.example.airticketreservation.repository.LocationRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationService implements ILocationService{

    private final LocationRep locationRep;

    @Autowired
    public LocationService(LocationRep locationRep) {
        this.locationRep = locationRep;
    }

    @Override
    public List<Location> getLocations() {
        return locationRep.findAll();
    }
}
