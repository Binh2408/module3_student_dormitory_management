package org.example.quan_ly_ky_tuc_xa.service;


import org.example.quan_ly_ky_tuc_xa.dto.HopDongDtoResponse;
import org.example.quan_ly_ky_tuc_xa.dto.contract.ThongTinHopDongDTO;
import org.example.quan_ly_ky_tuc_xa.entity.HopDong;
import org.example.quan_ly_ky_tuc_xa.repository.HopDongRepository;
import org.example.quan_ly_ky_tuc_xa.repository.IHopDongRepository;

import java.util.List;

public class HopDongService implements IHopDongService {
    private static final IHopDongRepository hopDongRepository = new HopDongRepository();


    @Override
    public List<HopDongDtoResponse> findAll() {
        return hopDongRepository.findAll();
    }

    @Override
    public boolean save(HopDong hopDong) {
        return hopDongRepository.save(hopDong);
    }

    @Override
    public boolean update(HopDong hopDong) {
        return hopDongRepository.update(hopDong);
    }

    @Override
    public boolean remove(int id) {
        return hopDongRepository.remove(id);
    }

    @Override
    public List<HopDongDtoResponse> searchBySinhVienVaLoaiPhong(String tenSinhVien, int maPhong) {
        return hopDongRepository.searchBySinhVienVaLoaiPhong(tenSinhVien, maPhong);
    }

    @Override
    public ThongTinHopDongDTO findContractByUsername(String username) {
        return hopDongRepository.findContractByUsername(username);
    }
}
