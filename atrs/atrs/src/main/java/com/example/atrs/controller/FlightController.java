package com.example.atrs.controller;

import com.example.atrs.dto.FlightFetch;
import com.example.atrs.entity.FlightMaster;
import com.example.atrs.entity.LocationMaster;
import com.example.atrs.exception.FlightIdNotFoundException;
import com.example.atrs.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


@RestController
@RequestMapping(path = "/flight-api")
public class FlightController {
    private final FlightService flightService;
    public FlightController(FlightService flightService){
        this.flightService = flightService;
    }



    @PostMapping(path = "/flightRegister")
    public ResponseEntity<Object> register(@RequestBody @Valid FlightMaster flightMaster){
        return flightService.registerFlight(flightMaster);
    }
    @GetMapping(path = "/searchFlightById/{Id}")
    public FlightMaster searchFlightById(@PathVariable("Id")  int flightId) throws FlightIdNotFoundException {
        if(flightService.searchFlightById(flightId)==null){
            throw new FlightIdNotFoundException("Given Flight id is not present");
        }
        return flightService.searchFlightById(flightId);
    }
    @GetMapping(path = "/searchFlight")
    public ResponseEntity<Object> searchFlight(@RequestBody FlightFetch flightFetch){
        return flightService.searchFlight(flightFetch);
    }
    @GetMapping(path = "/searchFlight/{sourceId}/{destinationId}/{dprDate}")
    public List<Object> searchFlight1(@PathVariable("sourceId")LocationMaster sourceId, @PathVariable("destinationId")LocationMaster destinationId, @PathVariable("dprDate")Date dprDate) throws FlightIdNotFoundException {
        List<Object> flights=flightService.searchFlight1(sourceId, destinationId, dprDate);
        if(flights.isEmpty()){
            throw new FlightIdNotFoundException("there is  no flight available");
        }else {
            return flights;
        }
    }
    @GetMapping(path = "/flights")
    public List<FlightMaster> getAllFlight(){
        return flightService.getAllFlight();
    }
}
