package org.example.quan_ly_ky_tuc_xa.repository.phong_va_thong_bao;

import org.example.quan_ly_ky_tuc_xa.entity.phong_va_thong_bao.Phong;
import org.example.quan_ly_ky_tuc_xa.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepoPhong implements IRepoPhong{
    private final String SELECT_ALL = "select * from phong where is_delete = 0;";
    private final String INSERT_INTO = "insert into phong(ten_phong,ma_loai_phong,so_nguoi_do_da,so_nguoi_hien_tai,gia_moi_thang,ma_trang_thai_su_dung,is_delete) values(?,?,?,?,?,?,?);";
    private final String UPDATE_BY_ID = "update phong set ten_phong=?,ma_loai_phong=?,so_nguoi_do_da=?,so_nguoi_hien_tai=?,gia_moi_thang=?,ma_trang_thai_su_dung=?,is_delete=? where ma_phong=?;";
    private final String FIND_BY_ID = "select * from phong where ma_phong =?";
    private final String SEARCH_BY_NAME = "select p.ma_phong, p.ten_phong, p.ma_loai_phong, p.so_nguoi_do_da, \n" +
            "       p.so_nguoi_hien_tai, p.gia_moi_thang, p.ma_trang_thai_su_dung, p.is_delete,lp.ten_loai_phong,tt.ten_trang_thai_su_dung\n" +
            " from phong p\n" +
            " join loai_phong lp on lp.ma_loai_phong=p.ma_loai_phong\n" +
            " join trang_thai_su_dung tt on tt.ma_trang_thai_su_dung=p.ma_trang_thai_su_dung\n" +
            " where p.ten_phong like concat('%',?,'%');";
    private final String SEARCH_BY_NAME_LOAI_PHONG = "select  p.ma_phong, p.ten_phong, p.ma_loai_phong, p.so_nguoi_do_da, \n" +
            "       p.so_nguoi_hien_tai, p.gia_moi_thang, p.ma_trang_thai_su_dung, p.is_delete ,lp.ten_loai_phong,tt.ten_trang_thai_su_dung\n" +
            " from phong p\n" +
            " join loai_phong lp on lp.ma_loai_phong=p.ma_loai_phong\n" +
            " join trang_thai_su_dung tt on tt.ma_trang_thai_su_dung=p.ma_trang_thai_su_dung\n" +
            " where p.ten_phong like concat('%',?,'%')\n" +
            " and lp.ma_loai_phong=?;";
    private final String DELETE_BY_ID = "update phong set is_delete = 1 where ma_phong = ?;";

    @Override
    public List<Phong> findAll() {
        List<Phong> phongList = new ArrayList<>();
        // kết nối với DB ở đây
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ma_phong = resultSet.getInt("ma_phong");
                String ten_phong = resultSet.getString("ten_phong");
                int ma_loai_phong = resultSet.getInt("ma_loai_phong");
                int so_nguoi_toi_da = resultSet.getInt("so_nguoi_do_da");
                int so_nguoi_hien_tai = resultSet.getInt("so_nguoi_hien_tai");
                double gia_moi_thang = resultSet.getDouble("gia_moi_thang");
                int ma_trang_thai = resultSet.getInt("ma_trang_thai_su_dung");
                int is_delete = resultSet.getInt("is_delete");
                Phong phong = new Phong(ma_phong, ten_phong,ma_loai_phong, so_nguoi_toi_da, so_nguoi_hien_tai, gia_moi_thang,ma_trang_thai,is_delete);
                phongList.add(phong);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phongList;
    }

    @Override
    public boolean add(Phong phong) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);) {
            preparedStatement.setString(1, phong.getTenPhong());
            preparedStatement.setInt(2, phong.getLoaiPhong());
            preparedStatement.setInt(3, phong.getSoNguoiToiDa());
            preparedStatement.setInt(4, phong.getSoNguoiHienTai());
            preparedStatement.setDouble(5, phong.getGiaMoiThang());
            preparedStatement.setInt(6, phong.getTrangThai());
            preparedStatement.setInt(7, phong.getIsDelete());
            int effectRow = preparedStatement.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean edit(Phong phong) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);) {
            preparedStatement.setString(1, phong.getTenPhong());
            preparedStatement.setInt(2, phong.getLoaiPhong());
            preparedStatement.setInt(3, phong.getSoNguoiToiDa());
            preparedStatement.setInt(4, phong.getSoNguoiHienTai());
            preparedStatement.setDouble(5, phong.getGiaMoiThang());
            preparedStatement.setInt(6, phong.getTrangThai());
            preparedStatement.setInt(7, phong.getIsDelete());
            preparedStatement.setInt(8, phong.getIdPhong());
            int effectRow = preparedStatement.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(int id) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);) {
            preparedStatement.setInt(1, id);
            int effectRow = preparedStatement.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e) {
            System.out.println("lỗi kết nối db");
        }
        return false;
    }

    @Override
    public List<Phong> search(String name,int idPhong) {
        List<Phong> phongList=new ArrayList<>();
        if (idPhong !=0) {
            try (Connection connection = BaseRepository.getConnectDB();
                 PreparedStatement preparedStatemen = connection.prepareStatement(SEARCH_BY_NAME_LOAI_PHONG);) {
                preparedStatemen.setString(1,name);
                preparedStatemen.setInt(2,idPhong);
                ResultSet resultSet = preparedStatemen.executeQuery();
                while (resultSet.next()) {
                    int ma_phong = resultSet.getInt("ma_phong");
                    String ten_phong = resultSet.getString("ten_phong");
                    int ma_loai_phong = resultSet.getInt("ma_loai_phong");
                    int so_nguoi_toi_da = resultSet.getInt("so_nguoi_do_da");
                    int so_nguoi_hien_tai = resultSet.getInt("so_nguoi_hien_tai");
                    double gia_moi_thang = resultSet.getDouble("gia_moi_thang");
                    int ma_trang_thai = resultSet.getInt("ma_trang_thai_su_dung");
                    int is_delete = resultSet.getInt("is_delete");
                    Phong phong = new Phong(ma_phong, ten_phong,ma_loai_phong, so_nguoi_toi_da, so_nguoi_hien_tai, gia_moi_thang,ma_trang_thai,is_delete);
                    phongList.add(phong);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            try (Connection connection = BaseRepository.getConnectDB();
                 PreparedStatement preparedStatemen = connection.prepareStatement(SEARCH_BY_NAME);) {
                preparedStatemen.setString(1, name);
                ResultSet resultSet = preparedStatemen.executeQuery();
                while (resultSet.next()) {
                    int ma_phong = resultSet.getInt("ma_phong");
                    String ten_phong = resultSet.getString("ten_phong");
                    int ma_loai_phong = resultSet.getInt("ma_loai_phong");
                    int so_nguoi_toi_da = resultSet.getInt("so_nguoi_do_da");
                    int so_nguoi_hien_tai = resultSet.getInt("so_nguoi_hien_tai");
                    double gia_moi_thang = resultSet.getDouble("gia_moi_thang");
                    int ma_trang_thai = resultSet.getInt("ma_trang_thai_su_dung");
                    int is_delete = resultSet.getInt("is_delete");
                    Phong phong = new Phong(ma_phong, ten_phong,ma_loai_phong, so_nguoi_toi_da, so_nguoi_hien_tai, gia_moi_thang,ma_trang_thai,is_delete);
                    phongList.add(phong);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return phongList;
    }

    public Phong findById(int id) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int ma_phong = Integer.parseInt(resultSet.getString("ma_phong"));
                String ten_phong = resultSet.getString("ten_phong");
                int ma_loai_phong = Integer.parseInt(resultSet.getString("ma_loai_phong"));
                int so_nguoi_do_da = Integer.parseInt(resultSet.getString("so_nguoi_do_da"));
                int so_nguoi_hien_tai = Integer.parseInt(resultSet.getString("so_nguoi_hien_tai"));
                double gia_moi_thang = Double.parseDouble(resultSet.getString("gia_moi_thang"));
                int ma_trang_thai = Integer.parseInt(resultSet.getString("ma_trang_thai_su_dung"));
                int is_delete = Integer.parseInt(resultSet.getString("is_delete"));
                Phong phong = new Phong(ma_phong,ten_phong,ma_loai_phong,so_nguoi_do_da,so_nguoi_hien_tai,gia_moi_thang,ma_trang_thai,is_delete);
                return phong;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
