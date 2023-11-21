package com.example.ticketbooking.service;

import com.example.ticketbooking.entity.Customer;
import com.example.ticketbooking.repository.CustomerReposit;
import com.example.ticketbooking.repository.LoginReposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerReposit customerRepository;
    private final LoginReposit loginReposit;
@Autowired
    public CustomerServiceImpl(CustomerReposit customerRepository, LoginReposit loginReposit) {
        this.customerRepository = customerRepository;
        this.loginReposit = loginReposit;
    }

    public boolean registerCustomer(Customer customer) {
        customerRepository.save(customer);
        return true;
    }

    public boolean performLogin(String email, String password) {
        Optional<Customer> customer = customerRepository.findByEmail(email);
        return customer.map(l -> l.getPassword().equals(password)).orElse(false);
    }

    @Override
    public boolean saveCustomer(Customer customer) {
        try {
            loginReposit.save(customer);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
