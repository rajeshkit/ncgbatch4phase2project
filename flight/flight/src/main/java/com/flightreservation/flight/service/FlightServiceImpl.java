package com.flightreservation.flight.service;

import com.flightreservation.flight.entity.Flight;
import com.flightreservation.flight.entity.Location;
import com.flightreservation.flight.exception.SourceNotFoundException;
import com.flightreservation.flight.repository.IFlightRepo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FlightServiceImpl implements IFlightService{
    private final IFlightRepo flightRepo;
@Autowired
    public FlightServiceImpl(IFlightRepo flightRepo) {
        this.flightRepo = flightRepo;
    }

    @SneakyThrows
    @Override
    public List<Flight> getFlightsBySource(Location source)   {


        if(!flightRepo.existsBySource(source)) {
            String message = "source is not found";
            throw new SourceNotFoundException(message);
        }
            return flightRepo.findBySource(source);
 }
    boolean existsBySource(Location source) {
        if (flightRepo.existsById(source.getLocationId())) {
            flightRepo.toString();
            return true;
        }
        return false;
    }

    @SneakyThrows
    @Override
    public List<Flight> getFlightsByDestination(Location dest)  {
        if(!flightRepo.existsBySource(dest))
        {
            String message="destination not found";
            throw new SourceNotFoundException(message);
        }
        return flightRepo.findByDestination(dest);
    }

    @Override
    public List<Flight> getAllFlights(Location s) {
        return flightRepo.findByDestination(s);
    }

    @Override
    public List<Flight> getAllFlights() {

    return flightRepo.findAll();
    }
}
