package com.example.airticketreservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerIdNotFound.class)
    public ResponseEntity<com.example.airticketreservation.exception.ApiError> handleCustomerIdNotFoundException(CustomerIdNotFound ex) {
        System.out.println(ex.getMessage());
        com.example.airticketreservation.exception.ApiError apiError = new ApiError(new Date(), ex.getMsg(), " Enter a valid customer Id");
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<String> noRecordFoundExceptionHandler(RecordNotFoundException ex)
    {
        String message = ex.getMessage();
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = EmptyInputException.class)
    public ResponseEntity<String> emptyInputExceptionHandler(com.example.airticketreservation.exception.EmptyInputException ex)
    {
        String message = ex.getMessage();
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }

}