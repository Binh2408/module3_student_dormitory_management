package org.example.quan_ly_ky_tuc_xa.controller;

import org.example.quan_ly_ky_tuc_xa.service.IThongKeDoangThuService;
import org.example.quan_ly_ky_tuc_xa.service.ThongKeDoangThuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/revenueStatistics")
public class RevenueStatisticsController extends HttpServlet {
    private static final IThongKeDoangThuService thongKeDoangThuService = new ThongKeDoangThuService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> doanhThuTheoQuy = thongKeDoangThuService.getDoanhThuTheoQuy();
        String jsArray = doanhThuTheoQuy.toString();
        req.setAttribute("doanhThu", jsArray);
        req.getRequestDispatcher("/WEB-INF/revenue_statistics/display.jsp").forward(req, resp);
    }
}
