package com.example.FlightBooking.service;

import com.example.FlightBooking.exception.FlightIdNotFoundException;
import com.example.FlightBooking.exception.FlightSrcDestNotFoundException;

import java.util.List;

public interface IFlightMasterService {

    public List<String> getAllFlights();



    public List<String> getFlightById(String f_no) throws FlightIdNotFoundException;

    public List<String> getFlightBySourceAndDestination(String src, String dest) throws FlightSrcDestNotFoundException;

}
