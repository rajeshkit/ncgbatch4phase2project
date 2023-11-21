package com.example.airticket.controller;

import com.example.airticket.service.IBookingService;
import com.example.airticket.entity.Booking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;



@RestController
@RequestMapping("/booking-api")
public class BookingController {
    private final IBookingService bookingService;
    Logger logger = LoggerFactory.getLogger(BookingController.class);
    @Autowired
    public BookingController(IBookingService bookingService){
        this.bookingService = bookingService;
    }


    @PostMapping("/bookDetails")
    public boolean flightBooking(@RequestBody Booking booking) {
        logger.info("booking flight ticket");
        bookingService.bookFlight(booking);
        return true;
    }

    @GetMapping(path="/allBookings")
    public ResponseEntity<Object> getAllBookings() {
        logger.info("Getting all booked ticket deatils");
        return bookingService.getAllBookings();
    }

    @GetMapping(path="/getByDate")
    public List<Booking> getByDate(@RequestParam("bookingDate") LocalDate date){
        return bookingService.findByDate(date);
    }
}
