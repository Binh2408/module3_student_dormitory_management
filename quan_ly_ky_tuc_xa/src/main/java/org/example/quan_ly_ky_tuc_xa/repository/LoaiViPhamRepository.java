package org.example.quan_ly_ky_tuc_xa.repository;

import org.example.quan_ly_ky_tuc_xa.entity.LoaiViPham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiViPhamRepository implements ILoaiViPhamRepository {
    private static final String SELECT_ALL = "select * from loai_vi_pham";

    @Override
    public List<LoaiViPham> findAll() {
        List<LoaiViPham> loaiViPhamList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int loaiViPhamId = resultSet.getInt("ma_vi_pham");
                String tenViPham = resultSet.getString("ten_vi_pham");
                int mucPhat = resultSet.getInt("muc_phat");
                loaiViPhamList.add(new LoaiViPham(loaiViPhamId, tenViPham, mucPhat));
            }

        } catch (SQLException e) {
            System.out.println("loi ket noi db");
        }
        return loaiViPhamList;
    }
}
