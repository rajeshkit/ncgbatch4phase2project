package com.sampath.airlinebookingsystem.controller;

import com.sampath.airlinebookingsystem.dtos.BookingDto;
import com.sampath.airlinebookingsystem.service.interfaces.IBookingService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final IBookingService bookingService;

    Logger logger = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    public BookingController(IBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/{customerId}")
    public ResponseEntity<BookingDto> saveBooking(@Valid @RequestBody BookingDto bookingDto,
                                                @PathVariable("customerId") Integer customerId,
                                                @RequestParam  Integer flightId){
        BookingDto createBooking = this.bookingService.bookTicket(bookingDto,customerId,flightId);
        return new ResponseEntity<>(createBooking, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<BookingDto>> getAllBookings(){
        logger.info("getting all booking in controller");
        return ResponseEntity.ok(this.bookingService.getAllBooking());
    }

    @GetMapping("/flight/{flightId}")
    public ResponseEntity<List<BookingDto>> getBookingbyflightId(@PathVariable Integer flightId){
        logger.info("get booking by flight");
        return ResponseEntity.ok(this.bookingService.getBookingDetailsOfFlight(flightId));
    }

    @GetMapping("/{bid}")
    public ResponseEntity<BookingDto> getBookingbyId(@PathVariable Integer bid){
        logger.info("getting booking details by Id {}",bid);
        return ResponseEntity.ok(this.bookingService.getBookingDetailsById(bid));
    }
}
