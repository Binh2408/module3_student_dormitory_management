package org.example.quan_ly_ky_tuc_xa.dto.contract;

import java.time.LocalDateTime;

public class ThongTinHopDongDTO {
    private int maHopDong;
    private String tenPhong;
    private String tenLoaiPhong;
    private int soNguoiToiDa;
    private int soNguoiHienTai;
    private double giaMoiThang;
    private String trangThaiPhong;
    private LocalDateTime thoiGianBatDau;
    private LocalDateTime thoiGianKetThuc;

    public ThongTinHopDongDTO() {
    }

    public ThongTinHopDongDTO(int maHopDong, String tenPhong, String tenLoaiPhong, int soNguoiToiDa, int soNguoiHienTai, double giaMoiThang, String trangThaiPhong, LocalDateTime thoiGianBatDau, LocalDateTime thoiGianKetThuc) {
        this.maHopDong = maHopDong;
        this.tenPhong = tenPhong;
        this.tenLoaiPhong = tenLoaiPhong;
        this.soNguoiToiDa = soNguoiToiDa;
        this.soNguoiHienTai = soNguoiHienTai;
        this.giaMoiThang = giaMoiThang;
        this.trangThaiPhong = trangThaiPhong;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public int getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(int maHopDong) {
        this.maHopDong = maHopDong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public int getSoNguoiToiDa() {
        return soNguoiToiDa;
    }

    public void setSoNguoiToiDa(int soNguoiToiDa) {
        this.soNguoiToiDa = soNguoiToiDa;
    }

    public int getSoNguoiHienTai() {
        return soNguoiHienTai;
    }

    public void setSoNguoiHienTai(int soNguoiHienTai) {
        this.soNguoiHienTai = soNguoiHienTai;
    }

    public double getGiaMoiThang() {
        return giaMoiThang;
    }

    public void setGiaMoiThang(double giaMoiThang) {
        this.giaMoiThang = giaMoiThang;
    }

    public String getTrangThaiPhong() {
        return trangThaiPhong;
    }

    public void setTrangThaiPhong(String trangThaiPhong) {
        this.trangThaiPhong = trangThaiPhong;
    }

    public LocalDateTime getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(LocalDateTime thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public LocalDateTime getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(LocalDateTime thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }
}
