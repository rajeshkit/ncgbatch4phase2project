package com.example.FlightBooking.service;

import com.example.FlightBooking.entity.CustomerMaster;
import com.example.FlightBooking.entity.Login;
import com.example.FlightBooking.repository.CustomerMasterRepository;
import com.example.FlightBooking.serviceImp.CustomerMasterServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.Collections;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCustomerMasterServiceImp {
    @Mock
    private CustomerMasterRepository customerMasterRepository;
    @InjectMocks
    private CustomerMasterServiceImp customerMasterService;
    private CustomerMaster customerMaster;
    private Login login;

    @BeforeAll
    public void setup(){
        MockitoAnnotations.initMocks(this);
        customerMaster = new CustomerMaster();
        customerMaster.setCustomerId(1001L);
        customerMaster.setCustomerName("Customer1");
        customerMaster.setDob(new Date(1997,1,19));
        customerMaster.setSsnNo("SSN1");
        customerMaster.setSsnType("SSNTYPE");

        login = new Login();
        login.setEmail("admin@mail.com");
        login.setPassword("admin");
        customerMaster.setLogin(login);

        Mockito.when(customerMasterRepository.save(Mockito.any(CustomerMaster.class))).thenReturn(customerMaster);
        Mockito.when(customerMasterRepository.findAll()).thenReturn(Collections.singletonList(customerMaster));
    }

    @Test
    public void testSaveCustomer() throws Exception {
       Assertions.assertNotNull(customerMasterService.insertCustomer(customerMaster));
    }

    @Test
    public void testGetAllCustomers(){

        Assertions.assertNotNull(customerMasterService.getAllCustomer());
    }
}
