<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

<header class="py-3 shadow-sm position-relative" style="background-color: #ffffff;">
    <!-- Logout Icon -->
    <a href="${pageContext.request.contextPath}/logout"
       class="position-absolute top-0 end-0 m-3 text-danger"
       title="Đăng xuất">
        <i class="bi bi-box-arrow-right fs-4"></i>
    </a>

    <!-- Title -->
    <h1 class="text-center fw-bold" style="color: #4CAF50;">HỆ THỐNG QUẢN LÝ KÝ TÚC XÁ</h1>
</header>


<nav class="navbar navbar-expand-lg" style="background-color: #e65100;">
    <div class="container-fluid">
        <button class="navbar-toggler text-white" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">
            <!-- Navigation Menu -->
            <ul class="navbar-nav d-flex flex-wrap justify-content-evenly w-100">
                <li class="nav-item">
                    <a class="nav-link text-white fw-semibold px-3"
                       href="${pageContext.request.contextPath}/account/list">
                        Quản Lý Tài Khoản, Thông Tin
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white fw-semibold px-3"
                       href="/admin?action=ContractManagement">
                        Quản Lý Hợp Đồng
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white fw-semibold px-3"
                       href="/admin?action=ViolationManagement">
                        Quản Lý Vi Phạm
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white fw-semibold px-3"
                       href="/admin?action=RevenueStatistics">
                        Thống Kê Doanh Thu
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white fw-semibold px-3"
                       href="/admin?action=RoomManagement">
                        Quản Lý Phòng
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white fw-semibold px-3"
                       href="/admin?action=Notification">
                        Thông Báo
                    </a>
                </li>
            </ul>

        </div>
    </div>
</nav>
