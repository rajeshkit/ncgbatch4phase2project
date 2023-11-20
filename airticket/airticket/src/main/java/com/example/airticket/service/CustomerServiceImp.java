package com.example.airticket.service;

import com.example.airticket.entity.Customer;

public interface CustomerServiceImp {
    boolean customerRegistration(Customer customer);

    boolean saveCustomer(Customer customer);

    boolean createLogin(String email, String password);
}
