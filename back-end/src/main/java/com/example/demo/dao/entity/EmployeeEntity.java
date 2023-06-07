package com.example.demo.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Getter
@Setter
@Table(name = "employee")
public class EmployeeEntity extends BaseEntity {

    /**
     * Entity for the Employee table.
     */
    @Column(name = "name", nullable = false, unique = false)
    private String name;
    @Column(name = "salary", nullable = false, unique = false)
    private double salary;


}

