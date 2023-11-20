package com.example.ticketbooking.service;

import com.example.ticketbooking.entity.Flight;
import com.example.ticketbooking.requestdto.FlightRequest;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface IFlightService{

    String flightRegistration(FlightRequest flightRequest);

    List<Flight> searchBySourceAndDestinationAndDepartureDate(String source, String destination, Date date);

    Optional<Flight> getFlightById(int id);
}
