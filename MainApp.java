import dao.ISachDAO;
import dao.SachDAO;
import database.DBConnect;
import model.Sach;

import java.util.List;
import java.util.Scanner;

/**
 * Class Main - Entry point của ứng dụng Quản Lý Sách
 * Cung cấp giao diện console để thực hiện các chức năng CRUD
 */
public class MainApp {
    private static ISachDAO sachDAO;
    private static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   HỆ THỐNG QUẢN LÝ SÁCH - QLsach      ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println();

        // Khởi tạo
        sachDAO = new SachDAO();
        scanner = new Scanner(System.in);

        // Kiểm tra kết nối database
        if (!DBConnect.isConnected()) {
            System.err.println("✗ Không thể kết nối database. Vui lòng kiểm tra cấu hình!");
            return;
        }

        // Menu chính
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getIntInput("Nhập lựa chọn: ");

            switch (choice) {
                case 1:
                    xemTatCaSach();
                    break;
                case 2:
                    timSachTheoMa();
                    break;
                case 3:
                    themSachMoi();
                    break;
                case 4:
                    capNhatSach();
                    break;
                case 5:
                    xoaSach();
                    break;
                case 6:
                    timKiemSachTheoTen();
                    break;
                case 7:
                    timKiemSachTheoTacGia();
                    break;
                case 0:
                    System.out.println("\n✓ Đang thoát chương trình...");
                    running = false;
                    break;
                default:
                    System.out.println("\n✗ Lựa chọn không hợp lệ! Vui lòng thử lại.");
            }

