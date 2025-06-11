<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/2/2025
  Time: 5:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        $('#tableHopDong').dataTable({
            "info": false,
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 2
        })
    })

    function deleteInfo(id, name) {
        document.getElementById("idHopDongXoa").value = id;
        document.getElementById("tenSinhVienCanXoa").innerText = name;
    }
</script>
<body>
<jsp:include page="/WEB-INF/common/navbar_admin.jsp"/>
<!-- QUẢN LÝ HỢP ĐỒNG -->
<div class="container container-section" id="contract-section">

    <c:choose>
        <c:when test="${param.message == 'Delete Success'}">
            <div class="toast align-items-center text-bg-success border-0" role="alert" aria-live="assertive"
                 aria-atomic="true" id="message">
                <div class="d-flex">
                    <div class="toast-body">
                        Đã Xoá Thành Công
                    </div>
                    <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"
                            aria-label="Close"></button>
                </div>
            </div>
        </c:when>
        <c:when test="${param.message == 'Update Success'}">
            <div class="toast align-items-center text-bg-success border-0" role="alert" aria-live="assertive"
                 aria-atomic="true" id="message">
                <div class="d-flex">
                    <div class="toast-body">
                       Thay Đổi Thành Công
                    </div>
                    <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"
                            aria-label="Close"></button>
                </div>
            </div>
        </c:when>
        <c:when test="${param.message == 'Create Success'}">
            <div class="toast align-items-center text-bg-success border-0" role="alert" aria-live="assertive"
                 aria-atomic="true" id="message">
                <div class="d-flex">
                    <div class="toast-body">
                       Thêm Mới Thành Công
                    </div>
                    <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"
                            aria-label="Close"></button>
                </div>
            </div>
        </c:when>
        <c:when test="${param.message == 'Not Delete Success'}">
            <div class="toast align-items-center text-bg-success border-0" role="alert" aria-live="assertive"
                 aria-atomic="true" id="message">
                <div class="d-flex">
                    <div class="toast-body">
                        Xoá Thất Bại
                    </div>
                    <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"
                            aria-label="Close"></button>
                </div>
            </div>
        </c:when>
        <c:when test="${param.message == 'Not Update Success'}">
            <div class="toast align-items-center text-bg-success border-0" role="alert" aria-live="assertive"
                 aria-atomic="true" id="message">
                <div class="d-flex">
                    <div class="toast-body">
                        Thay Đổi Thất Bại
                    </div>
                    <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"
                            aria-label="Close"></button>
                </div>
            </div>
        </c:when>
        <c:when test="${param.message == 'Not Create Success'}">
            <div class="toast align-items-center text-bg-success border-0" role="alert" aria-live="assertive"
                 aria-atomic="true" id="message">
                <div class="d-flex">
                    <div class="toast-body">
                        Thêm Mới Thất Bại
                    </div>
                    <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"
                            aria-label="Close"></button>
                </div>
            </div>
        </c:when>
    </c:choose>
    <h2 class="text-center mt-3 mb-4 text-success">Quản Lý Hợp Đồng</h2>

    <div class="d-flex justify-content-between align-items-center mb-3">
        <!-- Nút tạo mới bên trái -->
        <button class="btn btn-success mb-3" onclick="window.location.href='contract?action=add'">
            <i class="fa fa-plus"></i> Thêm MớI Hợp Đồng
        </button>

        <!-- Form tìm kiếm bên phải -->
        <form class="d-flex" role="search" method="post" action="contract?action=search">
            <input class="form-control me-2" type="search" placeholder="--Nhập Tên SV--" name="search"
                   aria-label="Search">

            <select name="phong_id" class="form-control me-2" aria-label="Search">
                <option value="${0}">-- Chọn Phòng --</option>
                <c:forEach items="${phongList}" var="phong">
                    <option value="${phong.idPhong}">${phong.tenPhong}</option>
                </c:forEach>
            </select>

            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>
    <table class="table table-sm table-bordered text-center table-striped" id="tableHopDong">
        <thead class="table-light">
        <tr>
            <th style="text-align: center">STT</th>
            <th style="text-align: left">Tên Sinh Viên</th>
            <th style="text-align: center">Phòng</th>
            <th style="text-align: center">Ngày Bắt Đầu Thuê</th>
            <th style="text-align: center">Ngày Kết Thúc Thuê</th>
            <th style="text-align: center">Tổng Chi Phí</th>
            <th style="text-align: center">Hành Động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="hopDongDtoResponse" items="${hopDongDtoResponseList}" varStatus="idx">
            <tr>
                <td style="text-align: center">${idx.count}</td>
                <td style="text-align: left">${hopDongDtoResponse.tenSinhVien}</td>
                <td style="text-align: center">${hopDongDtoResponse.tenPhong}</td>
                <td style="text-align: center">${hopDongDtoResponse.thoiGianBatDau}</td>
                <td style="text-align: center">${hopDongDtoResponse.thoiGianKetThuc}</td>
                <td>
                    <fmt:formatNumber value="${hopDongDtoResponse.chiPhiThue}" type="number" groupingUsed="true"/>VND
                </td>
                <td>
                    <button class="btn btn-sm btn-warning btn-update me-1" data-bs-toggle="modal"
                            data-id="${hopDongDtoResponse.maHopDong}"
                            onclick="window.location.href='/contract?action=update&updateHopDongId=${hopDongDtoResponse.maHopDong}'">
                        <i class="fa fa-edit"></i>
                    </button>
                    <button class="btn btn-sm btn-danger btn-delete" data-bs-toggle="modal"
                            data-bs-target="#confirmDeleteModal" data-id="${hopDongDtoResponse.maHopDong}"
                            onclick="deleteInfo('${hopDongDtoResponse.maHopDong}','${hopDongDtoResponse.tenSinhVien}')">
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
                    <h5 class="modal-title text-danger">Xác Nhận Xoá Hợp Đồng</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <div class="modal-body">
                    Bạn có muốn xoá hợp đồng của sinh vien <span id="tenSinhVienCanXoa"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Thoát</button>
                    <form method="post" action="contract?action=delete">
                        <input type="hidden" id="idHopDongXoa" name="deleteContractId">
                        <button type="submit" id="confirmDeleteBtn" class="btn btn-danger">Có ,Xoá</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body><script>
    // Kiểm tra nếu URL có query string
    if (window.location.search) {
        // Xóa query string mà không reload
        window.history.replaceState({}, document.title, window.location.pathname);
    }
</script>

</html>
