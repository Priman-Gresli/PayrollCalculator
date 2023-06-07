package com.example.demo.service.impl;

import com.example.demo.dao.entity.ApplicationPropertyEntity;
import com.example.demo.dao.repository.ApplicationPropertyRepository;
import com.example.demo.dao.repository.EmployeeRepository;
import com.example.demo.service.ApplicationPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationPropertyServiceImpl implements ApplicationPropertyService {

    @Autowired
    private ApplicationPropertyRepository applicationPropertyRepository;


    @Override
    public void setMinSalary(ApplicationPropertyEntity applicationProperty) {
        applicationPropertyRepository.save(applicationProperty);
    }

    @Override
    public double getMinSalary(String propertyName) {
        ApplicationPropertyEntity minSalary = applicationPropertyRepository.findByPropertyName(propertyName);
        return minSalary.getPropertyvalue();
    }

    @Override
    public double updateMinSalary(String applicationProperty) {
        applicationPropertyRepository.
    }


}
