package com.example.airticketreservation.service;

import com.example.airticketreservation.entity.Flight;
import com.example.airticketreservation.repository.FlightRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
@Service
public class FlightService implements IFlightService{
    private final FlightRep flightRep;

    @Autowired
    public FlightService(FlightRep flightRep) {
        this.flightRep = flightRep;
    }

    @Override
    public List<Flight> searchFlights(String from, String to, Date departureDate) {
        return flightRep.findBySourceAndDestinationAndDate(from, to, departureDate);
    }
}