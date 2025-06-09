package org.example.quan_ly_ky_tuc_xa.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThongKeDoanhThuRepository implements IThongKeDoanhThuRepository {

    private static final String DOANH_THU_THEO_QUY = "select month(hd.thoi_gian_bat_dau)as thang,sum(p.gia_moi_thang) " +
            "as tong  from hop_dong hd left join phong p on hd.ma_phong=p.ma_phong group by thang";


    @Override
    public List<Integer> getDoanhThuTheoQuy() {
        List<Integer> doanhThu = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            doanhThu.add(0);
        }
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(DOANH_THU_THEO_QUY);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int thang = resultSet.getInt("thang");
                int tong = resultSet.getInt("tong");
                int quy = (thang - 1) / 3;
                doanhThu.set(quy, doanhThu.get(quy) + tong);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return doanhThu;
    }
}
