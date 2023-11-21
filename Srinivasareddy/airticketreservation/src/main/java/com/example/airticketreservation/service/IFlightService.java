package com.example.airticketreservation.service;

import com.example.airticketreservation.entity.Flight;


import java.sql.Date;
import java.util.List;

public interface IFlightService {
    List<Flight> searchFlights(String from, String to, Date departureDate);
}
