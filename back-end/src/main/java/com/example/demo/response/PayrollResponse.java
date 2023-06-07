package com.example.demo.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayrollResponse {
    /**
     * Response type for the payroll response.
     */
    private double takeHomeSalary ;
    private double epf;
    private double etf;
}
