package com.example.atrs.service;

import com.example.atrs.entity.CustomerMaster;

import java.util.List;

public interface CustomerRegister {
    String registerCustomer(CustomerMaster customerMaster);
     boolean customerLogin(String email,String password);
     List<CustomerMaster> getAllCustomerInfo();
}
