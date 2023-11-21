package com.example.atrs.service;

import com.example.atrs.entity.CustomerMaster;
import com.example.atrs.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
 class CustomerServiceImpTest {
    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private CustomerServiceImp customerServiceImp;
    @Test
    void registerCustomer(){
        CustomerMaster customerMaster1=new CustomerMaster(101,"Naruto",new Date(2000-1-1),"naruto@gmail.com","123455","n12","active");
        String cus= customerServiceImp.registerCustomer(customerMaster1);
        verify(customerRepository, times(1)).save(customerMaster1);
        assertEquals("Customer registered successFully",cus);
    }
    @Test
    void loginCus(){
        CustomerMaster customerMaster1=new CustomerMaster(101,"Naruto",new Date(2000-1-1),"naruto@gmail.com","123455","n12","active");
        when(customerRepository.findByEmailAndPassword("naruto@gmail.com", "123455")).thenReturn(Optional.of(customerMaster1));
        boolean loginStatus = customerServiceImp.customerLogin("naruto@gmail.com", "123455");
        verify(customerRepository, times(1)).findByEmailAndPassword("naruto@gmail.com", "123455");
        assertTrue(loginStatus);
    }
}
