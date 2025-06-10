package org.example.quan_ly_ky_tuc_xa.repository;

import org.example.quan_ly_ky_tuc_xa.dto.HopDongDtoResponse;
import org.example.quan_ly_ky_tuc_xa.dto.contract.ThongTinHopDongDTO;
import org.example.quan_ly_ky_tuc_xa.entity.HopDong;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HopDongRepository implements IHopDongRepository {
    private static final String SELECT_ALL = "select hd.ma_hop_dong,sv.ten_sinh_vien,p.ten_phong,hd.thoi_gian_bat_dau," +
            "hd.thoi_gian_ket_thuc,timestampdiff(month,hd.thoi_gian_bat_dau,hd.thoi_gian_ket_thuc)*p.gia_moi_thang " +
            "as chi_phi_thue from hop_dong hd left\n" +
            "          join phong p on hd.ma_phong= p.ma_phong \n" +
            "\t\tjoin sinh_vien sv on sv.ma_sinh_vien=hd.ma_sinh_vien where hd.is_delete=0";

    private static final String INSERT_INTO = "insert into hop_dong " +
            "(ma_sinh_vien,ma_phong,thoi_gian_bat_dau,thoi_gian_ket_thuc) values(?,?,?,?)";


    private static final String UPDATE = " update hop_dong set ma_sinh_vien=?,ma_phong=?,thoi_gian_bat_dau=?" +
            ",thoi_gian_ket_thuc=? where ma_hop_dong=?";

    private static final String DELETE = "update hop_dong set is_delete=1 where ma_hop_dong=?";

    private static final String SEARCH = "call search_by_sinh_vien_and_ma_phong(?,?)";

    private static final String FIND_CONTRACT_BY_USERNAME = "select \n" +
            "    hd.ma_hop_dong, p.ten_phong,  lp.ten_loai_phong,  p.so_nguoi_do_da,  p.so_nguoi_hien_tai, \n" +
            "    p.gia_moi_thang as gia_moi_thang, ttsd.ten_trang_thai_su_dung, hd.thoi_gian_bat_dau, hd.thoi_gian_ket_thuc\n" +
            "from tai_khoan tk\n" +
            "join sinh_vien sv on sv.ma_tai_khoan = tk.ma_tai_khoan\n" +
            "join hop_dong hd on sv.ma_sinh_vien = hd.ma_sinh_vien\n" +
            "join phong p on p.ma_phong = hd.ma_phong\n" +
            "join loai_phong lp on p.ma_loai_phong = lp.ma_loai_phong\n" +
            "join trang_thai_su_dung ttsd on p.ma_trang_thai_su_dung = ttsd.ma_trang_thai_su_dung\n" +
            "where tk.user_name = ?\n" +
            "  and tk.is_delete = 0 \n" +
            "  and sv.is_delete = 0 \n" +
            "  and hd.is_delete = 0\n" +
            "LIMIT 1;";
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
                HopDongDtoResponse hopDongDtoResponse = new HopDongDtoResponse(hopDongId, tenSinhVien, tenPhong, thoiGianBatDau, thoiGianKetThuc, chiPhiThue);
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
            preparedStatement.setInt(1, id);
            int effectRow = preparedStatement.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e) {
            System.out.println("loi ket noi database");
        }
        return false;
    }

    @Override
    public List<HopDongDtoResponse> searchBySinhVienVaLoaiPhong(String tenSinhVienSearch, int maPhong) {
        List<HopDongDtoResponse> hopDongDtoResponseList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             CallableStatement callableStatement = connection.prepareCall(SEARCH)) {
            callableStatement.setString(1, tenSinhVienSearch);
            callableStatement.setInt(2, maPhong);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int hopDongId = resultSet.getInt("ma_hop_dong");
                String tenSinhVien = resultSet.getString("ten_sinh_vien");
                String tenPhong = resultSet.getString("ten_phong");
                LocalDate thoiGianBatDau = resultSet.getDate("thoi_gian_bat_dau").toLocalDate();
                LocalDate thoiGianKetThuc = resultSet.getDate("thoi_gian_ket_thuc").toLocalDate();
                int chiPhiThue = resultSet.getInt("chi_phi_thue");
                HopDongDtoResponse hopDongDtoResponse = new HopDongDtoResponse(hopDongId, tenSinhVien, tenPhong, thoiGianBatDau, thoiGianKetThuc, chiPhiThue);
                hopDongDtoResponseList.add(hopDongDtoResponse);
            }
        } catch (SQLException e) {
            System.out.println("loi ket noi database");
        }
        return hopDongDtoResponseList;
    }

    @Override
    public ThongTinHopDongDTO findContractByUsername(String username) {
        ThongTinHopDongDTO result = null;
        try (Connection conn = BaseRepository.getConnectDB();
             PreparedStatement ps = conn.prepareStatement(FIND_CONTRACT_BY_USERNAME)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = new ThongTinHopDongDTO(
                        rs.getInt("ma_hop_dong"),
                        rs.getString("ten_phong"),
                        rs.getString("ten_loai_phong"),
                        rs.getInt("so_nguoi_do_da"),
                        rs.getInt("so_nguoi_hien_tai"),
                        rs.getDouble("gia_moi_thang"),
                        rs.getString("ten_trang_thai_su_dung"),
                        rs.getTimestamp("thoi_gian_bat_dau").toLocalDateTime(),
                        rs.getTimestamp("thoi_gian_ket_thuc").toLocalDateTime()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
