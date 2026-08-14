# Employee Payroll JDBC App

Basic Employee Payroll CRUD application using Spring Boot and JdbcTemplate.

## Stack

- Java 17
- Spring Boot 3.5.5
- Spring MVC / REST
- Spring JDBC
- JdbcTemplate
- H2 Database
- Maven
- Bean Validation

## This project does NOT use JPA

There is no:
- JpaRepository
- Hibernate
- @Entity
- @Id
- @GeneratedValue
- Spring Data JPA dependency

The repository executes SQL using JdbcTemplate.

## Project Flow

Controller
    ↓
Service
    ↓
Repository
    ↓
JdbcTemplate
    ↓
SQL
    ↓
H2 Database

For SELECT:

Database → ResultSet → RowMapper → Employee → DTO → JSON

## CRUD APIs

POST   /api/employees
GET    /api/employees
GET    /api/employees/{id}
PUT    /api/employees/{id}
DELETE /api/employees/{id}

### POST example

{
  "empName": "Harsh Vardhan",
  "department": "IT",
  "salary": 65000
}

### PUT example

{
  "empName": "Harsh Vardhan",
  "department": "Software Development",
  "salary": 70000
}

## H2 Console

http://localhost:8080/h2-console

JDBC URL:
jdbc:h2:mem:employee_payroll_db

Username:
sa

Password:
leave blank

## Run

mvn spring-boot:run

or:

mvn clean package
java -jar target/employee-payroll-jdbc-0.0.1-SNAPSHOT.jar
