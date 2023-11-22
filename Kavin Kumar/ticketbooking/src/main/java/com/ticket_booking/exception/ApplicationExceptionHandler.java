package com.ticket_booking.exception;

import com.ticket_booking.extras.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.format.DateTimeParseException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    Logger logger= LoggerFactory.getLogger(ApplicationExceptionHandler.class);
    String message;
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object>handleValidationException(Exception ex, BindingResult br){
        FieldError fe=br.getFieldError();
        if (fe!=null)
        {
            logger.error(fe.getDefaultMessage());
        }
        message= fe != null ? fe.getDefaultMessage() : null;
        Result result=new Result(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<Object> handleInvalidDateFormat(Exception ex){
        message="Invalid time format please enter a valid time";
        logger.error(message);
        Result result=new Result(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    @ExceptionHandler(ValueNotFoundException.class)
    public ResponseEntity<Object> handleValueNotFoundException(Exception ex){
        message=ex.getMessage();
        logger.error(message);
        Result result=new Result(message);
        return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ValueAlreadyExistsException.class)
    public ResponseEntity<Object> handleValueAlreadyExists(Exception ex){
        message= ex.getMessage();
        logger.error(message);
        Result result=new Result(message);
        return new ResponseEntity<>(result,HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(UnexpectedErrorException.class)
    public ResponseEntity<Object> handleUnexpectedError(Exception ex){
        message=ex.getMessage();
        logger.error(message);
        Result result=new Result(message);
        return new ResponseEntity<>(result,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotLoggedInException.class)
    public ResponseEntity<Object> handleNotLoggedInException(Exception ex){
        message= ex.getMessage();
        logger.error(message);
        Result result=new Result(message);
        return new ResponseEntity<>(result,HttpStatus.UNAUTHORIZED);
    }

}
