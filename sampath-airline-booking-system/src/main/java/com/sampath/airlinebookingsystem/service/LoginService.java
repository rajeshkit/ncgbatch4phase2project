package com.sampath.airlinebookingsystem.service;

import com.sampath.airlinebookingsystem.entity.Customer;
import com.sampath.airlinebookingsystem.repository.CustomerRepository;
import com.sampath.airlinebookingsystem.service.interfaces.ILoginService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService implements ILoginService {


    private final CustomerRepository customerRepository;

    Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    public LoginService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public boolean login(String email, String password) {
        logger.info("Login");
        Optional<Customer> customerOptional = customerRepository.findByEmailAndPassword(email,
                password);
        return customerOptional.isPresent();
    }
}
