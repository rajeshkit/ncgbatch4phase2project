package com.example.FlightBooking.controller;

import com.example.FlightBooking.exception.FlightIdNotFoundException;
import com.example.FlightBooking.exception.FlightSrcDestNotFoundException;
import com.example.FlightBooking.service.IFlightMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightMasterController {

    @Autowired
    public IFlightMasterService iFlightMasterService;


    //    logging is implemented
    Logger logger= LoggerFactory.getLogger(FlightMasterController.class);


    @GetMapping("/flights")
    public List<String> getAllFlights(){
        return iFlightMasterService.getAllFlights();
    }

        @GetMapping("/flight/{id}")
    public List<String> findFlightById(@PathVariable("id") String id) throws FlightIdNotFoundException {
        return iFlightMasterService.getFlightById(id);
    }

    @GetMapping("/flight/{src}/{dest}")
    public List<String> findFlightBySourceAndDestination(@PathVariable("src") String src, @PathVariable("dest") String dest) throws FlightIdNotFoundException, FlightSrcDestNotFoundException {
        List<String> iflight= iFlightMasterService.getFlightBySourceAndDestination(src,dest);
        logger.info(iflight.toString());
        return iflight;
    }

}
