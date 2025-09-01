--LAB ACTIVITY
--1. Find the minimum and maximum salary of the Job title 'President' from the Jobs table.
select * from jobs;
select min_salary, max_salary from jobs where job_title = 'President';
--2. Find details of employees whose last name is 'Snares'. Return employee ID, first name, last name, and department ID.
select * from employees;
select employee_id, first_name, last_name, department_id from employees where last_name = 'Snares';
--3. Write a SQL query to find all jobs where the minimum salary is between $10,000 and $15,000 and the maximum salary is greater than $25,000. Use the BETWEEN and AND operators.
select * from jobs where min_salary between 10000 and 15000 and max_salary > 25000;
--4. Write a SQL query to find the employees whose last name starts with 'S' and who do not have a commission (COMMISSION_PCT is NULL). Use the LIKE and NULL operators.
select * from employees where last_name like 'S%' and commission_pct is null;
--5. Find the employees with the first names “John”, “NEENA”, and “Lency”.
select * from employees where first_name in ('John', 'Neena', 'Lency');
--6. Find the list of cities except those with country ID ‘IN’ and ‘CH’ from the Locations table.
select * from locations;
select * from locations where country_id not in ('IN', 'CH');
--7. Find the list of phone numbers with DEPARTMENT_ID = 90 but not with job_id = 'IT_PROG' from the Employees table.
select phone_number, department_id, job_id from employees where department_id = 90 and job_id != 'IT_PROG';
--8. Write a SQL query to find the list of unique job titles in the Jobs table. Ensure there are no duplicate job titles using the UNIQUE operator.
select distinct job_title from jobs;
--9. Write a SQL query to find employees who were hired before '01-Jan-2005' or after '31-Dec-2015'. Use the OR operator to combine the conditions.
select * from employees where hire_date < '01-Jan-2005' or hire_date > '31-Dec-2015';
--10. Write a SQL query to find the employees whose salary is not between $20,000 and $30,000. Use the NOT BETWEEN operator to specify the salary range.
select * from employees where salary not between 20000 and 30000;
--11. Write a SQL query to find the Employees with the First name “John” “NEENA” and “Lency”
select * from employees where first_name in ('John', 'Neena', 'Lency');
--12. Write a query to find the list of cities with country ID ‘IT’ from locations table.
select city from locations where country_id = 'IT';
--13. Write a query to find the list of city except country ID ‘IN’ and ‘CH’ from locations table.
select city from locations where country_id not in ('IN', 'CH');
--14. Write a query to find the list of employees who are hired after '12-Dec-07' from employee table.
select * from employees where hire_date > '12-Dec-07';
--15. Write a query to find the list of employees who are hired after '12-Dec-07' in Department with DEPARTMENT_ID=100 from employee table.
select * from employees where hire_date > '12-Dec-07' and department_id = 100;

--LAB TASK
--1. Write a SQL query to display the first and last names of all employees whose salaries are $15000.
select first_name, last_name , salary from employees where salary = 15000;
--2. Find employees who either have a salary greater than $60,000 or work in department 50.
select * from employees where salary > 60000 or department_id = 50;
--3. Write a SQL query to find the details of all jobs with a maximum salary greater than $10,000 from the Jobs table.
select * from jobs where max_salary > 10000;
--4. Write a SQL query to display the department name where manager id is null from departments table.
select * from departments;
select department_name from departments where manager_id is null;
--5. Retrieve employees who are in department 30 and have a salary greater than $40,000.
select * from employees where department_id = 30 and salary > 40000;
--6. List employees whose salaries are between $30,000 and $50,000.
select * from employees where salary between 30000 and 50000;
--7. Write a SQL query to find the employees who do have a commission (COMMISSION_PCT is NOT NULL) from the Employees table.
select * from employees where commission_pct is not null;
--8. Write an SQL query to retrieve the details of employees who work in departments 10, 20, or 30.
select * FROM employees where department_id in (10, 20, 30);
--9. List employees who are not in department 40.
select * from employees where department_id != 40;
--10. Find employees who either have a salary greater than $60,000 or work in department 50.
select * from employees where salary > 60000 or department_id = 50;