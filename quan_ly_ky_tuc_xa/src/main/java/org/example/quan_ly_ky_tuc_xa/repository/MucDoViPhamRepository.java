package org.example.quan_ly_ky_tuc_xa.repository;

import org.example.quan_ly_ky_tuc_xa.entity.LoaiViPham;
import org.example.quan_ly_ky_tuc_xa.entity.MucDoViPham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MucDoViPhamRepository implements IMucDoViPhamRepository {
    private static final String SELECT_ALL = "select * from muc_do_vi_pham;";

    @Override
    public List<MucDoViPham> findAll() {
        List<MucDoViPham> mucDoViPhamList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int maMucDoViPham = resultSet.getInt("ma_muc_do_vi_pham");
                String tenMucDoViPham = resultSet.getString("ten_muc_do_vi_pham");
                mucDoViPhamList.add(new MucDoViPham(maMucDoViPham, tenMucDoViPham));
            }
        } catch (SQLException e) {
            System.out.println("loi ket noi db");
        }
        return mucDoViPhamList;
    }
}
