package com.example.demo.controller;

import com.example.demo.request.CalculateSalaryRequest;
import com.example.demo.service.ApplicationPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tax")
public class TaxController {

    @Autowired
    private ApplicationPropertyService applicationPropertyService;
    @GetMapping("/calculate")
    public double calculateTax(@RequestBody CalculateSalaryRequest salaryRequest) {
        double minSalary = applicationPropertyService.getMinSalary("minSalary");

        double inputSalary = salaryRequest.getSalary();
        if (inputSalary<=minSalary) return 0;
        double tax = taxCal(inputSalary - minSalary);
        return tax;
    }

    public double taxCal(double salary){
        double taxBound = 500000;
        double tax = 0;
        int count = 1;

        while (salary > 0) {
            if (salary > taxBound) {
                tax += taxBound * 0.06 * count;
                salary -= taxBound;
            } else {
                tax += salary * 0.06 * count;
                break;
            }
            count ++;
        }
        return tax;
    }
}
