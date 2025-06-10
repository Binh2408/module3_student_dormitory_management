<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/common/head_admin.jsp"/>
<style>
    th {
        text-align: center !important;
    }
</style>
<body class="container-fluid">

<jsp:include page="/WEB-INF/common/navbar_admin.jsp"/>

<div class="container container-section">
    <h2 class="text-center text-success my-4">Danh Sách Phòng Hiện Có</h2>

    <!-- Toast xóa phòng -->
    <c:if test="${param.delete eq 'true'}">
        <div class="toast align-items-center text-bg-success position-fixed bottom-0 end-0 p-3" style="z-index:1055"
             id="deleteToast">
            <div class="d-flex">
                <div class="toast-body">Xoá phòng thành công!</div>
                <button class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"></button>
            </div>
        </div>
    </c:if>

    <div class="d-flex justify-content-between mb-3">
        <a class="btn btn-success" href="phongs?action=create">
            <i class="fa fa-plus"></i> Thêm Mới Phòng
        </a>
    </div>

    <c:if test="${not empty phongList}">
        <table id="tablePhong" class="table table-sm table-bordered table-striped text-center">
            <thead class="table-light">
            <tr>
                <th>STT</th>
                <th>Tên Phòng</th>
                <th>Số Người</th>
                <th>Giá Mỗi Tháng (VNĐ)</th>
                <th>Trạng Thái</th>
                <th>Loại Phòng</th>
                <th>Hành Động</th>
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
                        <a href="phongs?action=update&id=${phong.idPhong}" class="btn btn-warning btn-sm me-1">
                            <i class="fa fa-edit"></i>
                        </a>
                        <button onclick="deleteInfo('${phong.idPhong}','${phong.tenPhong}')" type="button"
                                class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#deleteModal">
                            <i class="fa fa-trash"></i>
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty phongList}">
        <div class="alert alert-info text-center">Không có phòng nào được tìm thấy.</div>
    </c:if>
</div>

<!-- Modal xoá -->
<div class="modal fade" id="deleteModal" tabindex="-1">
    <div class="modal-dialog modal-dialog-centered">
        <form method="post" action="phongs?action=delete">
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
    document.addEventListener("DOMContentLoaded", () => {
        $('#tablePhong').DataTable({
            info: false,
            dom: 'lrtip',
            lengthChange: false,
            pageLength: 5,
            language: {
                paginate: { previous: "Trước", next: "Sau" },
                search: "Tìm kiếm:",
                emptyTable: "Không có dữ liệu",
                zeroRecords: "Không tìm thấy kết quả phù hợp"
            }
        });

        const toastEl = document.getElementById('deleteToast');
        if (toastEl) {
            new bootstrap.Toast(toastEl, {delay: 3000}).show();
        }
    });

    function deleteInfo(id, name) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = name;
    }
</script>
</body>
</html>
