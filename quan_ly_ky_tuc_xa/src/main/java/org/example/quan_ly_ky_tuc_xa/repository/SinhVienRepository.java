package org.example.quan_ly_ky_tuc_xa.repository;


import org.example.quan_ly_ky_tuc_xa.dto.SinhVienDtoResponse;
import org.example.quan_ly_ky_tuc_xa.dto.student.SinhVienDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SinhVienRepository implements ISinhVienRepository {
    private static final String SELECT_ALL = "select sv.ma_sinh_vien, sv.ten_sinh_vien,tk.user_name ,sv.cmnd ,sv.email from sinh_vien sv left join tai_khoan tk on sv.ma_tai_khoan= tk.ma_tai_khoan;";
    private static final String FIND_STUDENT_PROFILE = "select \n" +
            "    sv.ma_sinh_vien, sv.ten_sinh_vien, sv.cmnd, sv.so_dien_thoai,\n" +
            "    sv.email, gt.ten_gioi_tinh, lh.ten_lop_hoc\n" +
            "from \n" +
            "    tai_khoan tk\n" +
            "join\n" +
            "    sinh_vien sv on sv.ma_tai_khoan = tk.ma_tai_khoan\n" +
            "left join \n" +
            "    gioi_tinh gt on sv.ma_gioi_tinh = gt.ma_gioi_tinh\n" +
            "left join\n" +
            "    lop_hoc lh on sv.ma_lop_hoc = lh.ma_lop_hoc\n" +
            "where \n" +
            "    tk.user_name = ? \n" +
            "    and tk.is_delete = 0\n" +
            "    and sv.is_delete = 0;\n";
    private static final String UPDATE_STUDENT_PROFILE = "UPDATE sinh_vien SET ten_sinh_vien = ?, cmnd = ?, so_dien_thoai = ?, email = ? WHERE ma_sinh_vien = ? AND is_delete = 0";

    private static final String SELECT_SV_CHUA_TAO_HD = "select sv.ma_sinh_vien, sv.ten_sinh_vien ,sv.cmnd ,sv.email,tk.user_name\n" +
            " from sinh_vien sv \n" +
            " left join tai_khoan tk \n" +
            " on sv.ma_tai_khoan= tk.ma_tai_khoan\n" +
            " where ma_sinh_vien not in (\n" +
            " select distinct sv.ma_sinh_vien from sinh_vien sv join hop_dong hd on sv.ma_sinh_vien =hd.ma_sinh_vien where hd.is_delete=0\n" +
            " );";

    private static final String FIND_SV_BY_ID = "call search_sinh_vien_by_ma_hop_dong(?)";

    @Override
    public List<SinhVienDtoResponse> findAll() {
        List<org.example.quan_ly_ky_tuc_xa.dto.SinhVienDtoResponse> sinhVienList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int sinhVienId = resultSet.getInt("ma_sinh_vien");
                String tenSinhVien = resultSet.getString("ten_sinh_vien");
                String userName = resultSet.getString("user_name");
                String cmnd = resultSet.getString("cmnd");
                String email = resultSet.getString("email");
                org.example.quan_ly_ky_tuc_xa.dto.SinhVienDtoResponse sinhVienDtoResponse = new org.example.quan_ly_ky_tuc_xa.dto.SinhVienDtoResponse(sinhVienId, tenSinhVien, userName, cmnd, email);
                sinhVienList.add(sinhVienDtoResponse);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sinhVienList;
    }

    @Override
    public SinhVienDTO findStudentProfileByUsernameAndPassword(String username) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_STUDENT_PROFILE)) {

            preparedStatement.setString(1, username);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new SinhVienDTO(
                        rs.getString("ma_sinh_vien"),
                        rs.getString("ten_sinh_vien"),
                        rs.getString("cmnd"),
                        rs.getString("so_dien_thoai"),
                        rs.getString("email"),
                        rs.getString("ten_gioi_tinh"),
                        rs.getString("ten_lop_hoc")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateProfile(int id, SinhVienDTO updatedStudent) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_PROFILE)) {
            preparedStatement.setString(1, updatedStudent.getTenSinhVien());
            preparedStatement.setString(2, updatedStudent.getSoCMND());
            preparedStatement.setString(3, updatedStudent.getSoDienThoai());
            preparedStatement.setString(4, updatedStudent.getEmail());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SinhVienDtoResponse> getSVChuaTaoHD() {
        List<org.example.quan_ly_ky_tuc_xa.dto.SinhVienDtoResponse> sinhVienList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SV_CHUA_TAO_HD);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int sinhVienId = resultSet.getInt("ma_sinh_vien");
                String tenSinhVien = resultSet.getString("ten_sinh_vien");
                String userName = resultSet.getString("user_name");
                String cmnd = resultSet.getString("cmnd");
                String email = resultSet.getString("email");
                org.example.quan_ly_ky_tuc_xa.dto.SinhVienDtoResponse sinhVienDtoResponse =
                        new org.example.quan_ly_ky_tuc_xa.dto.SinhVienDtoResponse(sinhVienId, tenSinhVien, userName, cmnd, email);
                sinhVienList.add(sinhVienDtoResponse);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sinhVienList;
    }

    @Override
    public SinhVienDtoResponse findSVByHDId(int hdID) {
        SinhVienDtoResponse sinhVienDtoResponse = new SinhVienDtoResponse();
        try (Connection connection = BaseRepository.getConnectDB();
             CallableStatement callableStatement = connection.prepareCall(FIND_SV_BY_ID)) {
            callableStatement.setInt(1, hdID);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int sinhVienId = resultSet.getInt("ma_sinh_vien");
                String tenSinhVien = resultSet.getString("ten_sinh_vien");
                String userName = resultSet.getString("user_name");
                String cmnd = resultSet.getString("cmnd");
                String email = resultSet.getString("email");
                sinhVienDtoResponse.setSinhVienId(sinhVienId);
                sinhVienDtoResponse.setTenSinhVien(tenSinhVien);
                sinhVienDtoResponse.setUserName(userName);
                sinhVienDtoResponse.setCmnd(cmnd);
                sinhVienDtoResponse.setEmail(email);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sinhVienDtoResponse;
    }

}
