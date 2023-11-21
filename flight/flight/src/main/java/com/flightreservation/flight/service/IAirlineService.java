package com.flightreservation.flight.service;

import com.flightreservation.flight.entity.Airline;

import java.util.List;
import java.util.Optional;

public interface IAirlineService {
    public List<Airline> getAllAirlines();
    public Optional<Airline> getLocation(int id);
    public Airline registerAirline(Airline airline);

}
