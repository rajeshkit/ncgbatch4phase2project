package com.ats.controller;

import com.ats.entity.CurrentUserSession;
import com.ats.entity.UserLoginDTO;
import com.ats.exception.LoginException;
import com.ats.service.ILoginService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ats")
public class UserLoginController {
    private final ILoginService loginService;
    private final Logger logger = LoggerFactory.getLogger(UserLoginController.class);

    @Autowired
    public UserLoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/user/login")
    public ResponseEntity<CurrentUserSession> logInUser(@Valid @RequestBody UserLoginDTO login) throws LoginException {
        logger.info("Received request to login user with login details: {}", login);
        CurrentUserSession currentUserSession = loginService.userLogin(login);
        logger.info("User login successful. User session details: {}", currentUserSession);
        return new ResponseEntity<>(currentUserSession, HttpStatus.ACCEPTED);
    }

    @PostMapping("/user/logout")
    public String logoutUser(@RequestParam(required = false) String key) throws LoginException {
        logger.info("Received request to logout user with key: {}", key);
        String result = loginService.userLogout(key);
        logger.info("User logout result: {}", result);
        return result;
    }
}
