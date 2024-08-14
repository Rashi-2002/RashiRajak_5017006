DECLARE
    CURSOR cur_monthlyStatements IS
        SELECT c.CustomerID, c.Name, t.TransactionDate, t.Amount, t.TransactionType 
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE t.TransactionDate BETWEEN TRUNC(SYSDATE, 'MM') AND LAST_DAY(SYSDATE);
BEGIN
    FOR rec IN cur_monthlyStatements LOOP
        DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.Name || ', Date: ' || rec.TransactionDate || ', Amount: ' || rec.Amount || ', Type: ' || rec.TransactionType);
    END LOOP;
END;
/

