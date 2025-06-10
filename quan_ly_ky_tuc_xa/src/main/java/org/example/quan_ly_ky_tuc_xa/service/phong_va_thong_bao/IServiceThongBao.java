package org.example.quan_ly_ky_tuc_xa.service.phong_va_thong_bao;

import org.example.quan_ly_ky_tuc_xa.entity.phong_va_thong_bao.ThongBao;

import java.util.List;

public interface IServiceThongBao {
    void sendNotification(ThongBao tb);
    List<ThongBao> findAll();
}
