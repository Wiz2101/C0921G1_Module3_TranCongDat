use furama;

-- Câu 2:
-- Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.

SELECT 
    nhan_vien.ma_nhan_vien, nhan_vien.ho_ten
FROM
    nhan_vien
WHERE
    ho_ten RLIKE '^[HTK]'
        AND LENGTH(ho_ten) <= 15;
        
-- Câu 3:
-- Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

SELECT 
    khach_hang.ma_khach_hang, khach_hang.ho_ten
FROM
    khach_hang
WHERE
    YEAR(ngay_sinh) BETWEEN 1971 AND 2003
        AND dia_chi RLIKE 'Đà Nẵng|Quảng Trị';

-- Câu 4:
-- Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

SELECT 
    khach_hang.ma_khach_hang, khach_hang.ho_ten, COUNT(hop_dong.ma_khach_hang) as so_lan_dat_phong
FROM
    khach_hang
        JOIN
    hop_dong ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
        JOIN
    loai_khach ON loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
WHERE
    ten_loai_khach = 'Diamond'
GROUP BY khach_hang.ma_khach_hang
ORDER BY COUNT(hop_dong.ma_khach_hang) ASC;

-- Câu 5:
-- Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien
-- (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) 
-- cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

SELECT 
    khach_hang.ma_khach_hang,
    khach_hang.ho_ten,
    loai_khach.ten_loai_khach,
    dich_vu.ten_dich_vu,
    hop_dong.ma_hop_dong,
    hop_dong.ngay_lam_hop_dong,
    hop_dong.ngay_ket_thuc,
    SUM(IFNULL(dich_vu.chi_phi_thue, 0) + IFNULL((hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia),
            0)) AS 'tong_tien'
FROM
    khach_hang
        LEFT JOIN
    loai_khach ON loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
        LEFT JOIN
    hop_dong ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
        LEFT JOIN
    dich_vu ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
        LEFT JOIN
    dich_vu_di_kem ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
GROUP BY ma_hop_dong
ORDER BY ma_khach_hang ASC, ma_hop_dong DESC;

-- Câu 6:
-- Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng 
-- thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).

SELECT 
    dich_vu.ma_dich_vu,
    dich_vu.ten_dich_vu,
    dich_vu.dien_tich,
    dich_vu.chi_phi_thue,
    loai_dich_vu.ten_loai_dich_vu
FROM
    dich_vu
        JOIN
    loai_dich_vu ON dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
        JOIN
    hop_dong ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
WHERE
    dich_vu.ma_dich_vu NOT IN (SELECT 
            hop_dong.ma_dich_vu
        FROM
            hop_dong
        WHERE
            MONTH(hop_dong.ngay_lam_hop_dong) BETWEEN 1 AND 3)
GROUP BY ten_dich_vu;

-- Câu 7:
-- Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ đã từng được khách hàng 
-- đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.

SELECT 
    dich_vu.ma_dich_vu,
    dich_vu.ten_dich_vu,
    dich_vu.dien_tich,
    dich_vu.so_nguoi_toi_da,
    dich_vu.chi_phi_thue,
    loai_dich_vu.ten_loai_dich_vu
FROM
    dich_vu
        JOIN
    loai_dich_vu ON dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
        JOIN
    hop_dong ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
WHERE
    hop_dong.ma_dich_vu NOT IN (SELECT 
            hop_dong.ma_dich_vu
        FROM
            hop_dong
        WHERE
            YEAR(hop_dong.ngay_lam_hop_dong) = 2021)
GROUP BY ma_dich_vu;

-- Câu 8:
-- Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.

SELECT 
    khach_hang.ho_ten
FROM
    khach_hang
HAVING COUNT(khach_hang.ho_ten) > 1;

-- Câu 9:
-- Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

SELECT 
    MONTH(hop_dong.ngay_lam_hop_dong) as 'thang',
    COUNT(MONTH(hop_dong.ngay_lam_hop_dong)) as 'so_luong_khach_hang'
FROM
    hop_dong
WHERE
    YEAR(hop_dong.ngay_lam_hop_dong) = 2021
GROUP BY MONTH(hop_dong.ngay_lam_hop_dong)
ORDER BY MONTH(hop_dong.ngay_lam_hop_dong) ASC;

-- Câu 10:
-- Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).

