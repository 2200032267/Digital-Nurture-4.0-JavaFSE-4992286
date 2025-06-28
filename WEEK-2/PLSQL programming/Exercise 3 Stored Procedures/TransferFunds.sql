CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN accounts.account_id%TYPE,
    p_to_account   IN accounts.account_id%TYPE,
    p_amount       IN accounts.balance%TYPE
)
IS
  v_source_balance accounts.balance%TYPE;
BEGIN
  IF p_amount <= 0 THEN
    DBMS_OUTPUT.PUT_LINE('Transfer failed: Amount must be positive.');
    RETURN;
  END IF;

  SELECT balance
  INTO v_source_balance
  FROM accounts
  WHERE account_id = p_from_account
  FOR UPDATE;

  IF v_source_balance >= p_amount THEN
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_account;

    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_account;

    DBMS_OUTPUT.PUT_LINE('Success! Transfer of ' || TO_CHAR(p_amount, 'FM$999,999.00') || ' completed.');
    COMMIT;
  ELSE
    DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient funds in account ' || p_from_account || '.');
    ROLLBACK;
  END IF;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('Transfer failed: One or both accounts do not exist.');
    ROLLBACK;
END TransferFunds;
/
