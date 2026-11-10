# Company Mess Management System

## How to Run (3 Steps)

### Step 1 — Setup MySQL
```bash
mysql -u root -p < mess_management.sql
```
Then open `src/main/resources/application.properties` and set your MySQL password:
```
spring.datasource.password=YOUR_MYSQL_PASSWORD
```

### Step 2 — Run Spring Boot
```bash
mvn spring-boot:run
```

### Step 3 — Open Browser
```
http://localhost:8080
```

---

## Login Credentials

| Role     | Credential                              |
|----------|-----------------------------------------|
| Employee | Register first, then login              |
| Manager  | man101 / 1234  or  man102 / 5678        |
| Admin    | admin / admin123                        |

---

## Project Structure
```
mess-project/
├── pom.xml
├── mess_management.sql          ← Run this first
├── README.md
└── src/main/
    ├── java/com/mess/
    │   ├── MessApplication.java
    │   ├── controller/
    │   │   ├── EmployeeController.java   (register, login)
    │   │   ├── AuthController.java       (manager, admin login)
    │   │   ├── PaymentController.java    (save, all, stats)
    │   │   └── PageController.java
    │   ├── entity/
    │   │   ├── Employee.java
    │   │   └── Payment.java
    │   └── repository/
    │       ├── EmployeeRepository.java
    │       └── PaymentRepository.java
    └── resources/
        ├── application.properties
        └── static/
            ├── index.html
            ├── assets/           (food images)
            ├── employee/
            │   ├── emp.login.html
            │   ├── emp.reg.html
            │   ├── menubooking.html
            │   └── payment.html
            ├── manager/
            │   ├── man.login.html
            │   ├── menubooking.html
            │   └── payment.html
            └── admin/
                ├── ad.login.html
                └── ad.dash.html  ← Live data from MySQL
```

## API Endpoints
| Method | URL | Description |
|--------|-----|-------------|
| POST | /api/employee/register | Register employee |
| POST | /api/employee/login | Employee login |
| POST | /api/auth/manager | Manager login |
| POST | /api/auth/admin | Admin login |
| POST | /api/payment/save | Save payment to DB |
| GET  | /api/payment/all | All payments (admin) |
| GET  | /api/payment/stats | Dashboard stats |

## Razorpay Setup
In `employee/payment.html` and `manager/payment.html`, replace:
```js
key: 'rzp_test_YourKeyHere'
```
with your actual Razorpay Test Key from https://dashboard.razorpay.com
