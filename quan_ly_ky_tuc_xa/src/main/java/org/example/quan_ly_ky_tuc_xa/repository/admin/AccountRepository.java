package org.example.quan_ly_ky_tuc_xa.repository.admin;

import org.example.quan_ly_ky_tuc_xa.entity.Account;
import org.example.quan_ly_ky_tuc_xa.entity.SinhVien;
import org.example.quan_ly_ky_tuc_xa.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements IAccountRepository {

    @Override
    public int createAccountAndReturnId(Account account) {
        String sql = "INSERT INTO tai_khoan (user_name, password, ma_vai_tro, ngay_tao_tk, is_delete) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = BaseRepository.getConnectDB();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, account.getUserName());
            stmt.setString(2, account.getPassword());
            stmt.setInt(3, account.getMaVaiTro());
            stmt.setTimestamp(4, Timestamp.valueOf(account.getNgayTaoTaiKhoan()));
            stmt.setInt(5, account.isDelete() ? 1 : 0);

            int affected = stmt.executeUpdate();
            if (affected > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1); // Trả về ma_tai_khoan
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public boolean createSinhVien(SinhVien sv) {
        String sql = "INSERT INTO sinh_vien (ten_sinh_vien, ma_tai_khoan, ma_lop_hoc, ma_gioi_tinh, cmnd, email, so_dien_thoai, is_delete) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = BaseRepository.getConnectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, sv.getTenSinhVien());
            stmt.setInt(2, sv.getMaTaiKhoan());
            stmt.setInt(3, sv.getMaLop());
            stmt.setInt(4, sv.getMaGioiTinh());
            stmt.setString(5, sv.getSoCMND());
            stmt.setString(6, sv.getEmail());
            stmt.setString(7, sv.getSoDienThoai());
            stmt.setInt(8, sv.getIsDelete());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateAccount(Account account) {
        String sql = "UPDATE tai_khoan SET user_name = ?, password = ?, ma_vai_tro = ?, is_delete = ? WHERE ma_tai_khoan = ?";
        try (Connection conn = BaseRepository.getConnectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, account.getUserName());
            stmt.setString(2, account.getPassword());
            stmt.setInt(3, account.getMaVaiTro());
            stmt.setInt(4, account.isDelete() ? 1 : 0);
            stmt.setInt(5, account.getMaTaiKhoan());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateSinhVien(SinhVien sv) {
        String sql = "UPDATE sinh_vien SET ten_sinh_vien = ?, ma_lop_hoc = ?, ma_gioi_tinh = ?, cmnd = ?, email = ?, so_dien_thoai = ?, is_delete = ? WHERE ma_sinh_vien = ?";
        try (Connection conn = BaseRepository.getConnectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, sv.getTenSinhVien());
            stmt.setInt(2, sv.getMaLop());
            stmt.setInt(3, sv.getMaGioiTinh());
            stmt.setString(4, sv.getSoCMND());
            stmt.setString(5, sv.getEmail());
            stmt.setString(6, sv.getSoDienThoai());
            stmt.setInt(7, sv.getIsDelete());
            stmt.setInt(8, sv.getSinhVienId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean softDeleteAccount(int maTaiKhoan) {
        String sql = "UPDATE tai_khoan SET is_delete = 1 WHERE ma_tai_khoan = ?";
        try (Connection conn = BaseRepository.getConnectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maTaiKhoan);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean softDeleteSinhVienByMaTaiKhoan(int maTaiKhoan) {
        String sql = "UPDATE sinh_vien SET is_delete = 1 WHERE ma_tai_khoan = ?";
        try (Connection conn = BaseRepository.getConnectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maTaiKhoan);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT ma_tai_khoan, user_name, password, ma_vai_tro, ngay_tao_tk, is_delete FROM tai_khoan WHERE ma_vai_tro = 2 and is_delete = 0";

        try (Connection conn = BaseRepository.getConnectDB();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Account acc = new Account();
                acc.setMaTaiKhoan(rs.getInt("ma_tai_khoan"));
                acc.setUserName(rs.getString("user_name"));
                acc.setPassword(rs.getString("password"));
                acc.setMaVaiTro(rs.getInt("ma_vai_tro"));
                acc.setNgayTaoTaiKhoan(rs.getTimestamp("ngay_tao_tk").toLocalDateTime());
                acc.setDelete(rs.getBoolean("is_delete"));
                list.add(acc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    @Override
    public Account getAccountById(int maTaiKhoan) {
        String sql = "SELECT * FROM tai_khoan WHERE ma_tai_khoan = ?";
        try (Connection conn = BaseRepository.getConnectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maTaiKhoan);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Account acc = new Account();
                acc.setMaTaiKhoan(rs.getInt("ma_tai_khoan"));
                acc.setUserName(rs.getString("user_name"));
                acc.setPassword(rs.getString("password"));
                acc.setMaVaiTro(rs.getInt("ma_vai_tro"));
                acc.setNgayTaoTaiKhoan(rs.getTimestamp("ngay_tao_tk").toLocalDateTime());
                acc.setDelete(rs.getBoolean("is_delete"));
                return acc;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SinhVien getSinhVienByMaTaiKhoan(int maTaiKhoan) {
        String sql = "SELECT * FROM sinh_vien WHERE ma_tai_khoan = ?";
        try (Connection conn = BaseRepository.getConnectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maTaiKhoan);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setSinhVienId(rs.getInt("ma_sinh_vien"));
                sv.setMaTaiKhoan(rs.getInt("ma_tai_khoan"));
                sv.setTenSinhVien(rs.getString("ten_sinh_vien"));
                sv.setMaLop(rs.getInt("ma_lop_hoc"));
                sv.setMaGioiTinh(rs.getInt("ma_gioi_tinh"));
                sv.setSoCMND(rs.getString("cmnd"));
                sv.setEmail(rs.getString("email"));
                sv.setSoDienThoai(rs.getString("so_dien_thoai"));
                sv.setIsDelete(rs.getInt("is_delete"));
                return sv;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
