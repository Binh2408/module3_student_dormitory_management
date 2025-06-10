package org.example.quan_ly_ky_tuc_xa.controller;


import org.example.quan_ly_ky_tuc_xa.dto.BienBanViPhamDtoReponse;
import org.example.quan_ly_ky_tuc_xa.dto.SinhVienDtoResponse;
import org.example.quan_ly_ky_tuc_xa.entity.BienBanViPham;
import org.example.quan_ly_ky_tuc_xa.entity.LoaiViPham;
import org.example.quan_ly_ky_tuc_xa.entity.MucDoViPham;
import org.example.quan_ly_ky_tuc_xa.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(urlPatterns = "/violationRecord")
public class BienBanViPhamController extends HttpServlet {
    private static final IBienBanViPhamService bienBanViPhamService = new BienBanViPhamService();
    private static final ISinhVienService sinhVienService = new SinhVienService();
    private static final ILoaiViPhamService loaiViPhamService = new LoaiViPhamService();
    private static final IMucDoViPhamService mucDoViPhamService = new MucDoViPhamService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        String message = req.getParameter("message");
        String type = req.getParameter("type"); // success, danger, warning, info
        if (message != null && !message.isEmpty()) {
            req.setAttribute("message", message);
            req.setAttribute("type", type != null ? type : "info");
        }
        switch (action) {
            case "add":
                showFormCreate(req, resp);
                break;
            case "edit":
                showFormEdit(req, resp);
                break;
            case "delete":
                break;
            default:
                showList(req, resp);
        }
    }

    private void deleteBienBan(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int deleteBienBanId = Integer.parseInt(req.getParameter("deleteContractId"));
        boolean isDeleteSuccess = bienBanViPhamService.remove(deleteBienBanId);
        String mess = "delete success";
        if (!isDeleteSuccess) {
            mess = "not delete success";
        }
        resp.sendRedirect("/violationRecord?message=" + mess);
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        BienBanViPhamDtoReponse bienBanViPhamDtoReponse = bienBanViPhamService.findById(id);
        if (bienBanViPhamDtoReponse != null) {
            List<SinhVienDtoResponse> sinhVienDtoResponseList = sinhVienService.findAll();
            List<LoaiViPham> loaiViPhamList = loaiViPhamService.findAll();
            List<MucDoViPham> mucDoViPhamList = mucDoViPhamService.findAll();
            req.setAttribute("loaiViPhamList", loaiViPhamList);
            req.setAttribute("mucDoViPhamList", mucDoViPhamList);
            req.setAttribute("sinhVienDtoResponseList", sinhVienDtoResponseList);
            req.setAttribute("bienBanViPhamDtoReponse", bienBanViPhamDtoReponse);
            req.getRequestDispatcher("/WEB-INF/violation_record/update.jsp").forward(req, resp);
        }
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<SinhVienDtoResponse> sinhVienDtoResponseList = sinhVienService.findAll();
        List<LoaiViPham> loaiViPhamList = loaiViPhamService.findAll();
        List<MucDoViPham> mucDoViPhamList = mucDoViPhamService.findAll();
        req.setAttribute("loaiViPhamList", loaiViPhamList);
        req.setAttribute("mucDoViPhamList", mucDoViPhamList);
        req.setAttribute("sinhVienDtoResponseList", sinhVienDtoResponseList);
        req.getRequestDispatcher("/WEB-INF/violation_record/create.jsp").forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<LoaiViPham> loaiViPhamList = loaiViPhamService.findAll();
        req.setAttribute("loaiViPhamList", loaiViPhamList);
        List<BienBanViPhamDtoReponse> bienBanViPhamDtoReponseList = bienBanViPhamService.findAll();
        req.setAttribute("bienBanViPhamDtoReponseList", bienBanViPhamDtoReponseList);
        req.getRequestDispatcher("/WEB-INF/violation_record/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        switch (action) {
            case "add":
                save(req, resp);
                break;
            case "edit":
                editBienBan(req, resp);
                break;
            case "delete":
                deleteBienBan(req, resp);
                break;
            case "search":
                searchBienBan(req, resp);
                break;
            default:
                showList(req, resp);
        }
    }

    private void searchBienBan(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchName = req.getParameter("search");
        int maLoaiViPham = Integer.parseInt(req.getParameter("loai_vi_pham_id"));
        List<BienBanViPhamDtoReponse> bienBanViPhamDtoReponseList =
                bienBanViPhamService.searchBySinhVienVaLoaiViPham(searchName, maLoaiViPham);
        List<LoaiViPham> loaiViPhamList = loaiViPhamService.findAll();
        req.setAttribute("loaiViPhamList", loaiViPhamList);
        req.setAttribute("bienBanViPhamDtoReponseList", bienBanViPhamDtoReponseList);
        req.getRequestDispatcher("/WEB-INF/violation_record/list.jsp").forward(req, resp);

    }

    private void editBienBan(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int maBienBanViPham = Integer.parseInt(req.getParameter("bienBanId"));
        int maSinhVienViPham = Integer.parseInt(req.getParameter("tenSinhVien"));
        int maLoaiViPham = Integer.parseInt(req.getParameter("loaiViPham"));
        int maMucDoViPham = Integer.parseInt(req.getParameter("mucDoViPham"));
        String thoiGianViPham = req.getParameter("thoiGianViPham");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ngayViPham = LocalDate.parse(thoiGianViPham, dateTimeFormatter);
        BienBanViPham bienBanViPham = new BienBanViPham(maBienBanViPham, maSinhVienViPham, maLoaiViPham, maMucDoViPham, ngayViPham);
        boolean isEditSuccess = bienBanViPhamService.update(bienBanViPham);
        String message = isEditSuccess ? "Thay đổi biên bản thành công!" : "Thay đổi biên bản thất bại!";
        resp.sendRedirect("violationRecord?message=" + message);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int maSinhVienViPham = Integer.parseInt(req.getParameter("tenSinhVien"));
        int maLoaiViPham = Integer.parseInt(req.getParameter("loaiViPham"));
        int maMucDoViPham = Integer.parseInt(req.getParameter("mucDoViPham"));
        String thoiGianViPham = req.getParameter("thoiGianViPham");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ngayViPham = LocalDate.parse(thoiGianViPham, dateTimeFormatter);
        BienBanViPham bienBanViPham = new BienBanViPham(maSinhVienViPham, maLoaiViPham, maMucDoViPham, ngayViPham);
        boolean isCreateSuccess = bienBanViPhamService.save(bienBanViPham);
        String mess = "Thêm Mới Thành Công";
        if (!isCreateSuccess) {
            mess = "Thêm Mới Thất Bại";
        }
        resp.sendRedirect("/violationRecord?message="+mess);
    }
}
