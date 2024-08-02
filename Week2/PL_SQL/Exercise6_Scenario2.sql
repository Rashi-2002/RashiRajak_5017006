DECLARE
    CURSOR cur_annualFee IS
        SELECT AccountID, Balance FROM Accounts;
BEGIN
    FOR rec IN cur_annualFee LOOP
        UPDATE Accounts
        SET Balance = Balance - 50,
            LastModified = SYSDATE
        WHERE AccountID = rec.AccountID;
    END LOOP;

    COMMIT;
END;
/

