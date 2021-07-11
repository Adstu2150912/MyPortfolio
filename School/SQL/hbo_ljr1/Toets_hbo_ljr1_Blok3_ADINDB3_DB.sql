/*
Auteur: Adam Oubelkas
Project: Tentamen Databases 3
Aanmaakdatum: 19-05-2020
Bestandsnaam: 2150912_Adam_Oubelkas_Toets_Blok3_ADINDB3_DB.sql
Versie: 1
DBMS: Oracle Server
*/


--Uitwerking opgave 1.

CREATE TABLE Department
(
	'Number' NUMBER CONSTRAINT department_id_nn NOT NULL
	,Name VARCHAR2(255) NULL
	,Location VARCHAR2(255) NULL
	,NumberOfEmployees NUMBER NULL
);

CREATE UNIQUE INDEX department_id_pk
ON Department (department_id_nn);

ALTER TABLE Department
ADD ( CONSTRAINT department_id_pk PRIMARY KEY (department_id_nn));

--Uitwerking opgave 2.

CREATE TABLE Project
(
	'Number' NUMBER CONSTRAINT project_id_nn NOT NULL
	,DepartmentNumber NUMBER NOT NULL
	,DepartmentName VARCHAR2(255) NULL
	,Name VARCHAR2(255) NOT NULL
	,Location VARCHAR2(255) NOT NULL
);

CREATE UNIQUE INDEX project_id_pk
ON Project (project_id_nn);

ALTER TABLE Project
ADD ( CONSTRAINT project_id_pk PRIMARY KEY (project_id_nn));


CREATE Employee
(
	SSN NUMBER CONSTRAINT employee_id_nn NOT NULL
	,DepartmentNumber NUMBER NOT NULL
	,DepartmentName VARCHAR(255) NULL
	,Supervisor NUMBER NOT NULL
	,BirthDate DATE NULL
	,Sex CHAR(1) NULL
	,Address VARCHAR(255) NULL
	,Salary NUMBER NULL
	,FirstName VARCHAR(255) NULL
	,MInit VARCHAR(255) NULL
	,LastName VARCHAR(255) NULL
);

--Uitwerking opgave 3.

CREATE SEQUENCE department_seq
START WITH 1
INCREMENT BY 1
MAXVALUE 100
NOCACHE
NOCYCLE;

--Uitwerking opgave 4.

INSERT INTO Department
VALUES  (department_seq.NEXTVAL, 'Sales', 'London', 25)
,(department_seq.NEXTVAL, 'Management', 'London', 5)
,(department_seq.NEXTVAL, 'IT', 'Birmingham', 10);

--Uitwerking opgave 5.

ALTER TABLE Project
ADD (ProjectManager NUMBER NOT NULL);

ALTER TABLE Project
ADD ( CONSTRAINT project_employee_fk FOREIGN KEY (ProjectManager) REFERENCES Employee(SSN));

--Uitwerking opgave 6.

UPDATE Employee
SET Salary = Salary * 0.05;

--Uitwerking opgave 7.

CREATE USER johnmo
IDENTIFIED BY welkom123;

GRANT CREATE SESSION 
TO johnmo;

--Uitwerking opgave 8.

FOR x IN (SELECT * FROM user_tables)
LOOP
  EXECUTE IMMEDIATE 'GRANT DELETE ON ' || x.table_name || ' TO johnmo';
END LOOP;

--Uitwerking opgave 9.

GRANT SELECT
ON Project TO johnmo;

--Uitwerking opgave 10.

FOR x IN (SELECT * FROM user_tables)
LOOP
  EXECUTE IMMEDIATE 'REVOKE DELETE ON ' || x.table_name || ' TO johnmo';
END LOOP;

--Uitwerking opgave 11.

CREATE VIEW vw_overzicht_project
AS
SELECT Project.Name, Project.Location, Employee.FirstName, Employee.LastName, Project_Employee.Hours
FROM Employee e, Project_Employee pe, Project p 
WHERE e.SSN = pe.EmployeeSSN AND pe.ProjectNumber = p.[Number];

--Uitwerking opgave 12.

REVOKE SELECT
ON Project FROM johnmo;

REVOKE CREATE SESSION 
FROM johnmo;