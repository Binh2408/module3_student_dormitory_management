package org.example.quan_ly_ky_tuc_xa.repository.room;

import org.example.quan_ly_ky_tuc_xa.dto.room.ThongTinPhongDTO;
import org.example.quan_ly_ky_tuc_xa.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhongRepository implements IPhongRepository {
    private static final String FIND_ROOM_BY_STUDENT_ID = "select \n" +
            "    p.ten_phong, lp.ten_loai_phong, p.so_nguoi_do_da, p.so_nguoi_hien_tai, p.gia_moi_thang, ttsd.ten_trang_thai_su_dung,\n" +
            "    hd.thoi_gian_bat_dau, hd.thoi_gian_ket_thuc\n" +
            "from sinh_vien sv\n" +
            "join hop_dong hd on sv.ma_sinh_vien = hd.ma_sinh_vien\n" +
            "join phong p on p.ma_phong = hd.ma_phong\n" +
            "join loai_phong lp on p.ma_loai_phong = lp.ma_loai_phong\n" +
            "join trang_thai_su_dung ttsd on p.ma_trang_thai_su_dung = ttsd.ma_trang_thai_su_dung\n" +
            "where sv.ma_sinh_vien = ?\n" +
            "  and sv.is_delete = 0\n" +
            "  and hd.is_delete = 0\n" +
            "LIMIT 1;";

    @Override
    public ThongTinPhongDTO findThongTinPhongByMaSinhVien(int maSinhVien) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ROOM_BY_STUDENT_ID);) {
            preparedStatement.setInt(1, maSinhVien);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ThongTinPhongDTO thongTinPhongDTO = new ThongTinPhongDTO();
                thongTinPhongDTO.setTenPhong(resultSet.getString("ten_phong"));
                thongTinPhongDTO.setLoaiPhong(resultSet.getString("ten_loai_phong"));
                thongTinPhongDTO.setSoNguoiToiDa(resultSet.getInt("so_nguoi_do_da"));
                thongTinPhongDTO.setSoNguoiHienTai(resultSet.getInt("so_nguoi_hien_tai"));
                thongTinPhongDTO.setGiaMoiThang(resultSet.getDouble("gia_moi_thang"));
                thongTinPhongDTO.setTrangThai(resultSet.getString("ten_trang_thai_su_dung"));
                thongTinPhongDTO.setThoiGianBatDau(resultSet.getTimestamp("thoi_gian_bat_dau").toLocalDateTime());
                thongTinPhongDTO.setThoiGianKetThuc(resultSet.getTimestamp("thoi_gian_ket_thuc").toLocalDateTime());
                return thongTinPhongDTO;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
