package org.example.quan_ly_ky_tuc_xa.entity;

import java.sql.Date;
import java.time.LocalDate;

public class HopDong {
    private int hopDongId;
    private int sinhVienId;
    private int maPhong;
    private LocalDate thoiGianBatDau;
    private LocalDate thoiGianKetThuc;


    public HopDong() {
    }

    public HopDong(int hopDongId, int sinhVienId, int maPhong, LocalDate thoiGianBatDau, LocalDate thoiGianKetThuc) {
        this.hopDongId = hopDongId;
        this.sinhVienId = sinhVienId;
        this.maPhong = maPhong;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public HopDong(int sinhVienId, int maPhong, LocalDate thoiGianBatDau, LocalDate thoiGianKetThuc) {
        this.sinhVienId = sinhVienId;
        this.maPhong = maPhong;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
    }


    public int getHopDongId() {
        return hopDongId;
    }

    public void setHopDongId(int hopDongId) {
        this.hopDongId = hopDongId;
    }

    public int getSinhVienId() {
        return sinhVienId;
    }

    public void setSinhVienId(int sinhVienId) {
        this.sinhVienId = sinhVienId;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
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
}

