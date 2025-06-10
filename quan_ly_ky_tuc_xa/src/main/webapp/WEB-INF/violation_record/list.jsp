<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/3/2025
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="/WEB-INF/common/head_admin.jsp"/>
<style>
    th {
        text-align: center !important;
    }
</style>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        let deleteButtons = document.querySelectorAll(".btn-delete");
        let deleteContractCodeInput = document.getElementById("deleteContractCode");
        for (let button of deleteButtons) {
            button.addEventListener("click", function () {
                deleteContractCodeInput.value = this.getAttribute("data-id")
            })
        }

        const toastElement = document.getElementById('message');
        if (toastElement) {
            const toast = new bootstrap.Toast(toastElement);
            toast.show();
        }
    })
    $(document).ready(function () {
        $('#tableBienBan').DataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 2
        })
    })
</script>
<body>
<jsp:include page="/WEB-INF/common/navbar_admin.jsp"/>

<!-- QUẢN LÝ VI PHẠM -->
<div class="container container-section" id="violation-section">
    <h2 class="text-center mt-3 mb-4 text-success">Quản Lý Vi Phạm</h2>

    <c:if test="${not empty param.message}">
        <div class="toast align-items-center text-bg-success border-0" role="alert" aria-live="assertive"
             aria-atomic="true" id="message">
            <div class="d-flex">
                <div class="toast-body">
                        ${param.message}
                </div>
                <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"
                        aria-label="Close"></button>
            </div>
        </div>
    </c:if>
    <div class="d-flex justify-content-between align-items-center mb-3">
        <!-- Nút tạo mới bên trái -->
        <button class="btn btn-success" onclick="window.location.href='violationRecord?action=add'">
            <i class="fa fa-plus"></i> Thêm Mới Biên Bản
        </button>
        <!-- Form tìm kiếm bên phải -->
        <form class="d-flex" role="search" method="post" action="violationRecord?action=search">
            <input class="form-control me-2" type="search" placeholder="Search by name" name="search"
                   aria-label="Search">

            <select name="loai_vi_pham_id" class="form-control me-2" aria-label="Search">
                <option value="${0}">-- Chọn sinh viên vi phạm --</option>
                <c:forEach items="${loaiViPhamList}" var="loaiViPham">
                    <option value="${loaiViPham.loaiViPhamId}">${loaiViPham.tenLoaiViPham}</option>
                </c:forEach>
            </select>
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>

    <table class="table table-sm table-bordered text-center table-striped" id="tableBienBan">
        <thead class="table-light">
        <tr>
            <th>STT</th>
            <th>Sinh Viên Vi Phạm</th>
            <th>Loại Vi Phạm</th>
            <th>Mức Độ Vi Phạm</th>
            <th>Thời Gian Vi Phạm</th>
            <th>Hành Động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="bienBanViPhamDtoReponse" items="${bienBanViPhamDtoReponseList}" varStatus="status">
            <tr>
                <td style="text-align: center">${status.count}</td>
                <td style="text-align: left">${bienBanViPhamDtoReponse.tenSinhVien}</td>
                <td>${bienBanViPhamDtoReponse.tenLoaiViPham}</td>
                <td>${bienBanViPhamDtoReponse.mucDoViPham}</td>
                <td style="text-align: center">${bienBanViPhamDtoReponse.thoiGianViPham}</td>
                <td>
                    <button class="btn btn-sm btn-warning btn-update me-1" data-bs-toggle="modal"
                            data-bs-target="#updateContractModal"
                            onclick="window.location.href='violationRecord?action=edit&id=${bienBanViPhamDtoReponse.bienBanId}'">
                        <i class="fa fa-edit"></i>
                    </button>
                    <button class="btn btn-sm btn-danger btn-delete" data-bs-toggle="modal"
                            data-bs-target="#confirmDeleteModal"
                            data-id="${bienBanViPhamDtoReponse.bienBanId}">
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
                    <form method="post" action="violationRecord?action=delete">
                        <input type="hidden" id="deleteContractCode" name="deleteContractId">
                        <button type="submit" id="confirmDeleteBtn" class="btn btn-danger">Yes, Delete</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
