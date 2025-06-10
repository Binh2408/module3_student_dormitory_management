package org.example.quan_ly_ky_tuc_xa.controller;

import org.example.quan_ly_ky_tuc_xa.dto.HopDongDtoResponse;
import org.example.quan_ly_ky_tuc_xa.dto.SinhVienDtoResponse;
import org.example.quan_ly_ky_tuc_xa.entity.HopDong;


import org.example.quan_ly_ky_tuc_xa.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;

@WebServlet(urlPatterns = "/contract")
public class HopDongController extends HttpServlet {
    private final IHopDongService hopDongService = new HopDongService();
    private final ISinhVienService sinhVienService = new SinhVienService();

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
            case "update":
                showFormUpdate(req, resp);
                break;
            case "delete":
                break;
            default:
                showList(req, resp);
        }
    }

    private void showFormUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int updateId = Integer.parseInt(req.getParameter("updateHopDongId"));
        HopDongDtoResponse hopDongDtoResponse = hopDongService.timKiemHopDongTheoId(updateId);
        req.setCharacterEncoding("UTF-8");
        List<SinhVienDtoResponse> sinhVienDtoResponseList = sinhVienService.findAll();
        req.setAttribute("sinhVienDtoResponseList", sinhVienDtoResponseList);
        if (hopDongDtoResponse != null) {
            req.setAttribute("hopDongDtoResponse", hopDongDtoResponse);
            req.getRequestDispatcher("/WEB-INF/contracts/update.jsp").forward(req, resp);
        }
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<SinhVienDtoResponse> sinhVienDtoResponseList = sinhVienService.findAll();
        req.setAttribute("sinhVienDtoResponseList", sinhVienDtoResponseList);
        req.getRequestDispatcher("/WEB-INF/contracts/create.jsp").forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<HopDongDtoResponse> hopDongDtoResponseList = hopDongService.findAll();
        req.setAttribute("hopDongDtoResponseList", hopDongDtoResponseList);
        req.getRequestDispatcher("/WEB-INF/contracts/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                save(req, resp);
                break;
            case "update":
                updateHopDong(req, resp);
                break;
            case "delete":
                removeHopDong(req, resp);
                break;
            case "search":
                searchHopDong(req, resp);
                break;
            default:
                showList(req, resp);
                break;
        }
    }

    private void searchHopDong(HttpServletRequest req, HttpServletResponse resp) {
        String searchName = req.getParameter("search");
        List<HopDongDtoResponse> hopDongDtoResponseList =
                hopDongService.searchBySinhVienVaLoaiPhong(searchName, 0);
        req.setAttribute("hopDongDtoResponseList",hopDongDtoResponseList);
        try {
            req.getRequestDispatcher("/WEB-INF/contracts/list.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateHopDong(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        int maSinhVien = Integer.parseInt(req.getParameter("ma_sinh_vien"));
        int maPhong = Integer.parseInt(req.getParameter("ma_phong"));
        int maHopDong = Integer.parseInt(req.getParameter("hop_dong_id"));
        String thoiGianBatDau = req.getParameter("ngay_bat_dau");
        String thoiGianKetThuc = req.getParameter("ngay_ket_thuc");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ngayBatDau = LocalDate.parse(thoiGianBatDau, dateTimeFormatter);
        LocalDate ngayKetThuc = LocalDate.parse(thoiGianKetThuc, dateTimeFormatter);
        HopDong hopDong = new HopDong(maHopDong, maSinhVien, maPhong, ngayBatDau, ngayKetThuc);
        boolean isUpdateSuccess = hopDongService.update(hopDong);
        String mess = "update success";
        if (!isUpdateSuccess) {
            mess = "not update success";
        }
        resp.sendRedirect("contract?message" + mess);

    }

    private void removeHopDong(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int deleteContractId = Integer.parseInt(req.getParameter("deleteContractId"));
        boolean isDeleteSuccess = hopDongService.remove(deleteContractId);
        String mess = "delete success";
        if (!isDeleteSuccess) {
            mess = "not delete success";
        }
        resp.sendRedirect("/contract?message" + mess);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int maSinhVien = Integer.parseInt(req.getParameter("ma_sinh_vien"));
        int maPhong = Integer.parseInt(req.getParameter("ma_phong"));
        String thoiGianBatDau = req.getParameter("ngay_bat_dau");
        String thoiGianKetThuc = req.getParameter("ngay_ket_thuc");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ngayBatDauThue = LocalDate.parse(thoiGianBatDau, dateTimeFormatter);
        LocalDate ngayKetThucThue = LocalDate.parse(thoiGianKetThuc, dateTimeFormatter);
        HopDong hopDong = new HopDong(maSinhVien, maPhong, ngayBatDauThue, ngayKetThucThue);
        boolean isCreatSuccess = hopDongService.save(hopDong);
        String mess = "creat success";
        if (!isCreatSuccess) {
            mess = " not creat  success";
        }

        resp.sendRedirect("/contract?message" + mess);
    }
}
