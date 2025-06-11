package org.example.quan_ly_ky_tuc_xa.repository.phong_va_thong_bao;

import org.example.quan_ly_ky_tuc_xa.entity.phong_va_thong_bao.TrangThaiPhong;
import org.example.quan_ly_ky_tuc_xa.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepoTrangThaiPhong implements IRepoTrangThaiPhong{
    private final String SELECT_ALL ="select * from trang_thai_su_dung;";
    @Override
    public List<TrangThaiPhong> findAll() {
        List<TrangThaiPhong> trangThaiPhongList = new ArrayList<>();
        // kết nối DB
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("ma_trang_thai_su_dung");
                String name = resultSet.getString("ten_trang_thai_su_dung");
                TrangThaiPhong trangThaiPhong = new TrangThaiPhong(id,name);
                trangThaiPhongList.add(trangThaiPhong);
            }
        } catch ( SQLException e) {
            throw new RuntimeException(e);
        }

        return trangThaiPhongList;
    }
}
