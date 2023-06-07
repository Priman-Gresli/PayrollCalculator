package com.example.demo.controller;

import com.example.demo.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayRollController {

    @Autowired
    private PayrollService payrollService;


    @GetMapping("/employee")
    public String getEmployee(){
        return payrollService.getEmployee();
    }
}
