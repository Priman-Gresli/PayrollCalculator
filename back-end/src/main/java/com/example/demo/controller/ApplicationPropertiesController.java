package com.example.demo.controller;

import com.example.demo.dao.entity.ApplicationPropertyEntity;
import com.example.demo.service.ApplicationPropertyService;
import com.example.demo.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ApplicationPropertiesController {

    @Autowired
    private ApplicationPropertyService applicationPropertyService;
    @PostMapping("/application")
    public void setMinSalary(@RequestBody ApplicationPropertyEntity applicationProperty){
        applicationPropertyService.setMinSalary(applicationProperty);
    }

}
