-- ============================================================
--  Company Mess Management System — MySQL Schema + Seed Data
--  Run: mysql -u root -p < mess_management.sql
-- ============================================================
CREATE DATABASE IF NOT EXISTS mess_db;
USE mess_db;

-- employees
CREATE TABLE IF NOT EXISTS employees (
  id          BIGINT AUTO_INCREMENT PRIMARY KEY,
  name        VARCHAR(100) NOT NULL,
  register_no VARCHAR(50)  UNIQUE NOT NULL,
  department  VARCHAR(50)  NOT NULL,
  email       VARCHAR(100) UNIQUE NOT NULL,
  phone       VARCHAR(15)  NOT NULL,
  password    VARCHAR(255) NOT NULL,
  created_at  TIMESTAMP    DEFAULT CURRENT_TIMESTAMP
);

-- payments (real-time saved after every Razorpay transaction)
CREATE TABLE IF NOT EXISTS payments (
  id            BIGINT AUTO_INCREMENT PRIMARY KEY,
  employee_name VARCHAR(100) NOT NULL,
  email         VARCHAR(100) NOT NULL,
  phone         VARCHAR(20),
  role          VARCHAR(20)  DEFAULT 'Employee',
  amount        DOUBLE       NOT NULL,
  razorpay_id   VARCHAR(100),
  status        VARCHAR(20)  DEFAULT 'Pending',
  payment_date  DATETIME     DEFAULT CURRENT_TIMESTAMP
);

-- ============================================================
-- Seed Data
-- ============================================================
-- Sample employee (password: emp123)
INSERT IGNORE INTO employees (name,register_no,department,email,phone,password)
VALUES ('Test Employee','EMP001','CSE','employee@mess.com','9876543210','emp123');

-- Confirm setup
SELECT 'Database ready!' AS status;
