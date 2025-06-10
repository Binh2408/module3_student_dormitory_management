package org.example.quan_ly_ky_tuc_xa.repository;

import org.example.quan_ly_ky_tuc_xa.dto.SinhVienDtoResponse;
import org.example.quan_ly_ky_tuc_xa.dto.student.SinhVienDTO;

import java.util.List;

public interface ISinhVienRepository {
    List<SinhVienDtoResponse> findAll();
    SinhVienDTO findStudentProfileByUsernameAndPassword(String username);
    void updateProfile(int id, SinhVienDTO updatedStudent);
}
