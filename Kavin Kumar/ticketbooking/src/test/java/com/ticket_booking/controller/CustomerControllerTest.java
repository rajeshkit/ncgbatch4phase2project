package com.ticket_booking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticket_booking.extras.Result;
import com.ticket_booking.entity.Booking;
import com.ticket_booking.entity.Customer;
import com.ticket_booking.service.BookingServiceInterface;
import com.ticket_booking.service.CustomerServiceInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerServiceInterface customerService;

    @MockBean
    private BookingServiceInterface bookingService;

    @Test
    void testRegisterCustomer() throws Exception {

        Result expectedResult = new Result(true,"Register success! Customer Id:13086917");
        when(customerService.register(any(Customer.class)))
                .thenReturn(ResponseEntity.ok().body(expectedResult));

        mockMvc.perform(post("/api/customer/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "   \n" +
                                "   \"name\":\"rohith\",\n" +
                                "   \"dob\":\"2000-12-12\",\n" +
                                "   \"email\":\"rohith2@gmail.com\",\n" +
                                "   \"password\":13080303,\n" +
                                "   \"idCardType\":\"sfsff\",\n" +
                                "   \"idCardNo\":352644\n" +
                                "  \n" +
                                "\n" +
                                "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(expectedResult.getMessage()))
                .andExpect(jsonPath("$.success").value(expectedResult.isSuccess()));
    }

    @Test
    void testLogout() throws Exception {
        // Mock service response
        Result expectedResult = new Result(true,"Logout success!");
        when(customerService.logout())
                .thenReturn(ResponseEntity.ok().body(expectedResult));

        // Perform the request and assert the response
        mockMvc.perform(get("/api/customer/logout"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(expectedResult.getMessage()))
                .andExpect(jsonPath("$.success").value(expectedResult.isSuccess()));
    }

    @Test
    void testFindCustomerById() throws Exception {
        // Mock service response
        Customer expectedResult = new Customer(13082356,"kavin",
                LocalDate.of(2000, 4, 3), "kavin@gmail.com",
                "kavin123", "aadhar", "1234567");

        when(customerService.findCustomer(13082356))
                .thenReturn(ResponseEntity.ok().body(expectedResult));

        // Perform the request and assert the response
        mockMvc.perform(get("api/customer/id/{customerId}", 13082356))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(expectedResult.getId()))
                .andExpect(jsonPath("$.name").value(expectedResult.getName()))
                .andExpect(jsonPath("$.dob").value(expectedResult.getDob().toString()))
                .andExpect(jsonPath("$.email").value(expectedResult.getEmail()))
                .andExpect(jsonPath("$.password").value(expectedResult.getPassword()))
                .andExpect(jsonPath("$.idCardType").value(expectedResult.getIdCardType()))
                .andExpect(jsonPath("$.idCardNo").value(expectedResult.getIdCardNo()));
    }
    @Test
    void testFindCustomerByEmail() throws Exception {
        Customer expectedResult = new Customer(13082356,"kavin",
                LocalDate.of(2000, 4, 3), "kavin@gmail.com",
                "kavin123", "aadhar", "1234567");

        when(customerService.findCustomer("kavin@gmail.com"))
                .thenReturn(ResponseEntity.ok().body(expectedResult));


        mockMvc.perform(get("/api/customer/email/{customerEmail}", "kavin@gmail.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(expectedResult.getId()))
                .andExpect(jsonPath("$.name").value(expectedResult.getName()))
                .andExpect(jsonPath("$.dob").value(expectedResult.getDob().toString()))
                .andExpect(jsonPath("$.email").value(expectedResult.getEmail()))
                .andExpect(jsonPath("$.password").value(expectedResult.getPassword()))
                .andExpect(jsonPath("$.idCardType").value(expectedResult.getIdCardType()))
                .andExpect(jsonPath("$.idCardNo").value(expectedResult.getIdCardNo()));
    }


    @Test
    void testBookTickets() throws Exception {
        // Mock service response
        Result expectedResult = new Result(true, "Tickets booked successfully!");

        when(bookingService.bookTickets(any(Booking.class)))
                .thenReturn(ResponseEntity.ok().body(expectedResult));

        // Input payload
        Booking bookingDTO = new Booking();
        bookingDTO.setFlightNumber(125);
        bookingDTO.setNoOfSeats(3);
        final ObjectMapper objectMapper = new ObjectMapper();


        // Perform the request and assert the response
        mockMvc.perform(post("api/booking/book-tickets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bookingDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(expectedResult.getMessage()))
                .andExpect(jsonPath("$.success").value(expectedResult.isSuccess()));
    }


    @Test
    void testGetBooking() throws Exception {
        // Mock service response
        Result expectedResult = new Result(true,"Booking details found!");
        when(bookingService.getBooking(1))
                .thenReturn(ResponseEntity.ok().body(expectedResult));

        // Perform the request and assert the response
        mockMvc.perform(get("/customer-api/get-booking/{bookingId}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(expectedResult.getMessage()))
                .andExpect(jsonPath("$.success").value(expectedResult.isSuccess()));
    }


}