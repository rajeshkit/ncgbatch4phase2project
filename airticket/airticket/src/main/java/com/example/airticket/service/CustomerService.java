package com.example.airticket.service;

import com.example.airticket.entity.Customer;
import com.example.airticket.repository.CustomerRepository;
import com.example.airticket.repository.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@SuppressWarnings("ALL")
@Service
public class CustomerService implements CustomerServiceImp {
    Logger logger = LoggerFactory.getLogger(CustomerService.class);
    private final  CustomerRepository customerRepository;
    private final  LoginRepository loginRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository, LoginRepository loginRepository) {
        this.customerRepository = customerRepository;
        this.loginRepository = loginRepository;
    }

    public boolean customerRegistration(Customer customer) {
        customerRepository.save(customer);
        return true;
    }
    public boolean createLogin(String email, String password) {
        Optional<Customer> customer = customerRepository.findByEmail(email);
        return customer.map(l -> l.getPassword().equals(password)).orElse(false);
    }

    @Override
    public boolean saveCustomer(Customer customer) {
        try {
            loginRepository.save(customer);
            return true;
        } catch (Exception e) {
            logger.info("CustomerService");
            return false;
        }}
}




