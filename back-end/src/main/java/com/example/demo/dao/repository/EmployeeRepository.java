package com.example.demo.dao.repository;

import com.example.demo.dao.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

}
