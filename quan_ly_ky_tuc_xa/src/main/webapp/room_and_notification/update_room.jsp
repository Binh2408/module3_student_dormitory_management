<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Cập nhật phòng</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

  <style>
    body {
      background-image: url('https://laizhongliuxue.com/wp-content/uploads/2020/11/Picture16.png');
      background-size: cover;
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-position: center;
      font-family: 'Segoe UI', sans-serif;
    }

    .form-container {
      background-color: rgba(255, 255, 255, 0.6);
      border-radius: 12px;
      padding: 30px;
      margin-top: 50px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
      width: 40%;
    }

    h2 {
      text-align: center;
      color: #333;
    }
  </style>
</head>
<body>
<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-10 form-container">
      <h2 class="mb-4">Cập nhật phòng</h2>
      <form method="post" action="phongs" class="row g-3">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${phong.idPhong}">
        <div>
          <label class="form-label">Tên phòng</label>
          <input value="${phong.tenPhong}" name="ten_phong" type="text" class="form-control" required>
        </div>
        <div>
          <label class="form-label">Số người tối đa</label>
          <input value="${phong.soNguoiToiDa}" name="so_nguoi_do_da" type="number" class="form-control" required>
        </div>
        <div>
          <label class="form-label">Số người hiện tại</label>
          <input value="${phong.soNguoiHienTai}" name="so_nguoi_hien_tai" type="number" class="form-control" required>
        </div>
        <div>
          <label class="form-label">Giá tiền mỗi tháng</label>
          <input value="${phong.giaMoiThang}" name="gia_moi_thang" type="number"  class="form-control" required>
        </div>
        <select name="ma_trang_thai">
          <option>-----------------------chon trạng thái phòng-----------------------</option>
          <c:forEach items="${listTrangThai}" var="trangThai">
<%--            <option value="${trangThai.maTrangThai}">${trangThai.tenTrangThai}</option>--%>
            <c:choose>
              <c:when test="${trangThai.maTrangThai == phong.trangThai}">
                <option value="${trangThai.maTrangThai}" selected>${trangThai.tenTrangThai}</option>
              </c:when>
              <c:otherwise>
                <option value="${trangThai.maTrangThai}">${trangThai.tenTrangThai}</option>
              </c:otherwise>
            </c:choose>
          </c:forEach>
        </select>
        <select name="ma_loai_phong">
          <c:forEach items="${listLoaiPhong}" var="loaiPhong">
<%--            <option value="${loaiPhong.maLoaiPhong}">${loaiPhong.tenLoaiPhong}</option>--%>
            <c:choose>
              <c:when test="${loaiPhong.maLoaiPhong == phong.loaiPhong}">
                <option value="${loaiPhong.maLoaiPhong}" selected>${loaiPhong.tenLoaiPhong}</option>
              </c:when>
              <c:otherwise>
                <option value="${loaiPhong.maLoaiPhong}">${loaiPhong.tenLoaiPhong}</option>
              </c:otherwise>
            </c:choose>
          </c:forEach>
        </select>
        <div hidden="hidden">
          <label class="form-label">trạng thái xóa</label>
          <input  value="${phong.isDelete}" name="is_delete" type="number" class="form-control" required>
        </div>
        <div class="col-12 text-center mt-4">
          <button type="submit" class="btn btn-primary px-5">Cập nhật phòng</button>
          <a href="phongs" class="btn btn-light px-5">Quay lại</a>
        </div>
      </form>
    </div>
  </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
