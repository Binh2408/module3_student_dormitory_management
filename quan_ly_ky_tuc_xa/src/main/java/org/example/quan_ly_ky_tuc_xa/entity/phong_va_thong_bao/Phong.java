package org.example.quan_ly_ky_tuc_xa.entity.phong_va_thong_bao;

public class Phong {
    private int idPhong;
    private String tenPhong;
    private int loaiPhong;
    private int soNguoiToiDa;
    private int soNguoiHienTai;
    private double giaMoiThang;
    private int trangThai;
    private int isDelete = 0;

    public Phong(int idPhong, String tenPhong, int loaiPhong, int soNguoiToiDa, int soNguoiHienTai, double giaMoiThang, int trangThai, int isDelete) {
        this.idPhong = idPhong;
        this.tenPhong = tenPhong;
        this.loaiPhong = loaiPhong;
        this.soNguoiToiDa = soNguoiToiDa;
        this.soNguoiHienTai = soNguoiHienTai;
        this.giaMoiThang = giaMoiThang;
        this.trangThai = trangThai;
        this.isDelete = isDelete;
    }

    public Phong(int idPhong, String tenPhong, double giaMoiThang) {
        this.idPhong = idPhong;
        this.tenPhong = tenPhong;
        this.giaMoiThang = giaMoiThang;
    }

    public Phong(String tenPhong, int loaiPhong, int soNguoiToiDa, int soNguoiHienTai, double giaMoiThang, int trangThai) {

        this.tenPhong = tenPhong;
        this.loaiPhong = loaiPhong;
        this.soNguoiToiDa = soNguoiToiDa;
        this.soNguoiHienTai = soNguoiHienTai;
        this.giaMoiThang = giaMoiThang;
        this.trangThai = trangThai;
    }


    public int getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(int loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
