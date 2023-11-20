package com.ats.service;

import com.ats.entity.Flight;
import com.ats.entity.Location;
import com.ats.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    private FlightRepository flightRepository;
    @Override
    public boolean flightRegister(Flight flight) {
        Flight flight1 = flightRepository.save(flight);
        Optional<Flight> fs = flightRepository.findById(flight1.getFlightId());
        if (fs.isPresent()){
            return true;
        }
        return false;
    }

    @Override
    public List<Flight> flightSearchBySrcAndDestAndDepartDate(Location src, Location dest, Date departDate) {
        return flightRepository.findBySourceIdAndDestinationIdAndDepartDate(src,dest,departDate);
    }

    @Override
    public Optional<Flight> flightSearchById(long fId) {
        return flightRepository.findById(fId);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
}
