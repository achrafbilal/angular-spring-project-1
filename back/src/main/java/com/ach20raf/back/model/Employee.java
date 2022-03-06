package com.ach20raf.back.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    @Column(nullable = false,updatable = false)
    private String employeeCode;

    public Employee(){}


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Employee setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Employee setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Employee setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Employee setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Employee setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public Employee setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
        return this;
    }
}
