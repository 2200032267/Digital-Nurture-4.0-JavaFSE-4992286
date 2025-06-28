DECLARE
  -- Cursor to fetch loans due in the next 30 days
  CURSOR c_due_loans IS
    SELECT c.first_name, c.last_name, l.loan_id, l.due_date
    FROM customers c
    JOIN loans l ON c.customer_id = l.customer_id
    WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30;

BEGIN
  DBMS_OUTPUT.PUT_LINE('--- Sending reminders for loans due within 30 days ---');

  FOR rec IN c_due_loans LOOP
    -- Print a formatted reminder message for each loan
    DBMS_OUTPUT.PUT_LINE(
      'REMINDER for ' || rec.first_name || ' ' || rec.last_name ||
      ': Loan #' || rec.loan_id || ' is due on ' ||
      TO_CHAR(rec.due_date, 'DD-MON-YYYY') || '.'
    );
  END LOOP;

  DBMS_OUTPUT.PUT_LINE('--- All reminders sent. ---');
END;
/