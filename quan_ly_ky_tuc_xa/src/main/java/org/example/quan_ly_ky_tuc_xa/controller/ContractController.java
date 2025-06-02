package org.example.quan_ly_ky_tuc_xa.controller;

import org.example.quan_ly_ky_tuc_xa.entity.Contracts;
import org.example.quan_ly_ky_tuc_xa.entity.ViolationRecord;
import org.example.quan_ly_ky_tuc_xa.service.ContractsService;
import org.example.quan_ly_ky_tuc_xa.service.IContractsService;
import org.example.quan_ly_ky_tuc_xa.service.IViolationRecordService;
import org.example.quan_ly_ky_tuc_xa.service.ViolationRecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin")
public class ContractController extends HttpServlet {
    private final IContractsService contractsService = new ContractsService();
    private final IViolationRecordService violationRecordService = new ViolationRecordService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null || action.isEmpty()) {
            List<Contracts> contractsList = contractsService.getAll();
            List<ViolationRecord> violationRecordList = violationRecordService.getAll();
            req.setAttribute("contractsList", contractsList);
            req.setAttribute("violationRecords", violationRecordList);
            req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req, resp);
            return;
        }

        switch (action) {
            case "add":
                req.getRequestDispatcher("/WEB-INF/contract_create.jsp").forward(req, resp);
                break;
            case "edit":
//                String contractIdEdit = req.getParameter("id");
//                Contracts contractEdit = contractsService.findById(contractIdEdit);
//                req.setAttribute("contract", contractEdit);
//                req.getRequestDispatcher("/WEB-INF/contract_edit.jsp").forward(req, resp);
                break;
            case "delete":
//                String contractIdDelete = req.getParameter("id");
//                contractsService.delete(contractIdDelete);
//                resp.sendRedirect("admin"); // reload lại danh sách
                break;
            default:
                resp.sendRedirect("admin");
                break;
        }
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // Ví dụ xử lý thêm hợp đồng
//        String action = req.getParameter("action");
//        if ("add".equals(action)) {
//            String id = req.getParameter("contractId");
//            String studentName = req.getParameter("studentName");
//            String room = req.getParameter("roomName");
//            String start = req.getParameter("startDay");
//            String end = req.getParameter("endDay");
//
////            Contracts contract = new Contracts(id, studentName, room, start, end);
////            contractsService.add(contract);
////            resp.sendRedirect("admin");
//        } else if ("edit".equals(action)) {
//            // Xử lý update
//            String id = req.getParameter("contractId");
//            String studentName = req.getParameter("studentName");
//            String room = req.getParameter("roomName");
//            String start = req.getParameter("startDay");
//            String end = req.getParameter("endDay");
//
////            Contracts contract = new Contracts(id, studentName, room, start, end);
////            contractsService.update(contract);
////            resp.sendRedirect("admin");
//        }
//    }
}
