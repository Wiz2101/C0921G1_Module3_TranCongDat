create database order_management;
use order_management;
CREATE TABLE dv_khach (
    ma_dv INT NOT NULL PRIMARY KEY,
    ten_dv VARCHAR(45),
    dia_chi VARCHAR(45),
    dien_thoai VARCHAR(10),
    ma_so_nd int,
    foreign key (ma_so_nd) references nguoi_dat (ma_so_nd)
);

CREATE TABLE nguoi_dat (
    ma_so_nd INT NOT NULL PRIMARY KEY,
    ho_ten_nd VARCHAR(45)
);

create table hang (
	ma_hang int not null primary key,
    ten_hang varchar(45),
    dv_tinh varchar(45),
    mo_ta_hang varchar(45)
);

create table dat (
	so_dh int not null primary key,
    ngay_dat date,
    so_luong int
);

create table nguoi_giao(
	ma_so_ng int not null primary key,
    ho_ten_ng varchar(45)
);

create table noi_giao (
	ma_so_ddg int not null primary key,
    ten_noi_giao varchar(45)
);

create table nguoi_nhan (
	ma_so_nn int not null primary key,
    ho_ten_nn varchar(45)
);

create table giao(
	so_pg int not null primary key,
    ngay_giao date,
    don_gia int,
    so_luong int
);