package com.example.airticketreservation.controller;

import com.example.airticketreservation.exception.CustomerIdNotFound;
import com.example.airticketreservation.entity.Booking;
import com.example.airticketreservation.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/air-ticket")
public class BookingController {
    private final IBookingService bookingService;

    @Autowired
    public BookingController(IBookingService bookingService) {
        this.bookingService = bookingService;
    }
    @PostMapping("/booking")
    @ResponseBody
    public ResponseEntity<String> book(@RequestBody Booking booking) {
        boolean isBooked = bookingService.saveTicketBookingDetails(booking);
        if (isBooked) {
            bookingService.saveTicketBookingDetails(booking);
            return ResponseEntity.ok("Booking successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Flight booking is failed");
        }
    }
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Booking>> getBookingDetails(@PathVariable Long customerId) throws CustomerIdNotFound {
        List<Booking> custBookings = bookingService.getBookingDetails(customerId);
        if (custBookings.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(custBookings);
        }
    }
}
