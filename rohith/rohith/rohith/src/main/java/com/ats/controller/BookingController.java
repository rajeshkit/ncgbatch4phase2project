package com.ats.controller;


import com.ats.entity.Booking;
import com.ats.exception.BookingIdNotFoundException;
import com.ats.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ats/booking-api")
public class BookingController {

    Logger logger = LoggerFactory.getLogger(BookingController.class);
    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")
    public ResponseEntity<String> createBooking(@RequestBody Booking booking){
        boolean isRegistered = bookingService.createBooking(booking);
        if (isRegistered) {
            logger.info("Booking success");
            return ResponseEntity.ok("Booking completed successfully");
        } else {
            logger.error("Booking Fail");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Booking failed");
        }
    }

    @GetMapping("/booking/{id}")
    public Optional<Booking> getBookingById(@PathVariable("id") long bId) throws BookingIdNotFoundException {
        if (bookingService.getBookingById(bId).isEmpty()){
            logger.error("Booking NotFound");
            throw new BookingIdNotFoundException("Booking is not found");
        }
        logger.info("Booking Found");
        return bookingService.getBookingById(bId);
    }

    @GetMapping("/bookings")
    public List<Booking> getAllBookings(){
        logger.info("All Bookings");
        return bookingService.getAllBookings();
    }
}

