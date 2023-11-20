package com.example.airticketreservation.controller;

import com.example.airticketreservation.entity.Airline;
import com.example.airticketreservation.service.IAirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/air-ticket")
public class AirlineController {
    private final IAirlineService airlineService;

    @Autowired
    public AirlineController(IAirlineService airlineService) {
        this.airlineService = airlineService;
    }
    @GetMapping("/airlines")
    public ResponseEntity<List<Airline>> getAirlines(){
        List<Airline> airlines=airlineService.getAirlines();
        if (airlines.isEmpty()){
            return ResponseEntity.noContent().build();
        }return ResponseEntity.ok(airlines);
    }

}
