package com.example.airticket.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidationError implements ErrorController {

    final String errorPath;
    @Autowired
    public ValidationError(@Value("${custom.error.path:/error}") String errorPath) {
        this.errorPath = errorPath;
    }


    @RequestMapping("${custom.error.path:/error}")
    public ResponseEntity<Object> pathNotFound() {
        Api apiError=new Api("Provide correct Url");
        return new  ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);

    }
}
