package org.example.quan_ly_ky_tuc_xa.repository;


import org.example.quan_ly_ky_tuc_xa.dto.BienBanViPhamDtoReponse;
import org.example.quan_ly_ky_tuc_xa.dto.HopDongDtoResponse;
import org.example.quan_ly_ky_tuc_xa.entity.BienBanViPham;
import org.example.quan_ly_ky_tuc_xa.entity.HopDong;

import java.util.List;

public interface IBienBanViPhamRepository {
    List<BienBanViPhamDtoReponse> findAll();

    boolean save(BienBanViPham bienBanViPham);

    boolean update(BienBanViPham bienBanViPham);

    boolean remove(int id);

    List<BienBanViPhamDtoReponse> searchBySinhVienVaLoaiViPham();
}
