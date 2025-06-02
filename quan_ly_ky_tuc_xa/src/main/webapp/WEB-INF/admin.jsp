<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/2/2025
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contracts</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body style="background:#e6fff5">
<div class="container">
    <header class="row">
        <h1 class="text-center" style="color: #4CAF50">DORMITORY MANAGEMENT SYSTEM</h1>
    </header>
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <button class="btn btn-outline-info m-1" onclick="showSection('sinhvien-section')">StudentManagement
                        </button>
                    </li>
                    <li class="nav-item">
                        <button class="btn btn-outline-info m-1" onclick="showSection('contract-section')">ContractManagement
                        </button>
                    </li>
                    <li class="nav-item">
                        <button class="btn btn-outline-info m-1" onclick="showSection('violation-section')">ViolationManagement
                        </button>
                    </li>
                    <li class="nav-item">
                        <button class="btn btn-outline-info m-1" onclick="showSection('thongKe')">RevenueStatistics
                        </button>
                    </li>
                    <li class="nav-item">
                        <button class="btn btn-outline-info m-1">RoomManagement
                        </button>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- QUẢN LÝ HỢP ĐỒNG -->
    <div class="container container-section" id="contract-section" style="display: none">
        <h2 class="text-center mt-3 mb-4 text-danger">CONTRACT MANAGEMENT</h2>
        <a href="admin?action=add" class="btn btn-success mb-3">
            <i class="fa fa-plus"></i> Create New Contract
        </a>
        <table class="table table-sm table-bordered text-center table-striped">
            <thead class="table-light">
            <tr>
                <th>Contract ID</th>
                <th>Student Name</th>
                <th>Room</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="contract" items="${contractsList}">
                <tr>
                    <td>${contract.contractId}</td>
                    <td>${contract.studentName}</td>
                    <td>${contract.roomName}</td>
                    <td>${contract.startDay}</td>
                    <td>${contract.endDay}</td>

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
    </div>

    <!-- QUẢN LÝ VI PHẠM -->
    <div class="container container-section" id="violation-section" style="display: none">
        <h2 class="text-center mt-3 mb-4 text-danger">VIOLATION MANAGEMENT</h2>
        <button class="btn btn-success mb-3" data-bs-toggle="modal" data-bs-target="#createContractModal">
            <i class="fa fa-plus"></i> Create New Violation
        </button>
        <table class="table table-sm table-bordered text-center table-striped">
            <thead class="table-light">
            <tr>
                <th>ViolationRecordId</th>
                <th>ViolationStudentName</th>
                <th>ViolationTypeName;</th>
                <th>LevelOfViolationName</th>
                <th>TimeOfViolation</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="violation" items="${violationRecords}">
                <tr>
                    <td>${violation.violationRecordId}</td>
                    <td>${violation.violationStudentName}</td>
                    <td>${violation.violationTypeName}</td>
                    <td>${violation.levelOfViolationName}</td>
                    <td>${violation.timeOfViolation}</td>
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
    </div>

    <!-- THỐNG KÊ DOANH THU -->
    <div class="container container-section" id="thongKe" style="display: none">
        <h2 class="text-center mt-3 mb-4 text-danger">DORMITORY REVENUE STATISTICS</h2>
        <div>
            <canvas id="revenueChart" width="800" height="400"></canvas>
        </div>
    </div>
</div>


<!-- MODAL CHI TIẾT HỢP ĐỒNG -->
<div class="modal fade" id="contractDetailModal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Contract Detail</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <p>Hợp đồng thuê phòng của sinh viên Nguyen Van A tại phòng 101 từ 01/01/2025 đến 30/06/2025.</p>
            </div>
        </div>
    </div>
</div>


<!-- MODAL XÁC NHẬN XÓA -->
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

<!-- SCRIPT -->
<script>


    //hien thi selection
    function showSection(sectionId) {
        document.querySelectorAll('.container-section').forEach(el => el.style.display = 'none');
        document.getElementById(sectionId).style.display = 'block';
    }

    //ve bieu do thong ke

    const result = {
        labels: ["Quý 1", "Quý 2", "Quý 3", "Quý 4"],
        data: [3200000, 4500000, 2100000, 3800000]
    };

    const ctx = document.getElementById("revenueChart").getContext('2d');
    const revenueChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: result.labels,
            datasets: [{
                label: 'Doanh Thu (VND)',
                data: result.data,
                backgroundColor: ['#4caf50', '#2196f3', '#ff9800', '#f44336']
            }]
        },
        options: {
            responsive: true,
            scales: {
                y: {
                    beginAtZero: true,
                    ticks: {
                        callback: function (value) {
                            return value.toLocaleString('vi-VN') + ' VNĐ';
                        }
                    }
                }
            }
        }
    });

    let rowToDelete = null;

    // document.addEventListener('DOMContentLoaded', () => {
    //     document.querySelectorAll('.btn-delete').forEach(button => {
    //         button.addEventListener('click', function () {
    //             rowToDelete = this.closest('tr');
    //             const deleteModal = new bootstrap.Modal(document.getElementById('confirmDeleteModal'));
    //             deleteModal.show();
    //         });
    //     });
    //
    //     document.getElementById('confirmDeleteBtn').addEventListener('click', function () {
    //         if (rowToDelete) {
    //             rowToDelete.remove();
    //             rowToDelete = null;
    //         }
    //         const deleteModal = bootstrap.Modal.getInstance(document.getElementById('confirmDeleteModal'));
    //         deleteModal.hide();
    //     });
    // });
</script>

</body>
</html>
