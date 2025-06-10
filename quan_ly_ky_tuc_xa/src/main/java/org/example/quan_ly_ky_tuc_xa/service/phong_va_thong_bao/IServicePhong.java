package org.example.quan_ly_ky_tuc_xa.service.phong_va_thong_bao;

import org.example.quan_ly_ky_tuc_xa.entity.phong_va_thong_bao.Phong;

import java.util.List;

public interface IServicePhong {
    List<Phong> findAll();
    boolean add(Phong phong);
    boolean edit(Phong phong);
    boolean delete(int id);
    Phong search(int id);
    Phong findById(int id);
}
