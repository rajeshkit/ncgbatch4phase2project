package com.sampath.airlinebookingsystem.controller;

import com.sampath.airlinebookingsystem.dtos.ApiResponse;
import com.sampath.airlinebookingsystem.service.interfaces.ILoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final ILoginService loginService;

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    public LoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestParam("email") String email, @RequestParam(
            "password") String password){
       boolean login = this.loginService.login(email,password);
       if(login){
           logger.info("Login Successfully....!!");
           return new ResponseEntity<>(new ApiResponse("Login Successfull!!", true),
                   HttpStatus.OK);
       }
       return new ResponseEntity<>(new ApiResponse("Login failed!!", false),
                HttpStatus.NOT_FOUND);
    }
}
