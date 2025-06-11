package org.example.quan_ly_ky_tuc_xa.controller.phong_va_thong_bao;


import org.example.quan_ly_ky_tuc_xa.entity.phong_va_thong_bao.Phong;
import org.example.quan_ly_ky_tuc_xa.service.phong_va_thong_bao.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/phongs")
public class PhongController extends HttpServlet {
    private IServicePhong servicePhong=new ServicePhong();
    private IServiceLoaiPhong serviceLoaiPhong=new ServiceLoaiPhong();
    private IServiceTrangThaiPhong serviceTrangThaiPhong=new ServiceTrangThaiPhong();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormAdd(request,response);
                break;
            case "update":
                showFormEdit(request,response);
                break;
            case "search":
                search(request,response);
                break;
            case "detail":
                detail(request,response);
                break;
            default:
                List<Phong> phongList = servicePhong.findAll();
                request.setAttribute("phongList", phongList);
                request.setAttribute("listLoaiPhong", serviceLoaiPhong.findAll());
                request.setAttribute("listTrangThai", serviceTrangThaiPhong.findAll());
                request.getRequestDispatcher("/room_and_notification/room_list.jsp").forward(request, response);
                break;
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                add(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                break;
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchName =request.getParameter("searchName");
        int maLoaiPhong=Integer.parseInt(request.getParameter("maLoaiPhong"));
        request.setAttribute("searchName",searchName);
        request.setAttribute("maLoaiPhong",maLoaiPhong);
        request.setAttribute("listTrangThai", serviceTrangThaiPhong.findAll());
        request.setAttribute("phongList",servicePhong.search(searchName,maLoaiPhong));
        request.setAttribute("listLoaiPhong",serviceLoaiPhong.findAll());
        RequestDispatcher dispatcher=request.getRequestDispatcher("/room_and_notification/room_list.jsp");
        dispatcher.forward(request,response);
    }

    private void showFormAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Gán cả 2 thuộc tính trước
        req.setAttribute("listLoaiPhong", serviceLoaiPhong.findAll());
        req.setAttribute("listTrangThai", serviceTrangThaiPhong.findAll());

        // Gửi request tới JSP một lần duy nhất
        RequestDispatcher dispatcher = req.getRequestDispatcher("/room_and_notification/create_room.jsp");
        dispatcher.forward(req, resp);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int detailId;
        try {
            detailId = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            request.setAttribute("error", "ID phòng không hợp lệ");
            request.getRequestDispatcher("/room_and_notification/error.jsp").forward(request, response);
            return;
        }
        Phong phong = servicePhong.findById(detailId);
        if (phong == null) {
            request.setAttribute("error", "Không tìm thấy phòng với ID: " + detailId);
            request.getRequestDispatcher("/room_and_notification/error.jsp").forward(request, response);
            return;
        }
        request.setAttribute("phong", phong);
        request.setAttribute("listLoaiPhong", serviceLoaiPhong.findAll());
        request.setAttribute("listTrangThai", serviceTrangThaiPhong.findAll());
        request.getRequestDispatcher("/room_and_notification/detail.jsp").forward(request, response);
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Phong phong = servicePhong.findById(id);
        req.setAttribute("phong", phong);
        req.setAttribute("listLoaiPhong", serviceLoaiPhong.findAll());
        req.setAttribute("listTrangThai", serviceTrangThaiPhong.findAll());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/room_and_notification/update_room.jsp");
        dispatcher.forward(req, resp);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String ten_phong = request.getParameter("ten_phong");
        int ma_loai_phong = Integer.parseInt(request.getParameter("ma_loai_phong"));
        int so_nguoi_do_da = Integer.parseInt(request.getParameter("so_nguoi_do_da"));
        int so_nguoi_hien_tai = Integer.parseInt(request.getParameter("so_nguoi_hien_tai"));
        double gia_moi_thang = Double.parseDouble(request.getParameter("gia_moi_thang"));
        int ma_trang_thai = Integer.parseInt(request.getParameter("ma_trang_thai"));
        int is_delete = Integer.parseInt(request.getParameter("is_delete"));
        Phong phong = new Phong(id,ten_phong,ma_loai_phong,so_nguoi_do_da,so_nguoi_hien_tai,gia_moi_thang,ma_trang_thai,is_delete);
        boolean isUpdateSuccess= servicePhong.edit(phong);
        String message=isUpdateSuccess?"updateSuccess":"updateFailed";
        response.sendRedirect("/phongs?message="+message);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int deleteId = Integer.parseInt(request.getParameter("deleteId"));
        boolean isDeleteSuccess =servicePhong.delete(deleteId);
        String mess=isDeleteSuccess?"deleteDeleted success":"deleteNot deleted success";
        response.sendRedirect("/phongs?message="+ mess );
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ten_phong = request.getParameter("ten_phong");
        int ma_loai_phong = Integer.parseInt(request.getParameter("ma_loai_phong"));
        int so_nguoi_do_da = Integer.parseInt(request.getParameter("so_nguoi_do_da"));
        int so_nguoi_hien_tai = Integer.parseInt(request.getParameter("so_nguoi_hien_tai"));
        double gia_moi_thang = Double.parseDouble(request.getParameter("gia_moi_thang"));
        int ma_trang_thai = Integer.parseInt(request.getParameter("ma_trang_thai"));
        Phong phong = new Phong(ten_phong,ma_loai_phong,so_nguoi_do_da,so_nguoi_hien_tai,gia_moi_thang,ma_trang_thai);
        boolean isAddSuccess= servicePhong.add(phong);
        String message= isAddSuccess?"addSuccess":"addFailed";
        response.sendRedirect("/phongs?message=" +message);
    }
}
