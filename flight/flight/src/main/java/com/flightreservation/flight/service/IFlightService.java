package com.flightreservation.flight.service;

import com.flightreservation.flight.entity.Flight;
import com.flightreservation.flight.entity.Location;

import java.util.List;

public interface IFlightService {
    public List<Flight> getFlightsBySource(Location source);
    public List<Flight> getFlightsByDestination(Location dest);
    public List<Flight> getAllFlights(Location s);

    List<Flight> getAllFlights();
}
