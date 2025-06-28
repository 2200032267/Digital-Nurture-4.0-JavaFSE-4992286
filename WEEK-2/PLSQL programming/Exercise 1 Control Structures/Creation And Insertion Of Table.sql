SET SERVEROUTPUT ON;

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE loans';
   EXECUTE IMMEDIATE 'DROP TABLE customers';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/

CREATE TABLE customers (
    customer_id   NUMBER PRIMARY KEY,
    first_name    VARCHAR2(50),
    last_name     VARCHAR2(50),
    date_of_birth DATE,
    balance       NUMBER(10, 2),
    is_vip        CHAR(1) DEFAULT 'N' CHECK (is_vip IN ('Y', 'N'))
);

CREATE TABLE loans (
    loan_id       NUMBER PRIMARY KEY,
    customer_id   NUMBER REFERENCES customers(customer_id),
    interest_rate NUMBER(4, 2),
    due_date      DATE
);

INSERT INTO customers (customer_id, first_name, last_name, date_of_birth, balance, is_vip)
VALUES (101, 'John', 'Smith', DATE '1955-05-20', 8500.00, 'N');

INSERT INTO customers (customer_id, first_name, last_name, date_of_birth, balance, is_vip)
VALUES (102, 'Jane', 'Doe', DATE '1988-11-15', 12500.50, 'N');

INSERT INTO customers (customer_id, first_name, last_name, date_of_birth, balance, is_vip)
VALUES (103, 'Peter', 'Jones', DATE '1949-01-30', 25000.00, 'N');

INSERT INTO customers (customer_id, first_name, last_name, date_of_birth, balance, is_vip)
VALUES (104, 'Mary', 'Williams', DATE '1992-07-22', 9500.00, 'N');

INSERT INTO loans (loan_id, customer_id, interest_rate, due_date)
VALUES (5001, 101, 5.50, SYSDATE + 90);

INSERT INTO loans (loan_id, customer_id, interest_rate, due_date)
VALUES (5002, 102, 4.75, SYSDATE + 120);

INSERT INTO loans (loan_id, customer_id, interest_rate, due_date)
VALUES (5003, 103, 6.00, SYSDATE + 60);

INSERT INTO loans (loan_id, customer_id, interest_rate, due_date)
VALUES (5004, 104, 5.25, SYSDATE + 15);

COMMIT;
