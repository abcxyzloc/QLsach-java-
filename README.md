# 📚 Quản Lý Sách (QLsach)

Hệ thống quản lý sách được xây dựng bằng Java, sử dụng kiến trúc DAO (Data Access Object) pattern.

## 🎯 Giới thiệu

Dự án Quản Lý Sách là một ứng dụng Java giúp quản lý thông tin sách trong thư viện hoặc cửa hàng sách. Hệ thống được thiết kế theo mô hình MVC với các lớp DAO để tương tác với cơ sở dữ liệu.

## 📋 Tính năng

- ✅ Quản lý thông tin sách
- ✅ Kết nối cơ sở dữ liệu
- ✅ Thao tác CRUD (Create, Read, Update, Delete)
- ✅ Kiến trúc DAO pattern
- ✅ Tách biệt logic nghiệp vụ và truy cập dữ liệu

## 🏗️ Cấu trúc dự án

```
QLsach(java)/
│
├── dao/                    # Data Access Object layer
│   ├── ISachDAO.java      # Interface định nghĩa các phương thức truy cập dữ liệu
│   └── SachDAO.java       # Implementation của ISachDAO
│
├── database/              # Database connection layer
│   └── DBConnect.java     # Quản lý kết nối database
│
├── model/                 # Model layer
│   └── Sach.java          # Entity class đại diện cho Sách
│
├── database.sql           # SQL script khởi tạo database
├── .gitignore            # Git ignore file
└── README.md             # Tài liệu dự án
```

## 🛠️ Công nghệ sử dụng

- **Ngôn ngữ**: Java
- **Cơ sở dữ liệu**: SQL Database
- **Pattern**: DAO (Data Access Object)
- **Architecture**: Layered Architecture (Model-DAO-Database)

## 📦 Yêu cầu hệ thống

- Java Development Kit (JDK) 8 trở lên
- SQL Database (MySQL/PostgreSQL/SQL Server)
- IDE: IntelliJ IDEA, Eclipse, NetBeans hoặc VS Code

## 🚀 Hướng dẫn cài đặt

### 1. Clone repository

```bash
git clone <repository-url>
cd QLsach(java)
```

### 2. Thiết lập cơ sở dữ liệu

- Tạo database mới trong SQL server của bạn
- Chạy file `database.sql` để khởi tạo schema và dữ liệu mẫu

```sql
-- Chạy script SQL
source database.sql
```

### 3. Cấu hình kết nối database

Mở file `database/DBConnect.java` và cập nhật thông tin kết nối:

```java
// Cập nhật các thông tin sau
private static final String URL = "jdbc:mysql://localhost:3306/qlsach";
private static final String USER = "your_username";
private static final String PASSWORD = "your_password";
```

### 4. Biên dịch và chạy

```bash
# Biên dịch
javac -d bin src/**/*.java

# Chạy ứng dụng
java -cp bin MainClass
```

## 📖 Hướng dẫn sử dụng

### Model Layer

Lớp `Sach.java` đại diện cho entity Sách với các thuộc tính:
- Mã sách
- Tên sách
- Tác giả
- Nhà xuất bản
- Năm xuất bản
- Giá
- Số lượng

### DAO Layer

**ISachDAO.java**: Interface định nghĩa các phương thức chuẩn
- `getAll()`: Lấy danh sách tất cả sách
- `getById(id)`: Lấy thông tin sách theo ID
- `insert(sach)`: Thêm sách mới
- `update(sach)`: Cập nhật thông tin sách
- `delete(id)`: Xóa sách

**SachDAO.java**: Implementation thực thi các phương thức

### Database Layer

**DBConnect.java**: Quản lý kết nối đến cơ sở dữ liệu
- Singleton pattern để đảm bảo chỉ có một kết nối
- Connection pooling để tối ưu hiệu suất

## 🤝 Đóng góp

Mọi đóng góp đều được chào đón! Vui lòng:

1. Fork repository
2. Tạo branch mới (`git checkout -b feature/AmazingFeature`)
3. Commit thay đổi (`git commit -m 'Add some AmazingFeature'`)
4. Push lên branch (`git push origin feature/AmazingFeature`)
5. Tạo Pull Request

## 📝 License

Dự án này được phát hành dưới giấy phép MIT. Xem file [LICENSE](LICENSE) để biết thêm chi tiết.

## 👥 Tác giả

- **Tên của bạn** - *Initial work*

## 📞 Liên hệ

Nếu bạn có bất kỳ câu hỏi nào, vui lòng liên hệ:
- Email: your.email@example.com
- GitHub: [@your-username](https://github.com/your-username)

## 🙏 Acknowledgments

- Cảm ơn đến tất cả những người đã đóng góp cho dự án này
- Các thư viện và công cụ mã nguồn mở đã sử dụng

---

⭐ **Nếu dự án này hữu ích, hãy cho một star nhé!** ⭐
