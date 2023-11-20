package com.example.airticket.service;

import com.example.airticket.entity.Airline;
import com.example.airticket.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineServiceImpl implements IAirlineService {
    private  final AirlineRepository airlineRepository;

    @Autowired
    public AirlineServiceImpl(AirlineRepository airlineRepository){
        this.airlineRepository = airlineRepository;
    }

    @Override
    public Airline createAirline(Airline airLine) {
        return airlineRepository.save(airLine);
    }

    @Override
    public ResponseEntity<Object> getAllAirlines() {
        List<Airline> airline = airlineRepository.findAll();
        if (airline.isEmpty()) {
            String msg = "AirLine table is empty";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        } else {
            return ResponseEntity.ok(airline);
        }
    }
}
