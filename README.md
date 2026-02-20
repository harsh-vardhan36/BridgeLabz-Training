# dbms-jdbc-practice
> ## This branch tracks my week 8 journey, during which I learned and implemented the concepts of dbms and JDBC.
---
## Week 8 = dbms-jdbc-practice
---
### Day 48 - worked on 'dbms-jdbc-practice' branch
**Date**: 06-feb-2026
> * learn about Database Management System
### [Relational Database](https://www.oracle.com/in/database/what-is-a-relational-database/) 
- IT is a type of database that stores and provides access to data points that are related to one  another.
### learn about [mySQL](https://www.w3schools.com/MySQL/default.asp) :
> *   Indexing in mySQL : **primary KEY** , **Unique Index**.
> *   Table Scan (No Index):
> * "SELECT * FROM users WHERE username = 'john';"
> *   -- MySQL reads EVERY row sequentially             
---
## Day 49 - worked on 'dbms-jdbc-practice' branch
**Date**: 07-feb-2026
### understand the importance of **Security Best Practices**
- Ensure Atomicity, Consistency, Isolation, and Durability (ACID).
### **Prevent SQL Injection**
> *   ● Always use parameterized queries or prepared statements."
>*    ● Avoid dynamic SQL unless absolutely necessary.
>*    ● Grant least privilege access (e.g., READ-ONLY for non-admin users).
>*    ● Avoid using root or admin for application queries.
---
## Day 50 - worked on 'dbms-jdbc-practice' 
**Date**: 08-feb-2026
- Implemented the Solution for :
- > [**LibraryManagement**](https://github.com/harsh-vardhan36/BridgeLabz-Training/tree/dbms-jdbc-practice/dbms-jdbc-practice/gcr-codebase/dbms_jdbc_practice/src/main/resources/sql_practice/librarymanagement)
- I have created a database named 'library_db' in which there are two tables named **_'books'_**,
- **_'students'_**, **_'borrow_records'_**... and more!
> * Implemented TRANSCATION
---
## Day 51 - worked on 'dbms-jdbc-practice'
**Date**: 09-feb-2026
- Implemented the Solution for :
>  * [**TranscationManagement**](https://github.com/harsh-vardhan36/BridgeLabz-Training/tree/dbms-jdbc-practice/dbms-jdbc-practice/gcr-codebase/dbms_jdbc_practice/src/main/resources/sql_practice/transcationmanagement)
- I have created a database called **_bank_db_** in which I have created table named as **_Account_** .
> * I have performed transcation between different accounts by using 'account_id'.
---
- Implemented the Solution for :
>  * [**Employee-Management**](https://github.com/harsh-vardhan36/BridgeLabz-Training/tree/dbms-jdbc-practice/dbms-jdbc-practice/gcr-codebase/dbms_jdbc_practice/src/main/resources/sql_practice/employeemanagement)
- I have created a database called **D_employee** in which I have created table named as **_employee_** .
> * I have performed various operations on it. Some of them are listed below:
> * **Adding Employee**
> * **Viewing all Employee**
> * **Updating Salary** and more...
- [code link](https://github.com/harsh-vardhan36/BridgeLabz-Training/tree/dbms-jdbc-practice/dbms-jdbc-practice/gcr-codebase/dbms_jdbc_practice/src/main/resources/sql_practice)
---
## Day 52 - worked on 'dbms-jdbc-practice' branch 
**Date**: 10-feb-2026
- ### Solved M1 Mock question paper
- > Solved 3 questions
- Question 1: Smart Canteen Order Tracker Scenario
> * A corporate office has a smart canteen where employees place food orders during lunch hours.
Each order contains the employee name, food item, quantity, and price per item.
- Question 2: Online Fitness App – Weekly Activity Analyzer
> * An online fitness application tracks the daily step count of a user for 7 days to analyze fitness
Performance.
- Question 3: Course Enrollment Analyzer 
> * A training institute wants to analyze course enrollments before publishing its annual report. 
---
## Day 53 - worked on'dbms-jdbc-practice' branch
**Date**: 11-feb-2026
- ### Learn about [**JDBC**](https://www.tutorialspoint.com/jdbc/index.htm):
 > * JDBC stands for Java Database Connectivity
- Topics Covered: 
 > * JDBC Architecture
 > * CRUD operaations
 >  * _prepared Statement_ vs _statement_
- JDBC Workflow:
> * Load Driver → Establish Connection → Create Statement →
Execute Query → Process Results → Close Resources
- lastly, I have established the [**database connection**](https://github.com/harsh-vardhan36/BridgeLabz-Training/blob/dbms-jdbc-practice/dbms-jdbc-practice/gcr-codebase/dbms_jdbc_practice/src/main/java/com/jdbc/DatabaseConnection.java) using jdbc.
---
## Day 54 - worked on 'dbms-jdbc-practice' branch
**Date**: 12-feb-2026
- ### Performed CRUD operation on database using jdbc:
> * [**CRUD**](https://github.com/harsh-vardhan36/BridgeLabz-Training/blob/dbms-jdbc-practice/dbms-jdbc-practice/gcr-codebase/dbms_jdbc_practice/src/main/java/com/jdbc/CRUD/CRUD.db) on DB.
- Performed Create, Read, Update, and Delete opeations.
> - [**Insert Example**](https://github.com/harsh-vardhan36/BridgeLabz-Training/blob/dbms-jdbc-practice/dbms-jdbc-practice/gcr-codebase/dbms_jdbc_practice/src/main/java/com/jdbc/CRUD/InsertStudent.java) : Inserted students details
> - [**Read Example**](https://github.com/harsh-vardhan36/BridgeLabz-Training/blob/dbms-jdbc-practice/dbms-jdbc-practice/gcr-codebase/dbms_jdbc_practice/src/main/java/com/jdbc/CRUD/readStudent.java) : Read students details
> - [**Update Example**](https://github.com/harsh-vardhan36/BridgeLabz-Training/blob/dbms-jdbc-practice/dbms-jdbc-practice/gcr-codebase/dbms_jdbc_practice/src/main/java/com/jdbc/CRUD/updateStudent.java) : Update Student details
> - [**Delete Example**](https://github.com/harsh-vardhan36/BridgeLabz-Training/blob/dbms-jdbc-practice/dbms-jdbc-practice/gcr-codebase/dbms_jdbc_practice/src/main/java/com/jdbc/CRUD/updateStudent.java) : Delete student details
---
## Day 55 - worked on 'dbms-jdbc-practice' branch
**Date**: 13-feb-2026
- ### performed a transaction on the database using JDBC
> * [**Transaction db**](https://github.com/harsh-vardhan36/BridgeLabz-Training/blob/dbms-jdbc-practice/dbms-jdbc-practice/gcr-codebase/dbms_jdbc_practice/src/main/java/com/jdbc/Transcation/Transcation.db) on DataBase.
- Implemented SavePoint for each transaction.
- Implemented Transaction using JDBC
> * [**Transaction Example**](https://github.com/harsh-vardhan36/BridgeLabz-Training/blob/dbms-jdbc-practice/dbms-jdbc-practice/gcr-codebase/dbms_jdbc_practice/src/main/java/com/jdbc/Transcation/TransactionExample.java)
> * [**SavePoint Example**](https://github.com/harsh-vardhan36/BridgeLabz-Training/blob/dbms-jdbc-practice/dbms-jdbc-practice/gcr-codebase/dbms_jdbc_practice/src/main/java/com/jdbc/Transcation/SavepointExample.java)
---
