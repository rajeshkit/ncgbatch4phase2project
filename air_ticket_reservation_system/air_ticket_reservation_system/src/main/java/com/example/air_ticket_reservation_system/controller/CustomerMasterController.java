package com.example.air_ticket_reservation_system.controller;

import com.example.air_ticket_reservation_system.entity.CustomerMaster;
import com.example.air_ticket_reservation_system.exceptionhandler.EntityNotFoundException;
import com.example.air_ticket_reservation_system.serviceinterfaces.ICustomerMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer-api")
public class CustomerMasterController {

    @Autowired
    ICustomerMaster iCustomerMaster;
    @PostMapping("/register")
    public CustomerMaster registerCustomer(@RequestBody CustomerMaster customerMaster){
        return  iCustomerMaster.registerCustomer(customerMaster);
    }
    @PutMapping("/update")
    public ResponseEntity<CustomerMaster> updateCustomerDetails(@RequestBody CustomerMaster updatedCustomer) throws EntityNotFoundException {
        CustomerMaster updatedCustomerDetails = iCustomerMaster.updateCustomerDetails(updatedCustomer);

        if (updatedCustomerDetails != null) {
            return new ResponseEntity<>(updatedCustomerDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/validate-customer")
    public ResponseEntity<String> validateCustomer(@RequestBody CustomerMaster customer) throws EntityNotFoundException {
        if (iCustomerMaster.validateCustomerDetails(customer)) {
            iCustomerMaster.registerCustomer(customer);
            // Valid customer details, proceed with registration
            // Add your registration logic here, e.g., saving to the database
            // customerRepository.save(customer);

            return new ResponseEntity<>("Customer registered successfully", HttpStatus.OK);
        } else {
            // Invalid customer details
            return new ResponseEntity<>("Invalid customer details or customer ID already exists", HttpStatus.BAD_REQUEST);
        }
    }

}
