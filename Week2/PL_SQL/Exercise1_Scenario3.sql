BEGIN
    FOR rec IN (SELECT l.LoanID, c.Name FROM Loans l
                JOIN Customers c ON l.CustomerID = c.CustomerID
                WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30)
    LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || rec.LoanID || ' for ' || rec.Name || ' is due within the next 30 days.');
    END LOOP;
END;
/

