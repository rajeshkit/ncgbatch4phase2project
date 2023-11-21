package com.flightreservation.flight.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
@RestControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<Object> handleIdNotFoundException(Exception ex){
        ApiError apiException=new ApiError(new Date(),ex.getMessage(),"Enter a valid id");
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(SourceNotFoundException.class)
    public ResponseEntity<Object> handleSourceNotFoundException(Exception ex){
        ApiError apiException=new ApiError(new Date(),ex.getMessage(),"The source is not found");
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(LocationNotFoundException.class)
    public ResponseEntity<Object> handleLocationNotFoundException(Exception ex){
        ApiError apiException=new ApiError(new Date(),ex.getMessage(),"Enter a valid location");
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(){
        return null;
    }



}
