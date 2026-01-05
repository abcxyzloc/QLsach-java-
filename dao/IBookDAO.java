package dao;

import model.Book;
import java.util.List;

/**
 * Interface định nghĩa các phương thức CRUD cho Book
 * Tuân thủ nguyên tắc DAO pattern
 */
public interface IBookDAO {

    /**
     * Lấy tất cả sách từ database
     * 
     * @return Danh sách các sách
     */
    List<Book> getAllBooks();

    /**
     * Lấy thông tin sách theo mã sách
     * 
     * @param bookId Mã sách cần tìm
     * @return Đối tượng Book hoặc null nếu không tìm thấy
     */
    Book getBookById(int bookId);

    /**
     * Thêm sách mới vào database
     * 
     * @param book Đối tượng sách cần thêm
     * @return true nếu thành công, false nếu thất bại
     */
    boolean insertBook(Book book);

    /**
     * Cập nhật thông tin sách
     * 
     * @param book Đối tượng sách cần cập nhật
     * @return true nếu thành công, false nếu thất bại
     */
    boolean updateBook(Book book);

    /**
     * Xóa sách theo mã sách
     * 
     * @param bookId Mã sách cần xóa
     * @return true nếu thành công, false nếu thất bại
     */
    boolean deleteBook(int bookId);

    /**
     * Tìm kiếm sách theo tên
     * 
     * @param bookName Tên sách cần tìm
     * @return Danh sách các sách tìm được
     */
    List<Book> searchBooksByName(String bookName);

    /**
     * Tìm kiếm sách theo tác giả
     * 
     * @param author Tên tác giả
     * @return Danh sách các sách của tác giả
     */
    List<Book> searchBooksByAuthor(String author);
}