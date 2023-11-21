package com.example.FlightBooking.service;

import com.example.FlightBooking.entity.CustomerMaster;

import java.util.List;

public interface ICustomerMasterService {
    String insertCustomer(CustomerMaster customer) throws Exception;
    public List<CustomerMaster> getAllCustomer();
}
