# https://leetcode.com/problems/second-highest-salary/description/

SELECT MAX(Salary) as 'SecondHighestSalary'
    FROM Employee
    WHERE Salary != (SELECT MAX(Salary) From Employee);
    
SELECT
    (SELECT DISTINCT
            Salary
        FROM
            Employee
        ORDER BY Salary DESC
        LIMIT 1 OFFSET 1) AS SecondHighestSalary;