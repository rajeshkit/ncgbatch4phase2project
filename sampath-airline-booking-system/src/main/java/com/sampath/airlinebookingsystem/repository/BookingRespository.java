package com.sampath.airlinebookingsystem.repository;

import com.sampath.airlinebookingsystem.entity.Booking;
import com.sampath.airlinebookingsystem.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRespository extends JpaRepository<Booking,Integer> {
    public List<Booking> findByFlightId(Flight flight);
}
