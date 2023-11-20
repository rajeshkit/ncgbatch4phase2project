package com.ats.service;

import com.ats.entity.Airline;
import com.ats.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineServiceImpl implements AirlineService{

    @Autowired
    private AirlineRepository airlineRepository;
    @Override
    public List<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }

    @Override
    public boolean airlineRegister(Airline airline) {
        Airline airline1 = airlineRepository.save(airline);
        Optional<Airline> as = airlineRepository.findById(airline1.getAirlineId());
        if (as.isPresent()){
            return true;
        }
        return false;
    }
}
