package org.example.quan_ly_ky_tuc_xa.entity;

public class Phong {
    //    create table phong(
//            ma_phong int primary key auto_increment,
//            ten_phong varchar(50) not null unique,
//    ma_loai_phong int,
//    so_nguoi_do_da int,
//    so_nguoi_hien_tai int,
//    gia_moi_thang double check (gia_moi_thang>0),
//    ma_trang_thai_su_dung int,
//    is_delete tinyint default 0,
//    foreign key (ma_loai_phong) references loai_phong(ma_loai_phong),
//    foreign key (ma_trang_thai_su_dung) references trang_thai_su_dung(ma_trang_thai_su_dung)
//            );
    private int phongId;
    private String tenPhong;
    private int loaiPhongId;
    private int soNguoiToiDa;
    private int soNguoiHienTai;
    private int giaMoiThang;
    private int trangThaiSuDungId;

    public Phong() {
    }

    public Phong(int phongId, String tenPhong, int giaMoiThang) {
        this.phongId = phongId;
        this.tenPhong = tenPhong;
        this.giaMoiThang = giaMoiThang;
    }

    public Phong(int phongId, String tenPhong, int loaiPhongId, int soNguoiToiDa,
                 int soNguoiHienTai, int giaMoiThang, int trangThaiSuDungId) {
        this.phongId = phongId;
        this.tenPhong = tenPhong;
        this.loaiPhongId = loaiPhongId;
        this.soNguoiToiDa = soNguoiToiDa;
        this.soNguoiHienTai = soNguoiHienTai;
        this.giaMoiThang = giaMoiThang;
        this.trangThaiSuDungId = trangThaiSuDungId;
    }

    public int getPhongId() {
        return phongId;
    }

    public void setPhongId(int phongId) {
        this.phongId = phongId;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public int getLoaiPhongId() {
        return loaiPhongId;
    }

    public void setLoaiPhongId(int loaiPhongId) {
        this.loaiPhongId = loaiPhongId;
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

    public int getGiaMoiThang() {
        return giaMoiThang;
    }

    public void setGiaMoiThang(int giaMoiThang) {
        this.giaMoiThang = giaMoiThang;
    }

    public int getTrangThaiSuDungId() {
        return trangThaiSuDungId;
    }

    public void setTrangThaiSuDungId(int trangThaiSuDungId) {
        this.trangThaiSuDungId = trangThaiSuDungId;
    }
}
