CREATE OR REPLACE PROCEDURE TransferFunds(p_fromAccountID NUMBER, p_toAccountID NUMBER, p_amount NUMBER) IS
    insufficient_funds EXCEPTION;
BEGIN
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_fromAccountID
    AND Balance >= p_amount;
    
    IF SQL%ROWCOUNT = 0 THEN
        RAISE insufficient_funds;
    END IF;

    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_toAccountID;

    COMMIT;

EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in source account.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

