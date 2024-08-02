CREATE OR REPLACE PROCEDURE UpdateSalary(p_employeeID NUMBER, p_percentage NUMBER) IS
    employee_not_found EXCEPTION;
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_percentage / 100)
    WHERE EmployeeID = p_employeeID;
    
    IF SQL%ROWCOUNT = 0 THEN
        RAISE employee_not_found;
    END IF;

    COMMIT;

EXCEPTION
    WHEN employee_not_found THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_employeeID || ' not found.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

