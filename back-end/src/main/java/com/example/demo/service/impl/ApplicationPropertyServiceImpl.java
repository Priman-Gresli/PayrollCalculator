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
        ApplicationPropertyEntity minSalaryProperty = applicationPropertyRepository.findByPropertyName(
                applicationProperty.getPropertyname()
        );
        if (minSalaryProperty != null) {
            // Record found, update the value
            Long id = minSalaryProperty.getId();
            applicationPropertyRepository.updateByPropertyId(applicationProperty.getPropertyvalue(), id);
        } else {
            applicationPropertyRepository.save(applicationProperty);
        }
    }

    @Override
    public double getMinSalary(String propertyName) {
        ApplicationPropertyEntity minSalary = applicationPropertyRepository.findByPropertyName(propertyName);
        return minSalary.getPropertyvalue();
    }

    @Override
    public void updateMinSalary(double value, String name) {
        applicationPropertyRepository.updateByPropertyName(value, name);
    }


}
