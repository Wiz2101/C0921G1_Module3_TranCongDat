drop database if EXISTS demo;
create DATABASE demo;
use demo;
CREATE TABLE product (
    Id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    productCode VARCHAR(10),
    productName VARCHAR(30),
    productPrice DOUBLE,
    productAmount INT,
    productDescription VARCHAR(100),
    productStatus VARCHAR(30)
);
-- Chèn một số dữ liệu mẫu cho bảng Product
insert into product
values 
(1,'A001','FL680',99.5,5,'Mechanical Keyboard','Stock'),
(2,'A002','NJ80',120.5,5,'Mechanical Keyboard','Stock'),
(3,'A003','CMY87',155.5,5,'Mechanical Keyboard','Out-of-Stock');

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
create unique index index_productCode on product (productCode);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create unique index index_composite on product (productName, productPrice);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain select * 
from product;

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view v_product as
select productCode, productName, productPrice, productStatus
from product;

-- Tiến hành sửa đổi view
update v_product
set productCode = 'NJ001'
where productName = 'NJ80';

-- Tiến hành xoá view
drop view v_product;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter // 
create procedure all_product()
begin
	select * from product;
end
//delimiter ;

call all_product();

-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure insert_product(
	pro_id int,
	pro_code VARCHAR(10),
    pro_name VARCHAR(30),
    pro_price DOUBLE,
    pro_amount INT,
    pro_description VARCHAR(100),
    pro_status VARCHAR(30))
begin
	insert into product
    values(pro_id,pro_code,pro_name,pro_price,pro_amount,pro_description,pro_status);
end
//delimiter ;

call insert_product(4,'AKKO001','AKKO3068',74,3,null,'Stock');

-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure edit_product(
	pro_id int,
	pro_code VARCHAR(10),
    pro_name VARCHAR(30),
    pro_price DOUBLE,
    pro_amount INT,
    pro_description VARCHAR(100),
    pro_status VARCHAR(30))
begin
	update product
    set productCode = pro_code,
    productCode = pro_code,
    productName = pro_name,
    productPrice = pro_price,
    productAmount = pro_amount,
    productDescription = pro_description,
    productStatus = pro_status
    where id = pro_id;
end
//delimiter ;

call edit_product(1,'FL001','FL680',99.5,5,'Mechanical Keyboard','In-Stock');

-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure del_product(pro_id int)
begin
	delete from product
    where id=pro_id;
end
// delimiter ;

call del_product(3);

