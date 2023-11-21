package com.example.air_ticket_reservation_system.testcontroller;

import com.example.air_ticket_reservation_system.controller.CustomerMasterController;
import com.example.air_ticket_reservation_system.entity.CustomerMaster;
import com.example.air_ticket_reservation_system.serviceinterfaces.ICustomerMaster;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomerControllerTest {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @InjectMocks
    private CustomerMasterController customerMasterController;

    @Mock
    private ICustomerMaster iCustomerMaster;

    @Test
    void testRegisterCustomer_Success() throws Exception {
        CustomerMaster customerMaster = new CustomerMaster();
        customerMaster.setCustomerName("John Doe");
        customerMaster.setEmail("john@example.com");
        customerMaster.setPassword("password");

        when(iCustomerMaster.registerCustomer(customerMaster)).thenReturn(customerMaster);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(customerMasterController).build();

        mockMvc.perform(post("/customer-api/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerMaster)))
                .andExpect(status().isOk())
                .andExpect(content().string("Customer registered successfully"));
    }

    @Test
    void testRegisterCustomer_Failure() throws Exception {
        CustomerMaster customerMaster = new CustomerMaster();
        customerMaster.setCustomerName("John Doe");
        customerMaster.setEmail("john@example.com");
        customerMaster.setPassword("password");

        when(iCustomerMaster.registerCustomer(customerMaster)).thenReturn(customerMaster);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(customerMasterController).build();
        mockMvc.perform(post("/customer-api/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerMaster)))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Registration failed"));
    }
}
