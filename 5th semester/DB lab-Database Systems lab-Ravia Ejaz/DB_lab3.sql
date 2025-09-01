--LAB ACTIVITY
--1.	Create a table named Departments with the following fields: Department_ID (Primary Key), Department_Name (NOT NULL, Unique), Manager_ID (Foreign Key referencing Employees table), and Location_ID.
CREATE TABLE Employees as select * from hr.employees;
alter table employees
add constraint pk_emp primary key(employee_id);
CREATE TABLE Departments(
    Department_ID NUMBER(5) PRIMARY KEY,
    Department_Name VARCHAR(30) NOT NULL UNIQUE,
    Manager_ID NUMBER(5),
    Location_ID NUMBER(5),
    CONSTRAINT fk_manager FOREIGN KEY (Manager_ID) REFERENCES Employees(Employee_ID)
);

--2.	Alter the Departments table to add a new column Established_Date of type DATE with a default value of the current date.
ALTER TABLE Departments
ADD Established_Date DATE DEFAULT SYSDATE;
--3.	Rename the Departments table to Company_Departments.
ALTER TABLE Departments 
RENAME TO Company_Departments;
--4.	Drop the table Company_Departments after ensuring it has no dependent constraints.
DROP TABLE Company_Departments CASCADE CONSTRAINTS;
--5.	Create a new table Project_Allocation similar to the Job_History table. Insert 3 rows, then truncate the table.
CREATE TABLE Project_Allocation (
    Project_ID NUMBER(5),
    Employee_ID NUMBER(5),
    Start_Date DATE,
    End_Date DATE
);

INSERT INTO Project_Allocation (Project_ID, Employee_ID, Start_Date, End_Date) VALUES (1, 101, SYSDATE, SYSDATE + 30);
INSERT INTO Project_Allocation (Project_ID, Employee_ID, Start_Date, End_Date) VALUES (2, 102, SYSDATE, SYSDATE + 30);
INSERT INTO Project_Allocation (Project_ID, Employee_ID, Start_Date, End_Date) VALUES (3, 103, SYSDATE, SYSDATE + 30);

TRUNCATE TABLE Project_Allocation;

--6.	Create two tables, Parent and Child, where Child has a foreign key referencing Parent. Use deferred constraint checking to insert a row into Child first, followed by Parent.
CREATE TABLE Parent (
    Parent_ID NUMBER(5) PRIMARY KEY,
    Parent_Name VARCHAR(30)
);

CREATE TABLE Child (
    Child_ID NUMBER PRIMARY KEY,
    Parent_ID NUMBER,
    CONSTRAINT fk_parent FOREIGN KEY (Parent_ID) REFERENCES Parent(Parent_ID) INITIALLY DEFERRED DEFERRABLE
);

-- Insert into Child first
INSERT INTO Child (Child_ID, Parent_ID) VALUES (1, 1);

-- Now insert into Parent
INSERT INTO Parent (Parent_ID, Parent_Name) VALUES (1, 'Parent 1');

--7.	Alter the Employees table to add a unique constraint on the Email column.
ALTER TABLE Employees
ADD CONSTRAINT unique_email UNIQUE (Email);

--8.	Create a table Employee_Salaries with fields Employee_ID, Salary, and a check constraint that ensures Salary is greater than 3000 but less than 10000.
CREATE TABLE Employee_Salaries (
    Employee_ID NUMBER,
    Salary NUMBER CHECK (Salary > 3000 AND Salary < 10000)
);

--9.	Insert a new row into the Employees table, ensuring all constraints are satisfied. Then update the Salary of an employee to 8500 where the Employee_ID is 106.
INSERT INTO Employees (Employee_ID, First_Name, Last_Name, Email, Salary) VALUES (208, 'John', 'Doe', 'john.doe@example.com', 5000);
UPDATE Employees SET Salary = 8500 WHERE Employee_ID = 208;

--10.	Create a Projects table with a foreign key constraint referencing Department_ID from Departments. Insert related data into both tables, then try to delete a Department row that is being referenced by a Projects row, and observe the constraint violation.
CREATE TABLE Projects (
    Project_ID NUMBER PRIMARY KEY,
    Project_Name VARCHAR2(100),
    Department_ID NUMBER,
    CONSTRAINT fk_department FOREIGN KEY (Department_ID) REFERENCES Departments(Department_ID)
);

