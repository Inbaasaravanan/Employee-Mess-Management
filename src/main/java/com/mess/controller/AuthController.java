package com.mess.controller;

import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    // Manager login - hardcoded (stored in DB via SQL seed)
    @PostMapping("/manager")
    public ResponseEntity<Map<String, Object>> managerLogin(@RequestBody Map<String, String> body) {
        Map<String, Object> res = new HashMap<>();
        String id = body.get("managerId"), pw = body.get("password");
        if (("man101".equals(id) && "1234".equals(pw))
                || ("man102".equals(id) && "5678".equals(pw))) {
            res.put("success", true);
            res.put("managerId", id);
            res.put("name", "Manager " + id);
            return ResponseEntity.ok(res);
        }
        res.put("success", false);
        res.put("message", "Invalid Manager ID or Password");
        return ResponseEntity.status(401).body(res);
    }

    // Admin login
    @PostMapping("/admin")
    public ResponseEntity<Map<String, Object>> adminLogin(@RequestBody Map<String, String> body) {
        Map<String, Object> res = new HashMap<>();
        if ("admin".equals(body.get("username")) && "admin123".equals(body.get("password"))) {
            res.put("success", true);
            return ResponseEntity.ok(res);
        }
        res.put("success", false);
        res.put("message", "Wrong credentials");
        return ResponseEntity.status(401).body(res);
    }
}
