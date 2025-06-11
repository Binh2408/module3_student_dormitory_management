package org.example.quan_ly_ky_tuc_xa.repository;

import org.example.quan_ly_ky_tuc_xa.dto.BienBanViPhamDtoReponse;
import org.example.quan_ly_ky_tuc_xa.dto.HopDongDtoResponse;
import org.example.quan_ly_ky_tuc_xa.dto.contract.ThongTinHopDongDTO;
import org.example.quan_ly_ky_tuc_xa.entity.HopDong;

import java.util.List;

public interface IHopDongRepository {
    List<HopDongDtoResponse> findAll();

    boolean save(HopDong hopDong);

    boolean update(HopDong hopDong);

    boolean remove(int id);

    List<HopDongDtoResponse> searchBySinhVienVaLoaiPhong(String tenSinhVien, int maPhong);

    ThongTinHopDongDTO findContractByUsername(String username);
}
