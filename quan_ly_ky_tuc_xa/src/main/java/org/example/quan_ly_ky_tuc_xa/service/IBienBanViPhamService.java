package org.example.quan_ly_ky_tuc_xa.service;

import org.example.quan_ly_ky_tuc_xa.dto.BienBanViPhamDtoReponse;
import org.example.quan_ly_ky_tuc_xa.entity.BienBanViPham;

import java.util.List;

public interface IBienBanViPhamService {
    List<BienBanViPhamDtoReponse> findAll();

    boolean save(BienBanViPham bienBanViPham);

    boolean update(BienBanViPham bienBanViPham);

    boolean remove(int id);

}
