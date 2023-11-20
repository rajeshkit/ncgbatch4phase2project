package com.ats.controller;

import com.ats.entity.Customer;
import com.ats.exception.CustomerIdNotFoundException;
import com.ats.service.CustomerService;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class CustomerControllerTest {
    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateCustomer() {
        Customer c1 = new Customer(1234L,"xyz",new Date(System.currentTimeMillis()),"xyz@gmail.com","xyz");
        when(customerService.createCustomer(any(Customer.class))).thenReturn(true);

        ResponseEntity<String> response = customerController.createCustomer(c1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Customer registered successfully", response.getBody());
    }
    @Test
    void testCustomerSearchById() throws CustomerIdNotFoundException {
        long customerId = 1234L;
        Customer c1 = new Customer(1234L,"xyz",new Date(System.currentTimeMillis()),"xyz@gmail.com","xyz");
        when(customerService.customerSearchById(eq(customerId))).thenReturn(Optional.of(c1));

        Optional<Customer> result = customerController.customerSearchById(customerId);

        assertEquals(c1, result.orElse(null));
    }
    @Test
    void testCustomerLogin() {
        String email = "xyz@gmail.com";
        String password = "xyz";
        when(customerService.customerLogin(eq(email), eq(password))).thenReturn(true);

        ResponseEntity<String> response = customerController.customerLogin(email, password);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Customer login success", response.getBody());
    }

    @Test
    void testGetAllCustomers() {
        Customer c1 = new Customer(1234L,"xyz",new Date(System.currentTimeMillis()),"xyz@gmail.com","xyz");
        Customer c2 = new Customer(1234L,"xyz",new Date(System.currentTimeMillis()),"xyz@gmail.com","xyz");
        List<Customer> customersList = Arrays.asList(c1,c2);
        when(customerService.getAllCustomers()).thenReturn(customersList);

        List<Customer> result = customerController.getAllCustomers();

        assertEquals(customersList.size(), result.size());
    }

}
