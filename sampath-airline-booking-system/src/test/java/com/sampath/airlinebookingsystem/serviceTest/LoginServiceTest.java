package com.sampath.airlinebookingsystem.serviceTest;

import com.sampath.airlinebookingsystem.entity.Customer;
import com.sampath.airlinebookingsystem.repository.CustomerRepository;
import com.sampath.airlinebookingsystem.service.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class LoginServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private LoginService loginService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoginSuccessful() {
        String email = "sampath@gmail.com";
        String password = "1234";

        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPassword(password);

        when(customerRepository.findByEmailAndPassword(email, password)).thenReturn(Optional.of(customer));
        boolean result = loginService.login(email, password);
        assertTrue(result);
    }

    @Test
    void testLoginFailed() {
        String email = "sampath@gmail.com";
        String password = "1234";

        when(customerRepository.findByEmailAndPassword(email, password)).thenReturn(Optional.empty());
        boolean result = loginService.login(email, password);
        assertFalse(result);
    }
}

