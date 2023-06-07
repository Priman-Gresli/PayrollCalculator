package com.example.demo.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Getter
@Setter
@Table(name = "appdata")
public class ApplicationPropertyEntity extends BaseEntity {
    @Column(name = "propertyname", nullable = false, unique = false)
    private String propertyname;
    @Column(name = "propertyvalue", nullable = false, unique = false)
    private double propertyvalue;
}
