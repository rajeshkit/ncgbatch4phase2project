package com.ats.service;

import com.ats.entity.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    boolean createBooking(Booking booking);

    Optional<Booking> getBookingById(long bId);

    List<Booking> getAllBookings();
}
