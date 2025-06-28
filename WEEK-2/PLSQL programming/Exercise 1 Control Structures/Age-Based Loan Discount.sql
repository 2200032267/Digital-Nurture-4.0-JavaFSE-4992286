DECLARE
  v_age NUMBER;

  CURSOR c_customer_loans IS
    SELECT c.customer_id, c.date_of_birth, l.loan_id, l.interest_rate
    FROM customers c
    JOIN loans l ON c.customer_id = l.customer_id
    FOR UPDATE OF l.interest_rate;

BEGIN
  DBMS_OUTPUT.PUT_LINE('--- Checking for loan discounts ---');

  FOR rec IN c_customer_loans LOOP
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, rec.date_of_birth) / 12);

    IF v_age > 60 THEN
      DBMS_OUTPUT.PUT_LINE('Customer ' || rec.customer_id || ' (Age: ' || v_age || ') qualifies for a discount.');
      DBMS_OUTPUT.PUT_LINE('  > Updating Loan ' || rec.loan_id || ': Old Rate=' || rec.interest_rate || '%, New Rate=' || (rec.interest_rate * 0.99) || '%');

      UPDATE loans
      SET interest_rate = interest_rate * 0.99
      WHERE CURRENT OF c_customer_loans;
    END IF;
  END LOOP;

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('--- Discount process complete. ---');
END;
/
