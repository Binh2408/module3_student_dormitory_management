package org.example.quan_ly_ky_tuc_xa.service;

import org.example.quan_ly_ky_tuc_xa.entity.LoaiViPham;
import org.example.quan_ly_ky_tuc_xa.repository.ILoaiViPhamRepository;
import org.example.quan_ly_ky_tuc_xa.repository.LoaiViPhamRepository;

import java.util.List;

public class LoaiViPhamService implements ILoaiViPhamService {
    private static final ILoaiViPhamRepository loaiViPhamRepository = new LoaiViPhamRepository();

    @Override
    public List<LoaiViPham> findAll() {
        return loaiViPhamRepository.findAll();
    }
}
