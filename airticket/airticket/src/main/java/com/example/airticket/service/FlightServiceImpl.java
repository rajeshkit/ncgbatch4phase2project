package com.example.airticket.service;

import com.example.airticket.entity.Flight;
import com.example.airticket.exception.FlightNotFoundException;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface FlightServiceImpl {
        List<Flight> searchAvailableFlights(String source, String destination, Date date) throws FlightNotFoundException;

         Optional<Flight> getFlightById(int id);
}


