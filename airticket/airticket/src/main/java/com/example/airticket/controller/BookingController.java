package com.example.airticket.controller;

import com.example.airticket.entity.Booking;
import com.example.airticket.exception.CustomerIdNotFoundException;
import com.example.airticket.service.BookingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking-api")
public class BookingController {

    private final BookingServiceImp bookingService;
     @Autowired
    public BookingController(BookingServiceImp bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping(path="/booking")
    public ResponseEntity<String> flightBooking(@RequestBody Booking booking){

        boolean isBooked = bookingService.flightBooking(booking);
        if (isBooked) {
            return ResponseEntity.ok("Flight booked successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please check properly!! Flight Booking failed");
        }
    }
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Booking>> getCustomerBookings(@PathVariable Long customerId) throws CustomerIdNotFoundException {
        List<Booking> customerBookings = bookingService.getCustomerBooking(customerId);
        if (customerBookings.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(customerBookings);
        }
    }
    }

