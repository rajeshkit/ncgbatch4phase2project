package com.example.air_ticket_reservation_system.serviceinterfaces;

import com.example.air_ticket_reservation_system.entity.FlightMaster;

import java.util.Optional;

public interface IFlightMaster {
    public FlightMaster registerFlight(FlightMaster flightMaster);
    public Optional<FlightMaster> searchFlights(String flightId);
}
