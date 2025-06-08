<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/2/2025
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creat Contact</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="d-flex justify-content-center align-items-center container-fluid"
     style="height: 100vh ;background:#e6fff5">
    <div class="card shadow p-4" style="width: 60%">
        <h2 class="text-center text-success">Create Contract</h2>

        <form id="contractForm" class="needs-validation" novalidate>
            <div class="row">
                <!--font hợp đồng-->
                <div class="col-sm-6">
                    <div class="row">
                        <label class="form-label col-sm-4">StudentCode</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control mb-3" placeholder="StudentCode" required>
                            <div class="invalid-feedback">Vui lòng nhập mã hợp lệ</div>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">RoomCode</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control mb-3" placeholder="RoomCode" required>
                            <div class="invalid-feedback">Vui lòng nhập mã phòng</div>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">StartDay</label>
                        <div class="col-sm-8">
                            <input type="date" class="form-control mb-3" required>
                            <div class="invalid-feedback">Vui lòng chọn ngày bắt đầu</div>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">EndDay</label>
                        <div class="col-sm-8">
                            <input type="date" class="form-control mb-3" required>
                            <div class="invalid-feedback">Vui lòng chọn ngày kết thúc</div>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">RentalCost</label>
                        <div class="col-sm-8">
                            <input type="number" class="form-control mb-3" required>
                            <div class="invalid-feedback">Vui lòng nhập giá thuê</div>
                        </div>
                    </div>
                </div>

                <!--              font thông tin sinh vien-->
                <div class="col-sm-6">
                    <div class="row">
                        <label class="form-label col-sm-4">StudentName</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control mb-3" readonly>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">Birthday</label>
                        <div class="col-sm-8">
                            <input type="date" class="form-control mb-3" readonly>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">Gender</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control mb-3" readonly>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">CMND</label>
                        <div class="col-sm-8">
                            <input type="number" class="form-control mb-3" readonly>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">Address</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control mb-3" readonly>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">NumberPhone</label>
                        <div class="col-sm-8">
                            <input type="number" class="form-control mb-3" readonly>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row justify-content-center">
                <div class="col-sm-4">
                    <button type="submit" class="btn btn-outline-success w-100">Create</button>
                </div>
                <div class="col-sm-4">
                    <button type="button" class="btn btn-outline-danger w-100" onclick="window.location.reload()">Exit
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>

<!-- Script xử lý Bootstrap validation -->
<script>
    (function () {
        'use strict'
        const form = document.getElementById('contractForm');
        form.addEventListener('submit', function (event) {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add('was-validated');
        });
    })();
</script>

</body>
</html>
