package com.sampath.airlinebookingsystem.service.interfaces;

import com.sampath.airlinebookingsystem.dtos.CustomerDto;

import java.util.List;

public interface ICustomerService {

    public CustomerDto createCustomer(CustomerDto customerDto);
    public CustomerDto updateCustomer(CustomerDto customerDto, Integer customerId);

    public CustomerDto getCustomerById(Integer customerId);
    public List<CustomerDto> getAllCustomers();
    public void deleteCustomer(Integer customerId);

}
