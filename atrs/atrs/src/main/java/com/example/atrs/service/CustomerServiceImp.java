package com.example.atrs.service;

import com.example.atrs.entity.CustomerMaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.example.atrs.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerRegister{
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImp.class);
    private final CustomerRepository customerRepository;
    public CustomerServiceImp(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    @Override
    public String registerCustomer(CustomerMaster customerMaster) {
        if(customerRepository.existsByEmail(customerMaster.getEmail())){
            logger.error("Email already exist in database");
            return "email already exist";
        }else {
            customerRepository.save(customerMaster);
            logger.info("Customer Registered");
            return "Customer registered successFully";
        }
    }
    @Override
    public boolean customerLogin(String email, String password) {
        Optional<CustomerMaster> customerMaster=customerRepository.findByEmailAndPassword(email,password);
        boolean details;
        details = customerMaster.isPresent();
        logger.info("Login successful");
        return details;
    }
    @Override
    public List<CustomerMaster> getAllCustomerInfo(){
        logger.info("Displaying all customer information");
       return customerRepository.findAll();
    }
}
