package com.example.atrs.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomError implements ErrorController {

     final String errorPath;
    @Autowired
    public CustomError(@Value("${custom.error.path:/error}") String errorPath) {
        this.errorPath = errorPath;
    }


    @RequestMapping("${custom.error.path:/error}")
    public ResponseEntity<Object> pathNotFound() {
        ApiError apiError=new ApiError("Please check the URL given in the path", "The requested path is not available or Please do check the values");
        return new  ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);

    }

}
