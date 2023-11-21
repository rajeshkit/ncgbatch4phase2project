package com.ats.service;

import com.ats.entity.Airline;

import java.util.List;

public interface AirlineService {
    List<Airline> getAllAirlines();

    boolean airlineRegister(Airline airline);
}
