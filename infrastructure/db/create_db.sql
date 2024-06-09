CREATE database postgres;

CREATE TABLE patient
(
    ID varchar PRIMARY KEY,
    NAME varchar(100) NOT NULL,
    GENDER varchar(5) NOT NULL,
    BIRTHDATE timestamp NOT NULL
);

INSERT INTO patient
VALUES ('d8ff176f-bd0a-4b8e-b329-871952e32e1f', 'Иванов Иван Иванович', 'male', '1994-03-28 18:25:43')
