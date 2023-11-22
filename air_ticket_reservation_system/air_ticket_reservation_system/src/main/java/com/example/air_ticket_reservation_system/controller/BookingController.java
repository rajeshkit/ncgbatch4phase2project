package com.example.air_ticket_reservation_system.controller;

import com.example.air_ticket_reservation_system.entity.BookingInfo;
import com.example.air_ticket_reservation_system.service.BookingService;
import com.example.air_ticket_reservation_system.serviceinterfaces.IBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("booking-api")
public class BookingController {

    @Autowired
    IBooking iBooking;
    @PostMapping("/book-flight")
    public BookingInfo createBooking(@RequestBody BookingInfo bookingInfo){
        return iBooking.createBooking(bookingInfo);
    }
    @GetMapping("/get-booking")
    public List<BookingInfo> getBooking(@RequestBody BookingInfo bookingInfo){
        return iBooking.getBooking(bookingInfo);
    }
}
