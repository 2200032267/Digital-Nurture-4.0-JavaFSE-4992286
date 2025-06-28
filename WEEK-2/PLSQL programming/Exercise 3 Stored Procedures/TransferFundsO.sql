BEGIN
  TransferFunds(p_from_account => 1001, p_to_account => 1003, p_amount => 500);
END;
/

SELECT * FROM accounts WHERE account_id IN (1001, 1003);

BEGIN
  TransferFunds(p_from_account => 1001, p_to_account => 1003, p_amount => 9000);
END;
/

SELECT * FROM accounts WHERE account_id IN (1001, 1003);
