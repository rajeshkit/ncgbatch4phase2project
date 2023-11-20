package com.example.airticketreservation.service;


import com.example.airticketreservation.repository.LoginRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService implements ILoginService{

    public final LoginRep loginRep;

    @Autowired
    public LoginService(LoginRep loginRep) {
        this.loginRep = loginRep;
    }
}
