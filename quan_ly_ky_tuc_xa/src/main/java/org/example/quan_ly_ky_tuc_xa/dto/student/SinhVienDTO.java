package org.example.quan_ly_ky_tuc_xa.dto.student;

public class SinhVienDTO {
    private String maSinhVien;
    private String tenSinhVien;
    private String soCMND;
    private String soDienThoai;
    private String email;
    private String gioiTinh;
    private String tenLop;

    public SinhVienDTO() {
    }

    public SinhVienDTO(String maSinhVien, String tenSinhVien, String soCMND, String soDienThoai, String email,
                       String gioiTinh, String tenLop) {
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.soCMND = soCMND;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.tenLop = tenLop;
    }

    public SinhVienDTO(String tenSinhVien, String soCMND, String soDienThoai, String email, String maSinhVien) {
        this.tenSinhVien = tenSinhVien;
        this.soCMND = soCMND;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.maSinhVien = maSinhVien;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }
}

