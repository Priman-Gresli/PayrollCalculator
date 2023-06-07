package com.example.demo.service.impl;

import com.example.demo.dao.entity.EmployeeEntity;
import com.example.demo.dao.repository.EmployeeRepository;
import com.example.demo.response.PayrollResponse;
import com.example.demo.response.SalaryDistributionResponse;
import com.example.demo.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private EmployeeRepository repository;

    final double stampFeeCalculation = 25.00;

    @Override
    public String getEmployee() {
        Optional<EmployeeEntity> byId = repository.findById(1L);
        EmployeeEntity employeeEntity = byId.get();
        return employeeEntity.getName();
    }
    @Autowired
    private ApplicationPropertyServiceImpl applicationPropertyService;
    @Override
    public List<PayrollResponse> getPayroll(Long id) {

        double minSalary = applicationPropertyService.getMinSalary("minSalary");
        Optional<EmployeeEntity> byId = repository.findById(id);
        EmployeeEntity employeeEntity = byId.get();
        double salary = employeeEntity.getSalary();

        double etf = epfCalculation(salary);
        double epf = etfCalculation(salary);
        double tax = taxCal(salary - minSalary);
        double sportFee = sportClubFeeCalculation(salary);
        double takeHomeSalary= getTakeHomeSalary(salary, stampFeeCalculation, tax, sportFee);

        PayrollResponse payrollResponse = new PayrollResponse();
        payrollResponse.setEpf(epf);
        payrollResponse.setEtf(etf);
        payrollResponse.setTakeHomeSalary(takeHomeSalary);

        ArrayList<PayrollResponse> payrollList = new ArrayList<>();
        payrollList.add(payrollResponse);
        return payrollList;


    }

    private double getTakeHomeSalary(double salary, double stampFeeCalculation, double tax, double sportFee) {
        return salary - tax - epfEmployeeCalculation(salary) - stampFeeCalculation - sportFee;
    }


    public double epfCalculation(double salary) {
        return salary*0.2;
    }
    public double etfCalculation(double salary) {
        return salary*0.03;
    }
    public double epfEmployeeCalculation(double salary) {
        return salary * 0.08;
    }
    public double epfEmployerCalculation(double salary) {
        return salary * 0.12;
    }
    public double sportClubFeeCalculation(double salary) {
        return salary * 0.005;
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
            if (count > 5) {
                tax += salary * 0.36;
                break;
            }

        }
        return tax;
    }

    @Override
    public double getTotalCost(Long id) {
        Optional<EmployeeEntity> byId = repository.findById(id);
        EmployeeEntity employeeEntity = byId.get();
        double salary = employeeEntity.getSalary();
        double epf = epfEmployerCalculation(salary);
        double etf = etfCalculation(salary);

        return salary+epf+etf;
    }

    @Override
    public double getTax(double salary) {
        double minSalary = applicationPropertyService.getMinSalary("minSalary");

        if (salary<=minSalary) return 0;
        double tax = taxCal(salary - minSalary);
        return tax;
    }

    @Override
    public List<SalaryDistributionResponse> getAllEmployeeSalaryDistribution() {

        List<SalaryDistributionResponse> result = new ArrayList<>();
        List<EmployeeEntity> employees = repository.findAll();
        System.out.println(employees);
        for (EmployeeEntity employee : employees) {
            SalaryDistributionResponse salaryDistributionOfEmployee = new SalaryDistributionResponse();
            System.out.println(employee.getName());
            salaryDistributionOfEmployee.setEmployeeId(employee.getId());
            salaryDistributionOfEmployee.setEmployeeName(employee.getName());

            double epf = epfEmployeeCalculation(employee.getSalary());
            salaryDistributionOfEmployee.setEpf(epf);

            double eft = etfCalculation(employee.getSalary());
            salaryDistributionOfEmployee.setEtf(eft);

            double tax = getTax(employee.getSalary());
            salaryDistributionOfEmployee.setTax(tax);

            double takeHomeSalary = getTakeHomeSalary(employee.getSalary(), stampFeeCalculation, tax,
                    sportClubFeeCalculation(employee.getSalary()));
            salaryDistributionOfEmployee.setTakeHomeSalary(takeHomeSalary);

            result.add(salaryDistributionOfEmployee);
        }
        return result;
    }



}