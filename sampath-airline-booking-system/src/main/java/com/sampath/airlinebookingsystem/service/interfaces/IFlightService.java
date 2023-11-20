package com.sampath.airlinebookingsystem.service.interfaces;

import com.sampath.airlinebookingsystem.dtos.FlightDto;
import com.sampath.airlinebookingsystem.entity.Location;

import java.sql.Date;
import java.util.List;

public interface IFlightService {

    public FlightDto createFlight(FlightDto flightDto, Integer aId, Integer srcId,Integer destId);

    FlightDto getFlight(int airlineId);

    List<FlightDto> getAllFlights();

    List<FlightDto> searchFlight(Location src, Location dest, Date date);
}
