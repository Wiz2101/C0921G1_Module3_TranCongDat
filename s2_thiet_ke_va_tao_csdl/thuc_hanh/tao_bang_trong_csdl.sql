create database quan_ly_diem_thi;
use quan_ly_diem_thi;
create table hoc_sinh(
	maHS varchar(20) primary key,
    tenHS varchar(50),
    ngaySinh datetime,
    lop varchar(20),
    gt varchar(20)
);

create table mon_hoc(
	maMH varchar(20) primary key,
    tenMH varchar(50)
);

create table bang_diem(
	maHS varchar(20),
    maMH varchar(20),
    diemThi int,
    ngayKT datetime,
    primary key (maHS,maMH),
    foreign key (maHS) references hoc_sinh(maHS),
    foreign key (maMH) references mon_hoc(maMH)
);

create table giao_vien(
	maGV varchar(20) primary key,
    tenGV varchar(20),
    sdt varchar(10)
);

alter table mon_hoc add maGV varchar(20);
alter table mon_hoc add constraint fk_maGV foreign key (maGV) references giao_vien(maGV);
