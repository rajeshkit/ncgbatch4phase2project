package com.example.ticketbooking.service;

import com.example.ticketbooking.entity.Airline;
import com.example.ticketbooking.repository.AirlineReposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineServiceImpl implements IAirlineService {
    private final AirlineReposit airlineRepository;
@Autowired
    public AirlineServiceImpl(AirlineReposit airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    public List<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }
}
