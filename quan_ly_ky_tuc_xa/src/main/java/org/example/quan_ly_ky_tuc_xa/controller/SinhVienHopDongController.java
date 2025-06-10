package org.example.quan_ly_ky_tuc_xa.controller;

import org.example.quan_ly_ky_tuc_xa.dto.contract.ThongTinHopDongDTO;
import org.example.quan_ly_ky_tuc_xa.entity.Account;
import org.example.quan_ly_ky_tuc_xa.service.HopDongService;
import org.example.quan_ly_ky_tuc_xa.service.IHopDongService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contracts")
public class SinhVienHopDongController extends HttpServlet {
    private final IHopDongService hopDongService = new HopDongService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // Lấy account từ session
        Account account = (Account) req.getSession().getAttribute("account");
        if (account == null) {
            resp.sendRedirect(req.getContextPath() + "/sign_in");
            return;
        }

        String username = account.getUserName();
        ThongTinHopDongDTO thongTinHopDong = hopDongService.findContractByUsername(username);

        if (thongTinHopDong != null) {
            req.setAttribute("thongTinHopDong", thongTinHopDong);
        } else {
            req.setAttribute("error", "Không tìm thấy hợp đồng");
        }

        req.getRequestDispatcher("/WEB-INF/contracts/hop_dong_sinh_vien.jsp").forward(req, resp);
    }
}

