CREATE OR REPLACE FUNCTION HasSufficientBalance(p_accountID NUMBER, p_amount NUMBER) RETURN BOOLEAN IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_accountID;

    IF v_balance >= p_amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
END;
/

