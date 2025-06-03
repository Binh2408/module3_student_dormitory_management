package org.example.quan_ly_ky_tuc_xa.controller;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin")
public class AdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
            String action =req.getParameter("action");
            if(action==null){
                action="";
            }
            switch (action){
                case "StudentManagement":
                    break;
                case"ContractManagement":
                   resp.sendRedirect("contract");
                    break;
                case "ViolationManagement":
                    resp.sendRedirect("violationRecord");
                    break;
                case "RevenueStatistics":
                    resp.sendRedirect("revenueStatistics");
                    break;
                case "RoomManagement":
                    break;
                default:
                    req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req,resp);
                    break;
            }
    }
}
