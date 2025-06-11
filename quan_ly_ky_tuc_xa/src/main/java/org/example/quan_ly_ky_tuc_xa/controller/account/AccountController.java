package org.example.quan_ly_ky_tuc_xa.controller.account;


import org.example.quan_ly_ky_tuc_xa.entity.Account;
import org.example.quan_ly_ky_tuc_xa.entity.SinhVien;
import org.example.quan_ly_ky_tuc_xa.service.admin.AccountService;
import org.example.quan_ly_ky_tuc_xa.service.admin.IAccountService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "AccountController", urlPatterns = {
        "/account/create", "/account/update", "/account/delete", "/account/list"
})
public class AccountController extends HttpServlet {

    private final IAccountService accountService = new AccountService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/account/list":
//                 Nếu bạn có danh sách sinh viên thì nên lấy ở đây
                List<Account> accountList = accountService.getAllAccounts();
                request.setAttribute("accountList", accountList);
                request.getRequestDispatcher("/WEB-INF/account/list.jsp").forward(request, response);
                break;
            case "/account/update":
                int maTaiKhoan = Integer.parseInt(request.getParameter("maTaiKhoan"));
                Account acc = accountService.getAccountById(maTaiKhoan);
                SinhVien sv = accountService.getSinhVienByMaTaiKhoan(maTaiKhoan);

                request.setAttribute("account", acc);
                request.setAttribute("sinhVien", sv);
                request.getRequestDispatcher("/WEB-INF/account/update.jsp").forward(request, response);
                break;            case "/account/create":
                request.getRequestDispatcher("/WEB-INF/account/create.jsp").forward(request, response);
                break;

            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        switch (path) {
            case "/account/create":
                handleCreate(request, response);
                break;
            case "/account/update":
                handleUpdate(request, response);
                break;
            case "/account/delete":
                handleDelete(request, response);
                break;
        }
    }

    private void handleCreate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Lấy dữ liệu từ form
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String tenSinhVien = request.getParameter("tenSinhVien");
        int maLop = Integer.parseInt(request.getParameter("maLop"));
        int maGioiTinh = Integer.parseInt(request.getParameter("maGioiTinh"));
        String soCMND = request.getParameter("soCMND");
        String email = request.getParameter("email");
        String soDienThoai = request.getParameter("soDienThoai");

        // Tạo đối tượng Account
        Account account = new Account();
        account.setUserName(userName);
        account.setPassword(password);
        account.setMaVaiTro(2); // mặc định sinh viên
        account.setNgayTaoTaiKhoan(LocalDateTime.now());
        account.setDelete(false);

        int maTaiKhoan = accountService.createAccountAndReturnId(account);

        if (maTaiKhoan > 0) {
            SinhVien sv = new SinhVien();
            sv.setMaTaiKhoan(maTaiKhoan);
            sv.setTenSinhVien(tenSinhVien);
            sv.setMaLop(maLop);
            sv.setMaGioiTinh(maGioiTinh);
            sv.setSoCMND(soCMND);
            sv.setEmail(email);
            sv.setSoDienThoai(soDienThoai);
            sv.setIsDelete(0);

            accountService.createSinhVien(sv);
            response.sendRedirect(request.getContextPath() + "/account/list?success=true");
        } else {
            request.setAttribute("error", "Không thể tạo tài khoản.");
            request.getRequestDispatcher("/WEB-INF/admin/create.jsp").forward(request, response);
        }
    }

    private void handleUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int maTaiKhoan = Integer.parseInt(request.getParameter("maTaiKhoan"));
        int maSinhVien = Integer.parseInt(request.getParameter("maSinhVien"));
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        Account account = new Account();
        account.setMaTaiKhoan(maTaiKhoan);
        account.setUserName(userName);
        account.setPassword(password);
        account.setMaVaiTro(2); // Sinh viên
        account.setDelete(false);

        accountService.updateAccount(account);

        String tenSinhVien = request.getParameter("tenSinhVien");
        int maLop = Integer.parseInt(request.getParameter("maLop"));
        int maGioiTinh = Integer.parseInt(request.getParameter("maGioiTinh"));
        String soCMND = request.getParameter("soCMND");
        String email = request.getParameter("email");
        String soDienThoai = request.getParameter("soDienThoai");

        SinhVien sv = new SinhVien();
        sv.setSinhVienId(maSinhVien);
        sv.setMaTaiKhoan(maTaiKhoan);
        sv.setTenSinhVien(tenSinhVien);
        sv.setMaLop(maLop);
        sv.setMaGioiTinh(maGioiTinh);
        sv.setSoCMND(soCMND);
        sv.setEmail(email);
        sv.setSoDienThoai(soDienThoai);
        sv.setIsDelete(0);

        accountService.updateSinhVien(sv);

        response.sendRedirect(request.getContextPath() + "/account/list?update=true");
    }

    private void handleDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int maTaiKhoan = Integer.parseInt(request.getParameter("maTaiKhoan"));
        accountService.softDeleteSinhVienByMaTaiKhoan(maTaiKhoan);
        accountService.softDeleteAccount(maTaiKhoan);
        response.sendRedirect(request.getContextPath() + "/account/list?delete=true");
    }
}
