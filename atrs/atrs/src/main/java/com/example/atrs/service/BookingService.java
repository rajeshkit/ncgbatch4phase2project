package com.example.atrs.service;

import com.example.atrs.entity.Booking;
import com.example.atrs.exception.BookingIdNotFoundException;
import com.example.atrs.exception.InvalidBookingException;

public interface BookingService {
     String bookTickets(Booking booking) throws InvalidBookingException;
     Booking searchBookingById(int bookingId);
     String deleteBooking(int bookingId) throws BookingIdNotFoundException;

}
