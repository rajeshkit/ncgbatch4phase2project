package com.ticket_booking.controller;

import com.ticket_booking.entity.Customer;
import com.ticket_booking.entity.Flight;
import com.ticket_booking.extras.CreationValidation;
import com.ticket_booking.extras.LoginValidation;
import com.ticket_booking.service.BookingServiceInterface;
import com.ticket_booking.service.CustomerServiceInterface;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/customer")
@RestController
public class CustomerController {
    private final CustomerServiceInterface customerService;
    @Autowired
    public CustomerController(CustomerServiceInterface customerService, BookingServiceInterface bookingService) {
        this.customerService = customerService;
    }

    Logger logger= LoggerFactory.getLogger(CustomerController.class);

    @PostMapping("/register")
    @Validated
    public ResponseEntity<Object> register( @Validated(CreationValidation.class) @RequestBody Customer customer){
        return customerService.register(customer);
    }
    @PostMapping("/login")
    @Validated
    public ResponseEntity<Object> customerLogin(@RequestBody @Validated(LoginValidation.class) Customer login){
        return  customerService.customerLogin(login);
    }

    @GetMapping("/logout")
    public ResponseEntity<Object> logout(){
        return customerService.logout();
    }
    @GetMapping("/id/{customerId}")
    public ResponseEntity<Object> findCustomer(@PathVariable int customerId){
        return customerService.findCustomer(customerId);
    }
    @GetMapping("/email/{customerEmail}")
    public ResponseEntity<Object> findCustomer(@PathVariable String customerEmail){
        return customerService.findCustomer(customerEmail);
    }

    @PostMapping("/flights")
    public ResponseEntity<Object> getFlights(@Valid Flight flight){

        return customerService.getAllFlights(flight);
    }
}
