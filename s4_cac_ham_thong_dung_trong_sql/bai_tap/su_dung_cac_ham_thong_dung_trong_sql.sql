-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.

SELECT 
    *
FROM
    `subject` sj
WHERE
    sj.credit >= ALL (SELECT 
            MAX(sj.credit)
        FROM
            `subject` sj);
            
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.

SELECT 
    *
FROM
    mark m
        JOIN
    `subject` sj ON sj.sub_id = m.sub_id
WHERE
    mark >= ALL (SELECT 
            MAX(m.mark)
        FROM
            mark m);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần

SELECT 
    *
FROM
    student st
        LEFT JOIN
    mark m ON m.student_id = st.student_id
GROUP BY st.student_id
HAVING AVG(m.mark)
ORDER BY mark