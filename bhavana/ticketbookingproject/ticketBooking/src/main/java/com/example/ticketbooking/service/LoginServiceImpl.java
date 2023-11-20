package com.example.ticketbooking.service;


import com.example.ticketbooking.repository.LoginReposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    public LoginServiceImpl(LoginReposit loginReposit) {
    }

}
