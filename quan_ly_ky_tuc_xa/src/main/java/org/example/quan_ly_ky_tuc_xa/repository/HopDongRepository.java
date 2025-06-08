package org.example.quan_ly_ky_tuc_xa.repository;

import org.example.quan_ly_ky_tuc_xa.dto.HopDongDtoResponse;
import org.example.quan_ly_ky_tuc_xa.entity.HopDong;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HopDongRepository implements IHopDongRepository {
    private static final String SELECT_ALL = "select hd.ma_hop_dong,sv.ten_sinh_vien,p.ten_phong,hd.thoi_gian_bat_dau,hd.thoi_gian_ket_thuc,p.gia_moi_thang as chi_phi_thue from hop_dong hd left\n" +
            " join phong p on hd.ma_phong= p.ma_phong \n" +
            " join sinh_vien sv on sv.ma_sinh_vien=hd.ma_sinh_vien where hd.is_delete=0";

    private static final String INSERT_INTO = "insert into hop_dong " +
            "(ma_sinh_vien,ma_phong,thoi_gian_bat_dau,thoi_gian_ket_thuc) values(?,?,?,?)";


    private static final String UPDATE = " update hop_dong set ma_sinh_vien=?,ma_phong=?,thoi_gian_bat_dau=?" +
            ",thoi_gian_ket_thuc=? where ma_hop_dong=?";

    private static final String DELETE = "update hop_dong set is_delete=1 where ma_hop_dong=?";

    @Override
    public List<HopDongDtoResponse> findAll() {
        List<HopDongDtoResponse> hopDongDtoResponseList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int hopDongId = resultSet.getInt("ma_hop_dong");
                String tenSinhVien = resultSet.getString("ten_sinh_vien");
                String tenPhong = resultSet.getString("ten_phong");
                LocalDate thoiGianBatDau = resultSet.getDate("thoi_gian_bat_dau").toLocalDate();
                LocalDate thoiGianKetThuc = resultSet.getDate("thoi_gian_ket_thuc").toLocalDate();
                int chiPhiThue = resultSet.getInt("chi_phi_thue");
                HopDongDtoResponse hopDongDtoResponse = new HopDongDtoResponse(hopDongId,tenSinhVien, tenPhong, thoiGianBatDau, thoiGianKetThuc, chiPhiThue);
                hopDongDtoResponseList.add(hopDongDtoResponse);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hopDongDtoResponseList;
    }

    @Override
    public boolean save(HopDong hopDong) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setInt(1, hopDong.getSinhVienId());
            preparedStatement.setInt(2, hopDong.getMaPhong());
            preparedStatement.setDate(3, Date.valueOf(hopDong.getThoiGianBatDau()));
            preparedStatement.setDate(4, Date.valueOf(hopDong.getThoiGianKetThuc()));
            preparedStatement.setInt(5, hopDong.getHopDongId());
            int effectRow = preparedStatement.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e) {
            System.out.println("loi ket noi db");
        }
        return false;
    }

    @Override
    public boolean update(HopDong hopDong) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setInt(1, hopDong.getSinhVienId());
            preparedStatement.setInt(2, hopDong.getMaPhong());
            preparedStatement.setDate(3, Date.valueOf(hopDong.getThoiGianBatDau()));
            preparedStatement.setDate(4, Date.valueOf(hopDong.getThoiGianKetThuc()));
            preparedStatement.setInt(5, hopDong.getHopDongId());
            int effectRow = preparedStatement.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e) {
            System.out.println("loi ket noi database");
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1,id);
            int effectRow = preparedStatement.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e) {
            System.out.println("loi ket noi database");
        }
        return false;
    }

    @Override
    public List<HopDongDtoResponse> findByNameAndPrice(int price, String name) {
        return null;
    }
}
