package com.sampath.airlinebookingsystem.service;

import com.sampath.airlinebookingsystem.dtos.CustomerDto;
import com.sampath.airlinebookingsystem.entity.Customer;
import com.sampath.airlinebookingsystem.exeception.ResourceNotFoundException;
import com.sampath.airlinebookingsystem.repository.CustomerRepository;
import com.sampath.airlinebookingsystem.service.interfaces.ICustomerService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CustomerService implements ICustomerService {


    private final CustomerRepository customerRepository;


    private final ModelMapper modelMapper;

    Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    public CustomerService(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = this.modelMapper.map(customerDto,Customer.class);
        Customer savedCustomer = this.customerRepository.save(customer);
        logger.info("created successfully {}",savedCustomer);
        return this.modelMapper.map(savedCustomer,CustomerDto.class);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto, Integer customerId) {

        Customer customer =
                this.customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer","customer id",customerId));

        customer.setCustomerName(customerDto.getCustomerName());
        customer.setDob(customerDto.getDob());
        customer.setEmail(customerDto.getEmail());
        customer.setPassword(customerDto.getPassword());
        customer.setSsnType(customerDto.getSsnType());
        customer.setSsnNo(customerDto.getSsnNo());

        Customer updatedCustomer = this.customerRepository.save(customer);
        logger.info("Updated successfully {}",updatedCustomer);
        return this.modelMapper.map(updatedCustomer,CustomerDto.class);
    }

    @Override
    public CustomerDto getCustomerById(Integer customerId) {
        Customer customer =
                this.customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer service class","customer number",customerId));
        logger.info("getting customer by id {}",customer);
        return this.modelMapper.map(customer,CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = this.customerRepository.findAll();
        List<CustomerDto> customerDtos =
                customers.stream().map(customer->this.modelMapper.map(customer,
                        CustomerDto.class)).collect(Collectors.toList());
        logger.info("getting all customers...");
        return customerDtos;
    }

    @Override
    public void deleteCustomer(Integer customerId) {
    Customer customer =
            this.customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer","customer id",customerId));
    this.customerRepository.delete(customer);
    logger.info("Deleted customer {}",customer);
    }
}
