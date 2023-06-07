package com.example.demo.service.impl;

import com.example.demo.dao.entity.EmployeeEntity;
import com.example.demo.dao.repository.EmployeeRepository;
import com.example.demo.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private EmployeeRepository repository;


    @Override
    public String getEmployee() {
        Optional<EmployeeEntity> byId = repository.findById(1L);
        EmployeeEntity employeeEntity = byId.get();
       return employeeEntity.getName();
    }
}
