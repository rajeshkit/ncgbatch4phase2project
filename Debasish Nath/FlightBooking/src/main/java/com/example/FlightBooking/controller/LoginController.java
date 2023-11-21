package com.example.FlightBooking.controller;

import com.example.FlightBooking.entity.Login;
import com.example.FlightBooking.exception.CustomerIdNotFoundException;
import com.example.FlightBooking.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    public ILoginService iLoginService;

    @PostMapping("/login")
    public String loginCustomer(@RequestBody Login login) throws CustomerIdNotFoundException {
        return iLoginService.loginCustomer(login);
    }
}
