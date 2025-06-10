<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Thông Tin Hợp Đồng</title>
  <!-- Bootstrap 5 CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .card {
      border: none;
      border-radius: 15px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    .card-header {
      background: linear-gradient(45deg, #ff6200, #cc4d00);
      color: white;
      border-radius: 15px 15px 0 0;
    }
    .card-body {
      background-color: white;
      padding: 2rem;
    }
    .info-row {
      margin-bottom: 1.5rem;
    }
    .info-label {
      font-weight: 600;
      color: #333;
    }
    .btn-custom {
      padding: 0.5rem 1.5rem;
      border-radius: 10px;
    }
    .alert {
      margin-bottom: 1.5rem;
    }
  </style>
</head>
<body class="bg-light">
<%@ include file="../../header_navbar_footer/header.jsp" %>

<div class="container mt-5">
  <c:if test="${not empty error}">
    <div class="alert alert-danger text-center">${error}</div>
  </c:if>

  <c:if test="${not empty thongTinHopDong}">
    <div class="card">
      <div class="card-header text-white">
        <h5 class="mb-0 text-center">Thông tin hợp đồng</h5>
      </div>
      <div class="card-body">
        <div class="info-row row align-items-center">
          <label class="col-sm-4 info-label">Phòng:</label>
          <div class="col-sm-8">${thongTinHopDong.tenPhong}</div>
        </div>
        <div class="info-row row align-items-center">
          <label class="col-sm-4 info-label">Loại phòng:</label>
          <div class="col-sm-8">${thongTinHopDong.tenLoaiPhong}</div>
        </div>
        <div class="info-row row align-items-center">
          <label class="col-sm-4 info-label">Số người tối đa:</label>
          <div class="col-sm-8">${thongTinHopDong.soNguoiToiDa}</div>
        </div>
        <div class="info-row row align-items-center">
          <label class="col-sm-4 info-label">Số người hiện tại:</label>
          <div class="col-sm-8">${thongTinHopDong.soNguoiHienTai}</div>
        </div>
        <div class="info-row row align-items-center">
          <label class="col-sm-4 info-label">Giá mỗi tháng:</label>
          <div class="col-sm-8"><fmt:formatNumber value="${thongTinHopDong.giaMoiThang}" type="number"/> VNĐ</div>
        </div>
        <div class="info-row row align-items-center">
          <label class="col-sm-4 info-label">Trạng thái phòng:</label>
          <div class="col-sm-8">${thongTinHopDong.trangThaiPhong}</div>
        </div>
        <div class="info-row row align-items-center">
          <label class="col-sm-4 info-label">Ngày bắt đầu:</label>
          <div class="col-sm-8">${thongTinHopDong.thoiGianBatDau}</div>
        </div>
        <div class="info-row row align-items-center">
          <label class="col-sm-4 info-label">Ngày kết thúc:</label>
          <div class="col-sm-8">${thongTinHopDong.thoiGianKetThuc}</div>
        </div>
      </div>
      <div class="card-footer text-center">
        <button class="btn btn-outline-primary btn-custom" onclick="window.print()">
          <i class="bi bi-printer"></i> In hợp đồng
        </button>
        <a href="../../home_page.jsp" class="btn btn-outline-secondary btn-custom ms-2">Quay lại</a>
      </div>
    </div>
  </c:if>

  <c:if test="${empty thongTinHopDong and empty error}">
    <div class="alert alert-warning text-center" role="alert">
      Không có thông tin hợp đồng để hiển thị.
    </div>
  </c:if>
</div>
<%@ include file="../../header_navbar_footer/footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</body>
</html>