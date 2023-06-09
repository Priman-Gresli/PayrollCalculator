package com.example.demo.controller;

import com.example.demo.response.PayrollResponse;
import com.example.demo.response.SalaryDistributionResponse;
import com.example.demo.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PayRollController {

    @Autowired
    private PayrollService payrollService;


    @GetMapping("/employee")
    public ResponseEntity<String> getEmployee(){
        String employeeName = payrollService.getEmployee();
        return new ResponseEntity<>(employeeName, HttpStatus.OK);
    }
    @GetMapping("/employee/payroll/{id}")
    public ResponseEntity<List<PayrollResponse>> getPayroll(@PathVariable Long id){
        List<PayrollResponse> payroll = payrollService.getPayroll(id);
        return new ResponseEntity<>(payroll, HttpStatus.OK);
    }

    @GetMapping("/employee/totalcost/{id}")
    public ResponseEntity<Double> getTotalCost(@PathVariable Long id){
        double totalCost = payrollService.getTotalCost(id);
        return new ResponseEntity<>(totalCost, HttpStatus.OK);
    }

    @GetMapping("/employee/salary-distribution")
    public ResponseEntity<List<SalaryDistributionResponse>> getAllEmployeeSalaryDistribution(){
        List<SalaryDistributionResponse> salaryDistributionResponses =
                payrollService.getAllEmployeeSalaryDistribution();
        return new ResponseEntity<List<SalaryDistributionResponse>>(salaryDistributionResponses, HttpStatus.OK);
    }

}