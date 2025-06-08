package org.example.quan_ly_ky_tuc_xa.dto;

import java.time.LocalDate;

public class HopDongDtoResponse {

    private int maHopDong;
    private String tenSinhVien;
    private String tenPhong;
    private LocalDate thoiGianBatDau;
    private LocalDate thoiGianKetThuc;
    private int chiPhiThue;
    public HopDongDtoResponse() {
    }



    public HopDongDtoResponse( String tenSinhVien, String tenPhong,
                              LocalDate thoiGianBatDau, LocalDate thoiGianKetThuc, int chiPhiThue) {
        this.tenSinhVien = tenSinhVien;
        this.tenPhong = tenPhong;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.chiPhiThue = chiPhiThue;
    }

    public HopDongDtoResponse(int maHopDong, String tenSinhVien, String tenPhong,
                              LocalDate thoiGianBatDau, LocalDate thoiGianKetThuc, int chiPhiThue) {
        this.maHopDong = maHopDong;
        this.tenSinhVien = tenSinhVien;
        this.tenPhong = tenPhong;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.chiPhiThue = chiPhiThue;
    }

    public int getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(int maHopDong) {
        this.maHopDong = maHopDong;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public LocalDate getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(LocalDate thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public LocalDate getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(LocalDate thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public int getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(int chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }
}
