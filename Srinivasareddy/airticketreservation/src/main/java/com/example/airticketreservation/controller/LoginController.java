package com.example.airticketreservation.controller;

import com.example.airticketreservation.entity.Customer;
import com.example.airticketreservation.service.ICustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/air-ticket")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    private final ICustomerService loginService;

    @Autowired
    public LoginController(ICustomerService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> authenticate(@RequestBody Customer customer) {
        LOGGER.info("Request received to authenticate user with email: {}", customer.getEmail());

        boolean isAuthenticated = loginService.loginProcess(customer.getEmail(), customer.getPassword());

        if (isAuthenticated) {
            LOGGER.info("Login successful for user with email: {}", customer.getEmail());
            loginService.saveCustomer(customer);
            return ResponseEntity.ok("Login successful");
        } else {
            LOGGER.warn("Login failed for user with email: {}", customer.getEmail());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
