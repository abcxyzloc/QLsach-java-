package dao;

import database.DBConnection;
import model.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation của IBookDAO
 * Thực hiện các thao tác CRUD với database
 */
public class BookDAO implements IBookDAO {

    private Connection connection;

    public BookDAO() {
        this.connection = DBConnection.getConnection();
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT * FROM sach";

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("ma_sach"),
                        rs.getString("ten_sach"),
                        rs.getString("tac_gia"),
                        rs.getString("nha_xuat_ban"),
                        rs.getInt("nam_xuat_ban"),
                        rs.getDouble("gia_ban"),
                        rs.getInt("so_luong"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            System.err.println("✗ Lỗi khi lấy danh sách sách: " + e.getMessage());
            e.printStackTrace();
        }

        return bookList;
    }

    @Override
    public Book getBookById(int bookId) {
        String sql = "SELECT * FROM sach WHERE ma_sach = ?";
        Book book = null;

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, bookId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                book = new Book(
                        rs.getInt("ma_sach"),
                        rs.getString("ten_sach"),
                        rs.getString("tac_gia"),
                        rs.getString("nha_xuat_ban"),
                        rs.getInt("nam_xuat_ban"),
                        rs.getDouble("gia_ban"),
                        rs.getInt("so_luong"));
            }
        } catch (SQLException e) {
            System.err.println("✗ Lỗi khi lấy thông tin sách: " + e.getMessage());
            e.printStackTrace();
        }

        return book;
    }

    @Override
    public boolean insertBook(Book book) {
        String sql = "INSERT INTO sach (ten_sach, tac_gia, nha_xuat_ban, nam_xuat_ban, gia_ban, so_luong) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, book.getBookName());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getPublisher());
            pstmt.setInt(4, book.getPublicationYear());
            pstmt.setDouble(5, book.getPrice());
            pstmt.setInt(6, book.getQuantity());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("✗ Lỗi khi thêm sách: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateBook(Book book) {
        String sql = "UPDATE sach SET ten_sach = ?, tac_gia = ?, nha_xuat_ban = ?, " +
                "nam_xuat_ban = ?, gia_ban = ?, so_luong = ? WHERE ma_sach = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, book.getBookName());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getPublisher());
            pstmt.setInt(4, book.getPublicationYear());
            pstmt.setDouble(5, book.getPrice());
            pstmt.setInt(6, book.getQuantity());
            pstmt.setInt(7, book.getBookId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("✗ Lỗi khi cập nhật sách: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteBook(int bookId) {
        String sql = "DELETE FROM sach WHERE ma_sach = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, bookId);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("✗ Lỗi khi xóa sách: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Book> searchBooksByName(String bookName) {
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT * FROM sach WHERE ten_sach LIKE ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "%" + bookName + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("ma_sach"),
                        rs.getString("ten_sach"),
                        rs.getString("tac_gia"),
                        rs.getString("nha_xuat_ban"),
                        rs.getInt("nam_xuat_ban"),
                        rs.getDouble("gia_ban"),
                        rs.getInt("so_luong"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            System.err.println("✗ Lỗi khi tìm kiếm sách: " + e.getMessage());
            e.printStackTrace();
        }

        return bookList;
    }

    @Override
    public List<Book> searchBooksByAuthor(String author) {
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT * FROM sach WHERE tac_gia LIKE ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "%" + author + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("ma_sach"),
                        rs.getString("ten_sach"),
                        rs.getString("tac_gia"),
                        rs.getString("nha_xuat_ban"),
                        rs.getInt("nam_xuat_ban"),
                        rs.getDouble("gia_ban"),
                        rs.getInt("so_luong"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            System.err.println("✗ Lỗi khi tìm kiếm sách theo tác giả: " + e.getMessage());
            e.printStackTrace();
        }

        return bookList;
    }
}