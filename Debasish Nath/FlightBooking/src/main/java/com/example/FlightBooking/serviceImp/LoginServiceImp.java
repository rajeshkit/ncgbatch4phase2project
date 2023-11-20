package com.example.FlightBooking.serviceImp;

import com.example.FlightBooking.entity.Login;
import com.example.FlightBooking.exception.CustomerIdNotFoundException;
import com.example.FlightBooking.repository.LoginRepository;
import com.example.FlightBooking.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements ILoginService {
    @Autowired
    public LoginRepository loginRepository;

    @Override
    public String loginCustomer(Login login) throws CustomerIdNotFoundException {

        Login login1 = loginRepository.findByEmailAndPassword(login.getEmail(),login.getPassword());
        if (login1 == null){
            throw new CustomerIdNotFoundException("Invalid username or password.");
        }
        return("Login Successful for " + login.getEmail());
    }
}
