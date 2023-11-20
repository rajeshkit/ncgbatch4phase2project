package com.sampath.airlinebookingsystem.controller;

import com.sampath.airlinebookingsystem.dtos.ApiResponse;
import com.sampath.airlinebookingsystem.dtos.CustomerDto;
import com.sampath.airlinebookingsystem.service.interfaces.ICustomerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final ICustomerService customerService;

    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/")
    public ResponseEntity<CustomerDto> createCategory(@Valid @RequestBody CustomerDto customerDto){
        CustomerDto customerDto1 = this.customerService.createCustomer(customerDto);
        return new ResponseEntity<>(customerDto1, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> updateCustomer(@Valid @RequestBody CustomerDto customerDto
            , @PathVariable("customerId") Integer customerId){
        CustomerDto updatedCustomer = this.customerService.updateCustomer(customerDto,customerId);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable("customerId") Integer customerId){
        this.customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(new ApiResponse("Customer deleted sucessfully.." +
                ".!!",true),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CustomerDto>> getAllCustomer(){
        return ResponseEntity.ok(this.customerService.getAllCustomers());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") Integer customerId){
        return ResponseEntity.ok(this.customerService.getCustomerById(customerId));
    }



}
