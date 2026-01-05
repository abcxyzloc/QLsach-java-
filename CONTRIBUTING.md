# 🤝 Hướng dẫn đóng góp (Contributing Guide)

Cảm ơn bạn đã quan tâm đến việc đóng góp cho dự án Quản Lý Sách! Chúng tôi rất trân trọng mọi đóng góp từ cộng đồng.

## 📋 Mục lục

- [Quy tắc chung](#quy-tắc-chung)
- [Quy trình đóng góp](#quy-trình-đóng-góp)
- [Chuẩn code](#chuẩn-code)
- [Commit Messages](#commit-messages)
- [Pull Request Process](#pull-request-process)
- [Báo cáo lỗi](#báo-cáo-lỗi)
- [Đề xuất tính năng](#đề-xuất-tính-năng)

## Quy tắc chung

- Tôn trọng mọi người trong cộng đồng
- Viết code rõ ràng, dễ đọc, có comment khi cần thiết
- Tuân thủ các chuẩn code đã được định nghĩa
- Test kỹ lưỡng trước khi submit PR
- Viết documentation cho các tính năng mới

## Quy trình đóng góp

### 1. Fork Repository

Click nút **Fork** ở góc trên bên phải của trang repository.

### 2. Clone về máy local

```bash
git clone https://github.com/YOUR_USERNAME/QLsach.git
cd QLsach
```

### 3. Tạo branch mới

```bash
# Tạo branch cho feature mới
git checkout -b feature/ten-tinh-nang

# Hoặc tạo branch cho bugfix
git checkout -b bugfix/ten-loi-can-sua
```

### 4. Thực hiện thay đổi

- Viết code
- Test kỹ lưỡng
- Commit thường xuyên với message rõ ràng

### 5. Push lên GitHub

```bash
git push origin feature/ten-tinh-nang
```

### 6. Tạo Pull Request

Truy cập repository trên GitHub và click **New Pull Request**.

## Chuẩn code

### Java Code Style

```java
// ✅ ĐÚNG: Sử dụng camelCase cho biến và method
public class SachDAO {
    private String tenSach;
    
    public void themSachMoi() {
        // implementation
    }
}

// ✅ ĐÚNG: Sử dụng PascalCase cho class
public class QuanLySach {
    // implementation
}

// ✅ ĐÚNG: Constants sử dụng UPPER_CASE
public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/qlsach";

// ✅ ĐÚNG: Indentation 4 spaces
public void example() {
    if (condition) {
        // code here
    }
}
```

### Quy tắc đặt tên

- **Class**: PascalCase (VD: `SachDAO`, `DBConnect`)
- **Method**: camelCase (VD: `getSach`, `themSachMoi`)
- **Variable**: camelCase (VD: `tenSach`, `giaBan`)
- **Constant**: UPPER_CASE (VD: `MAX_LENGTH`, `DATABASE_URL`)
- **Package**: lowercase (VD: `dao`, `model`, `database`)

### Code Organization

```
src/
├── dao/          # Data Access Objects
├── model/        # Entity classes
├── database/     # Database connections
├── service/      # Business logic
├── util/         # Utility classes
└── Main.java     # Entry point
```

## Commit Messages

### Format chuẩn

```
<type>(<scope>): <subject>

<body>

<footer>
```

### Types

- **feat**: Thêm tính năng mới
- **fix**: Sửa lỗi
- **docs**: Cập nhật documentation
- **style**: Thay đổi không ảnh hưởng đến logic (format, spacing)
- **refactor**: Refactor code
- **test**: Thêm hoặc cập nhật tests
- **chore**: Các thay đổi khác (build, dependencies)

### Ví dụ

```bash
# Feature mới
git commit -m "feat(dao): thêm method getAllSach vào SachDAO"

# Sửa lỗi
git commit -m "fix(database): sửa lỗi connection leak trong DBConnect"

# Documentation
git commit -m "docs(readme): cập nhật hướng dẫn cài đặt"

# Refactor
git commit -m "refactor(model): cải thiện structure của class Sach"
```

## Pull Request Process

### Checklist trước khi submit PR

- [ ] Code đã được test kỹ lưỡng
- [ ] Không có conflict với branch main
- [ ] Code tuân thủ coding standards
- [ ] Đã thêm/cập nhật documentation nếu cần
- [ ] Đã thêm/cập nhật tests nếu cần
- [ ] Commit messages rõ ràng và có ý nghĩa

### Template Pull Request

```markdown
## Mô tả

Mô tả ngắn gọn về những thay đổi trong PR này.

## Loại thay đổi

- [ ] Bug fix
- [ ] New feature
- [ ] Breaking change
- [ ] Documentation update

## Đã test như thế nào?

Mô tả các test cases đã thực hiện.

## Checklist

- [ ] Code tuân thủ coding standards
- [ ] Đã self-review code
- [ ] Đã thêm comments cho code phức tạp
- [ ] Đã cập nhật documentation
- [ ] Không có warnings mới
- [ ] Đã test kỹ lưỡng
```

## Báo cáo lỗi

### Template Issue cho Bug

```markdown
**Mô tả lỗi**
Mô tả rõ ràng và ngắn gọn về lỗi.

**Cách tái hiện lỗi**
1. Vào '...'
2. Click vào '....'
3. Scroll đến '....'
4. Thấy lỗi

**Kết quả mong đợi**
Mô tả kết quả bạn mong đợi.

**Screenshots**
Nếu có, thêm screenshots để minh họa.

**Môi trường**
- OS: [e.g. Windows 10]
- Java Version: [e.g. JDK 11]
- Database: [e.g. MySQL 8.0]
```

## Đề xuất tính năng

### Template Issue cho Feature Request

```markdown
**Mô tả tính năng**
Mô tả rõ ràng về tính năng bạn muốn đề xuất.

**Tại sao cần tính năng này?**
Giải thích vấn đề mà tính năng này sẽ giải quyết.

**Giải pháp đề xuất**
Mô tả solution bạn muốn implement.

**Giải pháp thay thế**
Mô tả các giải pháp thay thế khác bạn đã cân nhắc.

**Thông tin bổ sung**
Thêm bất kỳ thông tin nào khác về feature request.
```

## 📞 Liên hệ

Nếu có câu hỏi về việc đóng góp, vui lòng:
- Tạo issue trên GitHub
- Hoặc liên hệ qua email: your.email@example.com

## 🙏 Cảm ơn

Cảm ơn bạn đã dành thời gian đóng góp cho dự án! Mọi đóng góp, dù lớn hay nhỏ, đều được trân trọng.

---

Happy Coding! 🚀
