package com.ats.controller;

import com.ats.entity.Customer;
import com.ats.exception.CustomerIdNotFoundException;
import com.ats.service.CustomerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ats/customer-api")
public class CustomerController {

    Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<String> createCustomer(@RequestBody @Valid Customer customer) {
        boolean isRegistered = customerService.createCustomer(customer);
        if (isRegistered) {
            logger.info("Customer registered successfully");
            return ResponseEntity.ok("Customer registered successfully");
        } else {
            logger.error("Customer creation error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
        }
    }

    @GetMapping("customer/{id}")
    public Optional<Customer> customerSearchById(@PathVariable("id") long cId)throws CustomerIdNotFoundException {
        if (customerService.customerSearchById(cId).isEmpty()){
            logger.error("Customer NotFound");
            throw new CustomerIdNotFoundException("CustomerId is not found");
        }
        logger.info("Customer Found");
        return customerService.customerSearchById(cId);
    }

    @GetMapping("/customer/{email}/{password}")
    public ResponseEntity<String> customerLogin(@PathVariable("email") String email,@PathVariable("password")String password){
        boolean isRegistered = customerService.customerLogin(email,password);
        if (isRegistered) {
            logger.info("Customer login success");
            return ResponseEntity.ok("Customer login success");
        } else {
            logger.error("Customer login error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("login failed");
        }
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        logger.info("All Customers");
        return customerService.getAllCustomers();
    }

}
