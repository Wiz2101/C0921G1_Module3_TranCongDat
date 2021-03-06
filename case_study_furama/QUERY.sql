SELECT * FROM customer JOIN customer_type ON customer_type.customer_type_id = customer.customer_type_id WHERE customer_status = 1;
SELECT * FROM customer JOIN customer_type ON customer_type.customer_type_id = customer.customer_type_id;
SELECT * FROM case_study.customer;
INSERT INTO customer (customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_status) VALUES (2,"ABC","2000-12-12",0,"123123123","0912121212","xyz@gmail.com","123 XXX",0);
UPDATE customer SET customer_type_id= 2, customer_name = "A", customer_birthday = "2022-01-01", customer_gender=1, customer_id_card="0101010101",customer_phone="090123123",customer_email="test@gmail.com",customer_address="123 QWERTY" WHERE customer_id = 14;
SELECT * FROM customer JOIN customer_type ON customer_type.customer_type_id = customer.customer_type_id WHERE customer_id=14;
UPDATE customer SET customer_status = 1 WHERE customer_id = 11;
UPDATE customer SET customer_status = 1 WHERE customer_status = 0;
SELECT * FROM customer WHERE customer_name LIKE '%Ngh%';
SELECT * FROM service;
SELECT * FROM service LEFT JOIN rent_type ON rent_type.rent_type_id = service.rent_type_id LEFT JOIN service_type ON service_type.service_type_id = service.service_type_id;
SELECT * FROM rent_type;
SELECT * FROM service_type;
INSERT INTO service (service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors) VALUES ("Villa",24000,200000,2,1,2,"normal","có hồ bơi",400,2);
SELECT * FROM service LEFT JOIN rent_type ON rent_type.rent_type_id = service.rent_type_id LEFT JOIN service_type ON service_type.service_type_id = service.service_type_id WHERE service_id=4;
UPDATE service SET service_name = "A",service_area = 122,service_cost = 10.2,service_max_people = 2,rent_type_id=2,service_type_id=1,standard_room="vip",description_other_convenience="free ăn sáng",pool_area=20.3,number_of_floors=2 WHERE service_id = 6;
UPDATE service SET service_status = 0 WHERE service_id = 1;
SELECT * FROM employee JOIN `position` ON `position`.position_id = employee.position_id JOIN education_degree ON education_degree.education_degree_id = employee.education_degree_id JOIN division ON division.division_id = employee.division_id JOIN `user` ON `user`.username = employee.username WHERE employee_status = 1;
SELECT * FROM `position`;
SELECT * FROM education_degree;
SELECT * FROM division;
SELECT * FROM `user`;
INSERT INTO employee (employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username) VALUES ("A","2000-12-12","123123123",200,"090123123","abc@gmail.com","123ABC",1,1,1,"admin");
SELECT * FROM employee JOIN `position` ON `position`.position_id = employee.position_id JOIN education_degree ON education_degree.education_degree_id = employee.education_degree_id JOIN division ON division.division_id = employee.division_id JOIN `user` ON `user`.username = employee.username WHERE employee_id = 1;
UPDATE employee SET employee_name="A",employee_birthday="2021-12-11",employee_id_card="123121213",employee_salary=200,employee_phone="0920101212",employee_email="test@gmail.com",employee_address="222 ABC",position_id=2,education_degree_id=1,division_id=1,username="fo" WHERE employee_id = 1;
UPDATE employee SET employee_status=0 WHERE employee_id=1;
SELECT * FROM contract JOIN employee ON contract.employee_id = employee.employee_id JOIN customer ON contract.customer_id = customer.customer_id JOIN service ON contract.service_id = service.service_id WHERE contract_status = 1;
INSERT INTO contract (contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id) VALUES ("2020-12-12","2020-12-13",20000,400000,1,2,1);
SELECT * FROM employee;
SELECT * FROM customer;
SELECT * FROM service;
SELECT * FROM contract_detail JOIN contract ON contract_detail.contract_id = contract.contract_id JOIN attach_service ON contract_detail.attach_service_id = attach_service.attach_service_id WHERE contract_detail_status = 1;
SELECT * FROM contract;
SELECT * FROM attach_service;
INSERT INTO contract_detail (contract_id,attach_service_id,quantity) VALUES (1,1,3);
INSERT INTO service (service_id_name,service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors) VALUES ('DV-00011','Dat',100,2.0E+7,4,2,1,'vip','having pool',30.2,2)