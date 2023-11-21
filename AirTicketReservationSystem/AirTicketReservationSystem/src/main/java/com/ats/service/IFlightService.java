package com.ats.service;

import com.ats.entity.Flight;
import com.ats.exception.AdminException;
import com.ats.exception.FlightException;

import java.util.List;

public interface IFlightService {
    //admin methods
    public Flight addFlight(Flight flight, String key) throws FlightException, AdminException;
    public Flight updateFlight(Flight flight, String key) throws FlightException, AdminException;
    public Flight deleteFlight(Integer busId, String key) throws FlightException, AdminException;

    //admin + user methods
    public Flight viewFlight(Integer busId) throws FlightException;
    public List<Flight> viewFlightByFlightType(String busType) throws FlightException;
    public List<Flight> viewAllFlights() throws FlightException;
}
