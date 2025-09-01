--LAB ACTIVITY
--1. Write a query to list the name, job title, department name, and salary of the employees in ascending order of their department.
SELECT e.First_Name, e.Last_Name, e.Job_id, d.Department_Name, e.Salary FROM Employees e
JOIN Departments d ON e.Department_ID = d.Department_ID ORDER BY d.Department_Name ASC;

--2. Write a query to list the departments where at least two employees are working.
SELECT d.Department_ID, d.Department_Name FROM Departments d
JOIN Employees e ON d.Department_ID = e.Department_ID
GROUP BY d.Department_ID, d.Department_Name HAVING COUNT(e.Employee_ID) >= 2;

--3. Fetch all records where the employee&#39; s salary is less than the lowest salary in the company.
SELECT * FROM Employees WHERE Salary < (SELECT MIN(Salary) FROM Employees);

--4. Write a query to list the name, job title, annual salary, department name, and city of employees who earn 60000 or more annually and are not working as ANALYST.
SELECT e.First_Name, e.Last_Name, j.Job_Title, (e.Salary * 12) AS Annual_Salary, d.Department_Name, l.City
FROM Employees e JOIN Departments d ON e.Department_ID = d.Department_ID
JOIN Locations l ON d.Location_ID = l.Location_ID
JOIN Jobs j ON e.Job_ID = j.Job_ID
WHERE (e.Salary * 12) >= 60000 AND j.Job_Title != 'Accountant';

--5. Write a query to print details of the employees who are also Managers.
SELECT DISTINCT e1.* FROM Employees e1
JOIN Employees e2 ON e1.Employee_ID = e2.Manager_ID WHERE e2.Manager_ID IS NOT NULL;

--6. List department number and department name for all departments that have no employees.
SELECT d.Department_ID, d.Department_Name FROM Departments d
LEFT JOIN Employees e ON d.Department_ID = e.Department_ID WHERE e.Employee_ID IS NULL;

--7. Display employee name, salary, and department name where all employees match their department, including employees with no assigned department.
SELECT e.First_Name, e.Last_Name, e.Salary, d.Department_Name FROM Employees e
LEFT JOIN Departments d ON e.Department_ID = d.Department_ID;

--8. Display the name, job title, department name, and city of employees who are working in departments located in cities without a state province.
SELECT e.First_Name, e.Last_Name, j.Job_Title, d.Department_Name, l.City FROM Employees e
JOIN Departments d ON e.Department_ID = d.Department_ID
JOIN Locations l ON d.Location_ID = l.Location_ID
JOIN Jobs j ON e.Job_ID = j.Job_ID WHERE l.State_Province IS NULL;

--9. Write an SQL query to show records from one table that do not exist in another table.
SELECT e.* FROM Employees e
LEFT JOIN Job_History jh ON e.Employee_ID = jh.Employee_ID WHERE jh.Employee_ID IS NULL;

--10. Display all employees who belong to the US but not to the state of Washington.
SELECT e.first_name, d.department_id, l.country_id, l.state_province FROM Employees e
JOIN Departments d ON e.Department_ID = d.Department_ID
JOIN Locations l ON d.Location_ID = l.Location_ID
WHERE l.Country_ID = 'US' AND l.State_Province != 'Washington';

--LAB TASK
--11. Write a query to list the name, job title, department name, and location of employees who have a salary higher than the average salary in their department.
SELECT e.First_Name, e.Last_Name, j.Job_Title, d.Department_Name, l.Location_ID
FROM Employees e
JOIN Departments d ON e.Department_ID = d.Department_ID
JOIN Locations l ON d.Location_ID = l.Location_ID
JOIN Jobs j ON e.Job_ID = j.Job_ID
WHERE e.Salary > (
SELECT AVG(Salary) FROM Employees WHERE Department_ID = e.Department_ID);

--12. Write a query to list employees who have changed their job title at least once in their job history. 
SELECT DISTINCT e.* FROM Employees e
JOIN Job_History jh ON e.Employee_ID = jh.Employee_ID
WHERE e.Job_ID != jh.Job_ID;

--13. List employees who work in the same department as their managers
SELECT e.* FROM Employees e
JOIN Employees m ON e.Manager_ID = m.Employee_ID
WHERE e.Department_ID = m.Department_ID;

