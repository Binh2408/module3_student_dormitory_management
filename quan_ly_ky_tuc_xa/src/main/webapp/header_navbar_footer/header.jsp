<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/4/2025
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
  <style>
    /* Đồng bộ chiều cao các thành phần header phía phải */
    header form input,
    header form button,
    header .btn {
      height: 38px;
      padding-top: 6px;
      padding-bottom: 6px;
      line-height: 1.5;
      box-sizing: border-box;
    }

    .nav-link.nav-hover:hover {
      color: #ffd9c0 !important;
      text-decoration: underline;
      border-radius: 10px;
      background-color: rgba(255, 255, 255, 0.1); /* Nền nhạt khi hover */
    }

    .nav-link.active {
      color: #ffd9c0 !important;
      font-weight: bold;
      background-color: rgba(255, 255, 255, 0.1); /* Nền nhạt cho active */
      border-radius: 10px;
      text-decoration: none; /* Loại bỏ gạch chân khi active */
    }

    /* Đảm bảo không có dấu tick trong navbar */
    .navbar-nav li:before {
      content: none !important; /* Loại bỏ dấu tick nếu có */
    }
  </style>
</head>
<!-- Header -->
<header class="navbar navbar-expand-lg navbar-light bg-white shadow-sm py-3">
  <div class="container">
    <!-- Logo -->
    <a class="navbar-brand" href="homepage.jsp">
      <img src="https://subscription.codegym.vn/wp-content/uploads/2024/08/Logo-codegym-Subscription_1.png"
           alt="Logo" width="150">
    </a>

    <!-- Search form -->
    <form class="d-flex ms-auto" role="search">
      <input class="form-control me-2" type="search" placeholder="Tìm kiếm" aria-label="Search">
      <button class="btn text-white" style="background-color: #E85728FF" type="submit">
        <i class="bi bi-search"></i>
      </button>
    </form>
    <!-- Login Button -->
    <%
      Object account = session.getAttribute("account");
      if (account != null) {
    %>
    <!-- Đã đăng nhập: hiển thị icon -->
    <div class="dropdown ms-3">
      <button class="btn text-white dropdown-toggle" style="background-color: #E85728FF;" type="button" id="userMenu"
              data-bs-toggle="dropdown" aria-expanded="false">
        <i class="bi bi-person-circle"></i>
      </button>
      <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userMenu">
        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/students">Thông tin cá nhân</a></li>
        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Đăng xuất</a></li>
      </ul>
    </div>

    <%
    } else {
    %>
    <!-- Chưa đăng nhập: hiển thị nút đăng nhập -->
    <a href="sign_in" class="btn text-white" style="background-color: #E85728FF; margin-left: 10px">
      Đăng nhập
    </a>
    <%
      }
    %>
  </div>
</header>

<!-- Navbar (Navigation Menu) -->
<%
  String currentPage = request.getRequestURI(); // Lấy URI của trang hiện tại
%>
<nav class="navbar navbar-expand-lg" style="background-color: #E85728FF;">
  <div class="container">
    <button class="navbar-toggler text-white" type="button" data-bs-toggle="collapse" data-bs-target="#navbarMenu"
            aria-controls="navbarMenu" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-center" id="navbarMenu">
      <ul class="navbar-nav mx-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link text-white nav-hover <%= currentPage.contains("homepage") ? "active" : "" %>" href="../home_page.jsp">Trang chủ</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-white nav-hover <%= currentPage.contains("gioi-thieu") ? "active" : "" %>" href="gioi-thieu.jsp">Giới thiệu</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-white nav-hover <%= currentPage.contains("lien-he") ? "active" : "" %>" href="lien-he.jsp">Liên hệ</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-white nav-hover <%= currentPage.contains("information_ktx") ? "active" : "" %>" href="../navbar/information_ktx.jsp">Thông tin KTX</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-white nav-hover <%= currentPage.contains("gop-y") ? "active" : "" %>" href="gop-y.jsp">Góp ý</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-white nav-hover <%= currentPage.contains("hop-dong") ? "active" : "" %>" href="/contracts">Hợp đồng</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
</html>
