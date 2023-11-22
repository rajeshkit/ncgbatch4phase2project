package com.flightreservation.flight.controller;

import com.flightreservation.flight.entity.Booking;
import com.flightreservation.flight.service.IBookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/booking-api")

public class BookingController {
    private final IBookingService bookingService;
    @Autowired
    public BookingController(IBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @ResponseBody
    @PostMapping(path="/booking")
    public Booking bookingDetails(@RequestBody Booking book){
        return bookingService.bookingDetails(book);
    }
    @ResponseBody
    @GetMapping(path="/booking/id")
    public Optional<Booking> getBooking(@RequestBody int bId){
        return bookingService.getBooking(bId);
    }
    @ResponseBody
    @PostMapping(path="/booking/book")
    public List<Booking> getAllBooking(@RequestBody int customerId){
        return bookingService.getAllBooking(customerId);
    }



    

}
