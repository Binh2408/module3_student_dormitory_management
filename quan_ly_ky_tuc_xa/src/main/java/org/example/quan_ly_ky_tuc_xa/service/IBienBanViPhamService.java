package org.example.quan_ly_ky_tuc_xa.service;

import org.example.quan_ly_ky_tuc_xa.dto.BienBanViPhamDtoReponse;
import org.example.quan_ly_ky_tuc_xa.entity.BienBanViPham;

import java.util.List;

public interface IBienBanViPhamService {
    List<BienBanViPhamDtoReponse> findAll();

    boolean save(BienBanViPham bienBanViPham);

    boolean update(BienBanViPham bienBanViPham);

    boolean remove(int id);

    default BienBanViPhamDtoReponse findById(int id) {
        for (BienBanViPhamDtoReponse bienBanViPhamDtoReponse : findAll()) {
            if (bienBanViPhamDtoReponse.getBienBanId() == id) {
                return bienBanViPhamDtoReponse;
            }
        }
        return null;
    }
    List<BienBanViPhamDtoReponse> searchBySinhVienVaLoaiViPham(String tenSinhVien,int maLoaiViPham);

}
