package org.example.quan_ly_ky_tuc_xa.service;


import org.example.quan_ly_ky_tuc_xa.dto.HopDongDtoResponse;
import org.example.quan_ly_ky_tuc_xa.dto.contract.ThongTinHopDongDTO;
import org.example.quan_ly_ky_tuc_xa.entity.HopDong;

import java.util.List;

public interface IHopDongService {
    List<HopDongDtoResponse> findAll();

    boolean save(HopDong hopDong);

    boolean update(HopDong hopDong);

    boolean remove(int id);

    default HopDongDtoResponse timKiemHopDongTheoId(int id) {
        for (HopDongDtoResponse hopDongDtoResponse : findAll()) {
            if (hopDongDtoResponse.getMaHopDong() == id) {
                return hopDongDtoResponse;
            }
        }
        return null;
    }
    List<HopDongDtoResponse> searchBySinhVienVaLoaiPhong(String tenSinhVien, int maPhong);

    ThongTinHopDongDTO findContractByUsername(String username);

}