--14. Write a query to list the name, department name, and location of employees who work in the same country as their department location.
SELECT e.First_Name, e.Last_Name, d.Department_Name, l.Country_ID
FROM Employees e
JOIN Departments d ON e.Department_ID = d.Department_ID
JOIN Locations l ON d.Location_ID = l.Location_ID
WHERE l.Country_ID = 
(SELECT Country_ID FROM Locations WHERE Location_ID = d.Location_ID);

--15. Write a query to find employees who work in departments with more than 5 employees.
SELECT e.* FROM Employees e
JOIN Departments d ON e.Department_ID = d.Department_ID
WHERE d.Department_ID IN (
SELECT Department_ID FROM Employees GROUP BY Department_ID HAVING COUNT(Employee_ID) > 5);

--16. Display a list of employees along with their managers&#39; names.
SELECT e.First_Name AS Employee_Name, m.First_Name AS Manager_Name FROM Employees e
LEFT JOIN Employees m ON e.Manager_ID = m.Employee_ID;

--17. Write a query to list the employee names and their department names where the department is located in a different country than the employee's residence.
SELECT e.First_Name, e.Last_Name, d.Department_Name, l.Country_ID
FROM Employees e
JOIN Departments d ON e.Department_ID = d.Department_ID
JOIN Locations l ON d.Location_ID = l.Location_ID;

--18. Write a query to find employees who earn more than their department&#39;s average salary but less than the highest salary in the company.
SELECT e.* FROM Employees e
WHERE e.Salary > (SELECT AVG(Salary) FROM Employees WHERE Department_ID = e.Department_ID)
AND e.Salary < (SELECT MAX(Salary) FROM Employees);

SELECT e.* FROM Employees e JOIN 
(SELECT Department_ID, AVG(Salary) AS Avg_Salary FROM Employees GROUP BY Department_ID)
avg_salaries ON e.Department_ID = avg_salaries.Department_ID
JOIN (SELECT MAX(Salary) AS Max_Salary FROM Employees
) max_salary ON e.Salary < max_salary.Max_Salary
WHERE e.Salary > avg_salaries.Avg_Salary;

--19. Display a list of all employees who have worked in multiple departments, showing their job history and department names.
SELECT e.First_Name, e.Last_Name, 
COUNT(DISTINCT jh.Department_ID)as "Department_Count", jh.Department_ID 
FROM Job_History jh JOIN Employees e ON jh.Employee_ID = e.Employee_ID 
GROUP BY e.First_Name, e.Last_Name, jh.Department_ID 
HAVING COUNT(DISTINCT jh.Department_ID) > 1;

--20. Write a query to find employees who have worked in more than one region throughout their career. 
SELECT ed.First_Name, ed.Last_Name
From EMP_DETAILS_VIEW ed
JOIN Regions r ON ed.Region_Name = r.Region_Name 
GROUP BY ed.Employee_ID, ed.First_Name, ed.Last_Name HAVING COUNT(DISTINCT r.Region_ID) > 1;  

--21. List all employees and the region they are working in.
SELECT ed.First_Name, ed.Last_Name, ed.REGION_NAME FROM EMP_DETAILS_VIEW ed
JOIN Locations l ON ed.Location_ID = l.Location_ID;

--22. Find employees who have the same last name but work in different departments.
SELECT e1.First_Name, e1.Last_Name, e1.Department_ID, e2.Department_ID FROM Employees e1
JOIN Employees e2 ON e1.Last_Name = e2.Last_Name WHERE e1.Department_ID != e2.Department_ID;

--23. List employees who have changed job titles more than twice.
SELECT e.EMPLOYEE_ID, COUNT(DISTINCT jh.Job_ID) as job_count FROM Employees e JOIN Job_History jh ON e.Employee_ID = jh.Employee_ID 
GROUP BY e.Employee_ID HAVING COUNT(DISTINCT jh.Job_ID) > 2;

--24. Show job titles that are not currently assigned to any employee.
SELECT e.First_Name, e.Last_Name, e.Salary, d.Department_Name FROM Employees e
JOIN Departments d ON e.Department_ID = d.Department_ID WHERE (SELECT COUNT(*)FROM Employees e2 
WHERE e2.Department_ID = e.Department_ID AND e2.Salary > e.Salary) < 3
ORDER BY d.Department_Name, e.Salary DESC;

