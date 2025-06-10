package org.example.quan_ly_ky_tuc_xa.repository.phong_va_thong_bao;

import org.example.quan_ly_ky_tuc_xa.entity.phong_va_thong_bao.LoaiPhong;
import org.example.quan_ly_ky_tuc_xa.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepoLoaiPhong implements IRepoLoaiPhong{
    private final String SELECT_ALL ="select * from loai_phong;";
    @Override
    public List<LoaiPhong> findAll() {
        List<LoaiPhong> loaiPhongList = new ArrayList<>();
        // kết nối DB
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("ma_loai_phong");
                String name = resultSet.getString("ten_loai_phong");
                LoaiPhong loaiPhong = new LoaiPhong(id,name);
                loaiPhongList.add(loaiPhong);
            }
        } catch ( SQLException e) {
            throw new RuntimeException(e);
        }

        return loaiPhongList;
    }
}
