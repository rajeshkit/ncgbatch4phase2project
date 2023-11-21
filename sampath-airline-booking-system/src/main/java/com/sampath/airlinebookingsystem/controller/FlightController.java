package com.sampath.airlinebookingsystem.controller;

import com.sampath.airlinebookingsystem.dtos.FlightDto;
import com.sampath.airlinebookingsystem.entity.Location;
import com.sampath.airlinebookingsystem.exeception.ResourceNotFoundException;
import com.sampath.airlinebookingsystem.repository.LocationRespository;
import com.sampath.airlinebookingsystem.service.interfaces.IFlightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {


    private final IFlightService flightService;

    private final LocationRespository locationRespository;

    @Autowired
    public FlightController(IFlightService flightService, LocationRespository locationRespository) {
        this.flightService = flightService;
        this.locationRespository = locationRespository;
    }

    @PostMapping("/{airlineId}")
    public ResponseEntity<FlightDto> createFlight(@Valid @RequestBody FlightDto flightDto,
                                                  @PathVariable("airlineId") Integer airlineId,
                                                  @RequestParam Integer srcId,
                                                  @RequestParam Integer destId
                                            ){
        FlightDto createFlight = this.flightService.createFlight(flightDto,airlineId,srcId,destId);
        return new ResponseEntity<>(createFlight, HttpStatus.CREATED);
    }

    @GetMapping("/{airlineId}")
    public ResponseEntity<FlightDto> getFlight(@PathVariable int airlineId){
        return ResponseEntity.ok(this.flightService.getFlight(airlineId));
    }

    @GetMapping("/")
    public ResponseEntity<List<FlightDto>> getFlights(){
        return ResponseEntity.ok(this.flightService.getAllFlights());
    }

    @GetMapping("/search")
    public ResponseEntity<List<FlightDto>> searchFlight(@RequestParam Integer src,
                                                        @RequestParam Integer dest,
                                                        @RequestParam Date date){
        Location sourceLocation =
                locationRespository.findById(src).orElseThrow(()->new ResourceNotFoundException(
                        "Location","source Id",src));
        Location destLocation =
                locationRespository.findById(dest).orElseThrow(()->new ResourceNotFoundException(
                        "Location","dest Id",dest));

        List<FlightDto> flights = this.flightService.searchFlight(sourceLocation,destLocation,date);
        return ResponseEntity.ok(flights);


    }


}
