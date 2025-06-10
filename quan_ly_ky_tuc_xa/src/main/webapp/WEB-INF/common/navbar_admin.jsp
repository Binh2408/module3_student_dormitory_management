<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/2/2025
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="row">
    <h1 class="text-center" style="color: #4CAF50">HỆ THỐNG QUẢN LÝ KÝ TÚC XÁ</h1>
</header>
<nav class="navbar navbar-expand-lg">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <button class="btn btn-outline-success m-1"
                            onclick="window.location.href='/admin?action=StudentManagement'">Quản Lý Sinh Viên
                    </button>
                </li>
                <li class="nav-item">
                    <button class="btn btn-outline-success m-1"
                            onclick="window.location.href='/admin?action=ContractManagement'">Quản Lý Hợp Đồng
                    </button>
                </li>
                <li class="nav-item">
                    <button class="btn btn-outline-success m-1"
                            onclick="window.location.href='/admin?action=ViolationManagement'">Quản Lý Vi Phạm
                    </button>
                </li>
                <li class="nav-item">
                    <button class="btn btn-outline-success m-1"
                            onclick="window.location.href='/admin?action=RevenueStatistics'">Thống Kê Doanh Thu
                    </button>
                </li>
                <li class="nav-item">
                    <button class="btn btn-outline-success m-1"
                            onclick="window.location.href='/admin?action=RoomManagement'">QuảnLýPhòng
                    </button>
                </li>
                <li class="nav-item">
                    <button class="btn btn-outline-success m-1"
                            onclick="window.location.href='/admin?action=Notification'">Thông báo
                    </button>
                </li>
            </ul>
        </div>
    </div>
</nav>

