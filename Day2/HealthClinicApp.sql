-- Health clinic  App
show databases;
use healthclinicdb;
show tables;

create table doctors(
doctor_id int auto_increment primary key,
name varchar(50),
specialization varchar(100),
phone varchar(15),
email varchar(40) unique,
experience_years int,
joined_date timestamp default current_timestamp
)AUTO_INCREMENT = 100;

INSERT INTO doctors (name, specialization, phone, email, experience_years)
VALUES
('Dr. Asha Verma', 'Cardiologist', '9876543210', 'asha.verma@example.com', 12),
('Dr. Rajesh Kumar', 'Neurologist', '9123456780', 'rajesh.kumar@example.com', 15),
('Dr. Meera Singh', 'Pediatrician', '9988776655', 'meera.singh@example.com', 8),
('Dr. Arjun Patel', 'Orthopedic Surgeon', '9090909090', 'arjun.patel@example.com', 20),
('Dr. Kavita Sharma', 'Dermatologist', '9191919191', 'kavita.sharma@example.com', 10);

select * from doctors;

create table patients(
patient_id int auto_increment primary key,
name varchar(40) not null,
age int check(age>0),
gender enum('male','female') not null,
phone varchar(15),
address text,
joined_at timestamp default current_timestamp
);

INSERT INTO patients (name, age, gender, phone, address)
VALUES
('Rohan Mehta', 28, 'male', '9876543210', '45 MG Road, Indore'),
('Priya Sharma', 34, 'female', '9123456780', '12 Civil Lines, Bhopal'),
('Amit Verma', 42, 'male', '9988776655', '23 Nehru Nagar, Jabalpur'),
('Sneha Kapoor', 25, 'female', '9090909090', '78 Residency Area, Gwalior'),
('Arjun Singh', 50, 'male', '9191919191', '56 Shankar Nagar, Raipur');

select * from patients;

CREATE TABLE appointments (
    appointment_id INT AUTO_INCREMENT PRIMARY KEY,
    doctor_id INT,
    patient_id INT,
    appointment_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('confirmed', 'completed') DEFAULT 'confirmed',
    diagnosis TEXT,
    FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id),
    FOREIGN KEY (patient_id) REFERENCES patients(patient_id)
);

INSERT INTO appointments (doctor_id, patient_id, status, diagnosis)
VALUES
(100, 1, 'confirmed', 'Routine check-up, no issues found'),
(101, 2, 'completed', 'Migraine diagnosed, prescribed medication'),
(102, 3, 'confirmed', 'Child vaccination scheduled'),
(103, 4, 'completed', 'Fracture healed, physiotherapy advised'),
(104, 5, 'confirmed', 'Skin allergy under observation');

-- find the patients whose name ends with 'a'
select patient_id , name , age , gender from patients
where name like '%a';

-- find the patients whose name starts with  'A'
select * from patients
where name like  'A%';

-- find the patients who belongs to jabalpur
select name , age , gender, phone, address from patients
where address like '%jabalpur%';

--  Show all patient names and ages from the Patients table.
select name , age from patients;

-- Retrieve details of patients whose age is greater than 40.
select name, age, gender, phone , address from patients
where age > 40;

-- List all patients sorted by their admission date in descending order. 
select name, age , gender, phone , address from patients
order by joined_at desc;

-- Find the number of patients grouped by their city.

select address , count(*) as patientCount
from patients
where address like '%bhopal%'
group by address;

-- Display cities that have more than 1 patients.

select address , count(*) as patientCount
from patients
where address like '%bhopal%'
group by address
having count(*)>=1;

--  Show patient names along with their doctor’s name by joining Patients and Doctors tables
select  p.name , d.name from patients p
join  appointments a on a.patient_id = p.patient_id
join doctors d  on a.doctor_id  =  d.doctor_id;

-- retrieve only the first 2 patients whose names start with "A"?
select name , age , gender, phone from patients
where name like 'A%'
limit 2;