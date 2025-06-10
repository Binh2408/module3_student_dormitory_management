<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="/WEB-INF/common/head_admin.jsp"/>
<body>
<jsp:include page="/WEB-INF/common/navbar_admin.jsp"/>

<div class="container container-section">
    <h2 class="text-center text-primary my-4">Cập Nhật Tài Khoản Sinh Viên</h2>

    <c:if test="${not empty error}">
        <div class="alert alert-danger text-center">${error}</div>
    </c:if>

    <form method="post" action="${pageContext.request.contextPath}/account/update">
        <!-- Mã tài khoản và mã sinh viên ẩn -->
        <input type="hidden" name="maTaiKhoan" value="${account.maTaiKhoan}"/>
        <input type="hidden" name="maSinhVien" value="${sinhVien.sinhVienId}"/>

        <!-- Tài khoản -->
        <div class="row mb-3">
            <div class="col-md-6">
                <label class="form-label">Tên Đăng Nhập</label>
                <input type="text" class="form-control" name="userName" value="${account.userName}" required/>
            </div>
            <div class="col-md-6">
                <label class="form-label">Mật Khẩu (mới)</label>
                <input type="password" class="form-control" name="password" placeholder="••••••" required/>
            </div>
        </div>

        <hr/>

        <h5 class="text-primary mb-3">Thông Tin Sinh Viên</h5>

        <div class="row mb-3">
            <div class="col-md-6">
                <label class="form-label">Họ Tên Sinh Viên</label>
                <input type="text" class="form-control" name="tenSinhVien" value="${sinhVien.tenSinhVien}" required/>
            </div>
            <div class="col-md-6">
                <label class="form-label">Mã Lớp</label>
                <input type="number" class="form-control" name="maLop" value="${sinhVien.maLop}" required/>
            </div>
        </div>

        <div class="row mb-3">
            <div class="col-md-6">
                <label class="form-label">Giới Tính</label>
                <select name="maGioiTinh" class="form-control" required>
                    <option value="1" ${sinhVien.maGioiTinh == 1 ? "selected" : ""}>Nam</option>
                    <option value="2" ${sinhVien.maGioiTinh == 2 ? "selected" : ""}>Nữ</option>
                </select>
            </div>
            <div class="col-md-6">
                <label class="form-label">Số CMND/CCCD</label>
                <input type="text" class="form-control" name="soCMND" value="${sinhVien.soCMND}" required/>
            </div>
        </div>

        <div class="row mb-3">
            <div class="col-md-6">
                <label class="form-label">Email</label>
                <input type="email" class="form-control" name="email" value="${sinhVien.email}" required/>
            </div>
            <div class="col-md-6">
                <label class="form-label">Số Điện Thoại</label>
                <input type="text" class="form-control" name="soDienThoai" value="${sinhVien.soDienThoai}" required/>
            </div>
        </div>

        <div class="text-end">
            <button type="submit" class="btn btn-primary">
                <i class="fa fa-save"></i> Lưu Thay Đổi
            </button>
            <a href="${pageContext.request.contextPath}/account/list" class="btn btn-secondary">Huỷ</a>
        </div>
    </form>
</div>

</body>
</html>
