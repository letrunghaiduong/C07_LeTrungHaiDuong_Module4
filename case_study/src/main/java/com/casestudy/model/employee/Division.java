package com.casestudy.model.employee;

import javax.persistence.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "division")
    private Set<Employee> employees;
}
