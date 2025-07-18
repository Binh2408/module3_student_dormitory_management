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
<body class="container py-4">
<div class="d-flex justify-content-between align-items-center mb-3">
    <button class="btn btn-secondary" onclick="window.location.href='/phongs'"><h3 class="mb-0">Danh sách phòng hiện có</h3></button>
    <a class="btn btn-primary btn-sm" href="phongs?action=create">Thêm mới phòng</a>
</div>

<c:if test="${not empty param.message}">
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <c:choose>
            <c:when test="${param.message == 'deleteDeleted success'}">
                Xóa phòng thành công!
            </c:when>
            <c:when test="${param.message == 'addSuccess'}">
                Thêm mới phòng thành công!
            </c:when>
            <c:when test="${param.message == 'updateSuccess'}">
                Cập nhật phòng thành công!
            </c:when>
            <c:otherwise>
                ${param.message}
            </c:otherwise>
        </c:choose>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>

<form action="/phongs" method="get">
    <input name="action" hidden="hidden"  value="search">
    <input name="searchName" placeholder="Nhập tên phòng" value="${searchName}">
    <select name="maLoaiPhong">
        <option value="0">--Chọn loại phòng---</option>
        <c:forEach items="${listLoaiPhong}" var="lp">
            <c:if test="${lp.maLoaiPhong==maLoaiPhong}">
                <option value="${lp.maLoaiPhong}" selected>${lp.tenLoaiPhong}</option>
            </c:if>
            <c:if test="${lp.maLoaiPhong!=maLoaiPhong}">
                <option value="${lp.maLoaiPhong}">${lp.tenLoaiPhong}</option>
            </c:if>
        </c:forEach>
    </select>
    <select hidden="hidden" name="maTrangThai">
        <option value="0">--Chọn trạng thái---</option>
        <c:forEach items="${listTrangThai}" var="tt">
            <c:if test="${tt.maTrangThai == maTrangThai}">
                <option value="${tt.maTrangThai}" selected>${tt.tenTrangThai}</option>
            </c:if>
            <c:if test="${tt.maTrangThai != maTrangThai}">
                <option value="${tt.maTrangThai}">${tt.tenTrangThai}</option>
            </c:if>
        </c:forEach>
    </select>
    <button>Tìm kiếm</button>
</form>

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
            <td>
                <fmt:formatNumber value="${phong.giaMoiThang}" pattern="#,###" />
            </td>
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
                <a href="phongs?action=detail&id=${phong.idPhong}" class="btn btn-primary btn-sm">Chi tiết</a>
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
                    <h5 class="modal-title text-danger">Xoá Phòng</h5>
                </div>
                <div class="modal-body">
                    Bạn chắc chắn muốn xoá phòng <strong><span id="deleteName"></span></strong>?
                    <input type="hidden" name="deleteId" id="deleteId">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
                    <button class="btn btn-danger" type="submit">Xoá</button>
                </div>
            </div>
        </form>
    </div>
</div>

<!-- JS: jQuery + DataTables + Toast -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap5.min.js"></script>
<script>
    $('#tablePhong').dataTable({
        "dom": 'strip',            // Giao diện (l - length, r - processing, t - table, i - info, p - pagination)
        "lengthChange": false,     // Ẩn dropdown chọn số dòng/trang
        "pageLength": 5,           // Mặc định 5 dòng
        "searching": true,         // Cho phép tìm kiếm
        "ordering": true,         // Cho phép sắp xếp cột
        language: {
            paginate: {
                next: 'Trang sau',
                previous: 'Trang trước'
            },
            info: "",
            infoEmpty: "",
            infoFiltered: "",
            lengthMenu: "Hiển thị _MENU_ dòng mỗi trang",
            zeroRecords: "Không tìm thấy dữ liệu",

        }
    });

    function deleteInfo(id, name) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = name;
    }
</script>
</body>
</html>
