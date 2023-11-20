package com.example.flightreservation.service;

import com.example.flightreservation.requestdto.AirlineRequest;
import com.example.flightreservation.responsedto.AirlineResponse;

public interface IAirlineService {
    String updateAirline(int id, AirlineRequest airlineDTO);
    AirlineResponse getAirlineById(int id);
    String registerAirline(AirlineRequest airlineDTO);
}
