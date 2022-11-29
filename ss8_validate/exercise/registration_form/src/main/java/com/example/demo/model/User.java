package com.example.demo.model;

import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 5,max = 45,message = "{name}")
    @NotEmpty(message = "{notEmpty}")
    private String firstName;

    @Size(min = 5,max = 45,message = "{name}")
    @NotEmpty(message = "{notEmpty}")
    private String lastName;

    @Pattern(regexp = "[0-9]{10}", message = "Số điện thoại không hợp lệ")
    private String phoneNumber;

    @Min(value = 18, message = "User phải 18 tuổi trở lên")
    private int age;

    @Email
    private String email;

    public User(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
