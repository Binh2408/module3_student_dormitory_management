package org.example.quan_ly_ky_tuc_xa.controller;

import org.example.quan_ly_ky_tuc_xa.entity.Contracts;
import org.example.quan_ly_ky_tuc_xa.service.ContractsService;
import org.example.quan_ly_ky_tuc_xa.service.IContractsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/contract")
public class ContractController extends HttpServlet {
    private final IContractsService contractsService = new ContractsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                req.getRequestDispatcher("/WEB-INF/contracts/contract_create.jsp").forward(req, resp);
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                List<Contracts> contractsList = contractsService.getAll();
                req.setAttribute("contracts", contractsList);
                req.getRequestDispatcher("/WEB-INF/contracts/contract_list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
//
        switch (action) {
            case "add":
                String contractCode= req.getParameter("contractCode");
                String studentCode = req.getParameter("studentCode");
                String roomName = req.getParameter("roomName");
                LocalDate startDay = LocalDate.parse(req.getParameter("startDay"));
                LocalDate endDay = LocalDate.parse(req.getParameter("endDay"));
                double rentalCost=Double.parseDouble(req.getParameter("rentalCost"));
                Contracts contracts = new Contracts(contractCode,studentCode, roomName, startDay, endDay,rentalCost);
                Map<String, String> error = contractsService.add(contracts);
                if (!error.isEmpty()) {
                    req.setAttribute("error", error);
                    req.setAttribute("contract", contracts);
                    req.getRequestDispatcher("/WEB-INF/contracts/contract_create.jsp").forward(req, resp);
                }else {
                    resp.sendRedirect("contract");
                }
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                List<Contracts> contractsList = contractsService.getAll();
                req.setAttribute("contracts", contractsList);
                req.getRequestDispatcher("/WEB-INF/contracts/contract_list.jsp").forward(req, resp);
        }
    }
}
