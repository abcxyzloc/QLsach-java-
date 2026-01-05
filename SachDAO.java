package dao;

import database.DBConnect;
import model.Sach;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation của ISachDAO
 * Thực hiện các thao tác CRUD với database
 */
public class SachDAO implements ISachDAO {

    private Connection connection;

    public SachDAO() {
        this.connection = DBConnect.getConnection();
    }

    @Override
    public List<Sach> getAllSach() {
        List<Sach> dsSach = new ArrayList<>();
        String sql = "SELECT * FROM sach";

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Sach sach = new Sach(
                        rs.getInt("ma_sach"),
                        rs.getString("ten_sach"),
                        rs.getString("tac_gia"),
                        rs.getString("nha_xuat_ban"),
                        rs.getInt("nam_xuat_ban"),
                        rs.getDouble("gia_ban"),
                        rs.getInt("so_luong"));
                dsSach.add(sach);
            }
        } catch (SQLException e) {
            System.err.println("✗ Lỗi khi lấy danh sách sách: " + e.getMessage());
            e.printStackTrace();
        }

        return dsSach;
    }

    @Override
    public Sach getSachById(int maSach) {
        String sql = "SELECT * FROM sach WHERE ma_sach = ?";
        Sach sach = null;

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, maSach);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                sach = new Sach(
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

        return sach;
    }

    @Override
    public boolean insertSach(Sach sach) {
        String sql = "INSERT INTO sach (ten_sach, tac_gia, nha_xuat_ban, nam_xuat_ban, gia_ban, so_luong) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, sach.getTenSach());
            pstmt.setString(2, sach.getTacGia());
            pstmt.setString(3, sach.getNhaXuatBan());
            pstmt.setInt(4, sach.getNamXuatBan());
            pstmt.setDouble(5, sach.getGiaBan());
            pstmt.setInt(6, sach.getSoLuong());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("✗ Lỗi khi thêm sách: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateSach(Sach sach) {
        String sql = "UPDATE sach SET ten_sach = ?, tac_gia = ?, nha_xuat_ban = ?, " +
                "nam_xuat_ban = ?, gia_ban = ?, so_luong = ? WHERE ma_sach = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, sach.getTenSach());
            pstmt.setString(2, sach.getTacGia());
            pstmt.setString(3, sach.getNhaXuatBan());
            pstmt.setInt(4, sach.getNamXuatBan());
            pstmt.setDouble(5, sach.getGiaBan());
            pstmt.setInt(6, sach.getSoLuong());
            pstmt.setInt(7, sach.getMaSach());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("✗ Lỗi khi cập nhật sách: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteSach(int maSach) {
        String sql = "DELETE FROM sach WHERE ma_sach = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, maSach);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("✗ Lỗi khi xóa sách: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Sach> searchSachByName(String tenSach) {
        List<Sach> dsSach = new ArrayList<>();
        String sql = "SELECT * FROM sach WHERE ten_sach LIKE ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "%" + tenSach + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Sach sach = new Sach(
                        rs.getInt("ma_sach"),
                        rs.getString("ten_sach"),
                        rs.getString("tac_gia"),
                        rs.getString("nha_xuat_ban"),
                        rs.getInt("nam_xuat_ban"),
                        rs.getDouble("gia_ban"),
                        rs.getInt("so_luong"));
                dsSach.add(sach);
            }
        } catch (SQLException e) {
            System.err.println("✗ Lỗi khi tìm kiếm sách: " + e.getMessage());
            e.printStackTrace();
        }

        return dsSach;
    }

    @Override
    public List<Sach> searchSachByAuthor(String tacGia) {
        List<Sach> dsSach = new ArrayList<>();
        String sql = "SELECT * FROM sach WHERE tac_gia LIKE ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "%" + tacGia + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Sach sach = new Sach(
                        rs.getInt("ma_sach"),
                        rs.getString("ten_sach"),
                        rs.getString("tac_gia"),
                        rs.getString("nha_xuat_ban"),
                        rs.getInt("nam_xuat_ban"),
                        rs.getDouble("gia_ban"),
                        rs.getInt("so_luong"));
                dsSach.add(sach);
            }
        } catch (SQLException e) {
            System.err.println("✗ Lỗi khi tìm kiếm sách theo tác giả: " + e.getMessage());
            e.printStackTrace();
        }

        return dsSach;
    }
}