package com.example.airticket.service;

import com.example.airticket.entity.CustomerRegistration;
import org.springframework.http.ResponseEntity;

public interface ICustomerService {
    String createCustomer(CustomerRegistration customerdetilas);
    boolean login(String email , String password);
    ResponseEntity<Object> getAllCustomers();

}
