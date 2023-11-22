package com.flightreservation.flight.service;

import com.flightreservation.flight.entity.CustomerRegistration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface IRegistrationService {

    public CustomerRegistration registration(CustomerRegistration cus);
    public boolean updateCustomerName(int customerId,String name);
    public List<CustomerRegistration> findAllRegistration();
}
