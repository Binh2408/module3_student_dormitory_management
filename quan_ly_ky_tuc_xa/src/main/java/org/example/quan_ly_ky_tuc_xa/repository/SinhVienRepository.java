package org.example.quan_ly_ky_tuc_xa.repository;


import org.example.quan_ly_ky_tuc_xa.dto.SinhVienDtoResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SinhVienRepository implements ISinhVienRepository {
    private static final String SELECT_ALL = "select sv.ma_sinh_vien, sv.ten_sinh_vien,tk.user_name from sinh_vien sv left join tai_khoan tk on sv.ma_tai_khoan= tk.ma_tai_khoan;";

    @Override
    public List<SinhVienDtoResponse> findAll() {
        List<SinhVienDtoResponse> sinhVienList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int sinhVienId=resultSet.getInt("ma_sinh_vien");
                String tenSinhVien = resultSet.getString("ten_sinh_vien");
                String userName = resultSet.getString("user_name");
                SinhVienDtoResponse sinhVienDtoResponse = new SinhVienDtoResponse(sinhVienId,tenSinhVien, userName);
                sinhVienList.add(sinhVienDtoResponse);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sinhVienList;
    }
}
