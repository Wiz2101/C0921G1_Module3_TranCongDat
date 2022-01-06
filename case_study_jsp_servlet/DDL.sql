DROP DATABASE IF EXISTS case_study;
CREATE DATABASE case_study;
USE case_study;

CREATE TABLE rent_type (
	rent_type_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    rent_type_name VARCHAR(45),
    rent_cost DOUBLE
);

CREATE TABLE service_type (
	service_type_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    service_type_name VARCHAR(45)
);

CREATE TABLE service (
	service_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    service_id_name VARCHAR(10),
    service_name VARCHAR(45),
    service_area INT,
    service_cost DOUBLE,
    service_max_people INT,
    rent_type_id INT,
    FOREIGN KEY (rent_type_id) REFERENCES rent_type (rent_type_id),
    service_type_id INT,
    FOREIGN KEY (service_type_id) REFERENCES service_type (service_type_id),
    standard_room VARCHAR(45),
    description_other_convenience VARCHAR(45),
    pool_area DOUBLE,
    number_of_floors INT,
    service_status INT DEFAULT (1)
);

CREATE TABLE customer_type (
	customer_type_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    customer_type_name VARCHAR(45)
);

CREATE TABLE customer (
	customer_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    customer_id_name VARCHAR(10),
    customer_type_id INT,
    FOREIGN KEY (customer_type_id) REFERENCES customer_type (customer_type_id),
    customer_name VARCHAR(45),
    customer_birthday DATE,
    customer_gender BIT(1),
    customer_id_card VARCHAR(45),
    customer_phone VARCHAR(45),
    customer_email VARCHAR(45),
    customer_address VARCHAR(45),
    customer_status INT
);

CREATE TABLE `position` (
	position_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    position_name VARCHAR(45)
);

CREATE TABLE education_degree (
	education_degree_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    education_degree_name VARCHAR(45)
);

CREATE TABLE division (
	division_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    division_name VARCHAR(45)
);

CREATE TABLE `role` (
	role_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(255)
);

CREATE TABLE `user` (
	username VARCHAR(255) NOT NULL PRIMARY KEY,
    `password` VARCHAR(255)
);

CREATE TABLE user_role (
	role_id INT,
	FOREIGN KEY (role_id) REFERENCES `role`(role_id),
    username VARCHAR(255),
    FOREIGN KEY (username) REFERENCES `user`(username),
    PRIMARY KEY (role_id, username)
);

CREATE TABLE employee (
	employee_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    employee_name VARCHAR (45),
    employee_birthday DATE,
    employee_id_card VARCHAR(45),
    employee_salary DOUBLE,
    employee_phone VARCHAR(45),
    employee_email VARCHAR(45),
    employee_address VARCHAR(45),
    position_id INT,
    FOREIGN KEY (position_id) REFERENCES `position` (position_id),
    education_degree_id INT,
    FOREIGN KEY (education_degree_id) REFERENCES education_degree (education_degree_id),
    division_id INT,
    FOREIGN KEY (division_id) REFERENCES division (division_id),
    username VARCHAR(255),
    FOREIGN KEY (username) REFERENCES `user`(username),
    employee_status INT DEFAULT(1)
);

CREATE TABLE contract (
	contract_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    contract_start_date DATETIME,
    contract_end_date DATETIME,
    contract_deposit DOUBLE,
    contract_total_money DOUBLE,
    employee_id INT,
    FOREIGN KEY (employee_id) REFERENCES employee (employee_id),
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
    service_id INT,
    FOREIGN KEY (service_id) REFERENCES service (service_id),
    contract_status INT DEFAULT(1)
    );

CREATE TABLE attach_service (
	attach_service_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    attach_service_name VARCHAR(45),
    attach_service_cost DOUBLE,
    attach_service_unit VARCHAR(45),
    attach_service_status VARCHAR(45)
);

CREATE TABLE contract_detail (
	contract_detail_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    contract_id INT,
    FOREIGN KEY (contract_id) REFERENCES contract (contract_id),
    attach_service_id INT,
    FOREIGN KEY (attach_service_id) REFERENCES attach_service (attach_service_id),
    quantity INT,
    contract_detail_status INT DEFAULT(1)
);

