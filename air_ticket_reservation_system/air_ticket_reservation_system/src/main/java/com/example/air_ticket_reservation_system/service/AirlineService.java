package com.example.air_ticket_reservation_system.service;

import com.example.air_ticket_reservation_system.entity.AirlineMaster;
import com.example.air_ticket_reservation_system.repository.AirlineRepository;
import com.example.air_ticket_reservation_system.serviceinterfaces.IAirline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineService implements IAirline {
    @Autowired
    private AirlineRepository airlineRepository;
    @Override
    public AirlineMaster createAirline(AirlineMaster airlineMaster) {
        return airlineRepository.save(airlineMaster);
    }
}
