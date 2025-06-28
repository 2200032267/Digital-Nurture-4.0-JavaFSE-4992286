CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department_id IN employees.department_id%TYPE,
    p_bonus_pct     IN NUMBER
)
IS
BEGIN
  IF p_bonus_pct <= 0 THEN
    DBMS_OUTPUT.PUT_LINE('Error: Bonus percentage must be a positive number.');
    RETURN;
  END IF;

  UPDATE employees
  SET salary = salary * (1 + p_bonus_pct / 100)
  WHERE department_id = p_department_id;

  DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' employees in department ' || p_department_id || ' received a ' || p_bonus_pct || '% bonus.');
  COMMIT;
END UpdateEmployeeBonus;
/
