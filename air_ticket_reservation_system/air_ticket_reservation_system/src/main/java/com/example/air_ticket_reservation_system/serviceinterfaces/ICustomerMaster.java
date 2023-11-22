package com.example.air_ticket_reservation_system.serviceinterfaces;

import com.example.air_ticket_reservation_system.entity.CustomerMaster;
import com.example.air_ticket_reservation_system.exceptionhandler.EntityNotFoundException;

public interface ICustomerMaster {
    public CustomerMaster registerCustomer(CustomerMaster customerMaster);
    public CustomerMaster getCustomerById(String customerId);
    public CustomerMaster updateCustomerDetails(CustomerMaster updatedCustomer) throws EntityNotFoundException;
    public boolean validateCustomerDetails(CustomerMaster customer) throws EntityNotFoundException;
}
