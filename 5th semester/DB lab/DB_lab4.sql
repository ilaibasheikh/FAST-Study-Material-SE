--Lab Activity:
--1. Display the average salary for each job, but only for jobs where the average salary is greater than $10,000. Display the job ID and the average salary.
SELECT Job_ID, AVG(Salary) AS Average_Salary FROM Employees
GROUP BY Job_ID HAVING AVG(Salary) > 10000;

--2.For each department that has more than 2 employees, retrieve the department number and the number of its employees who are making more than $10,000. 
select Department_ID, COUNT(*) AS High_Earners from Employees where Salary > 10000
group by Department_ID HAVING COUNT(*) > 2;

--3. Display the name of the department that has the most recent job start date. Use ROWNUM to ensure only the most recent record is considered.
select Department_ID from Job_History
where Start_Date = (
    select MAX(Start_Date) from Job_History
)
and rownum = 1;

--4. Create indexes on employee id in both employees and job history tables. List employees who do not have any records in the job history table.
create index idx_employee_id on Employees(Employee_ID);
create index idx_job_history_employee_id on Job_History(Employee_ID);

select * from Employees where employee_id not in 
(select employee_id from job_history);
--5. Display the department number and the salary of the highest-paid employee in that department. Excluding departments where the maximum salary is below $2,000. Sort the results in descending order of the salary.
select Department_ID, MAX(Salary) AS Highest_Salary from Employees
group by Department_ID having MAX(Salary) > 2000 order by Highest_Salary desc;

--6. Display the department IDs and average salaries of employees where the average salary is above $6,000. Use ROWNUM to limit the results to the top 3 departments.
select Department_ID, Average_Salary
from (
    select Department_ID, AVG(Salary) AS Average_Salary from Employees
    group by Department_ID having AVG(Salary) > 6000
) where rownum <= 3;

--7. Retrieve the last name and job ID of employees who have the same job as the employee with Employee ID 150. 
select Last_Name, Job_ID from Employees
where Job_ID = (select Job_ID from Employees where Employee_ID = 150);

--8. Create table Job_History1 like the job history table of HR user. Insert records into Job_History1 for jobs with an end date of '19-DEC-07' from hr.Job History. 
create table Job_History1 as select * from Job_History where End_Date = TO_DATE('19-DEC-07', 'DD-MON-YY');

--9. Insert 5 rows in the Job_Historyl table and delete records from Job_History1 where the job id is ' AC_ACCOUNT'. 
insert into Job_History1 (Employee_ID, Job_ID, Start_Date, End_Date, Department_ID) values (101, 'IT_PROG', TO_DATE('01-JAN-08', 'DD-MON-YY'), TO_DATE('01-JAN-09', 'DD-MON-YY'), 10);
insert into Job_History1 (Employee_ID, Job_ID, Start_Date, End_Date, Department_ID) values (102, 'AD_VP', TO_DATE('02-JAN-08', 'DD-MON-YY'), TO_DATE('02-JAN-09', 'DD-MON-YY'), 20);
insert into Job_History1 (Employee_ID, Job_ID, Start_Date, End_Date, Department_ID) values (103, 'ACCOUNTING', TO_DATE('03-JAN-08', 'DD-MON-YY'), TO_DATE('03-JAN-09', 'DD-MON-YY'), 30);
insert into Job_History1 (Employee_ID, Job_ID, Start_Date, End_Date, Department_ID) values (104, 'FINANCE', TO_DATE('06-JAN-08', 'DD-MON-YY'), TO_DATE('06-JAN-09', 'DD-MON-YY'), 40);
insert into Job_History1 (Employee_ID, Job_ID, Start_Date, End_Date, Department_ID) values (105, 'IT_PROG', TO_DATE('07-JAN-08', 'DD-MON-YY'), TO_DATE('07-JAN-09', 'DD-MON-YY'), 50);

SELECT * FROM JOB_HISTORY1;
DELETE FROM JOB_HISTORY1 WHERE JOB_ID = 'ACCOUNTING';

--10. Delete records from Job History for departments with the name 'IT'.
DELETE FROM JOB_HISTORY1
WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME = 'IT');

--Lab Task:
--11. Display the names and salaries of employees who earn more than the average salary of their respective department. 
select First_Name, Salary from Employees e where Salary > (select AVG(Salary) from Employees where Department_ID = e.Department_ID);

--12. Display the job ID and the salary of the lowest-paid employee in each job. Exclude any jobs where the minimum salary is below $1,000. Sort the results in ascending order of salary.
select Job_ID, MIN(Salary) AS Lowest_Salary from Employees
group by Job_ID having MIN(Salary) >= 1000 order by Lowest_Salary ASC;

--13. Select first name and department ID of employees working in the same department as the employee with Employee ID 140.
select First_Name, Department_ID from Employees where Department_ID = 
(select Department_ID from Employees where Employee_ID = 140);

--14. List employees whose job title is the same as that of employee 7369 and whose salary is greater than that of employee 7876.
select e.* from Employees e where e.Job_ID = 
(select Job_ID from Employees where Employee_ID = 110)
and e.Salary > (select Salary from Employees where Employee_ID = 100);

--15. Create a replica of employees table and increase the salary of employees by 12% who have a salary between $5,000 and $10,000.
CREATE TABLE Employees_replica AS SELECT * FROM Employees;

UPDATE Employees_replica
SET Salary = Salary * 1.12
WHERE Salary BETWEEN 5000 AND 10000;

--16. Display the names and salaries of employees whose salaries fall in the top 10% of all salaries. Use ROWNUM to limit the results.
select First_Name, Salary from Employees where Salary IN (
    select Salary from (
    select Salary from Employees order by Salary DESC
    )
    where rownum <= (select COUNT(*) * 0.1 from Employees)
);

--17. Write a Query to display the number of departments with the same location.
select Location_ID, COUNT(*) AS Department_Count from Departments 
group by Location_ID having COUNT(*) > 1;
--18. Display the job ID and the salary of the lowest paid employee of that job. Exclude anyone whose job is not known. Exclude any groups where the minimum salary is 1500. Sort the output in descending order of the salary.
select Job_ID, MIN(Salary) AS Lowest_Salary from Employees where Job_ID IS NOT NULL
group by Job_ID having MIN(Salary) >= 1500 order by Lowest_Salary DESC;
--19. Write a Query to select Firstname and Department_ID of Employees who are working in the same department as employee ID no 130.
select First_Name, Department_ID from Employees
where Department_ID = (select Department_ID from Employees where Employee_ID = 130);

--20. List all employees who are not working in department 30 and who earn more than all employees working in department 30.
select * from Employees where Department_ID != 30 AND Salary > ALL 
(select Salary from Employees where Department_ID = 30);

--21. Write a query to display the department number, name (department name) and location name for all departments whose average salary is greater than any average salary of those departments whose location name is 'New York'. 
SELECT Department_ID, Department_Name, (select city from locations) as "location_name" FROM Departments
WHERE ( SELECT AVG(Salary) FROM Employees WHERE Department_ID = Departments.Department_ID
) > (SELECT AVG(Salary) FROM Employees WHERE Department_ID IN (
SELECT Department_ID FROM Departments WHERE Location_ID = (
SELECT Location_ID FROM Locations WHERE city = 'london'
)));

--22. Insert into employees BKP as it should copy the record of the employee whose hire date is '10-MAR-03' from employees table.
insert into Employees
select * from Employees where Hire_Date = TO_DATE('10-MAR-03', 'DD-MON-YY');
