package model;

/**
 * Class đại diện cho Entity Book (Sách)
 * Chứa các thuộc tính và phương thức liên quan đến Sách
 */
public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String publisher;
    private int publicationYear;
    private double price;
    private int quantity;

    // Constructor mặc định
    public Book() {
    }

    // Constructor đầy đủ tham số
    public Book(int bookId, String bookName, String author, String publisher,
            int publicationYear, double price, int quantity) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.price = price;
        this.quantity = quantity;
    }

    // Constructor không có bookId (dùng khi insert)
    public Book(String bookName, String author, String publisher,
            int publicationYear, double price, int quantity) {
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("Book[ID=%d, Name='%s', Author='%s', Publisher='%s', Year=%d, Price=%.2f, Quantity=%d]",
                bookId, bookName, author, publisher, publicationYear, price, quantity);
    }
}