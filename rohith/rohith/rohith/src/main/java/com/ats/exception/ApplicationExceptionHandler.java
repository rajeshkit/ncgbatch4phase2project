package com.ats.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;
import java.util.List;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(CustomerIdNotFoundException.class)
    public ResponseEntity<?> handlerCustomerIdNotFoundException(Exception ex){
        ApiError api = new ApiError(new Date(),ex.getMessage(), "Check your customer id!! Enter valid customer Id");
        ResponseEntity<?> responseEntity = new ResponseEntity<>(api, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(FlightIdNotFoundException.class)
    public ResponseEntity<?> handlerFlightIdNotFoundException(Exception ex){
        ApiError api = new ApiError(new Date(),ex.getMessage(), "Check your Flight id!! Enter valid Flight Id");
        ResponseEntity<?> responseEntity = new ResponseEntity<>(api, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<?> handlerFlightNotFoundException(Exception ex){
        ApiError api = new ApiError(new Date(),ex.getMessage(), "Check your variable in the Json data,Enter valid details");
        ResponseEntity<?> responseEntity = new ResponseEntity<>(api, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(BookingIdNotFoundException.class)
    public ResponseEntity<?> handlerBookingIdNotFoundException(Exception ex){
        ApiError api = new ApiError(new Date(),ex.getMessage(), "Check your Booking id!! Enter valid Booking Id");
        ResponseEntity<?> responseEntity = new ResponseEntity<>(api, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ApiError> handleNoHandlerFoundException(
            NoHandlerFoundException ex, HttpServletRequest httpServletRequest) {
        ApiError apiError = new ApiError(new Date(),"Entered Url is incorrect, pls check the Url", "404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerValidationException(Exception ex, BindingResult br){
        List<FieldError> list = br.getFieldErrors();
        StringBuilder sb= new StringBuilder();
        for (FieldError fe:list) {
            sb.append(fe.getField()+" "+ fe.getDefaultMessage()+",");
        }
        ApiError api = new ApiError(new Date(),sb.toString(), "Check your json input data");
        ResponseEntity<?> responseEntity = new ResponseEntity<>(api, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }
}
