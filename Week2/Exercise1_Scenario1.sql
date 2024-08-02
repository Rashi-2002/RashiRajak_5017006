BEGIN
    FOR rec IN (SELECT CustomerID, InterestRate FROM Loans l
                JOIN Customers c ON l.CustomerID = c.CustomerID
                WHERE EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM c.DOB) > 60) 
    LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = rec.CustomerID;
    END LOOP;
END;
/

