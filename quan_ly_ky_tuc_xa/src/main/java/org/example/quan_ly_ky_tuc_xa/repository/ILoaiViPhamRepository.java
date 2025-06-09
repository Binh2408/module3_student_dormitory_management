package org.example.quan_ly_ky_tuc_xa.repository;


import org.example.quan_ly_ky_tuc_xa.entity.LoaiViPham;

import java.util.List;

public interface ILoaiViPhamRepository {
    List<LoaiViPham> findAll();
}
