package com.flightreservation.flight.service;

import com.flightreservation.flight.entity.Airline;
import com.flightreservation.flight.repository.IAirlineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class AirlineServiceImpl implements IAirlineService{

    private final IAirlineRepo airlineRepo;
@Autowired
    public AirlineServiceImpl(IAirlineRepo airlineRepo) {

    this.airlineRepo = airlineRepo;
    }

    @Override
    public List<Airline> getAllAirlines() {

    return airlineRepo.findAll();
    }

    @Override
    public Optional<Airline> getLocation(int id) {

    return airlineRepo.findById(id);
    }

    @Override
    public Airline registerAirline(Airline airline) {

        return airlineRepo.save(airline);
    }

}
