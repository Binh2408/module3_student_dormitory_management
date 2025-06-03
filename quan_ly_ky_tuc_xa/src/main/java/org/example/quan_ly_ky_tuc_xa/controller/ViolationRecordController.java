package org.example.quan_ly_ky_tuc_xa.controller;

import org.example.quan_ly_ky_tuc_xa.entity.ViolationRecord;
import org.example.quan_ly_ky_tuc_xa.service.IViolationRecordService;
import org.example.quan_ly_ky_tuc_xa.service.ViolationRecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/violationRecord")
public class ViolationRecordController extends HttpServlet {
    private static final IViolationRecordService violationRecordService = new ViolationRecordService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                req.getRequestDispatcher("/WEB-INF/violation_record/violation_record_create.jsp").forward(req, resp);
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                List<ViolationRecord> violationRecords = violationRecordService.getAll();
                req.setAttribute("violationRecords", violationRecords);
                req.getRequestDispatcher("/WEB-INF/violation_record/violation_record_list.jsp").forward(req, resp);
        }
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
                String violationRecordCode = req.getParameter("violationRecordCode");
                String violationStudentName = req.getParameter("violationStudentCode");
                String violationTypeName = req.getParameter("violationTypeName");
                String levelOfViolationName = req.getParameter("levelOfViolationName");
                LocalDate timeOfViolation = LocalDate.parse(req.getParameter("timeOfViolation"));
                ViolationRecord violationRecord = new ViolationRecord(violationRecordCode, violationStudentName, violationTypeName, levelOfViolationName, timeOfViolation);
                Map<String, String> error = violationRecordService.add(violationRecord);
                if (!error.isEmpty()) {
                    req.setAttribute("error", error);
                    req.setAttribute("violationRecord", violationRecord);
                    req.getRequestDispatcher("/WEB-INF/violation_record/violation_record_create.jsp").forward(req, resp);
                } else {
                    resp.sendRedirect("violationRecord");
                }
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                List<ViolationRecord> violationRecords = violationRecordService.getAll();
                req.setAttribute("violationRecords", violationRecords);
                req.getRequestDispatcher("/WEB-INF/violation_record/violation_record_list.jsp").forward(req, resp);
        }
    }
}
