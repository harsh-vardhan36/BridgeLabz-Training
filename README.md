
# BridgeLabz-Training

> This is the `Refresher-Training` branch of the BridgeLabz Training repository. You can track my daily progress, learning milestones, and practical activities below.  
>  
> **Repository Tracking:** [harsh-vardhan36 GitHub Profile](https://github.com/harsh-vardhan36/)

---

## Training Overview

I am committing my code and files daily to document everything I learn and practice during this training. To make navigation simple and structured, the repository is organized into day-wise folders. Each folder contains the complete set of files, assignments, and activities for that specific day.

---

## Daily Log and Milestones

### Day 1: DDL and DML Operations
* **Focus Area:** Database Management Systems (DBMS), Data Definition Language (DDL), and Data Manipulation Language (DML).  
* **Code & Resources:** [View Day 1 Directory](https://github.com/harsh-vardhan36/BridgeLabz-Training/tree/Refresher-Training/Day1)

#### Core Concepts Covered
- Introduction to DBMS
- Problems with flat-file storage
- How DBMS solves redundancy, concurrency, and recovery issues
- CRUD operations using SQL

---

### Day 2: ER Diagrams, Junction Tables, and Database Normalization
* **Focus Area:** Entity-Relationship (ER) Diagrams, Many-to-Many Relationships, Data Anomalies, and Normalization up to Third Normal Form (3NF).  
* **Code & Resources:** [View Day 2 Directory](https://github.com/harsh-vardhan36/BridgeLabz-Training/tree/Refresher-Training/Day2)

#### Core Concepts Covered
- ER Diagram realization for many-to-many relationships
- Junction tables for patient-doctor-appointment modeling
- Normalization (1NF, 2NF, 3NF) to eliminate anomalies
- Practical SQL scripts for health clinic schema

---

### Day 3: Joins, Triggers, and Stored Procedures
* **Focus Area:** Advanced SQL operations — mastering joins, automating workflows with triggers, and encapsulating logic using stored procedures.  
* **Code & Resources:** [View Day 3 Directory](https://github.com/harsh-vardhan36/BridgeLabz-Training/tree/Refresher-Training/Day3)

#### Core Concepts Covered

##### 1. SQL Joins
- **INNER JOIN:** Match patients with confirmed appointments  
- **LEFT JOIN:** Show all doctors, even those without appointments  
- **RIGHT JOIN:** Show all patients, even those without appointments  

##### 2. Triggers
- **AFTER INSERT Trigger:** Update doctor statistics when a new appointment is booked  
- **AFTER UPDATE Trigger:** Log patient information changes into a `patient_log` table  
- **AFTER DELETE Trigger:** Decrement doctor patient counts when appointments are cancelled  

Triggers ensure **real-time analytics**, **data integrity**, and **automation**.

##### 3. Stored Procedures
- **AddDoctor Procedure:** Insert new doctor records with validated parameters  
- **AddPatient Procedure:** Add patients while enforcing mandatory fields (name, gender)  
- **BookAppointment Procedure:** Book appointments linking doctor and patient IDs, with default status as `confirmed`  

Stored procedures simplify integration with Java CLI applications by providing a clean, callable interface for database operations.

---
# Day 4: HealthClinic CLI Application (Java + JDBC)

## Focus Area
Building a command-line interface (CLI) application to interact with the HealthClinic database using JDBC.

## Code & Resources
[View Day 4 Directory](https://github.com/harsh-vardhan36/BridgeLabz-Training/tree/Refresher-Training/Day4)

---

## Core Concepts Covered
- **JDBC Workflow:** Driver loading, connection establishment, statement execution, result processing, and resource management  
- **POJO Classes:** Mapping database rows into Java objects for clean data handling  
- **PreparedStatement:** Parameterized queries to prevent SQL injection  
- **CLI Integration:** Menu-driven interface for CRUD operations on doctors, patients, and appointments  

## Application Features
- Add new doctors and patients  
- Book, update, and cancel appointments  
- View patient history and doctor schedules  

## Summary
This project demonstrates **end-to-end integration**:  
**SQL schema design → JDBC connection → Java POJO mapping → CLI interaction**
---

# Day 5: Spring Core Configuration

## Focus Area

Working with the three major Spring configuration approaches: **XML-based, Annotation-based, and Java-based configuration**.

## Code & Resources

[View Day 5 Directory](https://github.com/harsh-vardhan36/BridgeLabz-Training/tree/Refresher-Training/Day5)

## Core Concepts Covered

- **XML-Based Configuration:** Configuring Spring Beans using `applicationContext.xml`
- **Annotation-Based Configuration:** Using annotations such as `@Component`, `@Autowired`, and component scanning
- **Java-Based Configuration:** Using `@Configuration` and `@Bean`
- **Dependency Injection:** Constructor-based dependency injection
- **IoC Container:** Understanding how Spring creates and manages Beans

## Summary

Implemented the same Spring Core concepts using different configuration approaches and understood how Spring manages object creation and dependencies through the IoC Container.

---

# Day 6: MyGreetingApp – Spring MVC

## Focus Area

Building a basic **Spring MVC web application** named `MyGreetingApp` with Controller, Service, and Model layers.

## Code & Resources

[View Day 6 Directory](https://github.com/harsh-vardhan36/BridgeLabz-Training/tree/Refresher-Training/Day6)

## Core Concepts Covered

- **Spring MVC Architecture**
- **Controller Layer:** Handling requests using `@Controller`, `@GetMapping`, and `@PostMapping`
- **Service Layer:** Managing application/business logic
- **Model Layer:** Creating POJO classes for application data
- **Dependency Injection:** Using constructor injection
- **Form Handling:** Processing user registration and login requests
- **Request-Response Flow:** Understanding how requests move through Controller → Service → Model

## Application Features

- User Registration
- User Login
- Greeting functionality
- Controller-Service integration
- Basic MVC-based request handling

## Summary

Built `MyGreetingApp` to understand how **Spring MVC** works and how the Spring Core concepts of **IoC and Dependency Injection** are applied in a web application.

---

# Day 7: ContactApp – Spring Boot + H2 Database

## Focus Area

Building a **ContactApp** using **Spring Boot** with an **H2 in-memory database** and implementing complete **CRUD (Create, Read, Update, Delete)** operations.

## Code & Resources

[View Day 7 Directory](https://github.com/harsh-vardhan36/BridgeLabz-Training/tree/Refresher-Training/Day7)

## Core Concepts Covered

- **Spring Boot:** Creating and configuring a Spring Boot application
- **Spring Web:** Handling HTTP requests and responses
- **REST APIs:** Creating RESTful endpoints for contact management
- **H2 Database:** Using an in-memory database for storing contact information
- **Spring Data JPA:** Connecting the application with the database and performing database operations
- **Entity Mapping:** Creating entity classes using `@Entity` and mapping Java objects to database tables
- **Repository Layer:** Using `JpaRepository` for database access
- **CRUD Operations:** Implementing Create, Read, Update, and Delete functionality
- **Dependency Injection:** Using Spring's dependency injection to manage application components
- **Layered Architecture:** Understanding the flow between Controller → Service → Repository → Database

## Application Features

- Add a new contact
- Get all contacts
- Get a contact by ID
- Update an existing contact
- Delete a contact
- Store contact data using the H2 database
- Expose CRUD functionality through REST APIs

## CRUD Operations

- **Create:** Add a new contact to the database
- **Read:** Retrieve all contacts or a specific contact by ID
- **Update:** Modify an existing contact
- **Delete:** Remove a contact from the database

## Summary

Built `ContactApp` using **Spring Boot, Spring Data JPA, and H2 Database** to understand how REST APIs interact with a relational database. Implemented complete **CRUD operations** using a layered architecture consisting of **Controller → Service → Repository → H2 Database**.
```
# Day 8: ContactApp – Test Cases

## Focus Area

Implementing **test cases** for the ContactApp to ensure the application's functionality works as expected and to improve code reliability.

## Code & Resources

[View Day 8 Directory](https://github.com/harsh-vardhan36/BridgeLabz-Training/tree/Refresher-Training/Day8)

## Core Concepts Covered

- **Unit Testing:** Writing test cases to verify individual components and application logic
- **Spring Boot Testing:** Testing Spring Boot application components
- **Test Case Design:** Creating test scenarios for different application functionalities
- **CRUD Testing:** Validating Create, Read, Update, and Delete operations
- **Service Layer Testing:** Testing business logic and service-layer functionality
- **Controller Testing:** Verifying REST API request and response behavior
- **Assertions:** Using assertions to validate expected results

## Testing Coverage

- Test cases for adding contacts
- Test cases for retrieving contacts
- Test cases for retrieving a contact by ID
- Test cases for updating contacts
- Test cases for deleting contacts
- Validation of expected responses and application behavior

## Summary

Implemented **test cases for the ContactApp** to verify the correctness of its REST APIs and application logic. This helped improve the reliability of the application and provided a better understanding of testing practices in a Spring Boot project.

---

# Day 9: ContactApp – Swagger, Mapper, and Overall Project Structure

## Focus Area

Improving the **ContactApp's overall structure** by implementing **Swagger API documentation**, introducing a **Mapper layer**, and refining the project's layered architecture.

## Code & Resources

[View Day 9 Directory](https://github.com/harsh-vardhan36/BridgeLabz-Training/tree/Refresher-Training/Day9)

## Core Concepts Covered

- **Swagger / OpenAPI:** Documenting and testing REST APIs through an interactive API interface
- **API Documentation:** Providing clear documentation for available endpoints, request parameters, and responses
- **Mapper Layer:** Separating entity objects from DTOs and handling object conversion
- **DTO Mapping:** Converting request/response objects between different application layers
- **Layered Architecture:** Improving separation of responsibilities across Controller, Service, Mapper, Repository, and Database layers
- **Project Structure:** Organizing the application into well-defined packages and components
- **Separation of Concerns:** Keeping business logic, data access, mapping, and API handling independent

## Application Structure

The application structure was improved to follow a cleaner layered architecture:

**Controller → Service → Mapper → Repository → Database**

- **Controller:** Handles HTTP requests and responses
- **Service:** Contains business logic
- **Mapper:** Converts between DTOs and Entity objects
- **Repository:** Handles database operations using Spring Data JPA
- **Database:** Stores application data using H2

## Swagger Integration

- Added Swagger/OpenAPI documentation for REST APIs
- Documented available endpoints and their operations
- Enabled interactive API testing through the Swagger UI
- Improved API understanding and usability for developers

## Mapper Implementation

- Implemented a dedicated Mapper component
- Separated DTOs from database entities
- Converted request DTOs into entity objects
- Converted entity objects into response DTOs
- Improved maintainability and separation of responsibilities

## Summary

Enhanced the **ContactApp** by integrating **Swagger/OpenAPI documentation**, implementing a **Mapper layer**, and improving the overall project structure. The application now follows a cleaner and more maintainable architecture with better separation between API handling, business logic, object mapping, data access, and database operations.