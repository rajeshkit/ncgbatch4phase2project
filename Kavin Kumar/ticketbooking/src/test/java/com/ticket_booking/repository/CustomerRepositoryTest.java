package com.ticket_booking.repository;

import com.ticket_booking.extras.Result;
import com.ticket_booking.entity.Customer;
import com.ticket_booking.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;


import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerRepositoryTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    private Result result;

    @Test
    void testSaveCustomer() {
        Customer sampleCustomer = new Customer(13082356,"kavin",
                LocalDate.of(2000, 4, 3), "kavin@gmail.com",
                "kavin123", "aadhar", "1234567");

        when(customerRepository.save(sampleCustomer)).thenReturn(sampleCustomer);


        ResponseEntity<Object> responseEntity = customerService.register(sampleCustomer);


        assertNotNull(responseEntity);


        assertEquals(200, responseEntity.getStatusCodeValue());

        Result result = (Result) responseEntity.getBody();
        assertNotNull(result);
        assertEquals("Register success! Customer Id:13082356", result.getMessage());
        assertTrue(result.isSuccess());
    }
}


