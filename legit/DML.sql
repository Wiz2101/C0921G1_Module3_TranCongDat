INSERT INTO patient (patient_code,patient_name)
VALUES ("PT-0001","Nguyễn Văn An"),
("PT-0002","Nguyễn Tấn Bình"),
("PT-0003","Trần Quyết Chiến"),
("PT-0004","Phạm Văn Dần"),
("PT-0005","Nguyễn Thị E Đê");

INSERT INTO medical_record (medical_record_code,start_date,end_date,reason,patient_id) 
VALUES ("MC-0001","2021-12-12","2021-12-14","đau đầu",1),
("MC-0002","2021-12-12","2021-12-11","loét dạ dày",2),
("MC-0003","2021-12-12","2021-12-17","viêm phổi",3),
("MC-0004","2021-11-20","2021-12-13","chấn thương tay",4),
("MC-0005","2021-10-12","2021-11-01","covid-19",5);