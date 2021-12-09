create database order_management;
use order_management;
CREATE TABLE nguoi_dat (
    ma_so_nd INT NOT NULL PRIMARY KEY,
    ho_ten_nd VARCHAR(45)
);

CREATE TABLE hang (
    ma_hang INT NOT NULL PRIMARY KEY,
    ten_hang VARCHAR(45),
    dv_tinh VARCHAR(45),
    mo_ta_hang VARCHAR(45)
);

CREATE TABLE dat (
    so_dh INT NOT NULL PRIMARY KEY,
    ngay_dat DATE,
    so_luong INT,
    ma_so_nd INT,
    ma_hang INT,
    FOREIGN KEY (ma_so_nd)
        REFERENCES nguoi_dat (ma_so_nd),
    FOREIGN KEY (ma_hang)
        REFERENCES hang (ma_hang)
);

CREATE TABLE giao (
    so_pg INT NOT NULL PRIMARY KEY,
    ngay_giao DATE,
    don_gia INT,
    so_luong INT,
    ma_hang INT,
    FOREIGN KEY (ma_hang)
        REFERENCES hang (ma_hang)
);

CREATE TABLE nguoi_giao (
    ma_so_ng INT NOT NULL PRIMARY KEY,
    ho_ten_ng VARCHAR(45),
    so_pg INT,
    FOREIGN KEY (so_pg)
        REFERENCES giao (so_pg)
);

CREATE TABLE noi_giao (
    ma_so_ddg INT NOT NULL PRIMARY KEY,
    ten_noi_giao VARCHAR(45),
    so_pg INT,
    FOREIGN KEY (so_pg)
        REFERENCES giao (so_pg)
);

CREATE TABLE nguoi_nhan (
    ma_so_nn INT NOT NULL PRIMARY KEY,
    ho_ten_nn VARCHAR(45),
    so_pg INT,
    FOREIGN KEY (so_pg)
        REFERENCES giao (so_pg)
);

CREATE TABLE dv_khach (
    ma_dv INT NOT NULL PRIMARY KEY,
    ten_dv VARCHAR(45),
    dia_chi VARCHAR(45),
    dien_thoai VARCHAR(10),
    ma_so_nd INT,
    ma_so_nn INT,
    FOREIGN KEY (ma_so_nd)
        REFERENCES nguoi_dat (ma_so_nd),
    FOREIGN KEY (ma_so_nn)
        REFERENCES nguoi_nhan (ma_so_nn)
);