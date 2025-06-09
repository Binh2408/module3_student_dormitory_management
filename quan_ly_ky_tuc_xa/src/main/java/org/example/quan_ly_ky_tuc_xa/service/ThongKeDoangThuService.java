package org.example.quan_ly_ky_tuc_xa.service;


import org.example.quan_ly_ky_tuc_xa.repository.IThongKeDoanhThuRepository;
import org.example.quan_ly_ky_tuc_xa.repository.ThongKeDoanhThuRepository;

import java.util.List;

public class ThongKeDoangThuService implements IThongKeDoangThuService {
    private static final IThongKeDoanhThuRepository thongKeDoanhThuRepository = new ThongKeDoanhThuRepository();

    @Override
    public List<Integer> getDoanhThuTheoQuy() {
        return thongKeDoanhThuRepository.getDoanhThuTheoQuy();
    }
}
