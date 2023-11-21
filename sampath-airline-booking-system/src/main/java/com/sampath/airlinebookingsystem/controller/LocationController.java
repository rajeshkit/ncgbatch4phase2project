package com.sampath.airlinebookingsystem.controller;

import com.sampath.airlinebookingsystem.dtos.ApiResponse;
import com.sampath.airlinebookingsystem.dtos.LocationDto;
import com.sampath.airlinebookingsystem.service.interfaces.ILocationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final ILocationService locationService;

    @Autowired
    public LocationController(ILocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/")
    public ResponseEntity<LocationDto> createLocation(@Valid @RequestBody LocationDto locationDto){
        LocationDto categoryDto1 = this.locationService.createLocation(locationDto);
        return new ResponseEntity<>(categoryDto1, HttpStatus.CREATED);
    }

    @PutMapping("/{locationId}")
    public ResponseEntity<LocationDto> updateLocation(@Valid @RequestBody LocationDto locationDto
            , @PathVariable("locationId") Integer locationId){
        LocationDto updatedLocation = this.locationService.updateLocation(locationDto,locationId);
        return ResponseEntity.ok(updatedLocation);
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity<ApiResponse> deleteLocation(@PathVariable("locationId") Integer locationId){
        this.locationService.deleteLocation(locationId);
        return new ResponseEntity<>(new ApiResponse("Location deleted sucessfully.." +
                ".!!",true),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<LocationDto>> getAllLocation(){
        return ResponseEntity.ok(this.locationService.getAllLocations());
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<LocationDto> getLocation(@PathVariable("locationId") Integer locationId){
        return ResponseEntity.ok(this.locationService.getLocation(locationId));
    }
}
