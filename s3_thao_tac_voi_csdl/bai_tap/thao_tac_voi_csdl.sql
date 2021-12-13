use xay_dung_csdl_quan_ly_ban_hang;
-- Thêm dữ liệu vào trong 4 bảng như dưới đây:
insert into customer
values (customer_id, customer_name, customer_age),
(1,'Minh Quan',10),
(2,'Ngoc Oanh',20),
(3,'Hong Ha',50);
insert into `order`
values
(1,1,'2006/03/21',Null),
(2,2,'2006/03/23',Null),
(3,1,'2006/03/16',Null);
insert into product
values
(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);
insert into order_detail
values
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
SELECT 
    *
FROM
    `order`;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
SELECT 
    customer_name, product_name
FROM
    customer c
        JOIN
    `order` o ON c.customer_id = o.customer_id
        JOIN
    order_detail od ON o.order_id = od.order_id
        JOIN
    product p ON od.product_id = p.product_id
GROUP BY product_name;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
SELECT 
    *
FROM
    customer c
        LEFT JOIN
    `order` o ON c.customer_id = o.customer_id
        LEFT JOIN
    order_detail od ON o.order_id = od.order_id
        LEFT JOIN
    product p ON od.product_id = p.product_id
WHERE
    o.customer_id IS NULL;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. 
-- Giá bán của từng loại được tính = odQTY*pPrice)

SELECT 
    o.order_id,
    order_date,
    SUM(od.order_detail_qty),
    SUM(od.order_detail_qty * p.product_price) 'total_payment'
FROM
    `order` o
        JOIN
    order_detail od ON o.order_id = od.order_id
        JOIN
    product p ON od.product_id = p.product_id
GROUP BY order_id;



