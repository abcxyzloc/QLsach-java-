-- ===================================
-- CSDL: Quản Lý Sách (QLsach)
-- ===================================

-- Tạo database
CREATE DATABASE IF NOT EXISTS qlsach CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE qlsach;

-- Xóa bảng cũ nếu tồn tại
DROP TABLE IF EXISTS sach;

-- Tạo bảng Sách
CREATE TABLE sach (
    ma_sach INT AUTO_INCREMENT PRIMARY KEY,
    ten_sach VARCHAR(255) NOT NULL,
    tac_gia VARCHAR(100) NOT NULL,
    nha_xuat_ban VARCHAR(100),
    nam_xuat_ban INT,
    gia_ban DECIMAL(10, 2) NOT NULL,
    so_luong INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Thêm dữ liệu mẫu
INSERT INTO sach (ten_sach, tac_gia, nha_xuat_ban, nam_xuat_ban, gia_ban, so_luong) VALUES
('Lập Trình Java Cơ Bản', 'Nguyễn Văn A', 'NXB Giáo Dục', 2023, 150000, 50),
('Cấu Trúc Dữ Liệu và Giải Thuật', 'Trần Thị B', 'NXB Đại Học Quốc Gia', 2022, 200000, 30),
('Thiết Kế Phần Mềm Hướng Đối Tượng', 'Lê Văn C', 'NXB Thông Tin và Truyền Thông', 2023, 180000, 40),
('Cơ Sở Dữ Liệu', 'Phạm Thị D', 'NXB Giáo Dục', 2021, 160000, 45),
('Mạng Máy Tính', 'Hoàng Văn E', 'NXB Khoa Học và Kỹ Thuật', 2022, 175000, 35),
('Trí Tuệ Nhân Tạo', 'Đỗ Văn F', 'NXB Đại Học Quốc Gia', 2023, 220000, 25),
('Học Máy - Machine Learning', 'Vũ Thị G', 'NXB Thông Tin và Truyền Thông', 2023, 250000, 20),
('Lập Trình Web với Java', 'Ngô Văn H', 'NXB Giáo Dục', 2022, 190000, 38),
('Hệ Điều Hành', 'Bùi Thị I', 'NXB Khoa Học và Kỹ Thuật', 2021, 165000, 42),
('An Toàn Thông Tin', 'Đinh Văn K', 'NXB Đại Học Quốc Gia', 2023, 195000, 28);

-- Tạo index để tối ưu tìm kiếm
CREATE INDEX idx_ten_sach ON sach(ten_sach);
CREATE INDEX idx_tac_gia ON sach(tac_gia);
CREATE INDEX idx_nam_xuat_ban ON sach(nam_xuat_ban);

-- Hiển thị dữ liệu mẫu
SELECT * FROM sach;

-- Query thống kê
SELECT 
    COUNT(*) AS tong_so_sach,
    SUM(so_luong) AS tong_so_luong,
    AVG(gia_ban) AS gia_trung_binh,
    MIN(gia_ban) AS gia_thap_nhat,
    MAX(gia_ban) AS gia_cao_nhat
FROM sach;