package org.example.quan_ly_ky_tuc_xa.entity;

public class SinhVien {
    private int sinhVienId;
    private String tenSinhVien;
    private int maTaiKhoan;
    private int maLop;
    private int maGioiTinh;
    private String soCMND;
    private String email;
    private String soDienThoai;
    private int isDelete;

    public SinhVien(int sinhVienId, String tenSinhVien, int maTaiKhoan, int maLop, int maGioiTinh, String soCMND,
                    String email, String soDienThoai, int isDelete) {
        this.sinhVienId = sinhVienId;
        this.tenSinhVien = tenSinhVien;
        this.maTaiKhoan = maTaiKhoan;
        this.maLop = maLop;
        this.maGioiTinh = maGioiTinh;
        this.soCMND = soCMND;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.isDelete = isDelete;
    }


    public SinhVien() {
    }

    public int getSinhVienId() {
        return sinhVienId;
    }

    public void setSinhVienId(int sinhVienId) {
        this.sinhVienId = sinhVienId;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public int getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(int maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public int getMaLop() {
        return maLop;
    }

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }

    public int getMaGioiTinh() {
        return maGioiTinh;
    }

    public void setMaGioiTinh(int maGioiTinh) {
        this.maGioiTinh = maGioiTinh;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
