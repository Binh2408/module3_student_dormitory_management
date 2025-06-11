package org.example.quan_ly_ky_tuc_xa.service;

import org.example.quan_ly_ky_tuc_xa.dto.SinhVienDtoResponse;
import org.example.quan_ly_ky_tuc_xa.dto.student.SinhVienDTO;

import java.util.List;

public interface ISinhVienService {
    List<SinhVienDtoResponse> findAll();
    SinhVienDTO findStudentProfileByUsernameAndPassword(String username);
    void updateProfile(int id, SinhVienDTO updatedStudent);
    List<SinhVienDtoResponse> getSVChuaTaoHD();
    SinhVienDtoResponse findSVByHDId(int hdID);

}
