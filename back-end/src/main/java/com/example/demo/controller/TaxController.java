package com.example.demo.controller;

import com.example.demo.request.CalculateSalaryRequest;
import com.example.demo.service.ApplicationPropertyService;
import com.example.demo.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/tax")
public class TaxController {

    @Autowired
    private PayrollService payrollService;
    @GetMapping("/calculate")
    public double calculateTax(@RequestParam("salary") double salary ){

        double tax = payrollService.getTax(salary);
        return tax;
    }
}
