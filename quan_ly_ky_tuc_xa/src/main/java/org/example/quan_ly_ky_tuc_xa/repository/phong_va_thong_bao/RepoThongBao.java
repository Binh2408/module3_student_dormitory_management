package org.example.quan_ly_ky_tuc_xa.repository.phong_va_thong_bao;

import org.example.quan_ly_ky_tuc_xa.entity.phong_va_thong_bao.ThongBao;
import org.example.quan_ly_ky_tuc_xa.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepoThongBao implements IRepoThongBao{
    private final String SELECT_ALL = "select * from thong_bao;";

    @Override
    public void sendNotification(ThongBao tb) {
        List<ThongBao> thongBaoList = new ArrayList<>();
        thongBaoList.add(tb);
    }

    @Override
    public List<ThongBao> findAll() {
        List<ThongBao> thongBaoList = new ArrayList<>();
        // kết nối với DB ở đây
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maThongBao = resultSet.getString("ma_thong_bao");
                String tieuDe = resultSet.getString("tieu_de");
                String noiDung = resultSet.getString("noi_dung");
                LocalDateTime thoiGianGui= resultSet.getTimestamp("thoi_gian_gui").toLocalDateTime();

                ThongBao tb = new ThongBao(maThongBao,tieuDe, noiDung,thoiGianGui);
                thongBaoList.add(tb);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return thongBaoList;
    }
}
