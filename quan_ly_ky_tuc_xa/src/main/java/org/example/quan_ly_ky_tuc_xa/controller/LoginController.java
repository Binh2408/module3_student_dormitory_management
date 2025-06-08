package org.example.quan_ly_ky_tuc_xa.controller;

import org.example.quan_ly_ky_tuc_xa.entity.Account;
import org.example.quan_ly_ky_tuc_xa.repository.SignInRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sign_in")
public class LoginController extends HttpServlet {
    private final SignInRepository accountRepository = new SignInRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy Cookie username nếu có
        String savedUsername = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    savedUsername = cookie.getValue();
                    break;
                }
            }
        }

        // Gửi username đến JSP để điền sẵn (nếu có)
        req.setAttribute("savedUsername", savedUsername);
        req.getRequestDispatcher("/WEB-INF/sign_in/sign_in.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

        Account account = accountRepository.findByUsernameAndPassword(username,password);
        if (account != null) {
            // Lưu thông tin đăng nhập vào Session
            HttpSession session = req.getSession();
            session.setAttribute("account", account);
            session.setAttribute("success", "Đăng nhập thành công!");
            // Nếu có chọn "Ghi nhớ tôi", lưu username vào cookie
            if ("on".equals(remember)) {
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(7 * 24 * 60 * 60); // 7 ngày
                resp.addCookie(cookie);
            } else {
                // Xóa cookie nếu không chọn
                Cookie cookie = new Cookie("username", null);
                cookie.setMaxAge(0); // xóa ngay lập tức
                resp.addCookie(cookie);
            }

            int roleId = account.getMaVaiTro();
            if (roleId == 1) {
                resp.sendRedirect(req.getContextPath()+"/admin");
            } else if (roleId == 2) {
                resp.sendRedirect(req.getContextPath() + "/home_page.jsp");
            } else {
                // Vai trò không hợp lệ → đăng xuất
                session.invalidate();
                req.setAttribute("error", "Tài khoản không có quyền truy cập.");
                req.getRequestDispatcher("/WEB-INF/sign_in/sign_in.jsp").forward(req, resp);
            }

        } else {
            req.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng");
            req.setAttribute("savedUsername", username);
            req.getRequestDispatcher("/WEB-INF/sign_in/sign_in.jsp").forward(req, resp);
        }
    }
}
