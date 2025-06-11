<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/3/2025
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
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
            "info": false,
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 2
        })
    })

    function deleteInfo(id, name) {
        document.getElementById("idBienBanXoa").value = id;
        document.getElementById("tenSinhVienCanXoa").innerText = name;
    }
</script>
<body>
<jsp:include page="/WEB-INF/common/navbar_admin.jsp"/>

<!-- QUẢN LÝ VI PHẠM -->
<div class="container container-section" id="violation-section">
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
        <c:when test="${param.message == 'Not Creat Success'}">
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
    <h2 class="text-center mt-3 mb-4 text-success">Quản Lý Vi Phạm</h2>

    <div class="d-flex justify-content-between align-items-center mb-3">
        <!-- Nút tạo mới bên trái -->
        <button class="btn btn-success" onclick="window.location.href='violationRecord?action=add'">
            <i class="fa fa-plus"></i> Thêm Mới Biên Bản
        </button>

        <!-- Form tìm kiếm bên phải -->
        <form class="d-flex" role="search" method="post" action="violationRecord?action=search">
            <input class="form-control me-2" type="search" placeholder="--Nhập Tên SV--" name="search"
                   aria-label="Search">

            <select name="loai_vi_pham_id" class="form-control me-2" aria-label="Search">
                <option value="${0}">-- Chọn Loại Vi Phạm --</option>
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
                            data-id="${bienBanViPhamDtoReponse.bienBanId}"
                            onclick="deleteInfo('${bienBanViPhamDtoReponse.bienBanId}','${bienBanViPhamDtoReponse.tenSinhVien}')">
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
                    <h5 class="modal-title text-danger"> Xác Nhận Xoá Biên Bản Vi Phạm</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <div class="modal-body">
                    Bạn có muốn xoá biên bản của sinh viên <span id="tenSinhVienCanXoa"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Thoát</button>
                    <form method="post" action="violationRecord?action=delete">
                        <input type="hidden" id="idBienBanXoa" name="idBienBanXoa">
                        <button type="submit" id="confirmDeleteBtn" class="btn btn-danger">Có ,Xoá</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    // Kiểm tra nếu URL có query string
    if (window.location.search) {
        // Xóa query string mà không reload
        window.history.replaceState({}, document.title, window.location.pathname);
    }
</script>
</html>
