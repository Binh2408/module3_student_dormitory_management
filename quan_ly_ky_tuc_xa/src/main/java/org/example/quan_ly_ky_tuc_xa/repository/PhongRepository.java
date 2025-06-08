package org.example.quan_ly_ky_tuc_xa.repository;

import org.example.quan_ly_ky_tuc_xa.entity.Phong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhongRepository implements IPhongRepository {
    private static final String SELECT_ALL = "select ma_phong,ten_phong,gia_moi_thang from phong where so_nguoi_hien_tai <so_nguoi_toi_da";

    @Override
    public List<Phong> findAll() {
        List<Phong> phongList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int phongId = resultSet.getInt("ma_phong");
                String tenPhong = resultSet.getString("ten_phong");
                int giaMoiThang = resultSet.getInt("gia_moi_thang");
                phongList.add(new Phong(phongId, tenPhong,giaMoiThang));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phongList;
    }
}
