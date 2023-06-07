
package com.example.demo.response;

        import lombok.Getter;
        import lombok.Setter;

@Getter
@Setter
public class SalaryDistributionResponse {

    private Long employeeId;
    private String employeeName;
    private double takeHomeSalary;
    private double epf;
    private double etf;
    private double tax;

}