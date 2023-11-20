package com.example.airticketreservation.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerIdNotFound extends RuntimeException{
    private final String msg;

    public CustomerIdNotFound(String msg) {
        this.msg = msg;
    }
}