-- Insert related data
INSERT INTO Departments (Department_ID, Department_Name) VALUES (110, 'Finance');
INSERT INTO Projects (Project_ID, Project_Name, Department_ID) VALUES (1, 'Project A', 10);

-- Attempt to delete a Department referenced by Projects
DELETE FROM Departments WHERE Department_ID = 10;  -- This will cause a constraint violation.

--11.	Create a new user using SQL command Line and grant privileges. We are using this user to create our own database with related tables, which we are working on in lab#03.
--use command line
--12.	Create table Jobs and job_History (ignore foreign keys relations) same fields as given in HR Schema in which job_ID is considered as primary key in jobs table.
CREATE TABLE Jobs as select * from hr.jobs where 1=2;

CREATE TABLE Job_History as select * from hr.job_history where 1=2;

alter table jobs
add constraint pk_jobs primary key (job_id);
--13.	Change the data type of ‘job_ID’ from character to numeric in Jobs table.(Like IT_Prog->101).
-- Assuming Job_ID is currently VARCHAR2, we first need to drop it and then recreate it as NUMBER.
ALTER TABLE Jobs 
MODIFY Job_ID NUMBER(5);

--14.	Write a SQL statement to add job_id column in job_history table as foreign key referencing to the primary key job_id of jobs table.
ALTER TABLE Job_History
ADD CONSTRAINT fk_job FOREIGN KEY (Job_ID) REFERENCES Jobs(Job_ID);

--15.	Insert a new row in jobs table having all the attributes and the job_ID should update in job_History table as well.
INSERT INTO Jobs (Job_ID, Job_Title, Min_Salary, Max_Salary) VALUES (101, 'IT Programmer', 4000, 8000);
--16.	Add Column Job_Nature in Jobs table.
ALTER TABLE Jobs 
ADD Job_Nature VARCHAR(30);

--17.	Create replica of employee table.
CREATE TABLE Employees_Replica AS SELECT * FROM Employees;
--18.	Write a SQL statement to add employee_id column in job_history table as foreign key referencing to the primary key employee_id of employees table.
ALTER TABLE Job_History
ADD CONSTRAINT fk_employee FOREIGN KEY (Employee_ID) REFERENCES Employees(Employee_ID);
--19.	Drop column Job_Nature.
ALTER TABLE Jobs 
DROP COLUMN Job_Nature;

--20.	ALTER table EMPLOYEE created in question 5 and apply the constraint CHECK on First_Name attribute such that ENAME should always be inserted in capital letters. 
ALTER TABLE Employees
ADD CONSTRAINT check_first_name CHECK (First_Name = UPPER(First_Name));

--21.	ALTER table EMPLOYEE created in question 5 and apply the constraint on SALary attribute such that no two salaries of the employees should be similar. (Hint Unique)
ALTER TABLE Employees
ADD CONSTRAINT unique_salary UNIQUE (Salary);

--22.	ALTER table Employee created in question 5 and apply constraint on Phone_No such that Phone_No should not be entered empty (Hint modify).
ALTER TABLE Employees
MODIFY Phone_No NOT NULL;

--23.	Write a SQL statement to insert one row into the table employees.
INSERT INTO Employees (Employee_ID, First_Name, Last_Name, Email, Salary) VALUES 209, 'Jane', 'Doe', 'jane.doe@example.com', 7500);

--24.	Write a SQL statement to change the salary of employee to 8000 who’s ID is 105, if the existing salary is less than 1+000.
UPDATE Employees 
SET Salary = 8000 WHERE Employee_ID = 105 AND Salary < 1000;

--25.	Write a SQL statement to add a primary key for a combination of columns employee_id and job_id in employees table, give the reason why this command is showing error.
ALTER TABLE Employees 
ADD CONSTRAINT pk_employee_job PRIMARY KEY (Employee_ID, Job_ID);

--26.	Write a SQL statement to add an index named indx_job_id on job_id column in the table job_history.
CREATE INDEX indx_job_id ON Job_History(Job_ID);

--27.	Write a SQL statement to remove employees table.
DROP TABLE Employees CASCADE CONSTRAINTS;
