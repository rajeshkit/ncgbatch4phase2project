package com.sampath.airlinebookingsystem.serviceTest;

import com.sampath.airlinebookingsystem.dtos.CustomerDto;
import com.sampath.airlinebookingsystem.entity.Customer;
import com.sampath.airlinebookingsystem.repository.CustomerRepository;
import com.sampath.airlinebookingsystem.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class CustomerServiceTest {

    @MockBean
    private CustomerRepository customerRepository;

    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        ModelMapper modelMapper = new ModelMapper();
        customerService = new CustomerService(customerRepository, modelMapper);
    }

    @Test
    void testCreateCustomer() {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Sampath");

        Customer customer = new Customer();
        customer.setCustomerName("Sampath");

        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        CustomerDto result = customerService.createCustomer(customerDto);
        assertNotNull(result);
        assertEquals("Sampath", result.getCustomerName());
    }


    @Test
    void testUpdateCustomerNotFound() {
        Integer customerId = 1;
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("sampath");

        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setCustomerName("sampath");

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        CustomerDto customerDto1 = customerService.updateCustomer(customerDto,customerId);
        assertNotNull(customerDto1);
        assertEquals("sampath",customerDto1.getCustomerName());


    }

    @Test
    void testGetCustomerById() {
        // Arrange
        Integer customerId = 1;
        CustomerDto expectedCustomerDto = new CustomerDto();
        expectedCustomerDto.setCustomerName("John Doe");

        Customer existingCustomer = new Customer();
        existingCustomer.setCustomerId(customerId);
        existingCustomer.setCustomerName("John Doe");

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(existingCustomer));
        CustomerDto result = customerService.getCustomerById(customerId);
        assertNotNull(result);
        assertEquals("John Doe", result.getCustomerName());
    }

    @Test
    void testGetAllCustomers() {

        Customer c1 = new Customer(1,"sampath",new Date(2000,2,12),"sampath@gmail.com","aa",
                "TYP1","1");
        Customer c2 = new Customer(2,"ravi",new Date(2001,1,21),"ravi@gmail.com","bb",
                "TYP1","1");
        List<Customer> customers = Arrays.asList(c1,c2);

        CustomerDto cd1 = new CustomerDto(1,"sampath",new Date(2000,2,12),"sampath@gmail.com","aa",
                "TYP1","1");
        CustomerDto cd2 = new CustomerDto(2,"ravi",new Date(2001,1,21),"ravi@gmail.com","bb",
                "TYP1","1");

        List<CustomerDto> expectedCustomerDtos = Arrays.asList(cd1,cd2);

        when(customerRepository.findAll()).thenReturn(customers);

        List<CustomerDto> result = customerService.getAllCustomers();
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void testDeleteCustomer() {
        Integer customerId = 1;
        Customer existingCustomer = new Customer();
        existingCustomer.setCustomerId(customerId);
        existingCustomer.setCustomerName("Sampath");
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(existingCustomer));
        customerService.deleteCustomer(customerId);
        verify(customerRepository, times(1)).delete(existingCustomer);
    }
}