            if (running) {
                System.out.println("\nNhấn Enter để tiếp tục...");
                scanner.nextLine();
            }
        }

        // Đóng kết nối
        DBConnect.closeConnection();
        scanner.close();
        System.out.println("✓ Cảm ơn bạn đã sử dụng hệ thống!");
    }

    private static void displayMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                    MENU CHÍNH");
        System.out.println("=".repeat(50));
        System.out.println("1. Xem tất cả sách");
        System.out.println("2. Tìm sách theo mã");
        System.out.println("3. Thêm sách mới");
        System.out.println("4. Cập nhật thông tin sách");
        System.out.println("5. Xóa sách");
        System.out.println("6. Tìm kiếm sách theo tên");
        System.out.println("7. Tìm kiếm sách theo tác giả");
        System.out.println("0. Thoát");
        System.out.println("=".repeat(50));
    }

    private static void xemTatCaSach() {
        System.out.println("\n📚 DANH SÁCH TẤT CẢ SÁCH");
        System.out.println("─".repeat(120));

        List<Sach> dsSach = sachDAO.getAllSach();

        if (dsSach.isEmpty()) {
            System.out.println("Không có sách nào trong hệ thống.");
        } else {
            System.out.printf("%-5s %-30s %-20s %-20s %-12s %-12s %-10s%n",
                    "Mã", "Tên sách", "Tác giả", "NXB", "Năm XB", "Giá bán", "Số lượng");
            System.out.println("─".repeat(120));

            for (Sach sach : dsSach) {
                System.out.printf("%-5d %-30s %-20s %-20s %-12d %-12.0f %-10d%n",
                        sach.getMaSach(),
                        truncate(sach.getTenSach(), 30),
                        truncate(sach.getTacGia(), 20),
                        truncate(sach.getNhaXuatBan(), 20),
                        sach.getNamXuatBan(),
                        sach.getGiaBan(),
                        sach.getSoLuong());
            }
            System.out.println("─".repeat(120));
            System.out.println("Tổng số sách: " + dsSach.size());
        }
    }

    private static void timSachTheoMa() {
        System.out.println("\n🔍 TÌM SÁCH THEO MÃ");
        int maSach = getIntInput("Nhập mã sách: ");

        Sach sach = sachDAO.getSachById(maSach);
        if (sach != null) {
            hienThiChiTietSach(sach);
        } else {
            System.out.println("✗ Không tìm thấy sách có mã: " + maSach);
        }
    }

    private static void themSachMoi() {
        System.out.println("\n➕ THÊM SÁCH MỚI");

        System.out.print("Tên sách: ");
        String tenSach = scanner.nextLine();

        System.out.print("Tác giả: ");
        String tacGia = scanner.nextLine();

        System.out.print("Nhà xuất bản: ");
        String nhaXuatBan = scanner.nextLine();

        int namXuatBan = getIntInput("Năm xuất bản: ");
        double giaBan = getDoubleInput("Giá bán: ");
        int soLuong = getIntInput("Số lượng: ");

        Sach sachMoi = new Sach(tenSach, tacGia, nhaXuatBan, namXuatBan, giaBan, soLuong);

        if (sachDAO.insertSach(sachMoi)) {
            System.out.println("✓ Thêm sách thành công!");
        } else {
            System.out.println("✗ Thêm sách thất bại!");
        }
    }

    private static void capNhatSach() {
        System.out.println("\n✏️ CẬP NHẬT THÔNG TIN SÁCH");
        int maSach = getIntInput("Nhập mã sách cần cập nhật: ");

        Sach sach = sachDAO.getSachById(maSach);
        if (sach == null) {
            System.out.println("✗ Không tìm thấy sách có mã: " + maSach);
            return;
        }

        System.out.println("Thông tin hiện tại:");
        hienThiChiTietSach(sach);

        System.out.println("\nNhập thông tin mới (Enter để giữ nguyên):");

        System.out.print("Tên sách [" + sach.getTenSach() + "]: ");
        String tenSach = scanner.nextLine();
        if (!tenSach.isEmpty())
            sach.setTenSach(tenSach);

        System.out.print("Tác giả [" + sach.getTacGia() + "]: ");
        String tacGia = scanner.nextLine();
        if (!tacGia.isEmpty())
            sach.setTacGia(tacGia);

        System.out.print("Nhà xuất bản [" + sach.getNhaXuatBan() + "]: ");
        String nhaXuatBan = scanner.nextLine();
        if (!nhaXuatBan.isEmpty())
            sach.setNhaXuatBan(nhaXuatBan);

        System.out.print("Năm xuất bản [" + sach.getNamXuatBan() + "]: ");
        String namStr = scanner.nextLine();
        if (!namStr.isEmpty())
            sach.setNamXuatBan(Integer.parseInt(namStr));

        System.out.print("Giá bán [" + sach.getGiaBan() + "]: ");
        String giaStr = scanner.nextLine();
        if (!giaStr.isEmpty())
            sach.setGiaBan(Double.parseDouble(giaStr));

        System.out.print("Số lượng [" + sach.getSoLuong() + "]: ");
        String slStr = scanner.nextLine();
        if (!slStr.isEmpty())
            sach.setSoLuong(Integer.parseInt(slStr));

        if (sachDAO.updateSach(sach)) {
            System.out.println("✓ Cập nhật sách thành công!");
        } else {
            System.out.println("✗ Cập nhật sách thất bại!");
        }
    }

    private static void xoaSach() {
        System.out.println("\n🗑️ XÓA SÁCH");
        int maSach = getIntInput("Nhập mã sách cần xóa: ");

        Sach sach = sachDAO.getSachById(maSach);
        if (sach == null) {
            System.out.println("✗ Không tìm thấy sách có mã: " + maSach);
            return;
        }

        hienThiChiTietSach(sach);
        System.out.print("\nBạn có chắc chắn muốn xóa sách này? (Y/N): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("Y")) {
            if (sachDAO.deleteSach(maSach)) {
                System.out.println("✓ Xóa sách thành công!");
            } else {
                System.out.println("✗ Xóa sách thất bại!");
            }
        } else {
            System.out.println("✓ Đã hủy thao tác xóa.");
        }
    }

    private static void timKiemSachTheoTen() {
        System.out.println("\n🔍 TÌM KIẾM SÁCH THEO TÊN");
        System.out.print("Nhập tên sách: ");
        String tenSach = scanner.nextLine();

        List<Sach> dsSach = sachDAO.searchSachByName(tenSach);
        hienThiKetQuaTimKiem(dsSach, "tên: " + tenSach);
    }

    private static void timKiemSachTheoTacGia() {
        System.out.println("\n🔍 TÌM KIẾM SÁCH THEO TÁC GIẢ");
        System.out.print("Nhập tên tác giả: ");
        String tacGia = scanner.nextLine();

        List<Sach> dsSach = sachDAO.searchSachByAuthor(tacGia);
        hienThiKetQuaTimKiem(dsSach, "tác giả: " + tacGia);
    }

    private static void hienThiKetQuaTimKiem(List<Sach> dsSach, String criteria) {
        System.out.println("\n📋 KẾT QUẢ TÌM KIẾM - " + criteria);
        System.out.println("─".repeat(120));

        if (dsSach.isEmpty()) {
            System.out.println("Không tìm thấy sách nào.");
        } else {
            System.out.printf("%-5s %-30s %-20s %-20s %-12s %-12s %-10s%n",
                    "Mã", "Tên sách", "Tác giả", "NXB", "Năm XB", "Giá bán", "Số lượng");
            System.out.println("─".repeat(120));

            for (Sach sach : dsSach) {
                System.out.printf("%-5d %-30s %-20s %-20s %-12d %-12.0f %-10d%n",
                        sach.getMaSach(),
                        truncate(sach.getTenSach(), 30),
                        truncate(sach.getTacGia(), 20),
                        truncate(sach.getNhaXuatBan(), 20),
                        sach.getNamXuatBan(),
                        sach.getGiaBan(),
                        sach.getSoLuong());
            }
            System.out.println("─".repeat(120));
            System.out.println("Tìm thấy: " + dsSach.size() + " sách");
        }
    }

    private static void hienThiChiTietSach(Sach sach) {
        System.out.println("\n" + "─".repeat(50));
        System.out.println("📖 THÔNG TIN CHI TIẾT SÁCH");
        System.out.println("─".repeat(50));
        System.out.println("Mã sách:        " + sach.getMaSach());
        System.out.println("Tên sách:       " + sach.getTenSach());
        System.out.println("Tác giả:        " + sach.getTacGia());
        System.out.println("Nhà xuất bản:   " + sach.getNhaXuatBan());
        System.out.println("Năm xuất bản:   " + sach.getNamXuatBan());
        System.out.println("Giá bán:        " + String.format("%,.0f VNĐ", sach.getGiaBan()));
        System.out.println("Số lượng:       " + sach.getSoLuong());
        System.out.println("─".repeat(50));
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("✗ Vui lòng nhập số nguyên hợp lệ!");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("✗ Vui lòng nhập số thực hợp lệ!");
            }
        }
    }

    private static String truncate(String str, int maxLength) {
        if (str == null)
            return "";
        return str.length() > maxLength ? str.substring(0, maxLength - 3) + "..." : str;
    }
}
