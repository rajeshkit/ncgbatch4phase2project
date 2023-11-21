package com.example.FlightBooking.controller;

import com.example.FlightBooking.entity.BookingInfo;
import com.example.FlightBooking.service.IBookingInfoService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.health.HealthEndpointProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingInfoController {



//    logging is implemented
    Logger logger=LoggerFactory.getLogger(BookingInfoController.class);



    private final IBookingInfoService iBookingInfoService;

    @Autowired
    public BookingInfoController(IBookingInfoService iBookingInfoService) {

        this.iBookingInfoService = iBookingInfoService;
    }

    @PostMapping("/booking")
    public String addBooking(@RequestBody BookingInfo bookingInfo) throws Exception {

        return iBookingInfoService.insertBooking(bookingInfo);
    }

    @GetMapping("/booking/{id}")
    public List<String> findBookingInfoById(@PathVariable("id") Long id) throws Exception {
        List<String> ibo= iBookingInfoService.getBookingDetailsByBookId(id);
//        using logger to display info
        logger.info(ibo.toString());
        return ibo;
    }

}
