DECLARE
    CURSOR cur_loanInterestRates IS
        SELECT LoanID, InterestRate FROM Loans;
    newInterestRate NUMBER;
BEGIN
    FOR rec IN cur_loanInterestRates LOOP
        newInterestRate := rec.InterestRate * 1.05;  -- Assume the new policy increases interest rates by 5%
        UPDATE Loans
        SET InterestRate = newInterestRate
        WHERE LoanID = rec.LoanID;
    END LOOP;

    COMMIT;
END;
/

