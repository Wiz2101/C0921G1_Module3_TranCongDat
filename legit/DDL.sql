DROP DATABASE IF EXISTS legit;
CREATE DATABASE legit;
USE legit;

CREATE TABLE patient (
	patient_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    patient_code VARCHAR(10),
    patient_name VARCHAR(50),
    patient_delete_status INT DEFAULT (1)
);

CREATE TABLE medical_record (
	medical_record_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    medical_record_code VARCHAR(10),
    start_date DATE,
    end_date DATE,
    reason VARCHAR(255),
    patient_id INT,
    FOREIGN KEY (patient_id) REFERENCES patient(patient_id),
    medical_record_delete_status INT DEFAULT (1)
);



