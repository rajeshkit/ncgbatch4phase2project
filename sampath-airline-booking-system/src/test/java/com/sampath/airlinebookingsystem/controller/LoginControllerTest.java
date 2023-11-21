package com.sampath.airlinebookingsystem.controller;

import com.sampath.airlinebookingsystem.dtos.ApiResponse;
import com.sampath.airlinebookingsystem.service.interfaces.ILoginService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoginControllerTest {

    @Mock
    private ILoginService loginService;

    @Mock
    private Logger logger;

    @InjectMocks
    private LoginController loginController;

    public LoginControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoginSuccess() {
        String email = "sampath@gmail.com";
        String password = "sampath";

        when(loginService.login(email, password)).thenReturn(true);

        ResponseEntity<ApiResponse> responseEntity = loginController.login(email, password);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertTrue(responseEntity.getBody().getSuccess());
    }

    @Test
    void testLoginFailure() {
        String email = "sampath@gamil.com";
        String password = "smapth";
        when(loginService.login(email, password)).thenReturn(false);
        ResponseEntity<ApiResponse> responseEntity = loginController.login(email, password);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertFalse(responseEntity.getBody().getSuccess());
        assertEquals("Login failed!!", responseEntity.getBody().getMessage());
    }
}
