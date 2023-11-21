package com.sampath.airlinebookingsystem.exeception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginNotFoundException extends RuntimeException{
    final String email;
    final String password;

    public LoginNotFoundException(String email, String password) {
        super(String.format("%s or %s is not valid!!",email,password));
        this.email = email;
        this.password = password;
    }
}
