package com.example.airticket.service;

import com.example.airticket.exception.IdNotFoundException;
import com.example.airticket.entity.Flight;
import com.example.airticket.entity.Location;
import com.example.airticket.repository.AirlineRepository;
import com.example.airticket.repository.FlightRepository;
import com.example.airticket.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Service
public class FlightServiceImpl implements IFlightService {


    private  final  FlightRepository flightRepository;
    private final AirlineRepository airlineRepository;
    private final LocationRepository locationRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, AirlineRepository airlineRepository, LocationRepository locationRepository){
        this.flightRepository = flightRepository;
        this.airlineRepository=airlineRepository;
        this.locationRepository=locationRepository;
    }

    @Override
    public Flight createFlight(Flight flight) {
        flight.setAirline(airlineRepository.findById(flight.getAirlineId()));
        flight.setSource(locationRepository.findById(flight.getSourceId()));
        flight.setDestination(locationRepository.findById(flight.getDestinationId()));
        return flightRepository.save(flight);
    }

    public ResponseEntity<Object> searchAvailableFlights(Location source, Location destination, String date1)
    {
        LocalDate localDate = LocalDate.parse(date1);

        Date date = Date.valueOf(localDate);

        List<Flight> availableFlights = flightRepository.findBySourceAndDestinationAndDepartDate(source, destination, date);
        if (availableFlights.isEmpty()) {
            String errorMessage = "There is no Flight from "+ source +" to "+destination+" on "+date;
            return   ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } else {
            return ResponseEntity.ok(availableFlights);
        }
    }

    @Override
    public ResponseEntity<Object> getFlightById(long flightNumber) {
        String errorMessage = String.format("flightNumber with %s    not found in the database",flightNumber);
        Flight flight = flightRepository.findById(flightNumber);
        if(flight==null){
            throw new IdNotFoundException(errorMessage);
        }
            return ResponseEntity.ok(flight);
        }

    @Override
    public ResponseEntity<Object> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        if (flights.isEmpty()) {
            String msg = "No flights has been registered in this AirLine..";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        } else {
            return ResponseEntity.ok(flights);
        }
    }

}
