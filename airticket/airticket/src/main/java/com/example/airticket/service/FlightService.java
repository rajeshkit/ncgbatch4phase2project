package com.example.airticket.service;

import com.example.airticket.entity.Flight;
import com.example.airticket.exception.FlightNotFoundException;
import com.example.airticket.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService implements FlightServiceImpl{
    private final FlightRepository flightRepository;
    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
        public List<Flight> searchAvailableFlights(String source, String destination, Date date) throws FlightNotFoundException {
            return flightRepository.findBySrcAndDestAndDate(source, destination, date);
        }

    @Override
    public Optional<Flight> getFlightById(int id) {
        return Optional.empty();
    }
}
