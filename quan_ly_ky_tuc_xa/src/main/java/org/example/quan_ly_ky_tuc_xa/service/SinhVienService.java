package org.example.quan_ly_ky_tuc_xa.service;

import org.example.quan_ly_ky_tuc_xa.dto.SinhVienDtoResponse;
import org.example.quan_ly_ky_tuc_xa.repository.ISinhVienRepository;
import org.example.quan_ly_ky_tuc_xa.repository.SinhVienRepository;
import java.util.List;

public class SinhVienService implements ISinhVienService {
    private static final ISinhVienRepository sinhVienRepository = new SinhVienRepository();

    @Override
    public List<SinhVienDtoResponse> findAll() {
        return sinhVienRepository.findAll();
    }
}
