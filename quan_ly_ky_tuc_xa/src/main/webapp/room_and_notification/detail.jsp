<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 6/10/2025
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hiển thị chi tiết</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <style>
        body {
            background-image: url('https://img.tripi.vn/cdn-cgi/image/width=700,height=700/https://gcs.tripi.vn/public-tripi/tripi-feed/img/473644lEJ/dai-hoc-fpt-ha-noi-117058.jpg');
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
        #table{
            min-width: 400px; width: 50%;
        }
    </style>
</head>
<body>
<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-10 form-container">
            <h2 class="text-center">Chi tiết phòng</h2>
            <table id="table" class="table table-bordered w-50 mx-auto ">
                <tr>
                    <th>Mã phòng</th>
                    <td>${phong.idPhong}</td>
                </tr>
                <tr>
                    <th>Tên phòng</th>
                    <td>${phong.tenPhong}</td>
                </tr>
                <tr>
                    <th>Số người tối đa</th>
                    <td>${phong.soNguoiToiDa}</td>
                </tr>
                <tr>
                    <th>Số người hiện tại</th>
                    <td>${phong.soNguoiHienTai}</td>
                </tr>
                <tr>
                    <th>Giá phòng</th>
                    <td><fmt:formatNumber value="${phong.giaMoiThang}" type="number" groupingUsed="true"/> VNĐ</td>
                </tr>
                <tr>
                    <th>Loại phòng</th>
                    <td>
                        <c:forEach var="lp" items="${listLoaiPhong}">
                            <c:if test="${lp.maLoaiPhong == phong.loaiPhong}">
                                ${lp.tenLoaiPhong}
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <th>Trạng thái</th>
                    <td>
                        <c:forEach var="tt" items="${listTrangThai}">
                            <c:if test="${tt.maTrangThai == phong.trangThai}">
                                ${tt.tenTrangThai}
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
            </table>
            <div class="text-center">
                <a class="btn btn-secondary" href="/phongs">Quay lại danh sách</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
