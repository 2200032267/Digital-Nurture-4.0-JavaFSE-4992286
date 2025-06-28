DECLARE
  CURSOR c_all_customers IS
    SELECT customer_id, balance, is_vip FROM customers
    FOR UPDATE OF is_vip;
BEGIN
  DBMS_OUTPUT.PUT_LINE('--- Checking for VIP status promotion ---');
  FOR rec IN c_all_customers LOOP
    IF rec.balance > 10000 AND rec.is_vip = 'N' THEN
      DBMS_OUTPUT.PUT_LINE('Customer ' || rec.customer_id || ' with balance $' || rec.balance || ' promoted to VIP.');

      UPDATE customers
      SET is_vip = 'Y'
      WHERE CURRENT OF c_all_customers;
    END IF;
  END LOOP;

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('--- VIP status check complete. ---');
END;
/

BEGIN
  UPDATE customers
  SET is_vip = 'Y'
  WHERE balance > 10000;

  DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' customer(s) promoted to VIP status using a single SQL statement.');
  COMMIT;
END;
/
