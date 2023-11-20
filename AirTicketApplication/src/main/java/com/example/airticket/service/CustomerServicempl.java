package com.example.airticket.service;

import com.example.airticket.entity.CustomerRegistration;
import com.example.airticket.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServicempl implements ICustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServicempl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public String createCustomer(CustomerRegistration customerdetilas) {
        if(customerRepository.existsByEmail(customerdetilas.getEmail())){
            return "The email has been registered already";
        }
        else{
            customerRepository.save(customerdetilas);
             return "Successfully Registered Customer";
        }

    }

    public boolean login(String email , String password)
    {
        Optional<CustomerRegistration> customer = customerRepository.findByEmailAndPassword(email,password);
        return customer.isPresent();
    }

    @Override
    public ResponseEntity<Object> getAllCustomers() {
        List<CustomerRegistration> customers = customerRepository.findAll();
        if (customers.isEmpty()) {
            String msg = "No customer has been registered";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        } else {
            return ResponseEntity.ok(customers);
        }
    }
}
