package com.flightreservation.flight.repository;

import com.flightreservation.flight.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookingRepo extends JpaRepository<Booking,Integer> {
    List<Booking> findAllBookingByCustomerId(int cId);
}
