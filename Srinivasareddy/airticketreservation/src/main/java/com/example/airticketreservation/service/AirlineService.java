package com.example.airticketreservation.service;

import com.example.airticketreservation.entity.Airline;
import com.example.airticketreservation.repository.AirlineRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AirlineService implements IAirlineService{
    private final AirlineRep airlineRep;

    @Autowired
    public AirlineService(AirlineRep airlineRep) {
        this.airlineRep = airlineRep;
    }

    @Override
    public List<Airline> getAirlines() {
        return airlineRep.findAll();
    }
}
