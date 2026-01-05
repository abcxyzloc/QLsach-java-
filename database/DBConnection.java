package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class quản lý kết nối đến cơ sở dữ liệu
 * Sử dụng Singleton pattern để đảm bảo chỉ có một connection
 */
public class DBConnection {
    // Thông tin kết nối database - CẬP NHẬT THEO DATABASE CỦA BẠN
    private static final String DB_URL = "jdbc:mysql://localhost:3306/qlsach";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    private static Connection connection = null;

    // Private constructor để implement Singleton pattern
    private DBConnection() {
    }

    /**
     * Lấy kết nối đến database
     * 
     * @return Connection object
     */
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                // Load MySQL JDBC Driver
                Class.forName(DB_DRIVER);

                // Tạo kết nối mới
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                System.out.println("✓ Kết nối database thành công!");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("✗ Không tìm thấy MySQL JDBC Driver!");
            System.err.println("  Hãy thêm mysql-connector-java vào classpath");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("✗ Lỗi khi kết nối database!");
            System.err.println("  Kiểm tra lại: URL, username, password");
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Đóng kết nối database
     */
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("✓ Đã đóng kết nối database");
            }
        } catch (SQLException e) {
            System.err.println("✗ Lỗi khi đóng kết nối database!");
            e.printStackTrace();
        }
    }

    /**
     * Kiểm tra kết nối
     * 
     * @return true nếu đang kết nối, false nếu ngược lại
     */
    public static boolean isConnected() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
}
