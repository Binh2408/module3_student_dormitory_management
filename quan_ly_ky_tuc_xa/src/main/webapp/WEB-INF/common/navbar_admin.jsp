<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/2/2025
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="row">
    <h1 class="text-center" style="color: #4CAF50">DORMITORY MANAGEMENT SYSTEM</h1>
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
                    <button class="btn btn-outline-info m-1"
                            onclick="window.location.href='/admin?action=StudentManagement'">StudentManagement
                    </button>
                </li>
                <li class="nav-item">
                    <button class="btn btn-outline-info m-1"
                            onclick="window.location.href='/admin?action=ContractManagement'">ContractManagement
                    </button>
                </li>
                <li class="nav-item">
                    <button class="btn btn-outline-info m-1"
                            onclick="window.location.href='/admin?action=ViolationManagement'">ViolationManagement
                    </button>
                </li>
                <li class="nav-item">
                    <button class="btn btn-outline-info m-1"
                            onclick="window.location.href='/admin?action=RevenueStatistics'">RevenueStatistics
                    </button>
                </li>
                <li class="nav-item">
                    <button class="btn btn-outline-info m-1"
                            onclick="window.location.href='/admin?action=RoomManagement'">RoomManagement
                    </button>
                </li>
            </ul>
        </div>
    </div>
</nav>

