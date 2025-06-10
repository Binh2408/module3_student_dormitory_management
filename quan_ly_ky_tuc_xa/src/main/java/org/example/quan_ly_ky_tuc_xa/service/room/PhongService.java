package org.example.quan_ly_ky_tuc_xa.service.room;

import org.example.quan_ly_ky_tuc_xa.dto.room.ThongTinPhongDTO;
import org.example.quan_ly_ky_tuc_xa.entity.phong_va_thong_bao.Phong;
import org.example.quan_ly_ky_tuc_xa.repository.room.IPhongRepository;
import org.example.quan_ly_ky_tuc_xa.repository.room.PhongRepository;

import java.util.List;

public class PhongService implements IPhongService {
    private static final IPhongRepository phongRepository = new PhongRepository();

    @Override
    public ThongTinPhongDTO findThongTinPhongByMaSinhVien(int maSinhVien) {
        return phongRepository.findThongTinPhongByMaSinhVien(maSinhVien);
    }

    @Override
    public List<Phong> getPhongHD() {
        return phongRepository.getPhongHD();
    }
}
