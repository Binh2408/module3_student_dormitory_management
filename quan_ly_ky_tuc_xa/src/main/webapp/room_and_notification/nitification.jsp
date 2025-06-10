<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 6/10/2025
  Time: 12:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thông báo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<style>
    .notification-table {
        border-collapse: collapse;
        width: 100%;
        font-family: Arial, sans-serif;
    }

    .notification-table thead {
        background-color: #FFA500; /* màu cam */
        color: white;
    }

    .notification-table th, .notification-table td {
        padding: 12px;
        border: 1px solid #ffcc80;
    }

    .notification-table tr:nth-child(even) {
        background-color: #fff3e0;
    }

    .notification-table tr:hover {
        background-color: #ffe0b2;
    }
</style>

<body>
<h3>Danh sách thông báo</h3>
<table class="table table-bordered table-hover mt-4 notification-table">
    <thead class="table-warning text-center">
    <tr>
        <th>Mã thông báo</th>
        <th>Tiêu đề</th>
        <th>Nội dung</th>
        <th>Thời gian gửi</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="tb" items="${thongBaoList}">
        <tr>
            <td class="text-center">${tb.maThongBao}</td>
            <td><strong>${tb.tieuDe}</strong></td>
            <td>${tb.noiDung}</td>
            <td>${tb.thoiGianGui}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
