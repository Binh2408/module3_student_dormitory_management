package org.example.quan_ly_ky_tuc_xa.entity;

import java.time.LocalDate;

public class BienBanViPham {
    private int maBienBanViPham;
    private int maSinhVienViPham;
    private int maLoaiViPham;
    private int maMucDoViPham;
    private LocalDate thoiGianViPham;

    public BienBanViPham() {
    }

    public BienBanViPham(int maBienBanViPham, int maSinhVienViPham, int maLoaiViPham, int maMucDoViPham, LocalDate thoiGianViPham) {
        this.maBienBanViPham = maBienBanViPham;
        this.maSinhVienViPham = maSinhVienViPham;
        this.maLoaiViPham = maLoaiViPham;
        this.maMucDoViPham = maMucDoViPham;
        this.thoiGianViPham = thoiGianViPham;
    }

    public int getMaBienBanViPham() {
        return maBienBanViPham;
    }

    public void setMaBienBanViPham(int maBienBanViPham) {
        this.maBienBanViPham = maBienBanViPham;
    }

    public int getMaSinhVienViPham() {
        return maSinhVienViPham;
    }

    public void setMaSinhVienViPham(int maSinhVienViPham) {
        this.maSinhVienViPham = maSinhVienViPham;
    }

    public int getMaLoaiViPham() {
        return maLoaiViPham;
    }

    public void setMaLoaiViPham(int maLoaiViPham) {
        this.maLoaiViPham = maLoaiViPham;
    }

    public int getMaMucDoViPham() {
        return maMucDoViPham;
    }

    public void setMaMucDoViPham(int maMucDoViPham) {
        this.maMucDoViPham = maMucDoViPham;
    }

    public LocalDate getThoiGianViPham() {
        return thoiGianViPham;
    }

    public void setThoiGianViPham(LocalDate thoiGianViPham) {
        this.thoiGianViPham = thoiGianViPham;
    }
}
