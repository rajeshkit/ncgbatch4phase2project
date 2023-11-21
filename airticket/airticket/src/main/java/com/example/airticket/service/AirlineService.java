package com.example.airticket.service;

import com.example.airticket.entity.Airline;
import com.example.airticket.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AirlineService implements AirlineServiceImp {
    private final AirlineRepository airlineRepository;
    @Autowired
    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    public List<Airline> getAirlinesDetails() {

        return airlineRepository.findAll();
    }
}
