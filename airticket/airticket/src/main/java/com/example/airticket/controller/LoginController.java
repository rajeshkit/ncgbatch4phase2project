package com.example.airticket.controller;

import com.example.airticket.entity.Customer;
import com.example.airticket.service.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login-api")
public class LoginController {
   private final CustomerServiceImp loginService;
    @Autowired
    public LoginController(CustomerServiceImp loginService) {
        this.loginService = loginService;
    }

    @PostMapping(path="/login")
    @ResponseBody
    public ResponseEntity<String> authenticate(@RequestBody Customer customer) {
        boolean isAuthenticated = loginService.createLogin(customer.getEmail(), customer.getPassword());
        if (isAuthenticated) {
            loginService.saveCustomer(customer);
            return ResponseEntity.ok("Login is successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials! Please provide valid details");
        }
    }

}
