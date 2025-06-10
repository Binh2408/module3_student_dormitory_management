package org.example.quan_ly_ky_tuc_xa.repository.room;

import org.example.quan_ly_ky_tuc_xa.dto.room.ThongTinPhongDTO;
import org.example.quan_ly_ky_tuc_xa.entity.phong_va_thong_bao.Phong;

import java.util.List;

public interface IPhongRepository {
    ThongTinPhongDTO findThongTinPhongByMaSinhVien(int maSinhVien);

    List<Phong> getPhongHD();
}