SELECT 
    hop_dong.ma_hop_dong,
    hop_dong.ngay_lam_hop_dong,
    hop_dong.ngay_ket_thuc,
    IFNULL(hop_dong.tien_dat_coc, 0),
    SUM(IFNULL(hop_dong_chi_tiet.so_luong, 0))
FROM
    hop_dong
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
GROUP BY ma_hop_dong
ORDER BY ma_hop_dong ASC;

-- Câu 11:
-- Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.

SELECT 
    dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem
FROM
    hop_dong hop_dong
        JOIN
    hop_dong_chi_tiet hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
        JOIN
    dich_vu_di_kem dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
        RIGHT JOIN
    khach_hang kh ON hop_dong.ma_khach_hang = kh.ma_khach_hang
        JOIN
    loai_khach lk ON kh.ma_loai_khach = lk.ma_loai_khach
WHERE
    ten_loai_khach = 'Diamond'
        AND dia_chi REGEXP 'Vinh|Quảng Ngãi';
 
-- Câu 12:
-- Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem 
-- (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.

SELECT 
    hop_dong.ma_hop_dong,
    nhan_vien.ho_ten 'ho_ten_nv',
    khach_hang.ho_ten 'ho_ten_kh',
    khach_hang.so_dien_thoai 'so_dien_thoai_kh',
    dich_vu.ten_dich_vu,
    hop_dong.tien_dat_coc,
    hop_dong.ngay_lam_hop_dong,
    SUM(ifnull(hop_dong_chi_tiet.so_luong,0)) 'so_luong_dich_vu_di_kem'
FROM
    hop_dong
        LEFT JOIN
    nhan_vien ON hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
        LEFT JOIN
    khach_hang ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
        LEFT JOIN
    dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
        LEFT JOIN
    dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
WHERE
    (MONTH(hop_dong.ngay_lam_hop_dong) BETWEEN 10 AND 12)
        AND (YEAR(hop_dong.ngay_lam_hop_dong) = 2020)
        AND dich_vu.ma_dich_vu NOT IN (SELECT 
            dich_vu.ma_dich_vu
        FROM
            dich_vu
        WHERE
            (MONTH(hop_dong.ngay_lam_hop_dong) BETWEEN 1 AND 6)
                AND (YEAR(hop_dong.ngay_lam_hop_dong) = 2021))
	GROUP BY hop_dong.ma_hop_dong;

    
-- Câu 13:
-- Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
SELECT 
    dich_vu_di_kem.ma_dich_vu_di_kem,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    SUM(so_luong)
FROM
    dich_vu_di_kem
        JOIN
    hop_dong_chi_tiet ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
GROUP BY dich_vu_di_kem.ma_dich_vu_di_kem
HAVING SUM(so_luong) >= ALL (SELECT 
        (so_luong)
    FROM
        hop_dong_chi_tiet);

-- Câu 14:
-- Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung 
-- (được tính dựa trên việc count các ma_dich_vu_di_kem).

SELECT 
    hop_dong.ma_hop_dong,
    loai_dich_vu.ten_loai_dich_vu,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    COUNT(dich_vu_di_kem.ma_dich_vu_di_kem) 'so_lan_su_dung'
FROM
    hop_dong
        JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
        JOIN
    dich_vu ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
        JOIN
    loai_dich_vu ON loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
        JOIN
    dich_vu_di_kem ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
GROUP BY ten_dich_vu_di_kem
HAVING COUNT(hop_dong_chi_tiet.so_luong) = 1
ORDER BY ma_hop_dong ASC;

-- Câu 15:
-- Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi 
-- mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.

SELECT 
    nhan_vien.ma_nhan_vien,
    nhan_vien.ho_ten,
    trinh_do.ten_trinh_do,
    bo_phan.ten_bo_phan,
    nhan_vien.so_dien_thoai,
    nhan_vien.dia_chi
FROM
    nhan_vien
        JOIN
    bo_phan ON bo_phan.ma_bo_phan = nhan_vien.ma_bo_phan
        JOIN
    trinh_do ON trinh_do.ma_trinh_do = nhan_vien.ma_trinh_do
        JOIN
    hop_dong ON hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
GROUP BY nhan_vien.ma_nhan_vien
HAVING COUNT(hop_dong.ma_nhan_vien) <= 3;

-- Câu 16:
-- Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.

SELECT 
    nhan_vien.ma_nhan_vien, nhan_vien.ho_ten
FROM
    nhan_vien
WHERE
    nhan_vien.ma_nhan_vien IN (SELECT 
            nhan_vien.ma_nhan_vien
        FROM
            nhan_vien
                LEFT JOIN
            hop_dong ON hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
        GROUP BY nhan_vien.ma_nhan_vien
        HAVING COUNT(hop_dong.ma_nhan_vien) = 0);
    
DELETE FROM nhan_vien 
WHERE
    nhan_vien.ma_nhan_vien IN (
    SELECT 
        *
    FROM
        (SELECT 
            nhan_vien.ma_nhan_vien
        FROM
            nhan_vien
        LEFT JOIN hop_dong ON hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
        GROUP BY nhan_vien.ma_nhan_vien
        HAVING COUNT(hop_dong.ma_nhan_vien) = 0) tdlTmp);

-- Câu 17:
-- Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng 
-- với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 1.000.000 VNĐ.

SELECT 
    khach_hang.ma_khach_hang,
    khach_hang.ho_ten,
    khach_hang.ma_loai_khach,
    SUM((dich_vu.chi_phi_thue) + (dich_vu_di_kem.gia * hop_dong_chi_tiet.so_luong)) 'tong_tien'
FROM
    khach_hang
        JOIN
    hop_dong ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
        JOIN
    dich_vu ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
        JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
        JOIN
    dich_vu_di_kem ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
GROUP BY khach_hang.ho_ten
HAVING tong_tien >= 1000000
    AND ma_loai_khach != 1;

UPDATE khach_hang 
SET 
    khach_hang.ma_loai_khach = 1
WHERE
    khach_hang.ma_loai_khach = 2
        AND khach_hang.ma_khach_hang IN (SELECT 
            khach_hang.ma_khach_hang
        FROM
            (SELECT 
                khach_hang.ma_khach_hang,
                    ((dich_vu.chi_phi_thue) + (dich_vu_di_kem.gia * hop_dong_chi_tiet.so_luong)) 'tong_tien'
            FROM
                khach_hang
            JOIN hop_dong ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
            JOIN dich_vu ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
            JOIN hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
            JOIN dich_vu_di_kem ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
            GROUP BY khach_hang.ho_ten
            HAVING tong_tien >= 1000000) tdlTmp);

-- Câu 18:
-- Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
SELECT 
    khach_hang.ma_khach_hang,
    khach_hang.ho_ten,
    hop_dong.ngay_lam_hop_dong
FROM
    hop_dong
        JOIN
    khach_hang ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
WHERE
    YEAR(hop_dong.ngay_lam_hop_dong) < 2021;

SET FOREIGN_KEY_CHECKS=0;
DELETE FROM hop_dong 
WHERE
    YEAR(hop_dong.ngay_lam_hop_dong) < 2021;
    
-- Câu 19:
-- Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
SELECT 
    hop_dong.ngay_lam_hop_dong,
    dich_vu_di_kem.ma_dich_vu_di_kem,
    SUM(hop_dong_chi_tiet.so_luong)
FROM
    hop_dong hop_dong
        JOIN
    hop_dong_chi_tiet hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
        JOIN
    dich_vu_di_kem dich_vu_di_kem ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
WHERE
    YEAR(hop_dong.ngay_lam_hop_dong) = 2020
GROUP BY dich_vu_di_kem.ma_dich_vu_di_kem;

UPDATE dich_vu_di_kem 
SET dich_vu_di_kem.gia = (dich_vu_di_kem.gia * 2)
WHERE
    dich_vu_di_kem.ma_dich_vu_di_kem IN (
    SELECT ma_dich_vu_di_kem
	FROM (
    SELECT dich_vu_di_kem.ma_dich_vu_di_kem, hop_dong_chi_tiet.so_luong
            FROM
                hop_dong hop_dong
            JOIN hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
            JOIN dich_vu_di_kem ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
            WHERE
                YEAR(hop_dong.ngay_lam_hop_dong) = 2020
            GROUP BY dich_vu_di_kem.ma_dich_vu_di_kem
			HAVING SUM(hop_dong_chi_tiet.so_luong) >= 10) tdlTmp);

-- Câu 20:
-- Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị 
-- bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.

SELECT 
    ma_nhan_vien,
    ho_ten,
    email,
    so_dien_thoai,
    ngay_sinh,
    dia_chi
FROM
    nhan_vien 
UNION ALL SELECT 
    ma_khach_hang,
    ho_ten,
    email,
    so_dien_thoai,
    ngay_sinh,
    dia_chi
FROM
    khach_hang
