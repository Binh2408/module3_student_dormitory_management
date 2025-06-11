package org.example.quan_ly_ky_tuc_xa.controller;

import org.example.quan_ly_ky_tuc_xa.dto.room.ThongTinPhongDTO;
import org.example.quan_ly_ky_tuc_xa.dto.student.SinhVienDTO;
import org.example.quan_ly_ky_tuc_xa.repository.SinhVienRepository;
import org.example.quan_ly_ky_tuc_xa.service.ISinhVienService;
import org.example.quan_ly_ky_tuc_xa.service.SinhVienService;
import org.example.quan_ly_ky_tuc_xa.service.room.IPhongService;
import org.example.quan_ly_ky_tuc_xa.service.room.PhongService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/students")
public class StudentController extends HttpServlet {
    private final ISinhVienService sinhVienService = new SinhVienService();
    private final IPhongService phongService = new PhongService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy username đã đăng nhập từ session
        HttpSession session = req.getSession(false);
        String username = (session != null) ? (String) session.getAttribute("loggedUsername") : null;
        if (username == null) {
            resp.sendRedirect("login.jsp"); // chưa đăng nhập thì quay về login
            return;
        }
        // Gọi repo lấy thông tin sinh viên từ username
        SinhVienDTO sinhVienDTO = sinhVienService.findStudentProfileByUsernameAndPassword(username);
        if (sinhVienDTO == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Không tìm thấy thông tin sinh viên.");
            return;
        }
        // Gửi thông tin sang JSP để hiển thị
        req.setAttribute("studentProfile", sinhVienDTO);
        ThongTinPhongDTO phongDTO = phongService.findThongTinPhongByMaSinhVien(Integer.parseInt(sinhVienDTO.getMaSinhVien()));
        req.setAttribute("phongDTO", phongDTO);
        req.getRequestDispatcher("/WEB-INF/profile/thong_tin_ca_nhan.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy thông tin từ form gửi lên
        int maSinhVien = Integer.parseInt(req.getParameter("maSinhVien"));
        String tenSinhVien = req.getParameter("tenSinhVien");
        String email = req.getParameter("email");
        String soDienThoai = req.getParameter("soDienThoai");
        String soCMND = req.getParameter("soCMND");

        // Tạo DTO để truyền sang service
        SinhVienDTO updatedStudent = new SinhVienDTO();
        updatedStudent.setMaSinhVien(String.valueOf(maSinhVien));
        updatedStudent.setTenSinhVien(tenSinhVien);
        updatedStudent.setEmail(email);
        updatedStudent.setSoDienThoai(soDienThoai);
        updatedStudent.setSoCMND(soCMND);

        // Gọi service cập nhật
        sinhVienService.updateProfile(maSinhVien, updatedStudent);
        // Đặt thông báo thành công vào session
        HttpSession session = req.getSession();
        session.setAttribute("successMessage", "Cập nhật thông tin thành công!");
        // Redirect lại trang profile để hiển thị dữ liệu mới
        resp.sendRedirect("students");
    }
}
