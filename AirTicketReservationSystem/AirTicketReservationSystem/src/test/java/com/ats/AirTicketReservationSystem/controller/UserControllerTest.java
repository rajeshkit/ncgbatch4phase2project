package com.ats.AirTicketReservationSystem.controller;

import com.ats.controller.UserController;
import com.ats.entity.User;
import com.ats.exception.UserException;
import com.ats.service.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private IUserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUser() throws UserException {
        // Mock data
        User user = new User();
        when(userService.createUser(any())).thenReturn(user);

        // Test the controller
        ResponseEntity<User> responseEntity = userController.registerUser(user);

        // Verify the interactions
        verify(userService, times(1)).createUser(user);

        // Verify the response
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(user, responseEntity.getBody());
    }

    @Test
    void testUpdateUser() throws UserException {
        // Mock data
        User user = new User();
        String key = "someKey";
        when(userService.updateUser(any(), any())).thenReturn(user);

        // Test the controller
        ResponseEntity<User> responseEntity = userController.updateUser(user, key);

        // Verify the interactions
        verify(userService, times(1)).updateUser(user, key);

        // Verify the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(user, responseEntity.getBody());
    }
}

