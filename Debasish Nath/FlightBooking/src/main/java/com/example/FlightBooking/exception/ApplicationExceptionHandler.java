package com.example.FlightBooking.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice

public class ApplicationExceptionHandler {
    LocalDateTime currentDateTime = LocalDateTime.now(); // Get the current date and time
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Define the desired format
    String formattedDateTime = currentDateTime.format(formatter);
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> parentException(Exception e)
    {
        ApiErrorResponse api=new ApiErrorResponse(formattedDateTime,HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(api);
    }

    @ExceptionHandler({NoHandlerFoundException.class})
    public ResponseEntity<ApiErrorResponse> handleNoHandlerFoundException(
            NoHandlerFoundException ex, HttpServletRequest httpServletRequest) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(formattedDateTime,404, "Resource not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(apiErrorResponse);
    }
    @ExceptionHandler(CustomerIdNotFoundException.class)
    public ResponseEntity<?> noContentAvaliable(Exception e)
    {
        ApiErrorResponse api=new ApiErrorResponse(formattedDateTime,204,e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(api);
    }
    @ExceptionHandler(FlightIdNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleCustomIdNotFoundException(FlightIdNotFoundException ex)
    {
        ApiErrorResponse api=new ApiErrorResponse(formattedDateTime,204,ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(api);
    }
    @ExceptionHandler(NoFlightFoundException.class)
    public ResponseEntity<ApiErrorResponse> noFlightFoundException(Exception e)
    {
        ApiErrorResponse api=new ApiErrorResponse(formattedDateTime,204,e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(api);
    }
}
