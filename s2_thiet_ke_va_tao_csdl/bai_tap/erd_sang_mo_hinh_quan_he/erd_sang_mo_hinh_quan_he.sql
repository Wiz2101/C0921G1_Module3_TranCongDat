create database erd_sang_mo_hinh_quan_he;
use erd_sang_mo_hinh_quan_he;
CREATE TABLE phieu_xuat (
    so_phieu_xuat INT NOT NULL PRIMARY KEY,
    ngay_xuat DATE
);

CREATE TABLE vat_tu (
    ma_vtu INT NOT NULL PRIMARY KEY,
    ten_vtu VARCHAR(45)
);

CREATE TABLE phieu_nhap (
    ma_pn INT NOT NULL PRIMARY KEY,
    ngay_nhap DATE
);

CREATE TABLE don_dh (
    so_dh INT NOT NULL PRIMARY KEY,
    ngay_dh DATE
);

CREATE TABLE nha_cc (
    ma_nha_cc INT NOT NULL PRIMARY KEY,
    ten_nha_cc VARCHAR(45),
    dia_chi VARCHAR(45),
    sdt VARCHAR(10)
);
CREATE TABLE chi_tiet_phieu_xuat (
    ma_chi_tiet_phieu_xuat INT NOT NULL PRIMARY KEY,
    dg_xuat VARCHAR(45),
    sl_xuat INT,
    so_px INT,
    ma_vtu INT,
    FOREIGN KEY (so_px)
        REFERENCES phieu_xuat (so_phieu_xuat),
    FOREIGN KEY (ma_vtu)
        REFERENCES vat_tu (ma_vtu)
);

CREATE TABLE chi_tiet_phieu_nhap (
    ma_chi_tiet_phieu_nhap INT NOT NULL PRIMARY KEY,
    dg_nhap VARCHAR(45),
    sl_nhap INT,
    ma_vtu INT,
    ma_pn INT,
    FOREIGN KEY (ma_vtu)
        REFERENCES vat_tu (ma_vtu),
    FOREIGN KEY (ma_pn)
        REFERENCES phieu_nhap (ma_pn)
);

CREATE TABLE chi_tiet_don_dat_hang (
    ma_chi_tiet_don_dat_hang INT NOT NULL PRIMARY KEY,
    ma_vtu INT,
    so_dh INT,
    FOREIGN KEY (ma_vtu)
        REFERENCES vat_tu (ma_vtu),
    FOREIGN KEY (so_dh)
        REFERENCES don_dh (so_dh)
);

CREATE TABLE cung_cap (
    ma_cung_cap INT NOT NULL PRIMARY KEY,
    so_dh INT,
    ma_nha_cc INT,
    FOREIGN KEY (so_dh)
        REFERENCES don_dh (so_dh),
    FOREIGN KEY (ma_nha_cc)
        REFERENCES nha_cc (ma_nha_cc)
);