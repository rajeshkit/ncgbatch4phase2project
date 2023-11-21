package com.example.atrs.controller;

import com.example.atrs.entity.AirlineMaster;

import com.example.atrs.service.AirlineServiceImp;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/airline-api")
public class AirlineController {
    private final AirlineServiceImp airlineRegImp;

    public AirlineController(AirlineServiceImp airlineRegImp) {
        this.airlineRegImp = airlineRegImp;
    }

    @PostMapping(path = "/airlineRegister")
    public String registerAl(@RequestBody @Valid AirlineMaster airlineMaster) {
        airlineRegImp.registerAirline(airlineMaster);
        return "Airline Registered SuccessFully";
    }

    @GetMapping(path = "/airlineById")
    public List<AirlineMaster> getAllAirline() {
        return airlineRegImp.getAllAirline();
    }

}