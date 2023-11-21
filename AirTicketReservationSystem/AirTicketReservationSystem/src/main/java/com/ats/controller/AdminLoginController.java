package com.ats.controller;

import com.ats.entity.AdminLogin;
import com.ats.entity.CurrentAdminSession;
import com.ats.exception.AdminException;
import com.ats.exception.LoginException;
import com.ats.service.IAdminLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ats")
public class AdminLoginController {

    private final IAdminLoginService loginService;
    private final Logger logger = LoggerFactory.getLogger(AdminLoginController.class);

    @Autowired
    public AdminLoginController(IAdminLoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/admin/login")
    public ResponseEntity<CurrentAdminSession> loginAdmin(@RequestBody AdminLogin loginDTO) throws AdminException, LoginException {
        logger.info("Received request to login admin with loginDTO: {}", loginDTO);
        CurrentAdminSession currentAdminSession = loginService.adminLogin(loginDTO);
        logger.info("Admin login successful. Admin session details: {}", currentAdminSession);
        return new ResponseEntity<>(currentAdminSession, HttpStatus.ACCEPTED);
    }

    @PostMapping("/admin/logout")
    public String logoutAdmin(@RequestParam(required = false) String key) throws LoginException {
        logger.info("Received request to logout admin with key: {}", key);
        String result = loginService.adminLogout(key);
        logger.info("Admin logout result: {}", result);
        return result;
    }
}
