package org.example.quan_ly_ky_tuc_xa.entity;

public class LoaiViPham {
    private int loaiViPhamId;
    private String tenLoaiViPham;
    private int mucPhat;

    public LoaiViPham(int loaiViPhamId, String tenLoaiViPham, int mucPhat) {
        this.loaiViPhamId = loaiViPhamId;
        this.tenLoaiViPham = tenLoaiViPham;
        this.mucPhat = mucPhat;
    }

    public int getMucPhat() {
        return mucPhat;
    }

    public void setMucPhat(int mucPhat) {
        this.mucPhat = mucPhat;
    }

    public LoaiViPham(int loaiViPhamId, String tenLoaiViPham) {
        this.loaiViPhamId = loaiViPhamId;
        this.tenLoaiViPham = tenLoaiViPham;
    }

    public int getLoaiViPhamId() {
        return loaiViPhamId;
    }

    public void setLoaiViPhamId(int loaiViPhamId) {
        this.loaiViPhamId = loaiViPhamId;
    }

    public String getTenLoaiViPham() {
        return tenLoaiViPham;
    }

    public void setTenLoaiViPham(String tenLoaiViPham) {
        this.tenLoaiViPham = tenLoaiViPham;
    }
}
