CREATE DATABASE IF NOT EXISTS inkor_test;

USE inkor_test;

CREATE TABLE IF NOT EXISTS member (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    date_of_birth DATE,
    education TEXT,
    email VARCHAR(40),
    mobile_no VARCHAR(20)
);

SELECT * FROM member;