package com.example.FlightBooking.service;

import com.example.FlightBooking.entity.Login;
import com.example.FlightBooking.exception.CustomerIdNotFoundException;
import com.example.FlightBooking.repository.LoginRepository;
import com.example.FlightBooking.serviceImp.LoginServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestLoginServiceImp {
    @Mock
    private LoginRepository loginRepository;
    @InjectMocks
    private LoginServiceImp loginService;
    private Login validLogin;
    private Login invalidLogin;

    @BeforeAll
    public void setup(){
        MockitoAnnotations.initMocks(this);
        validLogin = new Login();
        validLogin.setEmail("admin@mail.com");
        validLogin.setPassword("admin");

        invalidLogin = new Login();
        invalidLogin.setEmail("admin@mail.com");
        invalidLogin.setPassword("wrong");

        Mockito.when(loginRepository.findByEmailAndPassword(validLogin.getEmail(),validLogin.getPassword())).thenReturn(validLogin);
    }

    @Test
    public void testValidLogin() throws CustomerIdNotFoundException {
        String response =  loginService.loginCustomer(validLogin);
        Assertions.assertEquals(("Login Successful for " + validLogin.getEmail()), response);
    }

    @Test
    public void testInvalidLogin() {
        Assertions.assertThrows(CustomerIdNotFoundException.class, () -> {
            loginService.loginCustomer(invalidLogin);
        });
    }
}
