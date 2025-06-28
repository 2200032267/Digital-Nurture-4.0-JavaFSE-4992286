BEGIN
  ProcessMonthlyInterest;
END;
/

SELECT * FROM accounts ORDER BY account_id;
