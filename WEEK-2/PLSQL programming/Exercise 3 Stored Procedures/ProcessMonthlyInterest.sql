CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
  UPDATE accounts
  SET balance = balance * 1.01
  WHERE account_type = 'SAVINGS';

  DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' savings accounts have been updated with 1% interest.');
  COMMIT;
END ProcessMonthlyInterest;
/
