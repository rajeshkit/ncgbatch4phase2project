package com.ats.service;

import com.ats.entity.Customer;
import com.ats.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public boolean createCustomer(Customer customer) {
        Customer cust = customerRepository.save(customer);
        Optional<Customer> opt = customerRepository.findById(cust.getCustomerId());
        if (opt.isPresent()){
            return true;
        }
        return false;
    }

    @Override
    public Optional<Customer> customerSearchById(long cId) {
        return customerRepository.findById(cId);
    }

    @Override
    public boolean customerLogin(String email, String password) {
        Optional<Customer> cl = customerRepository.findByEmailAndPassword(email,password);
        if (cl.isPresent()){
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
