package com.ats.service;

import com.ats.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    boolean createCustomer(Customer customer);

    Optional<Customer> customerSearchById(long cId);

    boolean customerLogin(String email, String password);

    List<Customer> getAllCustomers();
}
