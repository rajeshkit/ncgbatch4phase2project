package com.example.air_ticket_reservation_system.controller;

import com.example.air_ticket_reservation_system.dto.LoginRequest;
import com.example.air_ticket_reservation_system.entity.CustomerMaster;
import com.example.air_ticket_reservation_system.serviceinterfaces.ICustomerMaster;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login-api")
public class LoginController {

    @Autowired
    ICustomerMaster iCustomerMaster;
    @PostMapping
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest loginRequest) {
        CustomerMaster customerMaster = iCustomerMaster.getCustomerById(loginRequest.getCustomerAccountNumber());
      if(customerMaster!=null && customerMaster.getPassword().equals(loginRequest.getPassword())){
          return ResponseEntity.ok("Login SuccessFull");
      }
      else{
          return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login Failed");
      }
  }

}
