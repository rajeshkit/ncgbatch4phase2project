package com.example.airticketreservation.exception;

public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException(String message)
    {
        super(message);
    }
}

