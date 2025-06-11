package org.example.quan_ly_ky_tuc_xa.service;


import org.example.quan_ly_ky_tuc_xa.dto.BienBanViPhamDtoReponse;
import org.example.quan_ly_ky_tuc_xa.entity.BienBanViPham;
import org.example.quan_ly_ky_tuc_xa.repository.BienBanViPhamRepository;
import org.example.quan_ly_ky_tuc_xa.repository.IBienBanViPhamRepository;

import java.util.List;

public class BienBanViPhamService implements IBienBanViPhamService {
    private static final IBienBanViPhamRepository bienBanViPhamRepository = new BienBanViPhamRepository();


    @Override
    public List<BienBanViPhamDtoReponse> findAll() {
        return bienBanViPhamRepository.findAll();
    }

    @Override
    public boolean save(BienBanViPham bienBanViPham) {
        return bienBanViPhamRepository.save(bienBanViPham);

    }

    @Override
    public boolean update(BienBanViPham bienBanViPham) {
        return bienBanViPhamRepository.update(bienBanViPham);
    }

    @Override
    public boolean remove(int id) {
        return bienBanViPhamRepository.remove(id);
    }

    @Override
    public List<BienBanViPhamDtoReponse> searchBySinhVienVaLoaiViPham(String tenSinhVien, int maLoaiViPham) {
        return bienBanViPhamRepository.searchBySinhVienVaLoaiViPham(tenSinhVien, maLoaiViPham);
    }
}


