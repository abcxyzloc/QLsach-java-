package dao;

import model.Sach;
import java.util.List;

/**
 * Interface định nghĩa các phương thức CRUD cho Sach
 * Tuân thủ nguyên tắc DAO pattern
 */
public interface ISachDAO {

    /**
     * Lấy tất cả sách từ database
     * 
     * @return Danh sách các sách
     */
    List<Sach> getAllSach();

    /**
     * Lấy thông tin sách theo mã sách
     * 
     * @param maSach Mã sách cần tìm
     * @return Đối tượng Sach hoặc null nếu không tìm thấy
     */
    Sach getSachById(int maSach);

    /**
     * Thêm sách mới vào database
     * 
     * @param sach Đối tượng sách cần thêm
     * @return true nếu thành công, false nếu thất bại
     */
    boolean insertSach(Sach sach);

    /**
     * Cập nhật thông tin sách
     * 
     * @param sach Đối tượng sách cần cập nhật
     * @return true nếu thành công, false nếu thất bại
     */
    boolean updateSach(Sach sach);

    /**
     * Xóa sách theo mã sách
     * 
     * @param maSach Mã sách cần xóa
     * @return true nếu thành công, false nếu thất bại
     */
    boolean deleteSach(int maSach);

    /**
     * Tìm kiếm sách theo tên
     * 
     * @param tenSach Tên sách cần tìm
     * @return Danh sách các sách tìm được
     */
    List<Sach> searchSachByName(String tenSach);

    /**
     * Tìm kiếm sách theo tác giả
     * 
     * @param tacGia Tên tác giả
     * @return Danh sách các sách của tác giả
     */
    List<Sach> searchSachByAuthor(String tacGia);
}