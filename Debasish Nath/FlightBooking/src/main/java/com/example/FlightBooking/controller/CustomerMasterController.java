package com.example.FlightBooking.controller;

import com.example.FlightBooking.entity.CustomerMaster;
import com.example.FlightBooking.service.ICustomerMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerMasterController {
    @Autowired
    public ICustomerMasterService iCustomerMasterService;

    @PostMapping("/customer")
    public String addCustomer(@RequestBody CustomerMaster customerMaster) throws Exception {
        return iCustomerMasterService.insertCustomer(customerMaster);
    }
    @GetMapping("/customers")
    public List<CustomerMaster> getAllCustomer(){
        return iCustomerMasterService.getAllCustomer();
    }

}
