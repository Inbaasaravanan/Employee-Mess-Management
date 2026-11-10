package com.mess.controller;

import com.mess.entity.Payment;
import com.mess.repository.PaymentRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin("*")
public class PaymentController {
    @Autowired PaymentRepository repo;

    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> save(@RequestBody Map<String, Object> body) {
        Map<String, Object> res = new HashMap<>();
        try {
            Payment p = new Payment();
            p.setEmployeeName(body.get("name").toString());
            p.setEmail(body.get("email").toString());
            p.setPhone(body.get("phone").toString());
            p.setRole(body.getOrDefault("role", "Employee").toString());
            p.setAmount(Double.parseDouble(body.get("amount").toString()));
            p.setRazorpayId(body.get("razorpayId").toString());
            p.setStatus(body.get("status").toString());
            repo.save(p);
            res.put("success", true);
            res.put("message", "Payment saved");
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            res.put("success", false);
            res.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Payment>> all() {
        return ResponseEntity.ok(repo.findAllByOrderByPaymentDateDesc());
    }

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> stats() {
        List<Payment> all = repo.findAll();
        long success = all.stream().filter(p -> "Success".equals(p.getStatus())).count();
        double revenue =
                all.stream()
                        .filter(p -> "Success".equals(p.getStatus()))
                        .mapToDouble(Payment::getAmount)
                        .sum();
        Map<String, Object> m = new HashMap<>();
        m.put("totalOrders", all.size());
        m.put("successCount", success);
        m.put("failedCount", all.stream().filter(p -> "Failed".equals(p.getStatus())).count());
        m.put("totalRevenue", revenue);
        return ResponseEntity.ok(m);
    }
}
