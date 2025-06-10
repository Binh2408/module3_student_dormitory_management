<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<jsp:include page="/WEB-INF/common/head_admin.jsp"/>
<style>
    th {
        text-align: center !important;
    }

</style>
<body>
<jsp:include page="/WEB-INF/common/navbar_admin.jsp"/>

<div class="container container-section">
    <h2 class="text-center text-success my-4">Danh Sách Tài Khoản</h2>

    <!-- Toast tạo tài khoản -->
    <c:if test="${param.success eq 'true'}">
        <div class="toast align-items-center text-bg-success position-fixed bottom-0 end-0 p-3" style="z-index:1055"
             id="createToast">
            <div class="d-flex">
                <div class="toast-body">Tạo tài khoản thành công!</div>
                <button class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"></button>
            </div>
        </div>
    </c:if>

    <!-- Toast cập nhật tài khoản -->
    <c:if test="${param.update eq 'true'}">
        <div class="toast align-items-center text-bg-success position-fixed bottom-0 end-0 p-3" style="z-index:1055"
             id="updateToast">
            <div class="d-flex">
                <div class="toast-body">Cập nhật tài khoản thành công!</div>
                <button class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"></button>
            </div>
        </div>
    </c:if>

    <!-- Toast xoá tài khoản -->
    <c:if test="${param.delete eq 'true'}">
        <div class="toast align-items-center text-bg-success position-fixed bottom-0 end-0 p-3" style="z-index:1055"
             id="deleteToast">
            <div class="d-flex">
                <div class="toast-body">Xoá tài khoản thành công!</div>
                <button class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"></button>
            </div>
        </div>
    </c:if>

    <div class="d-flex justify-content-between mb-3">
        <a href="${pageContext.request.contextPath}/account/create" class="btn btn-success">
            <i class="fa fa-plus"></i> Thêm Tài Khoản
        </a>

    </div>

    <c:if test="${not empty accountList}">
        <table class="table table-sm table-bordered table-striped text-center" id="tableAccount">
            <thead class="table-light">
            <tr>
                <th>STT</th>
                <th>Tên tài khoản</th>
                <th>Ngày Tạo</th>
                <th>Hành Động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="acc" items="${accountList}" varStatus="idx">
                <tr>
                    <td>${idx.count}</td>
                    <td>${acc.userName}</td>
                    <td>${acc.ngayTaoTaiKhoanFormatted}</td>
                    <td>
                        <a class="btn btn-sm btn-warning me-1"
                           href="${pageContext.request.contextPath}/account/update?maTaiKhoan=${acc.maTaiKhoan}">
                            <i class="fa fa-edit"></i>
                        </a>
                        <button class="btn btn-sm btn-danger" data-bs-toggle="modal"
                                data-bs-target="#deleteModal"
                                onclick="setDelete(${acc.maTaiKhoan},'${acc.userName}')">
                            <i class="fa fa-trash"></i>
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty accountList}">
        <div class="alert alert-info text-center">Không có tài khoản nào được tìm thấy.</div>
    </c:if>
</div>

<!-- Modal xoá -->
<div class="modal fade" id="deleteModal" tabindex="-1">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header"><h5 class="modal-title text-danger">Xoá Tài Khoản</h5></div>
            <div class="modal-body">Bạn chắc chắn muốn xoá tài khoản <strong><span id="deleteUser"></span></strong>?
            </div>
            <div class="modal-footer">
                <button class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
                <form method="post" action="${pageContext.request.contextPath}/account/delete">
                    <input type="hidden" name="maTaiKhoan" id="deleteId">
                    <button class="btn btn-danger" type="submit">Xoá</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- JS: jQuery + DataTable + Bootstrap Toast -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap5.min.js"></script>
<script>
    document.addEventListener("DOMContentLoaded", () => {
        $('#tableAccount').DataTable({
            info: false,
            dom: 'lrtip',
            lengthChange: false,
            pageLength: 5,
            language: {
                paginate: {
                    previous: "Trước",
                    next: "Sau"
                },
                search: "Tìm kiếm:",
                emptyTable: "Không có dữ liệu",
                zeroRecords: "Không tìm thấy kết quả phù hợp"
            }
        });

        ['createToast', 'updateToast', 'deleteToast'].forEach(toastId => {
            const toastEl = document.getElementById(toastId);
            if (toastEl) {
                new bootstrap.Toast(toastEl, {delay: 3000}).show();
            }
        });
    });


    function setDelete(id, user) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteUser").innerText = user;
    }
</script>
</body>
</html>
