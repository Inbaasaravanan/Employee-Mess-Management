package com.mess.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String registerNo;

    private String department;

    @Column(unique = true)
    private String email;

    private String phone;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String r) {
        this.registerNo = r;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String d) {
        this.department = d;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String e) {
        this.email = e;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String p) {
        this.phone = p;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String p) {
        this.password = p;
    }
}
