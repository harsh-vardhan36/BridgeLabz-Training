-- Show all databases and then select healthclinicdb  for use.....
show databases;
use healthclinicdb;

-- show all tables of and view all the field/attribute of it...
show tables;
desc doctors;
desc patients;
desc appointments;
desc specialization;
desc  doctor_specialization;
desc doctor_stats;

-- the doctors table have covered 1NF and 2NF but it lacks 3NF because of specialization as same text is repeating for multiple doctors so lets fix it...
create  table specialization(
sp_id int auto_increment primary key,
specialization varchar(50)  unique  not  null
);

insert into specialization(specialization)
values('Cardiologist'),
('Neurologist'),
('Pediatrician'),
('Orthopedic'),
('Dermatologist');

-- Remove the specialization field from the  doctor, Now doctors table is normalized with 1NF, 2NF and 3NF 
alter table doctors
drop column specialization;

--  create a new table to store our doctor_specialization and their  id so that there can be one to one or one to many relations can establish.
create table doctor_specialization(
doctor_id int ,
sp_id int ,
primary key(doctor_id, sp_id),
foreign key (doctor_id) references doctors(doctor_id),
foreign key (sp_id) references specialization(sp_id));

insert into  doctor_specialization(doctor_id, sp_id)
values(100, 1),
(101, 2),
(102, 3),
(103, 4),
(104, 5);

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


-- list out Doctors with Their Specializations
select d.doctor_id, d.name, d.phone, s.specialization from doctors d
join doctor_specialization ds on ds.doctor_id  = d.doctor_id
join specialization s on s.sp_id = ds.sp_id;

select * from appointments;
--  list out all Patients with Their Appointed Doctor
select p.name as patientName , p.age , p.phone , p.address, d.doctor_id, d.name as DoctorAppointed , s.specialization
from patients p
left join appointments a on p.patient_id = a.patient_id
left join doctors d  on a.doctor_id = d.doctor_id
left join doctor_specialization ds on ds.doctor_id = d.doctor_id
left join specialization s on ds.sp_id = s.sp_id;

-- creating  a trigger Auto Update Doctor’s Patient Count for this we need a table 

create table doctor_stats(
doctor_id int primary key,
total_patients int default 0,
foreign key (doctor_id) references doctors(doctor_id)
);

-- creating a trigger on Appointment Insert
delimiter $$ -- Remember when using multi line statement/trigger we need  to change the delimiter so  that mySQL  understand at which  point it is actually ending
create trigger  update_doctor_stats
after insert on appointments
for each  row
begin
  insert into doctor_stats(doctor_id, total_patients)
  values(new.doctor_id, 1)
   on duplicate key update total_patients = total_patients + 1;
end $$
delimiter ;


delimiter $$ 
create trigger decrease_doctor_stats
after delete on appointments
for each row
begin
	update doctor_stats
    set total_patients = total_patients - 1
    where doctor_id  = old.doctor_id;
end$$
delimiter ;

-- moving to stored procedure -  it is a set of code block similar to programming methods which can be write once and reuse by  calling it and passing some paramenters.
-- lets create a store procedure for inserting  a new patient details.

delimiter $$
create procedure addPatient(
in p_name varchar(30),
in p_age int ,
in p_gender enum('male','female'),
in p_phone  varchar(15),
in p_address text
)
begin
insert into patients(name, age , gender, phone, address)
values(p_name, p_age, p_gender, p_phone, p_address);
end$$
delimiter ;

-- lets create one stored procedure for doctors as well

delimiter $$
create procedure addDoctor(
in d_name varchar(30),
in  d_phone varchar(15),
in d_email varchar(50),
in d_experience int ,
 in d_fees decimal(10,2)
)
begin 
insert into doctors(name, phone, email, experience_years, fees)
values(d_name, d_phone, d_email, d_experience,  d_fees);
end$$
delimiter ;

call addPatient('Ravina Tanddan',38, 'female','9879879870', 'swarajpuri Road, gaya ji');

select * from patients;

-- checking available stored procedure in our db;
SHOW PROCEDURE STATUS WHERE Db = 'healthclinicdb';
