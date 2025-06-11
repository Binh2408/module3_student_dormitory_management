package org.example.quan_ly_ky_tuc_xa.service;

import org.example.quan_ly_ky_tuc_xa.dto.SinhVienDtoResponse;
import org.example.quan_ly_ky_tuc_xa.dto.student.SinhVienDTO;
import org.example.quan_ly_ky_tuc_xa.repository.ISinhVienRepository;
import org.example.quan_ly_ky_tuc_xa.repository.SinhVienRepository;

import java.util.List;

public class SinhVienService implements ISinhVienService {
    private static final ISinhVienRepository sinhVienRepository = new SinhVienRepository();

    @Override
    public List<SinhVienDtoResponse> findAll() {
        return sinhVienRepository.findAll();
    }

    @Override
    public SinhVienDTO findStudentProfileByUsernameAndPassword(String username) {
        return sinhVienRepository.findStudentProfileByUsernameAndPassword(username);
    }

    @Override
    public void updateProfile(int id, SinhVienDTO updatedStudent) {
        sinhVienRepository.updateProfile(id, updatedStudent);
    }

    @Override
    public List<SinhVienDtoResponse> getSVChuaTaoHD() {
        return sinhVienRepository.getSVChuaTaoHD();
    }

    @Override
    public SinhVienDtoResponse findSVByHDId(int hdID) {
        return sinhVienRepository.findSVByHDId(hdID);
    }
}
