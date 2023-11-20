package com.example.airticket.service;


import com.example.airticket.entity.Booking;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;


public interface IBookingService {
     void bookFlight(Booking booking);

     ResponseEntity<Object> getAllBookings();
    List<Booking> findByDate(LocalDate bookingDate);
}
