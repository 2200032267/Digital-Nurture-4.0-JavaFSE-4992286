SET SERVEROUTPUT ON;

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE employees';
   EXECUTE IMMEDIATE 'DROP TABLE accounts';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/

CREATE TABLE accounts (
    account_id    NUMBER(10) PRIMARY KEY,
    account_type  VARCHAR2(20) CHECK (account_type IN ('SAVINGS', 'CHECKING')),
    balance       NUMBER(12, 2) NOT NULL
);

CREATE TABLE employees (
    employee_id   NUMBER(10) PRIMARY KEY,
    first_name    VARCHAR2(50),
    last_name     VARCHAR2(50),
    department_id NUMBER(4),
    salary        NUMBER(10, 2)
);

INSERT INTO accounts VALUES (1001, 'SAVINGS', 5000.00);
INSERT INTO accounts VALUES (1002, 'SAVINGS', 12000.00);
INSERT INTO accounts VALUES (1003, 'CHECKING', 1500.00);
INSERT INTO accounts VALUES (1004, 'SAVINGS', 750.50);

INSERT INTO employees VALUES (701, 'Alice', 'Wonder', 10, 60000);
INSERT INTO employees VALUES (702, 'Bob', 'Builder', 10, 65000);
INSERT INTO employees VALUES (703, 'Charlie', 'Chaplin', 20, 70000);

COMMIT;

SELECT * FROM accounts ORDER BY account_id;
SELECT * FROM employees ORDER BY employee_id;
