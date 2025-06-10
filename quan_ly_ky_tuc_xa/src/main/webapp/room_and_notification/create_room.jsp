<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm mới sản phẩm</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-image: url('https://anviethouse.vn/wp-content/uploads/2021/06/Thiet-ke-shop-dien-thoai-1-5.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-position: center;
            font-family: 'Segoe UI', sans-serif;
        }

        .form-container {
            background-color: rgba(255, 255, 255, 0.95);
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
            <h2 class="mb-4">Thêm phòng mới</h2>
            <form method="post" action="phongs" class="row g-3">
                <input type="hidden" name="action" value="create">
                <input type="hidden" name="ma_phong">
                <div>
                    <label class="form-label">Tên phòng</label>
                    <input value="${phong.ten_phong}" name="ten_phong" class="form-control" required>
                </div>
                <div>
                    <label class="form-label">Số người tối đa</label>
                    <input value="${phong.so_nguoi_do_da}" name="so_nguoi_do_da" type="number" class="form-control" required>
                </div>
                <div>
                    <label class="form-label"> Số người hiện tại</label>
                    <input value="${phong.so_nguoi_hien_tai}" name="so_nguoi_hien_tai" type="text" class="form-control" required>
                </div>
                <div>
                    <label class="form-label">Giá mỗi tháng</label>
                    <input value="${phong.giaMoiThang}" name="gia_moi_thang" type="text"  class="form-control" required>
                </div>
                <select name="ma_trang_thai">
                    <option value="" disabled selected>-----------------------chon trạng thái phòng-----------------------</option>
                    <c:forEach items="${listTrangThai}" var="trangThai">
                        <option value="${trangThai.maTrangThai}">${trangThai.tenTrangThai}</option>
                    </c:forEach>
                </select>
                <select name="ma_loai_phong">
                    <option value="" disabled selected>--------------------------chon loại phòng--------------------------</option>
                    <c:forEach items="${listLoaiPhong}" var="loaiPhong">
                        <option value="${loaiPhong.maLoaiPhong}">${loaiPhong.tenLoaiPhong}</option>
                    </c:forEach>
                </select>
                <div class="col-12 text-center mt-4">
                    <button type="submit" class="btn btn-primary px-5">Thêm phòng</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>