package com.example.airticket.exception;

public class EmptyInputException extends RuntimeException{

    public EmptyInputException(String message)
    {
        super(message);
    }
}