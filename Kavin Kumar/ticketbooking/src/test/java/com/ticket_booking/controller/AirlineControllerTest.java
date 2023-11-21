package com.ticket_booking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ticket_booking.extras.Result;
import com.ticket_booking.entity.Airline;
import com.ticket_booking.service.AirlineServiceInterface;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
class AirlineControllerTest {

    @Mock
    private AirlineServiceInterface airlineService;

    @InjectMocks
    private AirlineController airlineController;

    private MockMvc mockMvc;

    @Test
    void testRegister() throws Exception {
        mockMvc = standaloneSetup(airlineController).build();


        ObjectMapper objectMapper = new Jackson2ObjectMapperBuilder()
                .modules(new JavaTimeModule())
                .build();

        Airline airline = new Airline("air asia", LocalDate.of(2000, 4, 3),"123456",2973);


        Result mockResult = new Result();
        mockResult.setMessage("Airline registered successfully! Airline Id:2973");
        mockResult.setSuccess(true);

        when(airlineService.register(any(Airline.class))).thenReturn( ResponseEntity.ok().body(mockResult) );

        mockMvc.perform(MockMvcRequestBuilders.post("/api/airline/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(airline)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Airline registered successfully! Airline Id:2973"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true));
    }

    @Test
    void testLogin() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(airlineController).build();

        Result mockResult = new Result();
        mockResult.setMessage("Airline Login Success!");
        mockResult.setSuccess(true);

        when(airlineService.login(any(Airline.class))).thenReturn( ResponseEntity.ok().body(mockResult) );

        Airline airline = new Airline("kavin",LocalDate.of(2022,12,12),"123456",2198);



        mockMvc.perform(MockMvcRequestBuilders.post("api/airline/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(airline)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Airline Login Success!"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true));
    }

    @Test
    void testLogout() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(airlineController).build();

        Result mockResult = new Result(true,"Logout success");
        when(airlineService.logout()).thenReturn(ResponseEntity.ok().body(mockResult) );

        mockMvc.perform(MockMvcRequestBuilders.get("api/airline/logout")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Logout success"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true));
    }


}
