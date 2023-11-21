package com.example.FlightBooking.service;


import com.example.FlightBooking.entity.Login;
import com.example.FlightBooking.exception.CustomerIdNotFoundException;

public interface ILoginService {
    String loginCustomer(Login login) throws CustomerIdNotFoundException;
}
