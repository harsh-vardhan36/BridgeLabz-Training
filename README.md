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
