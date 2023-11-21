package com.example.airticketreservation.service;

import com.example.airticketreservation.entity.Flight;
import com.example.airticketreservation.exception.FlightNotFoundException;
import com.example.airticketreservation.repository.FlightRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@Slf4j
public class FlightService implements IFlightService{
    private final FlightRep flightRep;

    @Autowired
    public FlightService(FlightRep flightRep) {
        this.flightRep = flightRep;
    }

    @Override
    public List<Flight> searchFlights(String from, String to, Date departureDate) {

        List<Flight> optionalFlights = null;

            optionalFlights = flightRep.findBySourceAndDestinationAndDateIn(from, to, departureDate);
            if(optionalFlights.isEmpty())
                    throw new FlightNotFoundException("flight not found!!!!");/*catch (FlightNotFoundException e) {
            log.info("got Flight not found exception", e.getMsg());
            throw new FlightNotFoundException("flight not found");
        }*/

        //  List<Flight> flights = optionalFlights.orElseThrow(() -> new FlightIdNotFoundException("Flight is not Found!!!"));

        return optionalFlights;
    }
}