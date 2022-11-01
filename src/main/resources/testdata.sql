DELETE FROM EMPLOYEE;
TRUNCATE TABLE EMPLOYEE;
ALTER SEQUENCE EMPLOYEE.ID RESTART WITH 1;
INSERT INTO EMPLOYEE (FIRST_NAME, LAST_NAME, EMAIL, ADDRESS, ROLE, COMPANY_NAME) 
VALUES ('Jonny', 'Coddington', 'j.coddington@gmail.com', '123 Fake St, London, SE3 4DY', 'Java Developer', 'Peach Ltd');
INSERT INTO EMPLOYEE (FIRST_NAME, LAST_NAME, EMAIL, ADDRESS, ROLE, COMPANY_NAME) 
VALUES ('Jonny', 'Coddington', 'j.coddington@gmail.com', '123 Fake St, London, SE3 4DY', 'Java Developer', 'Peach Ltd');