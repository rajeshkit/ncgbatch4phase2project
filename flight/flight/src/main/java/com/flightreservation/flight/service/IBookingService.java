package com.flightreservation.flight.service;

import com.flightreservation.flight.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface IBookingService {
    @Autowired
    public Booking bookingDetails(Booking book);
    public Optional<Booking> getBooking(int bId);
    public List<Booking> getAllBooking(int customerId);

}
