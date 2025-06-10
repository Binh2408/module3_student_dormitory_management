package org.example.quan_ly_ky_tuc_xa.entity.phong_va_thong_bao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class ThongBao {
    private String maThongBao;
    private String tieuDe;
    private String noiDung;
    private LocalDateTime thoiGianGui;

    public ThongBao() {}

    public ThongBao(String maThongBao, String tieuDe, String noiDung, LocalDateTime thoiGianGui) {
        this.maThongBao = maThongBao;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.thoiGianGui = thoiGianGui;
    }

    public String getMaThongBao() {
        return maThongBao;
    }

    public void setMaThongBao(String maThongBao) {
        this.maThongBao = maThongBao;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public LocalDateTime getThoiGianGui() {
        return thoiGianGui;
    }

    public void setThoiGianGui(LocalDateTime thoiGianGui) {
        this.thoiGianGui = thoiGianGui;
    }
}
