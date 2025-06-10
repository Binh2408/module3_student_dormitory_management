package org.example.quan_ly_ky_tuc_xa.service.room;

import org.example.quan_ly_ky_tuc_xa.dto.room.ThongTinPhongDTO;
import org.example.quan_ly_ky_tuc_xa.repository.room.IPhongRepository;
import org.example.quan_ly_ky_tuc_xa.repository.room.PhongRepository;

public class PhongService implements IPhongService{
    private static final IPhongRepository phongRepository = new PhongRepository();

    @Override
    public ThongTinPhongDTO findThongTinPhongByMaSinhVien(int maSinhVien) {
        return phongRepository.findThongTinPhongByMaSinhVien(maSinhVien);
    }
}
