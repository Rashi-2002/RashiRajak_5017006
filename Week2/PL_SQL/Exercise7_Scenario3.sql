CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(p_accountID NUMBER, p_customerID NUMBER, p_accountType VARCHAR2, p_balance NUMBER);
    PROCEDURE CloseAccount(p_accountID NUMBER);
    FUNCTION GetTotalBalance(p_customerID NUMBER) RETURN NUMBER;
END AccountOperations;
/
CREATE OR REPLACE PACKAGE BODY AccountOperations AS
    PROCEDURE OpenAccount(p_accountID NUMBER, p_customerID NUMBER, p_accountType VARCHAR2, p_balance NUMBER) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_accountID, p_customerID, p_accountType, p_balance, SYSDATE);
    END OpenAccount;

    PROCEDURE CloseAccount(p_accountID NUMBER) IS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_accountID;
    END CloseAccount;

    FUNCTION GetTotalBalance(p_customerID NUMBER) RETURN NUMBER IS
        v_totalBalance NUMBER;
    BEGIN
        SELECT SUM(Balance) INTO v_totalBalance FROM Accounts WHERE CustomerID = p_customerID;
        RETURN v_totalBalance;
    END GetTotalBalance;
END AccountOperations;
/

