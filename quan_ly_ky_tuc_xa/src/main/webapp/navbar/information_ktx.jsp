<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/4/2025
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thông tin Ký túc xá</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <link rel="stylesheet" href="../css/home_page.css">
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        h2 {
            color: #ff6200;
            font-weight: bold;
            font-size: 24px;
        }
        .custom-list li {
            position: relative;
            padding-left: 20px;
            color: #333;
            font-size: 16px;
            line-height: 1.6;
        }
        .custom-list li:before {
            content: "✔";
            position: absolute;
            left: 0;
            color: #ff6200;
            font-size: 16px;
        }
        .img-container {
            max-height: 300px;
            overflow: hidden;
        }
        .img-container img {
            width: 100%;
            height: auto;
        }
    </style>
</head>
<body>
<%@ include file="../header_navbar_footer/header.jsp" %>
<div class="container my-5">
    <!-- Phía Tây -->
    <div class="row align-items-center mb-5">
        <div class="col-md-6 order-md-1">
            <div class="img-container">
                <img src="https://www.ktxhcm.edu.vn/uploads/banners/ktx-1.jpg" class="img-fluid"
                     alt="Ký túc xá Phía Tây">
            </div>
        </div>
        <div class="col-md-6 order-md-2">
            <h2>KÝ TÚC XÁ PHÍA TÂY:</h2>
            <ul class="list-unstyled custom-list">
                <li>Địa chỉ: 08 Hà Văn Tính, phường Hòa Khánh Nam, quận Liên Chiểu, TP. Đà Nẵng (cách Đại học Sư phạm Đà
                    Nẵng ~1.3km, cách Đại học Bách Khoa Đà Nẵng ~1.5km)
                </li>
                <li>Diện tích: 25.388m2</li>
                <li>Gồm 06 tòa nhà, có sức chứa khoảng 4.500 sinh viên.</li>
                <li>06 tòa nhà 5 tầng gồm: A, B, C, D, E, F</li>
                <li>Khu vực bố trí sinh viên nam: tầng 5 khu A, tầng 4, 5 khu B, C và khu D, E, F</li>
                <li>Khu vực bố trí sinh viên nữ: tầng 1, 2, 3, 4 khu A, tầng 1, 2, 3 khu B, C</li>
                <li>Khu vực dịch vụ & văn phòng: Khu vực tầng 1 khu điều hành Trung tâm</li>
            </ul>
        </div>
    </div>

    <!-- Phía Đông -->
    <div class="row align-items-center">
        <div class="col-md-6 order-md-2">
            <div class="img-container">
                <img src="https://www.ktxhcm.edu.vn/uploads/banners/ktx-2.jpg" class="img-fluid"
                     alt="Ký túc xá Phía Đông">
            </div>
        </div>
        <div class="col-md-6 order-md-1">
            <h2>KÝ TÚC XÁ PHÍA ĐÔNG:</h2>
            <ul class="list-unstyled custom-list">
                <li>Địa chỉ: Đường Đoàn Uẩn, phường Khuê Mỹ, quận Ngũ Hành Sơn, TP. Đà Nẵng (cách Đại học Kiến trúc Đà
                    Nẵng ~ 2.5km, cách Đại học Kinh tế Đà Nẵng ~ 1.7km)
                </li>
                <li>Diện tích: 11.964m2</li>
                <li>Gồm 03 tòa nhà, có sức chứa khoảng 2.500 sinh viên</li>
                <li>Gồm 03 tòa nhà: A, B, C (A, B: 5 tầng, C: 9 tầng)</li>
                <li>Khu vực bố trí sinh viên nam: Khu A, tầng 4, 5 Khu B</li>
                <li>Khu vực bố trí sinh viên nữ: Khu C, tầng 1, 2, 3 Khu B</li>
                <li>Khu vực dịch vụ & văn phòng: Tầng 01, 02 khu C</li>
            </ul>
        </div>
    </div>
    <hr>
    <div class="row align-items-center mb-5">
        <div class="col-md-6 order-md-1">
            <div class="img-container">
                <img src="https://ktxdn.vn/wp-content/uploads/2015/10/service-768x467.jpg" class="img-fluid"
                     alt="Dịch vụ tiện ích">
            </div>
        </div>
        <div class="col-md-6 order-md-2">
            <h2>DỊCH VỤ TIỆN ÍCH ĐA DẠNG:</h2>
            <ul class="list-unstyled custom-list">
                <li>Nhà ăn, điểm tâm</li>
                <li>Siêu thị mini tiện lợi</li>
                <li>Câu lạc bộ thể hình</li>
                <li>Hệ thống wifi phủ sóng khắp Ký túc xá</li>
                <li>Và còn rất nhiều dịch vụ tiện ích khác đi kèm đáp ứng nhu cầu ăn, ở, học tập và sinh hoạt của các bạn sinh viên…</li>
            </ul>
        </div>
    </div>
</div>
<%@ include file="../header_navbar_footer/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>