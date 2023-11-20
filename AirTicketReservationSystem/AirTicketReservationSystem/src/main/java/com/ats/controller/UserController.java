package com.ats.controller;

import com.ats.entity.User;
import com.ats.exception.UserException;
import com.ats.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ats")
public class UserController {
    private final IUserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody User user) throws UserException {
        logger.info("Received request to register user with details: {}", user);
        User savedUser = userService.createUser(user);
        logger.info("User registered successfully. User details: {}", savedUser);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("/user/update")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user, @RequestParam(required = false) String key) throws UserException {
        logger.info("Received request to update user with details: {}", user);
        User updatedUser = userService.updateUser(user, key);
        logger.info("User updated successfully. Updated user details: {}", updatedUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
