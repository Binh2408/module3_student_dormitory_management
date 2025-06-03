<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/2/2025
  Time: 5:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="/WEB-INF/common/head_admin.jsp"/>
<body>
<div class="container">
    <jsp:include page="/WEB-INF/common/navbar_admin.jsp"/>
    <!-- QUẢN LÝ HỢP ĐỒNG -->
    <div class="container container-section" id="contract-section">
        <h2 class="text-center mt-3 mb-4 text-danger">CONTRACT MANAGEMENT</h2>
        <button class="btn btn-success mb-3" onclick="window.location.href='contract?action=add'">
            <i class="fa fa-plus"></i> Create New Contract
        </button>
        <table class="table table-sm table-bordered text-center table-striped">
            <thead class="table-light">
            <tr>
                <th>NO</th>
                <th>ContractCode</th>
                <th>Student Name</th>
                <th>Room</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>RentalCost</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="contract" items="${contracts}" varStatus="idx">
                <tr>
                    <td>${idx.count}</td>
                    <th>${contract.contractCode}</th>
                    <td>${contract.studentCode}</td>
                    <td>${contract.roomName}</td>
                    <td>${contract.startDay}</td>
                    <td>${contract.endDay}</td>
                    <td>${contract.rentalCost}</td>
                    <td>
                        <button class="btn btn-sm btn-warning btn-update me-1" data-bs-toggle="modal"
                                data-bs-target="#updateContractModal">
                            <i class="fa fa-edit"></i>
                        </button>
                        <button class="btn btn-sm btn-danger btn-delete" data-bs-toggle="modal"
                                data-bs-target="#confirmDeleteModal">
                            <i class="fa fa-trash"></i>
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="modal fade" id="confirmDeleteModal" tabindex="-1">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title text-danger">Confirm Delete</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>
                    <div class="modal-body">Are you sure you want to delete this record?</div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                        <button type="button" id="confirmDeleteBtn" class="btn btn-danger">Yes, Delete</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
