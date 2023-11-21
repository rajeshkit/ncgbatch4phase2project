package com.example.airticketreservation.exception;

public class EmptyInputException extends RuntimeException{

    public EmptyInputException(String message)
    {
        super(message);
    }
}