package org.example.quan_ly_ky_tuc_xa.entity;

public class MucDoViPham {
    private int mucDoViPhamId;
    private String tenMucDoViPham;

    public MucDoViPham(int mucDoViPhamId, String tenMucDoViPham) {
        this.mucDoViPhamId = mucDoViPhamId;
        this.tenMucDoViPham = tenMucDoViPham;
    }

    public int getMucDoViPhamId() {
        return mucDoViPhamId;
    }

    public void setMucDoViPhamId(int mucDoViPhamId) {
        this.mucDoViPhamId = mucDoViPhamId;
    }

    public String getTenMucDoViPham() {
        return tenMucDoViPham;
    }

    public void setTenMucDoViPham(String tenMucDoViPham) {
        this.tenMucDoViPham = tenMucDoViPham;
    }
}
