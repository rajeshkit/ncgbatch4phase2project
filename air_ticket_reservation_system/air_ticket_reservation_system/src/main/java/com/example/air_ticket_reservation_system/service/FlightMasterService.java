package com.example.air_ticket_reservation_system.service;

import com.example.air_ticket_reservation_system.entity.FlightMaster;
import com.example.air_ticket_reservation_system.repository.FlightRepository;
import com.example.air_ticket_reservation_system.serviceinterfaces.IFlightMaster;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlightMasterService implements IFlightMaster {
    @Autowired
    private FlightRepository flightRepository;
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public FlightMaster registerFlight(FlightMaster flightMaster) {
        return flightRepository.save(flightMaster);
    }

    @Override
    public Optional<FlightMaster> searchFlights(String flightId) {
        return flightRepository.findById(flightId);
    }
}
