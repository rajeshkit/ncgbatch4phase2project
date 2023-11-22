package com.flightreservation.flight.controller;

import com.flightreservation.flight.entity.CustomerRegistration;
import com.flightreservation.flight.service.IRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reg-api")

public class RegistrationController {
    public final IRegistrationService registrationService;
@Autowired
    public RegistrationController(IRegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @ResponseBody
    @PostMapping(path="/register")
    public CustomerRegistration registration(@RequestBody CustomerRegistration cus){
        return registrationService.registration(cus);
    }
    @ResponseBody
    @GetMapping(path="/getall")
    public List<CustomerRegistration> findAllRegistration(){
    return registrationService.findAllRegistration();
    }
    @ResponseBody
    @PutMapping(path="/update")
    public boolean updateCustomerName(int customerId,String name){
    return registrationService.updateCustomerName(customerId,name);
    }

}
