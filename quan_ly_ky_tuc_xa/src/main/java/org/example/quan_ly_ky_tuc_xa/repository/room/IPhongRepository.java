package org.example.quan_ly_ky_tuc_xa.repository.room;

import org.example.quan_ly_ky_tuc_xa.dto.room.ThongTinPhongDTO;

public interface IPhongRepository {
    ThongTinPhongDTO findThongTinPhongByMaSinhVien(int maSinhVien);
}
