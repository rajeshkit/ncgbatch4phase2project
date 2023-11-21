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
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    private final ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
        LOGGER.info("Request received to register a customer with details: {}", customer);

        boolean isRegistered = customerService.registerCustomer(customer);

        if (isRegistered) {
            LOGGER.info("Customer registered successfully: {}", customer.getCustomerName());
            return ResponseEntity.ok("Customer registered successfully");
        } else {
            LOGGER.error("Customer registration failed for: {}", customer.getCustomerName());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
        }
    }
}
