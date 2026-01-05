package model;

/**
 * Class đại diện cho Entity Sách
 * Chứa các thuộc tính và phương thức liên quan đến Sách
 */
public class Sach {
    private int maSach;
    private String tenSach;
    private String tacGia;
    private String nhaXuatBan;
    private int namXuatBan;
    private double giaBan;
    private int soLuong;

    // Constructor mặc định
    public Sach() {
    }

    // Constructor đầy đủ tham số
    public Sach(int maSach, String tenSach, String tacGia, String nhaXuatBan,
            int namXuatBan, double giaBan, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.nhaXuatBan = nhaXuatBan;
        this.namXuatBan = namXuatBan;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    // Constructor không có maSach (dùng khi insert)
    public Sach(String tenSach, String tacGia, String nhaXuatBan,
            int namXuatBan, double giaBan, int soLuong) {
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.nhaXuatBan = nhaXuatBan;
        this.namXuatBan = namXuatBan;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    // Getters and Setters
    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return String.format("Sach[ID=%d, Ten='%s', TacGia='%s', NXB='%s', Nam=%d, Gia=%.2f, SoLuong=%d]",
                maSach, tenSach, tacGia, nhaXuatBan, namXuatBan, giaBan, soLuong);
    }
}