package com.example.airticket.controller;

import com.example.airticket.entity.CustomerRegistration;
import com.example.airticket.service.ICustomerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer-api")
public class CustomerController {
    private final ICustomerService customerService;
    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    public CustomerController(ICustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping(path = "/customer")
    public String createCustomer(@RequestBody @Valid CustomerRegistration cusdeatils){
        logger.info("Registering New Customer");
        return  customerService.createCustomer(cusdeatils);
    }

    @PostMapping(path ="/login")
    public boolean login(@RequestParam("email")String email ,@RequestParam("password")String password)
    {
        logger.info("Logging in with the help of email and password");
        return customerService.login(email,password);
    }

    @GetMapping(path="/allCustomers")
    public ResponseEntity<Object> getAllCustomers(){
        logger.info("To get all customer deatils");
        return  customerService.getAllCustomers();
    }
}
