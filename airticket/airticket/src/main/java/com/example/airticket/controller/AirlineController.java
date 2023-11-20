package com.example.airticket.controller;

import com.example.airticket.entity.Airline;
import com.example.airticket.service.AirlineServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airline-api")
public class AirlineController {

    private final AirlineServiceImp airlineService;
    @Autowired
    public AirlineController(AirlineServiceImp airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping("/airline")
    public ResponseEntity<List<Airline>> getAirlinesDetails() {
        List<Airline> airlines = airlineService.getAirlinesDetails();
        if (airlines.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(airlines);
        }
    }
}