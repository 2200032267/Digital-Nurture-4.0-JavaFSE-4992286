BEGIN
  UpdateEmployeeBonus(p_department_id => 10, p_bonus_pct => 5);
END;
/

SELECT * FROM employees ORDER BY employee_id;
