package com.example.airticketreservation.controller;

import com.example.airticketreservation.entity.Customer;
import com.example.airticketreservation.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/air-ticket")
public class LoginController {

    private final ICustomerService loginService;

    @Autowired
    public LoginController(ICustomerService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> authenticate(@RequestBody Customer customer) {
        boolean isAuthenticated = loginService.loginProcess(customer.getEmail(), customer.getPassword());
        if (isAuthenticated) {
            loginService.saveCustomer(customer);
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}