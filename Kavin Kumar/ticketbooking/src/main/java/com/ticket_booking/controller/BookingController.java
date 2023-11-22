package com.ticket_booking.controller;

import com.ticket_booking.entity.Booking;
import com.ticket_booking.service.BookingServiceInterface;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking-api")
public class BookingController {
    private final BookingServiceInterface bookingService;

    public BookingController(BookingServiceInterface bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/book")
    public ResponseEntity<Object> bookTickets(@RequestBody @Valid Booking booking)
    {
        return bookingService.bookTickets(booking);
    }
    @GetMapping("/booking/{bookingId}")
    public  ResponseEntity<Object> getBooking(@PathVariable int bookingId)
    {
        return bookingService.getBooking(bookingId);
    }
    @GetMapping("/bookings")
    public ResponseEntity<Object> getAllBooking(){
        return bookingService.getAllBooking();
    }
}
