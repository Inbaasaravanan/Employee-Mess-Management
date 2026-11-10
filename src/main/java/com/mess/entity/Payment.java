package com.mess.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeName;
    private String email;
    private String phone;
    private String role;
    private Double amount;
    private String razorpayId;
    private String status;
    private LocalDateTime paymentDate = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long i) {
        this.id = i;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String n) {
        this.employeeName = n;
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

    public String getRole() {
        return role;
    }

    public void setRole(String r) {
        this.role = r;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double a) {
        this.amount = a;
    }

    public String getRazorpayId() {
        return razorpayId;
    }

    public void setRazorpayId(String r) {
        this.razorpayId = r;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String s) {
        this.status = s;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime d) {
        this.paymentDate = d;
    }
}
