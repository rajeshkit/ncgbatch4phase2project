package com.example.airticket.controller;

import com.example.airticket.entity.Customer;
import com.example.airticket.service.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerController {
    private final CustomerServiceImp customerService;
 @Autowired
    public CustomerController(CustomerServiceImp customerService) {
        this.customerService = customerService;
    }

    @PostMapping(path="/customer")
    public ResponseEntity<String> customerRegistration(@RequestBody Customer customer){
        boolean isRegistered = customerService.customerRegistration(customer);
            if (isRegistered) {
                return ResponseEntity.ok("Customer has registered successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please Check!! Registration failed");
            }
        }
    }

