package org.example.quan_ly_ky_tuc_xa.dto;

public class SinhVienDtoResponse {
    private int sinhVienId;
    private String tenSinhVien;
    private String userName;
    private String cmnd;
    private String email;


    public SinhVienDtoResponse(int sinhVienId, String tenSinhVien, String userName, String cmnd, String email) {
        this.sinhVienId = sinhVienId;
        this.tenSinhVien = tenSinhVien;
        this.userName = userName;
        this.cmnd = cmnd;
        this.email = email;
    }

    public SinhVienDtoResponse(int sinhVienId, String tenSinhVien, String userName) {
        this.sinhVienId = sinhVienId;
        this.tenSinhVien = tenSinhVien;
        this.userName = userName;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SinhVienDtoResponse(String tenSinhVien, String userName) {
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
