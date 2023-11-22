package com.example.airticketreservation.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerIdNotFound extends RuntimeException{
    private final String msg;


    public CustomerIdNotFound(String msg) {
        this.msg = msg;
    }
}
