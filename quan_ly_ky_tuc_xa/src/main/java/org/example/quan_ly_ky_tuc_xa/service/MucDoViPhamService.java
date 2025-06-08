package org.example.quan_ly_ky_tuc_xa.service;

import org.example.quan_ly_ky_tuc_xa.entity.MucDoViPham;
import org.example.quan_ly_ky_tuc_xa.repository.IMucDoViPhamRepository;
import org.example.quan_ly_ky_tuc_xa.repository.MucDoViPhamRepository;

import java.util.List;

public class MucDoViPhamService implements IMucDoViPhamService {
    private static final IMucDoViPhamRepository mucDoViPhamRepository = new MucDoViPhamRepository();

    @Override
    public List<MucDoViPham> findAll() {
        return mucDoViPhamRepository.findAll();
    }
}
