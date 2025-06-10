<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Quản lý phòng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>
</head>
<jsp:include page="/WEB-INF/common/head_admin.jsp"/>

<body class="container py-4">
<jsp:include page="/WEB-INF/common/navbar_admin.jsp"/>

<div class="d-flex justify-content-between align-items-center mb-3">
    <h3 class="mb-0">Danh sách phòng hiện có</h3>
    <a class="btn btn-secondary btn-sm" href="phongs?action=create">Thêm mới phòng</a>
</div>

<hr class="my-4">
<table id="tablePhong" class="table table-bordered table-hover mt-3">
    <thead>
    <tr>
        <th>số thứ tự phòng</th>
        <th>Tên phòng</th>
        <th>Số người hiện tại / Tối đa</th>
        <th>Giá mỗi tháng (VNĐ)</th>
        <th>Trạng thái</th>
        <th>Loại phòng</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="phong" items="${phongList}" varStatus="count">
        <tr>
            <td>${count.count}</td>
            <td>${phong.tenPhong}</td>
            <td>${phong.soNguoiHienTai} / ${phong.soNguoiToiDa}</td>
            <td>${phong.giaMoiThang}</td>
            <td>
                <c:forEach var="trangThai1" items="${listTrangThai}">
                    <c:if test="${trangThai1.maTrangThai==phong.trangThai}">
                        ${trangThai1.tenTrangThai}
                    </c:if>
                </c:forEach>
            </td>
            <td>
                <c:forEach var="loaiPhong1" items="${listLoaiPhong}">
                    <c:if test="${loaiPhong1.maLoaiPhong==phong.loaiPhong}">
                        ${loaiPhong1.tenLoaiPhong}
                    </c:if>
                </c:forEach>
            </td>
            <td>
                <a href="phongs?action=update&id=${phong.idPhong}" class="btn btn-warning btn-sm">Sửa</a>
                <button onclick="deleteInfo('${phong.idPhong}','${phong.tenPhong}')" type="button"
                        class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Xóa
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form method="post" action="/phongs?action=delete">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Chức năng xóa</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input hidden="hidden" id="deleteId" name="deleteId">
                    <span>Bạn có muốn xoá phòng </span><span id="deleteName"></span> không?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
                    <button class="btn btn-primary">Xoá</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    function deleteInfo(id, name) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = name;
    }
</script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/dataTables.bootstrap5.min.css"/>
<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap5.min.js"></script>

<script>
    $('#tablePhong').dataTable({
        "dom": 'lrtip',            // Giao diện (l - length, r - processing, t - table, i - info, p - pagination)
        "lengthChange": false,     // Ẩn dropdown chọn số dòng/trang
        "pageLength": 3,           // Mặc định 5 dòng
        "searching": true,         // Cho phép tìm kiếm
        "ordering": true           // Cho phép sắp xếp cột
    });
</script>
</body>
</html>
