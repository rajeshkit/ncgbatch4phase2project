package com.example.ticketbooking.service;

import com.example.ticketbooking.entity.Airline;
import com.example.ticketbooking.entity.Flight;
import com.example.ticketbooking.exception.EmptyInputException;
import com.example.ticketbooking.repository.AirlineReposit;
import com.example.ticketbooking.repository.FlightReposit;
import com.example.ticketbooking.requestdto.FlightRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements IFlightService
{

    private final FlightReposit flightRepository;
    private final AirlineReposit airlineRepository;
@Autowired
    public FlightServiceImpl(FlightReposit flightRepository, AirlineReposit airlineRepository) {
        this.flightRepository = flightRepository;
        this.airlineRepository = airlineRepository;
    }

    public String flightRegistration(FlightRequest flightRequest)
    {
        Flight flight;

        Optional<Airline> airline = airlineRepository.findByName(flightRequest.getAirlineName());

        if(airline.isEmpty())
        {
            throw new EmptyInputException("Enter valid input");
        }
        else {
            flight = new Flight(flightRequest.getTotalSeats(), flightRequest.getSource(), flightRequest.getDestination(), flightRequest.getDepartureTime(), flightRequest.getFare(), flightRequest.getAvailableSeats(), flightRequest.getDepartureDate() ,airline.get());
        }

        airline.get().setFlightList(flight);

        airlineRepository.save(airline.get());
        return "Flight Details saved successfully";
    }

    public List<Flight> searchBySourceAndDestinationAndDepartureDate(String source , String destination , Date date)
    {
        return flightRepository.findBySourceAndDestinationAndDepartureDate(source,destination,date);
    }

    public Optional<Flight> getFlightById(int id) {

        return flightRepository.findById(id);
    }
}
