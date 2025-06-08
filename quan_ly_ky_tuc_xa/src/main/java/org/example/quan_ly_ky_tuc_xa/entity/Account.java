package org.example.quan_ly_ky_tuc_xa.entity;

import java.time.LocalDateTime;

public class Account {
    private int maTaiKhoan;
    private String userName;
    private String password;
    private int maVaiTro;
    private LocalDateTime ngayTaoTaiKhoan;
    private boolean isDelete;

    public Account() {
    }

    public Account(int maTaiKhoan, String userName, String password, int maVaiTro, LocalDateTime ngayTaoTaiKhoan, boolean isDelete) {
        this.maTaiKhoan = maTaiKhoan;
        this.userName = userName;
        this.password = password;
        this.maVaiTro = maVaiTro;
        this.ngayTaoTaiKhoan = ngayTaoTaiKhoan;
        this.isDelete = isDelete;
    }

    // Getters and Setters
    public int getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(int maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaVaiTro() {
        return maVaiTro;
    }

    public void setMaVaiTro(int maVaiTro) {
        this.maVaiTro = maVaiTro;
    }

    public LocalDateTime getNgayTaoTaiKhoan() {
        return ngayTaoTaiKhoan;
    }

    public void setNgayTaoTaiKhoan(LocalDateTime ngayTaoTaiKhoan) {
        this.ngayTaoTaiKhoan = ngayTaoTaiKhoan;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
