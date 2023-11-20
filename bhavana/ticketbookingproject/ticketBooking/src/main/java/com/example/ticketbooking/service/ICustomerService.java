package com.example.ticketbooking.service;

import com.example.ticketbooking.entity.Customer;

public interface ICustomerService {
    boolean registerCustomer(Customer customer);

    boolean performLogin(String email, String password);

    boolean saveCustomer(Customer customer);

}
