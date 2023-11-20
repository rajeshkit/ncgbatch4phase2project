package com.example.atrs.exception;

import jakarta.validation.ConstraintViolationException;
import jakarta.xml.bind.ValidationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingMatrixVariableException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.NoSuchElementException;

@RestControllerAdvice
public class AtrsExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handlingViolationException(Exception ex, BindingResult br){
        FieldError f=br.getFieldError();
        ApiError api=new ApiError("Constraint Violation!....",(f != null ? f.getDefaultMessage() : null));
        return new ResponseEntity<>(api, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> validationException(Exception ex,BindingResult br){
        FieldError fr=br.getFieldError();
        ApiError api=new ApiError("Validation Exception ",(fr != null ? fr.getDefaultMessage() : null));
        return new ResponseEntity<>(api,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handlingException(Exception ex,BindingResult br){
        FieldError ff=br.getFieldError();
        ApiError apiError=new ApiError("Check the Values Given!....", (ff != null ? ff.getDefaultMessage() : null));
        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(FlightIdNotFoundException.class)
    public ResponseEntity<Object> handlingIdNotFoundException(Exception ex){
        ApiError apiError=new ApiError("Id invalid!.....",ex.getMessage());
        return  new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MissingMatrixVariableException.class)
    public ResponseEntity<Object> handleException(Exception ex,BindingResult br){
        FieldError fe=br.getFieldError();
        ApiError apiError=new ApiError("Sorry!...", (fe != null ? fe.getDefaultMessage() : null));
        return  new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> noElementException(Exception ex){
        ApiError apiError=new ApiError("Check the values given!....",ex.getMessage());
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public ResponseEntity<Object>  dataAccessApiUsage(Exception ex){
        ApiError apiError=new ApiError("Flight is not registered!...",ex.getMessage());
        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidBookingException.class)
    public ResponseEntity<Object> bookingException(Exception ex){
        ApiError apiError=new ApiError("OOPS!...",ex.getMessage());
        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(JpaObjectRetrievalFailureException.class)
    public ResponseEntity<Object> jpaObjectException(JpaObjectRetrievalFailureException ex){
        ApiError apiError=new ApiError("Check the values given!....",ex.getMessage());
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BookingIdNotFoundException.class)
    public ResponseEntity<Object> notFoundException(BookingIdNotFoundException ex){
        ApiError apiError=new ApiError("oops...",ex.getMessage());
        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<Object> pathException(MissingMatrixVariableException ex){
        ApiError apiError=new ApiError("Check the path values given...",ex.getMessage());
        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
    }
    

}
