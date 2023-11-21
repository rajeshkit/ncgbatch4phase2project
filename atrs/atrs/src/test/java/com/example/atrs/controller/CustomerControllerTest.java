package com.example.atrs.controller;
import com.example.atrs.entity.CustomerMaster;
import com.example.atrs.service.CustomerServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
    @MockBean
    CustomerServiceImp customerServiceImp;
    @Autowired
     MockMvc mockMvc;

    @Test
    void registerCustomer() throws Exception{
        CustomerMaster customerMaster=new CustomerMaster(101,"Naruto",new Date(2000-1-1),"naruto@gmail.com","123455","n12","active");
        when(customerServiceImp.registerCustomer(any(CustomerMaster.class))).thenReturn("Register Success");
        mockMvc.perform(MockMvcRequestBuilders.post("/customer-api/customerRegister").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(customerMaster))).andExpect(status().isOk());
    }
    @Test
    void customerLogin() throws Exception{
        when(customerServiceImp.customerLogin("naruto@gmail.com","123455")).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.get("/customer-api/customerLogin").param("email","naruto@gmail.com").param("password","123455")).andExpect(status().isOk()).andExpect(content().string("Login Successful"));
    }
    @Test
    void getAllCustomer() throws Exception{
        CustomerMaster customerMaster1=new CustomerMaster(101,"Naruto",new Date(2000-1-1),"naruto@gmail.com","123455","n12","active");
        CustomerMaster customerMaster2=new CustomerMaster(102,"Minato",new Date(2009-1-1),"Minato@gmail.com","123456","n16","active");
        List<CustomerMaster> customer= Arrays.asList(customerMaster1,customerMaster2);
        when(customerServiceImp.getAllCustomerInfo()).thenReturn(customer);
        mockMvc.perform(MockMvcRequestBuilders.get("/customer-api/getAllCustomers")).andExpect(status().isOk());
    }
}
