package org.example.quan_ly_ky_tuc_xa.repository.admin;

import org.example.quan_ly_ky_tuc_xa.entity.Account;
import org.example.quan_ly_ky_tuc_xa.entity.SinhVien;

import java.util.List;


public interface IAccountRepository {
    // Tạo tài khoản và trả về ID tài khoản vừa tạo
    int createAccountAndReturnId(Account account);

    // Tạo sinh viên gắn với tài khoản
    boolean createSinhVien(SinhVien sv);

    // Cập nhật tài khoản
    boolean updateAccount(Account account);

    // Cập nhật sinh viên
    boolean updateSinhVien(SinhVien sv);

    // Xóa mềm tài khoản
    boolean softDeleteAccount(int maTaiKhoan);

    // Xóa mềm sinh viên theo mã tài khoản
    boolean softDeleteSinhVienByMaTaiKhoan(int maTaiKhoan);

    List<Account> getAllAccounts();

    Account getAccountById(int maTaiKhoan);

    SinhVien getSinhVienByMaTaiKhoan(int maTaiKhoan);
}