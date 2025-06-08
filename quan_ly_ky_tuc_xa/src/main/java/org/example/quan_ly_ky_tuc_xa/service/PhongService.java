package org.example.quan_ly_ky_tuc_xa.service;

import org.example.quan_ly_ky_tuc_xa.entity.Phong;
import org.example.quan_ly_ky_tuc_xa.repository.IPhongRepository;
import org.example.quan_ly_ky_tuc_xa.repository.PhongRepository;

import java.util.List;

public class PhongService implements IPhongService {
    private static final IPhongRepository phongRepository = new PhongRepository();

    @Override
    public List<Phong> findAll() {
        return phongRepository.findAll();
    }
}
