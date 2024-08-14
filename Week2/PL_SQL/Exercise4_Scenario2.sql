CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(p_loanAmount NUMBER, p_interestRate NUMBER, p_durationYears NUMBER) RETURN NUMBER IS
    v_monthlyInstallment NUMBER;
BEGIN
    v_monthlyInstallment := p_loanAmount * (p_interestRate / 100) / 12 / (1 - POWER(1 + (p_interestRate / 100) / 12, -p_durationYears * 12));
    RETURN v_monthlyInstallment;
END;
/

