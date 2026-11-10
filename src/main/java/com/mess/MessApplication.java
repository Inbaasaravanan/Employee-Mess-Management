package com.mess;

import com.mess.entity.Employee;
import com.mess.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MessApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessApplication.class, args);
    }

    @Bean
    public CommandLineRunner seedDatabase(EmployeeRepository repo) {
        return args -> {
            if (repo.findByEmail("employee@mess.com") == null) {
                Employee emp = new Employee();
                emp.setName("Test Employee");
                emp.setRegisterNo("EMP001");
                emp.setDepartment("CSE");
                emp.setEmail("employee@mess.com");
                emp.setPhone("9876543210");
                emp.setPassword("emp123");
                repo.save(emp);
                System.out.println(
                        ">>> Database connected and successfully seeded default employee (employee@mess.com / emp123)!");
            } else {
                System.out.println(">>> Database connected. Default employee already exists.");
            }
        };
    }
}
