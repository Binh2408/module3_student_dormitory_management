package org.example.quan_ly_ky_tuc_xa.repository.phong_va_thong_bao;

import org.example.quan_ly_ky_tuc_xa.entity.phong_va_thong_bao.LoaiPhong;

import java.util.List;

public interface IRepoLoaiPhong {
    List<LoaiPhong> findAll();
}
