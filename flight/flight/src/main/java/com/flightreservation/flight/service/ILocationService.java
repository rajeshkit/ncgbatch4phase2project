package com.flightreservation.flight.service;


import com.flightreservation.flight.entity.Location;

import java.util.List;

public interface ILocationService {

    public String findLocation();
    public List<Location> getAllLocations();
}
