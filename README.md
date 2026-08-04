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
* **Focus Area:** Database Management Systems (DBMS), Data Definition Language (DDLS), and Data Manipulation Language (DML).
* **Code & Resources:** [View Day 1 Directory](https://github.com/harsh-vardhan36/BridgeLabz-Training/tree/Refresher-Training/Day1)

#### Core Concepts Covered

##### 1. Introduction to DBMS
A Database Management System (DBMS) is software that enables applications to create, read, update, and delete data in an organized, secure, and reliable manner. It acts as a centralized engine, replacing the outdated practice of storing data in isolated text files.

##### 2. The Problem with Flat-File Storage (Before DBMS)
Prior to modern DBMS software, applications relied on flat files (such as `.txt` or `.csv`). This approach introduced several critical liabilities:
* **Data Redundancy:** Duplicate entries occur across multiple files. For example, updating a customer's phone number in one file leaves the other four outdated.
* **Lack of Concurrency Control:** Simultaneous edits by multiple users can result in data being silently overwritten or lost.
* **No Enforced Structure:** Files lack standard schemas, allowing invalid data types (e.g., text instead of numbers) to be written into fields.
* **Inefficient Querying:** Retrieving specific filtered datasets requires writing complex, custom code to scan every file line by line.
* **Weak Security & Recovery:** Corrupted files cause permanent data loss due to a lack of built-in backup, logging, or rollback mechanisms.

##### 3. How a DBMS Solves These Issues
A DBMS centralizes data management to resolve flat-file limitations by:
* Enforcing a strict structure (schema)
* Controlling concurrent user access
* Providing a standard query language (SQL)
* Guaranteeing recovery after a crash through robust logging and transactions

##### 4. Practical Application
Today's practical session focused on writing and executing various DDL and DML queries to perform standard CRUD (Create, Read, Update, Delete) operations.

---
### Day 2: ER Diagrams, Junction Tables, and Database Normalization
* **Focus Area:** Entity-Relationship (ER) Diagrams, Many-to-Many Relationships, Data Anomalies, and Normalization up to Third Normal Form (3NF).
* **Code & Resources:** [View Day 2 Directory](https://github.comBridgeLabz-Training/tree/Refresher-Training/Day2)

#### Core Concepts Covered

##### 1. ER Diagram Realization (Many-to-Many Relationships)
To model complex associations such as a Health Clinic system where one patient visits multiple doctors and one doctor treats multiple patients, a direct relationship is impossible. We resolve this many-to-many relationship using a **Junction Entity** (or associative table). The junction table breaks the complex relationship down by storing Foreign Keys that reference the Primary Keys of both parent entities.

##### 2. Database Normalization (1NF, 2NF, 3NF)
Normalization is the algorithmic process of organizing data in a database to reduce redundancy and eliminate destructive data anomalies:
* **Insertion Anomaly:** Inability to add data without the presence of other unrelated data attributes.
* **Update Anomaly:** Data inconsistency caused by updating data in one place while copies elsewhere remain unchanged.
* **Deletion Anomaly:** Unintentional loss of distinct facts due to deleting an unrelated record.

##### 3. Normal Form Progressions Demonstrated
* **Unnormalized/Flat Designs:** Storing all patient, doctor, and appointment data in a single wide table causes heavy update anomalies (e.g., updating a patient's phone number requires altering multiple rows).
* **First & Second Normal Form:** Splitting independent entities into distinct tables (`patient` and `doctor`) connected through an associative table (`appointment`) ensures updates hit exactly one row.
* **Third Normal Form (3NF):** Elimination of **Transitive Dependencies** (where a non-prime attribute depends on another non-prime attribute). Removing a department description from a doctor table and isolating it into its own `department` relational master table fulfills 3NF.

#### Live Coding Implementation Script

```sql
-- ============================================================
-- LIVE CODING SCRIPT — Health Clinic App
-- Target: MySQL / MariaDB 
-- ============================================================

CREATE DATABASE IF NOT EXISTS health_clinic;
USE health_clinic;

-- ============================================================
-- TOPIC 1 — ER DIAGRAM LIVE BUILD
-- ============================================================

```
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