package com.example.atrs.controller;

import com.example.atrs.entity.CustomerMaster;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.example.atrs.service.CustomerServiceImp;

import java.util.List;

@RestController
@RequestMapping(path = "/customer-api")
public class CustomerController {
    private final CustomerServiceImp customerServiceImp;
    public CustomerController(CustomerServiceImp customerServiceImp){
        this.customerServiceImp = customerServiceImp;
    }

    @PostMapping(path = "/customerRegister")
    public String registerCustomer(@RequestBody @Valid CustomerMaster customerMaster){
     return customerServiceImp.registerCustomer(customerMaster);
    }
    @GetMapping (path = "/customerLogin")
        public String login(@RequestParam("email")String email,@RequestParam("password")String password){
        boolean cusLogin= customerServiceImp.customerLogin(email,password);
        if(cusLogin){
            return "Login Successful";
        }
        else{
            return "Login failed";
        }
 }
 @GetMapping(path = "/customers")
    public List<CustomerMaster> searchAllCustomer(){
        return customerServiceImp.getAllCustomerInfo();
 }

}
