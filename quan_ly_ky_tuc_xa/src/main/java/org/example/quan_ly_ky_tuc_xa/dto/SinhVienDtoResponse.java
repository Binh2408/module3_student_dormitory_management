package org.example.quan_ly_ky_tuc_xa.dto;

public class SinhVienDtoResponse {
    private int sinhVienId;
    private String tenSinhVien;
    private String userName;

    public SinhVienDtoResponse(String tenSinhVien, String userName) {
        this.tenSinhVien = tenSinhVien;
        this.userName = userName;
    }

    public SinhVienDtoResponse(int sinhVienId, String tenSinhVien, String userName) {
        this.sinhVienId = sinhVienId;
        this.tenSinhVien = tenSinhVien;
        this.userName = userName;
    }


    public int getSinhVienId() {
        return sinhVienId;
    }

    public void setSinhVienId(int sinhVienId) {
        this.sinhVienId = sinhVienId;
    }

    public SinhVienDtoResponse() {
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
