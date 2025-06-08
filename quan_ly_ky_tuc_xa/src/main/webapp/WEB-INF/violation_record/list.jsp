<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/3/2025
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="/WEB-INF/common/head_admin.jsp"/>
<body>
<jsp:include page="/WEB-INF/common/navbar_admin.jsp"/>

<!-- QUẢN LÝ VI PHẠM -->
<div class="container container-section" id="violation-section">
    <h2 class="text-center mt-3 mb-4 text-success">Quản Lý Vi Phạm</h2>
    <button class="btn btn-success mb-3" data-bs-toggle="modal" data-bs-target="#createContractModal"
            onclick="window.location.href='violationRecord?action=add'">
        <i class="fa fa-plus"></i> Thêm Biên Bản
    </button>
    <table class="table table-sm table-bordered text-center table-striped">
        <thead class="table-light">
        <tr>
            <th>No</th>
            <th>ViolationStudentName</th>
            <th>ViolationTypeName;</th>
            <th>LevelOfViolationName</th>
            <th>TimeOfViolation</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="bienBanViPhamDtoReponse" items="${bienBanViPhamDtoReponseList}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${bienBanViPhamDtoReponse.tenSinhVien}</td>
                <td>${bienBanViPhamDtoReponse.tenLoaiViPham}</td>
                <td>${bienBanViPhamDtoReponse.mucDoViPham}</td>
                <td>${bienBanViPhamDtoReponse.thoiGianViPham}</td>
                <td>
                    <button class="btn btn-sm btn-warning btn-update me-1" data-bs-toggle="modal"
                            data-bs-target="#updateContractModal">
                        <i class="fa fa-edit"></i>
                    </button>
                    <button class="btn btn-sm btn-danger btn-delete" data-bs-toggle="modal"
                            data-bs-target="#confirmDeleteModal">
                        <i class="fa fa-trash"></i>
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
