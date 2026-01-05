# 🚀 Hướng Dẫn Chạy Dự Án QLsach

## 📋 Yêu cầu hệ thống

- **Java Development Kit (JDK)**: 8 trở lên
- **MySQL Database**: 5.7 trở lên
- **MySQL Connector/J**: JDBC Driver cho MySQL

## 📦 Bước 1: Cài đặt MySQL Connector

### Cách 1: Download thủ công
1. Tải MySQL Connector/J từ: https://dev.mysql.com/downloads/connector/j/
2. Giải nén và lấy file `mysql-connector-java-x.x.xx.jar`
3. Copy vào thư mục dự án hoặc thêm vào CLASSPATH

### Cách 2: Sử dụng Maven (khuyến nghị)
Tạo file `pom.xml` trong thư mục dự án:

```xml
<project>
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.qlsach</groupId>
    <artifactId>qlsach</artifactId>
    <version>1.0</version>
    
    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.33</version>
        </dependency>
    </dependencies>
</project>
```

## 💾 Bước 2: Thiết lập Database

1. Mở MySQL Workbench hoặc MySQL Command Line
2. Chạy file `database.sql`:

```bash
mysql -u root -p < database.sql
```

Hoặc trong MySQL Workbench:
- File → Open SQL Script → Chọn `database.sql`
- Click Execute (⚡)

3. Kiểm tra database đã được tạo:

```sql
USE qlsach;
SHOW TABLES;
SELECT * FROM sach;
```

## ⚙️ Bước 3: Cấu hình kết nối Database

Mở file [`database/DBConnect.java`](file:///d:/QLsach%28java%29/database/DBConnect.java) và cập nhật:

```java
private static final String DB_URL = "jdbc:mysql://localhost:3306/qlsach";
private static final String DB_USER = "root";           // Thay bằng username của bạn
private static final String DB_PASSWORD = "";           // Thay bằng password của bạn
```

## 🔨 Bước 4: Biên dịch dự án

### Sử dụng Command Line

```bash
# Di chuyển đến thư mục dự án
cd d:\QLsach(java)

# Tạo thư mục bin để chứa file .class
mkdir bin

# Biên dịch (với MySQL Connector)
javac -d bin -cp "mysql-connector-java-8.0.33.jar" MainApp.java model\Sach.java database\DBConnect.java dao\ISachDAO.java dao\SachDAO.java
```

### Sử dụng IDE

**IntelliJ IDEA:**
1. Open Project → Chọn thư mục `QLsach(java)`
2. File → Project Structure → Libraries → Add `mysql-connector-java.jar`
3. Click Run (▶️)

**Eclipse:**
1. File → Open Projects from File System → Chọn thư mục
2. Right-click project → Build Path → Add External JARs → Chọn `mysql-connector-java.jar`
3. Right-click `MainApp.java` → Run As → Java Application

**NetBeans:**
1. File → Open Project → Chọn thư mục
2. Libraries → Add JAR/Folder → Chọn `mysql-connector-java.jar`
3. Click Run (F6)

## ▶️ Bước 5: Chạy ứng dụng

### Command Line

```bash
# Chạy MainApp
java -cp "bin;mysql-connector-java-8.0.33.jar" MainApp
```

**Lưu ý trên Linux/Mac:** Dùng `:` thay vì `;`
```bash
java -cp "bin:mysql-connector-java-8.0.33.jar" MainApp
```

### Sử dụng IDE
Click nút Run (▶️) trong IDE

## 🎮 Hướng dẫn sử dụng

Khi chạy ứng dụng, bạn sẽ thấy menu:

```
╔════════════════════════════════════════╗
║   HỆ THỐNG QUẢN LÝ SÁCH - QLsach      ║
╚════════════════════════════════════════╝

==================================================
                    MENU CHÍNH
==================================================
1. Xem tất cả sách
2. Tìm sách theo mã
3. Thêm sách mới
4. Cập nhật thông tin sách
5. Xóa sách
6. Tìm kiếm sách theo tên
7. Tìm kiếm sách theo tác giả
0. Thoát
==================================================
```

### Các chức năng:

1. **Xem tất cả sách**: Hiển thị danh sách toàn bộ sách trong database
2. **Tìm sách theo mã**: Nhập mã sách để xem chi tiết
3. **Thêm sách mới**: Nhập thông tin để thêm sách mới
4. **Cập nhật**: Chọn sách và cập nhật thông tin
5. **Xóa sách**: Xóa sách khỏi database (có xác nhận)
6. **Tìm theo tên**: Tìm kiếm sách theo tên (hỗ trợ tìm kiếm mờ)
7. **Tìm theo tác giả**: Tìm kiếm sách theo tên tác giả

## 🐛 Xử lý lỗi thường gặp

### 1. ClassNotFoundException: com.mysql.cj.jdbc.Driver
**Nguyên nhân**: Chưa thêm MySQL Connector vào classpath
**Giải pháp**: Thêm file `.jar` vào classpath khi compile và run

### 2. SQLException: Access denied for user
**Nguyên nhân**: Sai username/password MySQL
**Giải pháp**: Kiểm tra lại thông tin trong `DBConnect.java`

### 3. SQLException: Unknown database 'qlsach'
**Nguyên nhân**: Chưa tạo database
**Giải pháp**: Chạy file `database.sql`

### 4. Connection timeout
**Nguyên nhân**: MySQL Server chưa chạy
**Giải pháp**: Khởi động MySQL Service

## 📝 Cấu trúc thư mục sau khi build

```
QLsach(java)/
├── bin/                    # File .class sau khi compile
│   ├── MainApp.class
│   ├── model/
│   ├── dao/
│   └── database/
├── dao/                    # Source code DAO
├── database/               # Source code Database
├── model/                  # Source code Model
├── MainApp.java           # Entry point
├── database.sql           # SQL script
└── mysql-connector-java.jar
```

## 🔗 Tài liệu tham khảo

- [MySQL Connector/J Documentation](https://dev.mysql.com/doc/connector-j/en/)
- [Java JDBC Tutorial](https://docs.oracle.com/javase/tutorial/jdbc/)
- [MySQL Documentation](https://dev.mysql.com/doc/)

## 💡 Tips

- Backup database thường xuyên
- Sử dụng IDE để debug dễ dàng hơn
- Kiểm tra log console khi gặp lỗi
- Đọc message lỗi để xác định nguyên nhân

---

✅ **Chúc bạn chạy dự án thành công!**
