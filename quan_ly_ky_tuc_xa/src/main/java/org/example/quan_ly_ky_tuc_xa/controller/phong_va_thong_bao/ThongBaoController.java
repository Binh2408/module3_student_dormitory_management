package org.example.quan_ly_ky_tuc_xa.controller.phong_va_thong_bao;

import org.example.quan_ly_ky_tuc_xa.entity.phong_va_thong_bao.ThongBao;
import org.example.quan_ly_ky_tuc_xa.service.phong_va_thong_bao.IServiceThongBao;
import org.example.quan_ly_ky_tuc_xa.service.phong_va_thong_bao.ServiceThongBao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@WebServlet("/thongbao")
public class ThongBaoController extends HttpServlet {
    private IServiceThongBao thongBaoService=new ServiceThongBao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maThongBao = request.getParameter("maThongBao");
        String tieuDe = request.getParameter("tieuDe");
        String noiDung = request.getParameter("noiDung");
        String raw = request.getParameter("thoiGianGui"); // ví dụ: "2025-06-09 11:05:04"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime thoiGianGui = LocalDateTime.parse(raw, formatter);

        ThongBao tb = new ThongBao(maThongBao,tieuDe, noiDung,thoiGianGui);
        thongBaoService.sendNotification(tb);

        request.setAttribute("thongBaoList", thongBaoService.findAll());
        request.getRequestDispatcher("/room_and_notification/send_notification.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ThongBao> thongBaoList=thongBaoService.findAll();
        request.setAttribute("thongBaoList",thongBaoList );
        request.getRequestDispatcher("/room_and_notification/send_notification.jsp").forward(request, response);
    }
}
