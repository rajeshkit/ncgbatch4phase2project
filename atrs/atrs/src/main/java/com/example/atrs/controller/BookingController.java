package com.example.atrs.controller;

import com.example.atrs.entity.Booking;
import com.example.atrs.exception.BookingIdNotFoundException;
import com.example.atrs.exception.InvalidBookingException;
import com.example.atrs.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/booking-api")
public class BookingController {
    private final BookingService bookingService;
    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }
    @PostMapping(path = "/bookingTicket")
    public String bookTickets(@RequestBody @Valid Booking booking) throws InvalidBookingException {
        return bookingService.bookTickets(booking);
    }
    @GetMapping(path = "/findBooking/{id}")
    public Booking searchByBooking(@PathVariable("id")int bookingId)throws BookingIdNotFoundException {
        if(bookingService.searchBookingById(bookingId)==null){
            throw new BookingIdNotFoundException("No such booking ID found");
        }
        return bookingService.searchBookingById(bookingId);
    }
    @DeleteMapping(path = "/booking/{id}")
    public String deleteBooking(@PathVariable("id")int bookingId) throws BookingIdNotFoundException {
        return bookingService.deleteBooking(bookingId);
    }
}
