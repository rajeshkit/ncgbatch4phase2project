package com.ats.controller;

import com.ats.entity.Booking;
import com.ats.entity.BookingDTO;
import com.ats.exception.BookingException;
import com.ats.service.IBookingService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ats")
public class BookingController {

    private final IBookingService service;
    private final Logger logger = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    public BookingController(IBookingService service) {
        this.service = service;
    }

    @PostMapping("/user/reservation/add")
    public ResponseEntity<Booking> addBooking(@Valid @RequestBody BookingDTO dto, @RequestParam(required = false) String key) throws BookingException {
        logger.info("Received request to add booking with DTO: {}", dto);
        Booking booking = service.addBooking(dto, key);
        logger.info("Booking added successfully. Booking details: {}", booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @PutMapping("/user/reservation/update/{rid}")
    public ResponseEntity<Booking> updateBooking(@Valid @RequestBody BookingDTO dto, @RequestParam(required = false) String key, @PathVariable Integer rid) throws BookingException {
        logger.info("Received request to update booking with DTO: {} and rid: {}", dto, rid);
        Booking booking = service.updateBooking(rid, dto, key);
        logger.info("Booking updated successfully. Updated booking details: {}", booking);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @DeleteMapping("/user/reservation/delete/{rid}")
    public ResponseEntity<Booking> deleteBooking(@RequestParam(required = false) String key, @PathVariable Integer rid) throws BookingException {
        logger.info("Received request to delete booking with rid: {}", rid);
        Booking booking = service.deleteBooking(rid, key);
        logger.info("Booking deleted successfully. Deleted booking details: {}", booking);
        return new ResponseEntity<>(booking, HttpStatus.ACCEPTED);
    }

    @GetMapping("/reservation/{rid}")
    public ResponseEntity<Booking> viewBookingById(@PathVariable Integer rid, @RequestParam(required = false) String key) throws BookingException {
        logger.info("Received request to view booking by id: {}", rid);
        Booking booking = service.viewBooking(rid, key);
        logger.info("Booking details: {}", booking);
        return new ResponseEntity<>(booking, HttpStatus.FOUND);
    }

    @GetMapping("/reservation/all")
    public ResponseEntity<List<Booking>> viewAllBooking(@RequestParam(required = false) String key) throws BookingException {
        logger.info("Received request to view all bookings.");
        List<Booking> reservations = service.getAllBooking(key);
        logger.info("Total bookings: {}", reservations.size());
        return new ResponseEntity<>(reservations, HttpStatus.FOUND);
    }

    @GetMapping("/user/reservation/{uid}")
    public ResponseEntity<List<Booking>> viewBookingsByUserId(@PathVariable Integer uid, @RequestParam(required = false) String key) throws BookingException {
        logger.info("Received request to view bookings by user id: {}", uid);
        List<Booking> bookings = service.viewBookingsByUerId(uid, key);
        logger.info("Total bookings for user {}: {}", uid, bookings.size());
        return new ResponseEntity<>(bookings, HttpStatus.FOUND);
    }
}
