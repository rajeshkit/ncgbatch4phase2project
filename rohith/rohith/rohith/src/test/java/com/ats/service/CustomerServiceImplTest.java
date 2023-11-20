package com.ats.service;
import com.ats.entity.Customer;
import com.ats.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest

public class CustomerServiceImplTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    void testCreateCustomer() {
        Customer c1 = new Customer(1234L,"xyz",new Date(System.currentTimeMillis()),"xyz@gmail.com","xyz");
        when(customerRepository.save(any(Customer.class))).thenReturn(c1);
        when(customerRepository.findById(any(Long.class))).thenReturn(Optional.of(c1));

        boolean result = customerService.createCustomer(new Customer(1234L,"xyz",new Date(System.currentTimeMillis()),"xyz@gmail.com","xyz"));
        assertTrue(result);
    }

    @Test
    void testCustomerSearchById() {
        long customerId = 1234L;
        Customer c1 = new Customer(1234L,"xyz",new Date(System.currentTimeMillis()),"xyz@gmail.com","xyz");
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(c1));

        Optional<Customer> result = customerService.customerSearchById(customerId);
        assertTrue(result.isPresent());
    }

    @Test
    void testCustomerLogin() {
        String email = "xyz@gmail.com";
        String password = "xyz";
        when(customerRepository.findByEmailAndPassword(email, password)).thenReturn(Optional.of(new Customer()));

        boolean result = customerService.customerLogin(email, password);
        assertTrue(result);
    }

    @Test
    void testGetAllCustomers() {
        Customer c1 = new Customer(1234L,"xyz",new Date(System.currentTimeMillis()),"xyz@gmail.com","xyz");
        Customer c2 = new Customer(1234L,"xyz",new Date(System.currentTimeMillis()),"xyz@gmail.com","xyz");
        when(customerRepository.findAll()).thenReturn(Arrays.asList(c1,c2));

        List<Customer> result = customerService.getAllCustomers();
        assertEquals(2, result.size());
    }
}
