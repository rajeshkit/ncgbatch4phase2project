package com.example.airticket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerIdNotFoundException.class)
    public ResponseEntity<com.example.airticket.exception.ApiError> handleCustomerIdNotFoundException(CustomerIdNotFoundException ex) {
        com.example.airticket.exception.ApiError apiError = new ApiError(new Date(), ex.getMessage(), " Enter a valid customer Id");
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<String>handleNoRecordFoundExceptionHandler(RecordNotFoundException ex)
    {
        String message = ex.getMessage();
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInputExceptionHandler(com.example.airticket.exception.EmptyInputException ex)
    {
        String message = ex.getMessage();
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }

}
