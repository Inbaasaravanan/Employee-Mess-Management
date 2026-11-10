package com.mess.controller;

import com.mess.entity.Employee;
import com.mess.repository.EmployeeRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired EmployeeRepository repo;

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody Employee emp) {
        Map<String, Object> res = new HashMap<>();
        if (repo.findByEmail(emp.getEmail()) != null) {
            res.put("success", false);
            res.put("message", "Email already exists");
            return ResponseEntity.badRequest().body(res);
        }
        if (repo.findByRegisterNo(emp.getRegisterNo()) != null) {
            res.put("success", false);
            res.put("message", "Register number already exists");
            return ResponseEntity.badRequest().body(res);
        }
        Employee saved = repo.save(emp);
        res.put("success", true);
        res.put("message", "Registration Successful");
        res.put("id", saved.getId());
        return ResponseEntity.ok(res);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Employee emp) {
        Map<String, Object> res = new HashMap<>();
        Employee user = repo.findByEmail(emp.getEmail());
        if (user != null && user.getPassword().equals(emp.getPassword())) {
            res.put("success", true);
            res.put("name", user.getName());
            res.put("id", user.getId());
            res.put("department", user.getDepartment());
            res.put("email", user.getEmail());
            res.put("phone", user.getPhone());
            return ResponseEntity.ok(res);
        }
        res.put("success", false);
        res.put("message", "Invalid email or password");
        return ResponseEntity.status(401).body(res);
    }
}
