package com.example.FlightBooking.serviceImp;

import com.example.FlightBooking.entity.CustomerMaster;
import com.example.FlightBooking.repository.CustomerMasterRepository;
import com.example.FlightBooking.service.ICustomerMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerMasterServiceImp implements ICustomerMasterService{
    @Autowired
    public CustomerMasterRepository customerMasterRepository;

    @Override
    public String insertCustomer(CustomerMaster customer) throws Exception {
        if(customerMasterRepository.save(customer)==null){
            throw new Exception("Customer is not saved");
        }
        return("CUSTOMER REGISTERED. Customer ID: "+customer.getCustomerId()+" , Customer Name: "+customer.getCustomerName()+" , Customer DOB: "+customer.getDob().toLocalDate()+" , Customer Email: "+customer.getLogin().getEmail()+" , Customer SSN Type: "+customer.getSsnType()+" , Customer SSN Number: "+customer.getSsnType());
    }

    @Override
    public List<CustomerMaster> getAllCustomer() {
        return customerMasterRepository.findAll();
    }
}
