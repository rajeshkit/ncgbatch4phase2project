package com.example.air_ticket_reservation_system.exceptionhandler;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)

    public ResponseEntity<?> handleEntityNotFoundException(Exception ex){
        ApiError api = new ApiError(new Date(),"Account Number is not found !!!", "check your Account Number !! Enter valid Account Number");
        ResponseEntity<?> err = new ResponseEntity<>(api, HttpStatus.NOT_FOUND);
        return err;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(LocationNotFoundException.class)

    public ResponseEntity<?> handleLocationNotFoundException(Exception e){
        ApiError api = new ApiError(new Date(),"Location not Found!","Provide Location Name.");
        ResponseEntity<?> err = new ResponseEntity<>(api,HttpStatus.NOT_FOUND);
        return err;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(FlightNotFoundException.class)

    public ResponseEntity<?> handleFlightNotFoundException(Exception e){
        ApiError api = new ApiError(new Date(),"Flight not Found!","Check the Flight details...");
        ResponseEntity<?> err = new ResponseEntity<>(api,HttpStatus.NOT_FOUND);
        return err;
    }
}
