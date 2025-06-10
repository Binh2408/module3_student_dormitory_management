<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="/WEB-INF/common/head_admin.jsp" />
<body>
<jsp:include page="/WEB-INF/common/navbar_admin.jsp"/>

<div class="container container-section">
    <h2 class="text-center text-success my-4">Tạo Tài Khoản Sinh Viên</h2>

    <c:if test="${not empty error}">
        <div class="alert alert-danger text-center">${error}</div>
    </c:if>

    <form method="post" action="${pageContext.request.contextPath}/account/create">
        <div class="row mb-3">
            <div class="col-md-6">
                <label class="form-label">Tên Đăng Nhập</label>
                <input type="text" class="form-control" name="userName" required />
            </div>
            <div class="col-md-6">
                <label class="form-label">Mật Khẩu</label>
                <input type="password" class="form-control" name="password" required />
            </div>
        </div>

        <hr />

        <h5 class="text-primary mb-3">Thông Tin Sinh Viên</h5>

        <div class="row mb-3">
            <div class="col-md-6">
                <label class="form-label">Họ Tên Sinh Viên</label>
                <input type="text" class="form-control" name="tenSinhVien" required />
            </div>
            <div class="col-md-6">
                <label class="form-label">Mã Lớp</label>
                <input type="number" class="form-control" name="maLop" required />
            </div>
        </div>

        <div class="row mb-3">
            <div class="col-md-6">
                <label class="form-label">Giới Tính</label>
                <select name="maGioiTinh" class="form-control" required>
                    <option value="">-- Chọn Giới Tính --</option>
                    <option value="1">Nam</option>
                    <option value="2">Nữ</option>
                </select>
            </div>
            <div class="col-md-6">
                <label class="form-label">Số CMND/CCCD</label>
                <input type="text" class="form-control" name="soCMND" required />
            </div>
        </div>

        <div class="row mb-3">
            <div class="col-md-6">
                <label class="form-label">Email</label>
                <input type="email" class="form-control" name="email" required />
            </div>
            <div class="col-md-6">
                <label class="form-label">Số Điện Thoại</label>
                <input type="text" class="form-control" name="soDienThoai" required />
            </div>
        </div>

        <div class="text-end">
            <button type="submit" class="btn btn-success">
                <i class="fa fa-plus"></i> Tạo Tài Khoản
            </button>
            <a href="${pageContext.request.contextPath}/account/list" class="btn btn-secondary">
                Quay Lại
            </a>
        </div>
    </form>
</div>

</body>
</html>
