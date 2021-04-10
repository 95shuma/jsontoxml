package com.example.jsontoxml.controller;

import com.example.jsontoxml.dto.Requests;
import com.example.jsontoxml.services.OperationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OperationController {

    private final OperationService operationService;

    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping("/")
    public String getMain(){
        log.info("authentication passed");
        return "Welcome to my app";
    }

    @PostMapping("/user/operation")
    public String performOperation(@RequestBody Requests request) {
        log.info("user used service");
        return operationService.getXml(request.getRequest());
    }

}
