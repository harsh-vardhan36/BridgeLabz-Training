-- 1 creating a database
	create database healthclinicdb;
    
 -- 2  viewing the database   
   show databases;
   
-- 3 selecting the database for operations
  use healthclinicdb;

-- 4 Creating table name 'doctor'
	create table doctor(
    DoctorID INT auto_increment PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Specialization VARCHAR(100) NOT NULL,
	Phone VARCHAR(15) UNIQUE,
    CreatedOn DATETIME DEFAULT current_timestamp);

-- 5 viewing the table
 show tables;
 
 -- 6 Inserting  values in the table.
		insert into doctor(FirstName, LastName, Specialization, Phone)
        values('Rohit', 'sharma', 'cardiologist', '+91-9988998800'),
               ('Dr.Ram','Raghuvanshi','surgeon','+1 100001000');
               
 -- 7 Adding one more row (EMAIL) to the existing table
	alter table doctor add Email varchar(100) unique;
 
 -- 8 Finding a Surgeon from the doctor list
	select DoctorID, FirstName, LastName, Specialization, phone 
    from doctor
    where Specialization = 'surgeon';
    
-- 9 updating the doctor email
	update doctor set Email= 'harsh@gmail.com' where DoctorID=1;
   
-- 10 Deleting a doctor record
	delete from doctor where DoctorID=1;
 
 --   viewing the final Table
 select * from doctor;