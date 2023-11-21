package com.example.air_ticket_reservation_system.service;

import com.example.air_ticket_reservation_system.entity.LocationMaster;
import com.example.air_ticket_reservation_system.repository.LocationRepository;
import com.example.air_ticket_reservation_system.serviceinterfaces.ILocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService implements ILocation {
    @Autowired
    private LocationRepository locationRepository;
    @Override
    public LocationMaster createLocation(LocationMaster locationMaster) {
        return locationRepository.save(locationMaster);
    }
}
