package com.ats.service;

import com.ats.entity.Flight;
import com.ats.entity.Location;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface FlightService {
    boolean flightRegister(Flight flight);

    List<Flight> flightSearchBySrcAndDestAndDepartDate(Location src, Location dest, Date departDate);

    Optional<Flight> flightSearchById(long fId);

    List<Flight> getAllFlights();
}
