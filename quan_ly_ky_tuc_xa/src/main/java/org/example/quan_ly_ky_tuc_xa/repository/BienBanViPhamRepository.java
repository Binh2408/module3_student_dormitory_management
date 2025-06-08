package org.example.quan_ly_ky_tuc_xa.repository;

import org.example.quan_ly_ky_tuc_xa.dto.BienBanViPhamDtoReponse;
import org.example.quan_ly_ky_tuc_xa.entity.BienBanViPham;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BienBanViPhamRepository implements IBienBanViPhamRepository {
    private static final String SELECT_ALL = "select bbvp.ma_bien_ban_vi_pham,sv.ten_sinh_vien,lvp.ten_vi_pham," +
            "mdvp.ten_muc_do_vi_pham,bbvp.thoi_gian_vi_pham\n" +
            " from bien_ban_vi_pham bbvp \n" +
            " join sinh_vien sv on bbvp.ma_sinh_vien_vi_pham=sv.ma_sinh_vien \n" +
            " join loai_vi_pham lvp on lvp.ma_vi_pham=bbvp.ma_loai_vi_pham \n" +
            " join muc_do_vi_pham mdvp on mdvp.ma_muc_do_vi_pham=bbvp.ma_muc_do_vi_pham";

    private static final String INSERT_INTO = "insert into bien_ban_vi_pham" +
            " (ma_sinh_vien_vi_pham,ma_loai_vi_pham,ma_muc_do_vi_pham,thoi_gian_vi_pham)value(\n" +
            " ?,?,?,?);";

    private static final String UPDATE = " update bien_ban_vi_pham set ma_sinh_vien_vi_pham=?," +
            "ma_loai_vi_pham=?,ma_muc_do_vi_pham=?,\n" +
            " thoi_gian_vi_pham=? where ma_bien_ban_vi_pham=?;";

    private static final String DELETE = "update bien_ban_vi_pham set is_delete =1 where ma_bien_ban_vi_pham =?;";

    @Override
    public List<BienBanViPhamDtoReponse> findAll() {
        List<BienBanViPhamDtoReponse> bienBanViPhamDtoReponseList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int maBienBanViPham = resultSet.getInt("ma_bien_ban_vi_pham");
                String tenSinhVien = resultSet.getString("ten_sinh_vien");
                String tenViPham = resultSet.getString("ten_vi_pham");
                String tenMucDoViPham = resultSet.getString("ten_muc_do_vi_pham");
                Date sqlThoiGianViPham = resultSet.getDate("thoi_gian_vi_pham");
                LocalDate thoiGianViPham = (sqlThoiGianViPham != null) ? sqlThoiGianViPham.toLocalDate() : null;
                BienBanViPhamDtoReponse bienBanViPhamDtoReponse = new BienBanViPhamDtoReponse(maBienBanViPham, tenSinhVien, tenViPham, tenMucDoViPham, thoiGianViPham);
                bienBanViPhamDtoReponseList.add(bienBanViPhamDtoReponse);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bienBanViPhamDtoReponseList;
    }

    @Override
    public boolean save(BienBanViPham bienBanViPham) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setInt(1, bienBanViPham.getMaSinhVienViPham());
            preparedStatement.setInt(2, bienBanViPham.getMaLoaiViPham());
            preparedStatement.setInt(3, bienBanViPham.getMaMucDoViPham());
            preparedStatement.setDate(4, Date.valueOf(bienBanViPham.getThoiGianViPham()));
            int effectRow = preparedStatement.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e) {
            System.out.println("loi ket noi db");
        }
        return false;
    }

    @Override
    public boolean update(BienBanViPham bienBanViPham) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setInt(1, bienBanViPham.getMaSinhVienViPham());
            preparedStatement.setInt(2, bienBanViPham.getMaLoaiViPham());
            preparedStatement.setInt(3, bienBanViPham.getMaMucDoViPham());
            preparedStatement.setDate(4, Date.valueOf(bienBanViPham.getThoiGianViPham()));
            preparedStatement.setInt(5, bienBanViPham.getMaBienBanViPham());
            int effectRow = preparedStatement.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e) {
            System.out.println("loi ket noi db");
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, id);
            int effectRow = preparedStatement.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e) {
            System.out.println("loi ket noi db");
        }
        return false;
    }

    @Override
    public List<BienBanViPhamDtoReponse> findByNameAndPrice(int price, String name) {
        return null;
    }
}
