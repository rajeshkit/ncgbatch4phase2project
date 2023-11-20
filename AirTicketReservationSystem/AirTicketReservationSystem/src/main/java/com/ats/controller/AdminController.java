package com.ats.controller;

import com.ats.entity.Admin;
import com.ats.exception.AdminException;
import com.ats.service.IAdminService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ats")
public class AdminController {

    private final IAdminService service;
    private final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    public AdminController(IAdminService service) {
        this.service = service;
    }

    @PostMapping("/admin/register")
    public ResponseEntity<Admin> registerAdmin(@Valid @RequestBody Admin admin) throws AdminException {
        logger.info("Received request to register admin: {}", admin);
        Admin savedAdmin = service.createAdmin(admin);
        logger.info("Admin registered successfully: {}", savedAdmin);
        return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
    }

    @PutMapping("/admin/update")
    public ResponseEntity<Admin> updateAdmin(@Valid @RequestBody Admin admin, @RequestParam(required = false) String key) throws AdminException {
        logger.info("Received request to update admin: {}", admin);
        Admin updatedAdmin = service.updateAdmin(admin, key);
        logger.info("Admin updated successfully: {}", updatedAdmin);
        return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
    }
}
