package org.example.quan_ly_ky_tuc_xa.service.admin;

import org.example.quan_ly_ky_tuc_xa.entity.Account;
import org.example.quan_ly_ky_tuc_xa.entity.SinhVien;
import org.example.quan_ly_ky_tuc_xa.repository.admin.AccountRepository;
import org.example.quan_ly_ky_tuc_xa.repository.admin.IAccountRepository;

import java.util.List;

public class AccountService implements IAccountService {
    private static final IAccountRepository accountRepository = new AccountRepository();
    @Override
    public int createAccountAndReturnId(Account account) {
        return accountRepository.createAccountAndReturnId(account);
    }

    @Override
    public boolean createSinhVien(SinhVien sv) {
        return accountRepository.createSinhVien(sv);
    }

    @Override
    public boolean updateAccount(Account account) {
        return accountRepository.updateAccount(account);
    }

    @Override
    public boolean updateSinhVien(SinhVien sv) {
        return accountRepository.updateSinhVien(sv);
    }

    @Override
    public boolean softDeleteAccount(int maTaiKhoan) {
        return accountRepository.softDeleteAccount(maTaiKhoan);
    }

    @Override
    public boolean softDeleteSinhVienByMaTaiKhoan(int maTaiKhoan) {
        return accountRepository.softDeleteSinhVienByMaTaiKhoan(maTaiKhoan);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }

    @Override
    public Account getAccountById(int maTaiKhoan) {
        return accountRepository.getAccountById(maTaiKhoan);
    }

    @Override
    public SinhVien getSinhVienByMaTaiKhoan(int maTaiKhoan) {
        return accountRepository.getSinhVienByMaTaiKhoan(maTaiKhoan);
    }
}
