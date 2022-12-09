package com.casestudy.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "position")
    private Set<Employee> employees;

}

