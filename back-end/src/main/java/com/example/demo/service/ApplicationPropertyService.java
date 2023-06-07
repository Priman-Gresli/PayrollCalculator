package com.example.demo.service;

import com.example.demo.dao.entity.ApplicationPropertyEntity;

public interface ApplicationPropertyService {
    void setMinSalary(ApplicationPropertyEntity applicationProperty);
    double getMinSalary(String applicationProperty);
    double updateMinSalary(String applicationProperty);
}
