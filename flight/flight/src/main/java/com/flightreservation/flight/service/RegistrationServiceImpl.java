package com.flightreservation.flight.service;

import com.flightreservation.flight.entity.CustomerRegistration;
import com.flightreservation.flight.repository.IRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImpl implements IRegistrationService{

    public final IRegistrationRepo registrationRepo;
@Autowired
    public RegistrationServiceImpl(IRegistrationRepo registrationRepo) {

    this.registrationRepo = registrationRepo;
    }

    @Override
    public CustomerRegistration registration(CustomerRegistration cus) {

        return registrationRepo.save(cus);
    }

    @Override
    public boolean updateCustomerName(int customerId,String name) {

    return false;

    }
    @Override
    public List<CustomerRegistration> findAllRegistration() {
        return registrationRepo.findAll();
    }
}
