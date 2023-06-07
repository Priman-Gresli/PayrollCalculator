package com.example.demo.service;

import com.example.demo.response.PayrollResponse;

import java.util.List;

public interface PayrollService {
    String getEmployee();
    List<PayrollResponse> getPayroll(Long id);
    double getTotalCost(Long id);
}
