<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thông tin cá nhân sinh viên</title>
    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .card {
            border: none;
            border-radius: 15px;
        }
        .card-header {
            background: linear-gradient(45deg, #ff6200, #cc4d00);
            border-radius: 15px 15px 0 0;
            color: white;
        }
        .card-body {
            background-color: white;
        }
        .col-form-label {
            color: #333;
        }
        .fw-bold {
            font-weight: 600;
        }
        .modal-header {
            background: linear-gradient(45deg, #ff6200, #cc4d00);
        }
        .modal-header .btn-close {
            filter: invert(1) brightness(2);
        }
        .section-title {
            font-size: 1.25rem;
            font-weight: 500;
            margin-top: 1.5rem;
            margin-bottom: 1rem;
            color: #555;
        }
    </style>
</head>
<body class="bg-light">
<%@ include file="../../header_navbar_footer/header.jsp" %>

<div class="container py-5">
<%--    &lt;%&ndash; Hiển thị thông báo nếu có &ndash;%&gt;--%>
<%--    <c:if test="${not empty sessionScope.successMessage}">--%>
<%--        <div class="alert alert-success alert-dismissible fade show text-center" role="alert">--%>
<%--                ${sessionScope.successMessage}--%>
<%--            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>--%>
<%--        </div>--%>
<%--        <c:remove var="successMessage" scope="session" />--%>
<%--    </c:if>--%>

    <div class="row justify-content-center">
        <div class="col-lg-8 col-md-10">
            <div class="card shadow-lg">
                <div class="card-header text-white">
                    <h4 class="mb-0 text-center">Thông tin cá nhân</h4>
                </div>
                <div class="card-body p-4">
                    <div class="mb-4 row align-items-center">
                        <label class="col-sm-4 col-form-label fw-bold">Mã sinh viên:</label>
                        <div class="col-sm-8">${studentProfile.maSinhVien}</div>
                    </div>
                    <div class="mb-4 row align-items-center">
                        <label class="col-sm-4 col-form-label fw-bold">Tên sinh viên:</label>
                        <div class="col-sm-8">${studentProfile.tenSinhVien}</div>
                    </div>
                    <div class="mb-4 row align-items-center">
                        <label class="col-sm-4 col-form-label fw-bold">Số CMND:</label>
                        <div class="col-sm-8">${studentProfile.soCMND}</div>
                    </div>
                    <div class="mb-4 row align-items-center">
                        <label class="col-sm-4 col-form-label fw-bold">Số điện thoại:</label>
                        <div class="col-sm-8">${studentProfile.soDienThoai}</div>
                    </div>
                    <div class="mb-4 row align-items-center">
                        <label class="col-sm-4 col-form-label fw-bold">Email:</label>
                        <div class="col-sm-8">${studentProfile.email}</div>
                    </div>
                    <div class="mb-4 row align-items-center">
                        <label class="col-sm-4 col-form-label fw-bold">Giới tính:</label>
                        <div class="col-sm-8">${studentProfile.gioiTinh}</div>
                    </div>
                    <div class="mb-4 row align-items-center">
                        <label class="col-sm-4 col-form-label fw-bold">Lớp học:</label>
                        <div class="col-sm-8">${studentProfile.tenLop}</div>
                    </div>

                    <div class="text-center mt-4">
                        <button class="btn btn-primary px-4" data-bs-toggle="modal" data-bs-target="#editModal">
                            <i class="bi bi-pencil-square"></i> Chỉnh sửa
                        </button>
                        <c:if test="${not empty phongDTO}">
                            <button class="btn btn-info px-4 ms-2" data-bs-toggle="modal" data-bs-target="#roomModal">
                                <i class="bi bi-house-door"></i> Xem thông tin phòng ở
                            </button>
                        </c:if>
                        <c:if test="${empty phongDTO}">
                            <div class="alert alert-warning text-center mt-4" role="alert">
                                Bạn chưa có thông tin hợp đồng hoặc phòng ở.
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal chỉnh sửa thông tin -->
<div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form action="/students" method="post">
                <div class="modal-header bg-warning text-white">
                    <h5 class="modal-title" id="editModalLabel">Chỉnh sửa thông tin sinh viên</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Đóng"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="tenSinhVien" class="form-label">Tên sinh viên</label>
                        <input type="text" class="form-control" id="tenSinhVien" name="tenSinhVien" value="${studentProfile.tenSinhVien}" required>
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email" value="${studentProfile.email}" required>
                    </div>
                    <div class="mb-3">
                        <label for="soDienThoai" class="form-label">Số điện thoại</label>
                        <input type="text" class="form-control" id="soDienThoai" name="soDienThoai" value="${studentProfile.soDienThoai}" required>
                    </div>
                    <div class="mb-3">
                        <label for="soCMND" class="form-label">Số CMND</label>
                        <input type="text" class="form-control" id="soCMND" name="soCMND" value="${studentProfile.soCMND}" required>
                    </div>
                    <!-- Hidden input để giữ mã sinh viên nếu cần -->
                    <input type="hidden" name="maSinhVien" value="${studentProfile.maSinhVien}">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                    <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Modal thông tin phòng ở -->
<div class="modal fade" id="roomModal" tabindex="-1" aria-labelledby="roomModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title text-center" id="roomModalLabel">Thông tin phòng ở</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Đóng"></button>
            </div>
            <div class="modal-body">
                <div class="mb-4 row align-items-center">
                    <label class="col-sm-4 col-form-label fw-bold">Tên phòng:</label>
                    <div class="col-sm-8">${phongDTO.tenPhong}</div>
                </div>
                <div class="mb-4 row align-items-center">
                    <label class="col-sm-4 col-form-label fw-bold">Loại phòng:</label>
                    <div class="col-sm-8">${phongDTO.loaiPhong}</div>
                </div>
                <div class="mb-4 row align-items-center">
                    <label class="col-sm-4 col-form-label fw-bold">Sức chứa:</label>
                    <div class="col-sm-8">${phongDTO.soNguoiToiDa} người</div>
                </div>
                <div class="mb-4 row align-items-center">
                    <label class="col-sm-4 col-form-label fw-bold">Số người hiện tại:</label>
                    <div class="col-sm-8">${phongDTO.soNguoiHienTai} người</div>
                </div>
                <div class="mb-4 row align-items-center">
                    <label class="col-sm-4 col-form-label fw-bold">Giá phòng / tháng:</label>
                    <div class="col-sm-8"><fmt:formatNumber type="number" maxFractionDigits="0" value="${phongDTO.giaMoiThang}" /> VNĐ</div>
                </div>
                <div class="mb-4 row align-items-center">
                    <label class="col-sm-4 col-form-label fw-bold">Trạng thái sử dụng:</label>
                    <div class="col-sm-8">${phongDTO.trangThai}</div>
                </div>
                <div class="mb-4 row align-items-center">
                    <label class="col-sm-4 col-form-label fw-bold">Hợp đồng từ:</label>
                    <div class="col-sm-8"><fmt:formatDate value="${phongDTO.thoiGianBatDauAsDate}" pattern="dd/MM/yyyy" />
                    </div>
                </div>
                <div class="mb-4 row align-items-center">
                    <label class="col-sm-4 col-form-label fw-bold">Đến ngày:</label>
                    <div class="col-sm-8"><fmt:formatDate value="${phongDTO.thoiGianKetThucAsDate}" pattern="dd/MM/yyyy" />
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
            </div>
        </div>
    </div>
</div>
<!-- Toast thông báo -->
<div class="position-fixed bottom-0 end-0 p-3" style="z-index: 1055">
    <div id="successToast" class="toast align-items-center text-white bg-success border-0" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="d-flex">
            <div class="toast-body">
                ${sessionScope.successMessage}
            </div>
            <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
    </div>
</div>
<c:remove var="successMessage" scope="session" />

<%@ include file="../../header_navbar_footer/footer.jsp" %>

<!-- Bootstrap 5 JS (optional for future features) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        const toastEl = document.getElementById("successToast");
        if (toastEl && toastEl.querySelector(".toast-body").textContent.trim() !== "") {
            const toast = new bootstrap.Toast(toastEl, { delay: 3000 });
            toast.show();
        }
    });
</script>

</body>
</html>