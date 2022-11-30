package com.casestudy.model.customer;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String Name;


    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customers;

    public CustomerType(int id, String name, Set<Customer> customers) {
        Id = id;
        Name = name;
        this.customers = customers;
    }

    public CustomerType() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
