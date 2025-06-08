package org.example.quan_ly_ky_tuc_xa.controller;


import org.example.quan_ly_ky_tuc_xa.dto.BienBanViPhamDtoReponse;
import org.example.quan_ly_ky_tuc_xa.dto.SinhVienDtoResponse;
import org.example.quan_ly_ky_tuc_xa.entity.LoaiViPham;
import org.example.quan_ly_ky_tuc_xa.entity.MucDoViPham;
import org.example.quan_ly_ky_tuc_xa.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/violationRecord")
public class BienBanViPhamController extends HttpServlet {
    private static final IBienBanViPhamService bienBanViPhamService = new BienBanViPhamService();
    private final ISinhVienService sinhVienService = new SinhVienService();
    private final IMucDoViPhamService mucDoViPhamService = new MucDoViPhamService();
    private final ILoaiViPhamService loaiViPhamService = new LoaiViPhamService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showFormCreate(req, resp);
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                showList(req, resp);
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
                break;
            case "delete":
                break;
            default:
        }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) {
        

//        boolean isCreatSuccess = bienBanViPhamService.save(hopDong);
//        String mess = "creat success";
//        if (!isCreatSuccess) {
//            mess = " not creat  success";
//        }
//        resp.sendRedirect("/contract?message" + mess);
    }
}
