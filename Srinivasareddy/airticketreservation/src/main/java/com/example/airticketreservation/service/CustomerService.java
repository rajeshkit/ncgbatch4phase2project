package com.example.airticketreservation.service;
import com.example.airticketreservation.entity.Customer;
import com.example.airticketreservation.repository.CustomerRep;
import com.example.airticketreservation.repository.LoginRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerService implements ICustomerService {
    private final CustomerRep customerRep;

    private final LoginRep loginRepository;

    @Autowired
    public CustomerService(CustomerRep customerRep, LoginRep loginRepository) {
        this.customerRep = customerRep;
        this.loginRepository = loginRepository;
    }

    public boolean registerCustomer(Customer customer) {
        customerRep.save(customer);
        return true;
    }

    public boolean loginProcess(String email, String password) {
        Optional<Customer> customer = customerRep.findByEmail(email);
        return customer.map(l -> l.getPassword().equals(password)).orElse(false);
    }

    @Override
    public boolean saveCustomer(Customer customer) {
        try {
            loginRepository.save(customer);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
