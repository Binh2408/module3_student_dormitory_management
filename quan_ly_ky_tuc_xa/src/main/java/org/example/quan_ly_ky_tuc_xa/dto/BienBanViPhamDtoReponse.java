package org.example.quan_ly_ky_tuc_xa.dto;

import java.time.LocalDate;

public class BienBanViPhamDtoReponse {
    private int bienBanId;
    private String tenSinhVien;
    private String tenLoaiViPham;
    private String mucDoViPham;
    private LocalDate thoiGianViPham;

    public BienBanViPhamDtoReponse() {
    }

    public BienBanViPhamDtoReponse(String tenSinhVien,
                                   String tenLoaiViPham, String mucDoViPham, LocalDate thoiGianViPham) {
        this.tenSinhVien = tenSinhVien;
        this.tenLoaiViPham = tenLoaiViPham;
        this.mucDoViPham = mucDoViPham;
        this.thoiGianViPham = thoiGianViPham;
    }


    public BienBanViPhamDtoReponse(int bienBanId, String tenSinhVien,
                                   String tenLoaiViPham, String mucDoViPham, LocalDate thoiGianViPham) {
        this.bienBanId = bienBanId;
        this.tenSinhVien = tenSinhVien;
        this.tenLoaiViPham = tenLoaiViPham;
        this.mucDoViPham = mucDoViPham;
        this.thoiGianViPham = thoiGianViPham;
    }

    public int getBienBanId() {
        return bienBanId;
    }

    public void setBienBanId(int bienBanId) {
        this.bienBanId = bienBanId;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }


    public String getTenLoaiViPham() {
        return tenLoaiViPham;
    }

    public void setTenLoaiViPham(String tenLoaiViPham) {
        this.tenLoaiViPham = tenLoaiViPham;
    }

    public String getMucDoViPham() {
        return mucDoViPham;
    }

    public void setMucDoViPham(String mucDoViPham) {
        this.mucDoViPham = mucDoViPham;
    }

    public LocalDate getThoiGianViPham() {
        return thoiGianViPham;
    }

    public void setThoiGianViPham(LocalDate thoiGianViPham) {
        this.thoiGianViPham = thoiGianViPham;
    }
}
