package org.example.quan_ly_ky_tuc_xa.dto.room;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class ThongTinPhongDTO {
    private String tenPhong;
    private String loaiPhong;
    private int soNguoiToiDa;
    private int soNguoiHienTai;
    private double giaMoiThang;
    private String trangThai;
    private LocalDateTime thoiGianBatDau;
    private LocalDateTime thoiGianKetThuc;

    public ThongTinPhongDTO() {
    }

    public ThongTinPhongDTO(String tenPhong, String loaiPhong, int soNguoiToiDa, int soNguoiHienTai, double giaMoiThang, String trangThai, LocalDateTime thoiGianBatDau, LocalDateTime thoiGianKetThuc) {
        this.tenPhong = tenPhong;
        this.loaiPhong = loaiPhong;
        this.soNguoiToiDa = soNguoiToiDa;
        this.soNguoiHienTai = soNguoiHienTai;
        this.giaMoiThang = giaMoiThang;
        this.trangThai = trangThai;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
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

    public Date getThoiGianBatDauAsDate() {
        return thoiGianBatDau != null ? Timestamp.valueOf(thoiGianBatDau) : null;
    }

    public Date getThoiGianKetThucAsDate() {
        return thoiGianKetThuc != null ? Timestamp.valueOf(thoiGianKetThuc) : null;
    }
}

