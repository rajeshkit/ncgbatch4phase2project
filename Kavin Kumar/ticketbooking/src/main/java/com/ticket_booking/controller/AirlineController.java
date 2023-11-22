package com.ticket_booking.controller;

import com.ticket_booking.entity.Airline;
import com.ticket_booking.extras.LoginValidation;
import com.ticket_booking.extras.RegistrationValidation;
import com.ticket_booking.service.AirlineServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/airline")
public class AirlineController {
    private final AirlineServiceInterface airlineService;

    @Autowired
    public AirlineController(AirlineServiceInterface airlineService) {
        this.airlineService = airlineService;
    }
    @PostMapping("/register")
    @Validated
    public ResponseEntity<Object> register(@RequestBody @Validated(RegistrationValidation.class) Airline airline){
        return airlineService.register(airline);
    }
    @PostMapping("/login")
    @Validated
    public ResponseEntity<Object> login(@Validated(LoginValidation.class) @RequestBody Airline airline){
        return airlineService.login(airline);
    }
    @GetMapping("logout")
    public ResponseEntity<Object> logout(){
        return airlineService.logout();
    }



}
