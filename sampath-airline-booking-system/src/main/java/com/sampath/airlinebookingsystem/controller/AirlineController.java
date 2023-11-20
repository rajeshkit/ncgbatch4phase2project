package com.sampath.airlinebookingsystem.controller;

import com.sampath.airlinebookingsystem.dtos.AirlineDto;
import com.sampath.airlinebookingsystem.dtos.ApiResponse;
import com.sampath.airlinebookingsystem.service.interfaces.IAirlineService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airlines")
public class AirlineController {


    private final IAirlineService airlineService;

    Logger logger = LoggerFactory.getLogger(AirlineController.class);

    @Autowired
    public AirlineController(IAirlineService airlineService, ModelMapper modelMapper) {
        this.airlineService = airlineService;
    }

    @PostMapping("/")
    public ResponseEntity<AirlineDto> createAirline(@Valid @RequestBody AirlineDto airlineDto){
        AirlineDto airlineDto1 = this.airlineService.createAirline(airlineDto);
        return new ResponseEntity<>(airlineDto1, HttpStatus.CREATED);
    }

    @PutMapping("/{airlineId}")
    public ResponseEntity<AirlineDto> updateAirline(@Valid @RequestBody AirlineDto airlineDto
            , @PathVariable("airlineId") Integer airlineId){
        logger.info("updating airline in airline controller");
        AirlineDto updatedAirline = this.airlineService.updateAirline(airlineDto,airlineId);
        return ResponseEntity.ok(updatedAirline);
    }

    @DeleteMapping("/{airlineId}")
    public ResponseEntity<ApiResponse> deleteAirline(@PathVariable("airlineId") Integer airlineId){
        logger.info("deleting airline in airline controller");
        this.airlineService.deleteAirline(airlineId);
        return new ResponseEntity<>(new ApiResponse("Airline deleted successfully.." +
                ".!!",true),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<AirlineDto>> getAllAirline(){
        logger.info("getting all airlines in controller");
        return ResponseEntity.ok(this.airlineService.getAllAirlines());
    }

    @GetMapping("/{airlineId}")
    public ResponseEntity<AirlineDto> getAirline(@PathVariable("airlineId") Integer airlineId){
        logger.info("getting airline with id: {}",airlineId);
        return ResponseEntity.ok(this.airlineService.getAirline(airlineId));
    }
}
