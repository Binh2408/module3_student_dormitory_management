package org.example.quan_ly_ky_tuc_xa.controller;

import org.example.quan_ly_ky_tuc_xa.entity.Contracts;
import org.example.quan_ly_ky_tuc_xa.entity.ViolationRecord;
import org.example.quan_ly_ky_tuc_xa.service.ContractsService;
import org.example.quan_ly_ky_tuc_xa.service.IContractsService;
import org.example.quan_ly_ky_tuc_xa.service.IViolationRecordService;
import org.example.quan_ly_ky_tuc_xa.service.ViolationRecordService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/admin")
public class ContractController extends HttpServlet {
    private final IContractsService contractsService = new ContractsService();
    private final IViolationRecordService violationRecordService = new ViolationRecordService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Contracts> contractsList = contractsService.getAll();
        req.setAttribute("contractsList", contractsList);
        List<ViolationRecord> violationRecordList=violationRecordService.getAll();
        req.setAttribute("violationRecords",violationRecordList);
        req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req,resp);
    }
}

