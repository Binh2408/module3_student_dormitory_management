package org.example.quan_ly_ky_tuc_xa.service.room;

import org.example.quan_ly_ky_tuc_xa.dto.room.ThongTinPhongDTO;

public interface IPhongService {
    ThongTinPhongDTO findThongTinPhongByMaSinhVien(int maSinhVien);

}
