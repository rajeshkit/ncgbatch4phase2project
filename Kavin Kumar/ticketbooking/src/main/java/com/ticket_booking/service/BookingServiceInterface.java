package com.ticket_booking.service;
import com.ticket_booking.entity.Booking;
import org.springframework.http.ResponseEntity;


public interface BookingServiceInterface {

        ResponseEntity<Object> bookTickets(Booking booking);

        ResponseEntity<Object> getAllBooking();

        ResponseEntity<Object> getBooking(int bookingId);
}
