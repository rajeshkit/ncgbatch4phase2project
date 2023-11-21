package com.example.air_ticket_reservation_system.service;

import com.example.air_ticket_reservation_system.entity.CustomerMaster;
import com.example.air_ticket_reservation_system.exceptionhandler.EntityNotFoundException;
import com.example.air_ticket_reservation_system.repository.CustomerRepository;
import com.example.air_ticket_reservation_system.serviceinterfaces.ICustomerMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerMasterService implements ICustomerMaster {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public CustomerMaster registerCustomer(CustomerMaster customerMaster) {
        return customerRepository.save(customerMaster);
    }

    @Override
    public CustomerMaster getCustomerById(String customerId) {
        Optional<CustomerMaster>opt =customerRepository.findById(customerId);
        CustomerMaster customerMaster= null;
        if(opt.isPresent())
        {
            customerMaster=opt.get();
        }
        return customerMaster;
    }

    @Override
    public CustomerMaster updateCustomerDetails(CustomerMaster updatedCustomer) throws EntityNotFoundException {
        Optional<CustomerMaster> existingCustomerOpt = customerRepository.findById(updatedCustomer.getCustomerId());

        if (existingCustomerOpt.isPresent()) {
            // Customer found, update the details
            CustomerMaster existingCustomer = existingCustomerOpt.get();
            existingCustomer.setCustomerName(updatedCustomer.getCustomerName());
            existingCustomer.setDob(updatedCustomer.getDob());
            existingCustomer.setPassword(updatedCustomer.getPassword());
            existingCustomer.setSsnName(updatedCustomer.getSsnName());
            existingCustomer.setSsnNumber(updatedCustomer.getSsnNumber());

            // Save the updated customer to the database
            return customerRepository.save(existingCustomer);
        } else {
            throw new EntityNotFoundException("Customer Id is not Valid", "Check Customer Id Again!");
            // Customer not found, return null or throw an exception based on your requirements

        }
    }

    @Override
    public boolean validateCustomerDetails(CustomerMaster customer) throws EntityNotFoundException {
        if (isCustomerIdUnique(customer.getCustomerId())) {
            // Additional validation logic can be added here
            // For example, check oEther constraints like age, email format, etc.

            return true; // Customer details are valid
        } else {
            throw new EntityNotFoundException("Customer Id is not Valid", "Check Customer Id Again!"); // Customer ID is not unique

        }
    }

    private boolean isCustomerIdUnique(String customerId) {
        return !customerRepository.existsById(customerId);
    }


}
