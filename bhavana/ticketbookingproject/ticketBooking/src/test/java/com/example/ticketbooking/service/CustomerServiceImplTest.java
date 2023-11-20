package com.example.ticketbooking.service;
import com.example.ticketbooking.entity.Customer;
import com.example.ticketbooking.repository.CustomerReposit;
import com.example.ticketbooking.repository.LoginReposit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {
    @Mock
    private CustomerReposit customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private LoginReposit loginRepository;

    @Test
    void testRegisterCustomer() {
        Customer customer = new Customer();

        Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(customer);

        boolean result = customerService.registerCustomer(customer);

        assertTrue(result);
    }

    @Test
    void testPerformLogin() {
        String email = "test@example.com";
        String password = "password";

        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPassword(password);

        Mockito.when(customerRepository.findByEmail(email)).thenReturn(Optional.of(customer));

        boolean result = customerService.performLogin(email, password);

        assertTrue(result);
    }

    @Test
    void testSaveCustomer_Success() {
        Customer customer = new Customer();

        Mockito.when(loginRepository.save(Mockito.any(Customer.class))).thenReturn(customer);

        boolean result = customerService.saveCustomer(customer);

        assertTrue(result);
    }

    @Test
    void testSaveCustomer_Failure() {
        Customer customer = new Customer();

        Mockito.when(loginRepository.save(Mockito.any(Customer.class))).thenThrow(RuntimeException.class);

        boolean result = customerService.saveCustomer(customer);

        assertFalse(result);
    }
}
