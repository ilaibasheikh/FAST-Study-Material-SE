--Lab Activity
--1.	Write a query to find employees whose first name starts with the letter 'J'. Order the result by last name.
select first_name, last_name, salary from employees where first_name like 'J%' order by last_name;
--2.	Display the employee's salary multiplied by 12 (annual salary) and alias the column as "Annual Salary". Use the ROUND function to round the salary to the nearest whole number.
select round(salary * 12, 0) as "Annual Salary" from employees;
--3.	List all Employees who have an ‘A’ in their last names.
select employee_id, first_name, last_name from employees where last_name like '%a%';
--4.	Write an SQL query to convert the salary of each employee to a string, concatenate it with the string ' USD', and alias the column as "Salary in USD".
select TO_CHAR(salary) || ' USD' as "Salary in USD" from employees;
--5.	Display the total salary for each department, ordering the results by the total salary in descending order. Alias the total salary column as "Total Salary".
select department_id, sum(salary) as "Total Salary" from employees group by department_id order by "Total Salary" desc;
--6.	Write a query to display the hire date of each employee in the format 'Month Year' (e.g., 'July 2023'). Alias the column as "Hire Date".
select to_char(hire_date, 'Month YYYY') as "Hire Date" from employees;
--7.	Display the salary of employee SUSAN with $ sign preceded.
select '$' || to_char(salary) as "Salary" from employees where first_name = 'Susan';
--8.	Display the employee number, name, salary, salary increase by 15% expressed as a whole number (labeled as New Salary), the difference between old salary and new salary (labeled as Increment).
select employee_id, first_name || last_name as "Name", salary, round(salary*0.15, 0) as "New Salary", salary - round(salary*0.15, 0) as "Increment" from employees;
--9.	Count the number of employees for each job title and order the result by the count in ascending order. Alias the count column as "Number of Employees".
select job_id, count(*) as "Number of Employees" from employees group by job_id order by "Number of Employees" asc;
--10.	Display the name of the employee who are working in the company for the past 35 years.
select first_name || last_name as "Employee_Name" from employees where extract(year from sysdate) - extract(year from hire_date) = 35;


--LAB TASK:
--1)	Print an employee name (first_name capital) and job id (lower Case)
select upper(first_name) as "First_Name", lower(job_id) As "Job_ID" from employees;
--2)	Comparing the hire dates for all employees who started in 2003, display the employee number, hire date, and month started using the conversion and date functions.
select employee_id, hire_date, TO_CHAR(hire_date, 'Month') as "Month Started" from employees where TO_CHAR(hire_date, 'YYYY') = '2003';
--3)	Find the next ‘Monday’ considering today’s date as date.
select NEXT_DAY(SYSDATE, 'MONDAY') as "Next Monday" from dual;
--4)	Show all employees’ last three letters of first name.
select SUBSTR(first_name, -3) as "Last 3 Letters" from employees;
--5)	List the name, hire date, and day of the week (labeled DAY) on which job was started. Order the result by day of week starting with Monday. 
select first_name, hire_date, TO_CHAR(hire_date, 'Day') as "DAY" from employees order by TO_CHAR(hire_date, 'D');
--6)	Display the department and manager id for all employees and round the commission up to 1 decimal. 
select department_id, manager_id, ROUND(commission_pct, 1) as "Commission" from employees;
--7)	Write a query to find the list of employees whose COMMISSION_PCT>0 and they do not belong to DEPARTMENT_ID 90 or 100 from Employees table 
select first_name, last_name, department_id, commission_pct from employees where commission_pct > 0 and department_id not in (90, 100);
--8)	Write a query to find the employees who are hired in year 2010 from Employees table. 
select first_name, last_name, hire_date from employees where EXTRACT(year from hire_date) = 2010;
--9)	Write a query to find the list of jobs whose min salary is greater than 8000 and less than 15,000 from job table. 
select job_title, min_salary from jobs where min_salary > 8000 and min_salary < 15000;
--10)	Write a query to find employee whose ID are greater than 100 and less than 150 and their department_id is greater than 90 and less than 100 along with their first_name, Last_name & Job ID. 
select employee_id, first_name, last_name, job_id from employees where employee_id > 100 and employee_id < 150 and department_id > 90 and department_id < 100;
--11)	Write a query to find total salary (Total salary formula = salary + (commission_pct* salary)) as “Total Salary”, commission_pct where commission_pct is not equal to null. 
select employee_id, salary + (commission_pct * salary) as "Total Salary", commission_pct from employees where commission_pct is not null;
--12)	Display the total salary being paid to all employees.
select SUM(salary) as "Total Salary" from employees;
--13)	List the employees information whose daily salary is more than Rs.100.
select first_name, last_name, salary / 30 as "Daily Salary" from employees where salary / 30 > 100;
--14)	List the employees who joined on (1-MAY-81, 3-DEC-81, 17-DEC-81, 19-JAN-80) in asc order of seniority.
select first_name, last_name, hire_date from employees where hire_date in ('01-MAY-81', '03-DEC-81', '17-DEC-81', '19-JAN-80') ORDER BY hire_date ASC;
