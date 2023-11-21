package com.example.airticketreservation.service;

import com.example.airticketreservation.entity.Customer;

public interface ICustomerService {
    boolean registerCustomer(Customer customer);
    boolean loginProcess(String email, String password);

    boolean saveCustomer(Customer customer);
}
