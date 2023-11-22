package com.example.air_ticket_reservation_system.controller;

import com.example.air_ticket_reservation_system.entity.AirlineMaster;
import com.example.air_ticket_reservation_system.serviceinterfaces.IAirline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airline-api")
public class AirlineController {

    @Autowired
    private IAirline iAirline;

    @PostMapping("/add-airline")

    public AirlineMaster createAirline(@RequestBody AirlineMaster airlineMaster){
        return iAirline.createAirline(airlineMaster);
    }
}
