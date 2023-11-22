package com.example.airticketreservation.controller;

import com.example.airticketreservation.exception.CustomerIdNotFound;
import com.example.airticketreservation.entity.Booking;
import com.example.airticketreservation.service.IBookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/air-ticket")
public class BookingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);

    private final IBookingService bookingService;

    @Autowired
    public BookingController(IBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/booking")
    @ResponseBody
    public ResponseEntity<String> book(@RequestBody Booking booking) {
        LOGGER.info("Request received to book a flight with details: {}", booking);

        boolean isBooked = bookingService.saveTicketBookingDetails(booking);

        if (isBooked) {
            LOGGER.info("Booking successful for customer with ID: {}", booking.getCustomerId());
            return ResponseEntity.ok("Booking successful");
        } else {
            LOGGER.warn("Flight booking failed for customer with ID: {}", booking.getCustomerId());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Flight booking is failed");
        }
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Booking>> getBookingDetails(@PathVariable Long customerId) {
        LOGGER.info("Request received to get booking details for customer with ID: {}", customerId);

        List<Booking> custBookings = bookingService.getBookingDetails(customerId);

        if (custBookings.isEmpty()) {
            LOGGER.info("No bookings found for customer with ID: {}", customerId);
            return ResponseEntity.noContent().build();
        } else {
            LOGGER.info("Returning booking details for customer with ID: {}", customerId);
            return ResponseEntity.ok(custBookings);
        }
    }
}
