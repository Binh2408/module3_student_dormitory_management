<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/3/2025
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/WEB-INF/common/head_admin.jsp"/>
<body>
<div class="d-flex justify-content-center align-items-center container-fluid"
     style="height: 100vh">
    <div class="card shadow p-4" style="width: 60%">
        <h2 class="text-center text-success">Create ViolationRecord</h2>
        <form method="post" id="contractForm" class="needs-validation" novalidate>
            <div class="row">
                <div class="col-sm-6">

                    <div class="row">
                        <label class="form-label col-sm-4">ViolationRecordId</label>
                        <div class="col-sm-8">
                            <input name="violationRecordCode" type="text" class="form-control mb-3"
                                   pattern="^BBVP-\d{3}"
                                   placeholder="violationRecordCode"
                                   required
                                   value="${violation.violationRecordCode}">
                            <div class="invalid-feedback">Vui lòng nhập mã sinh viên đúng định dạng vd:BBVP-000</div>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">StudentCode</label>
                        <div class="col-sm-8">
                            <input name="violationStudentCode" type="text" class="form-control mb-3"
                                   placeholder="violationStudentName"
                                   required
                                   value="${violation.violationStudentCode}"
                                   pattern="^SV-\d{3}$">
                            <div class="invalid-feedback">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">ViolationTypeName</label>
                        <div class="col-sm-8">
                            <input name="violationTypeName" type="text" class="form-control mb-3"
                                   placeholder="violationTypeName" required pattern="^([\p{Lu}][\p{L}]*)(\s[\p{Lu}][\p{L}]*)+$"
                                   value="${violation.violationTypeName}">
                            <div class="invalid-feedback">Vui lòng nhập loại vi phạm</div>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">LevelOfViolation</label>
                        <div class="col-sm-8">
                            <input name="levelOfViolationName" type="text" class="form-control mb-3" required
                                   value="${violation.levelOfViolationName}" placeholder="levelOfViolationName">
                            <div class="invalid-feedback">Vui lòng nhập mức độ vi phạm</div>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">TimeOfViolation</label>
                        <div class="col-sm-8">
                            <input name="timeOfViolation" type="date" class="form-control mb-3" required
                                   value="${violation.timeOfViolation}">
                            <div class="invalid-feedback">Vui lòng chọn ngày vi phạm</div>
                        </div>
                    </div>
                </div>

                <!--              font thông tin sinh vien-->
                <div class="col-sm-6">
                    <div class="row">
                        <label class="form-label col-sm-4">StudentName</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control mb-3" readonly>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">Birthday</label>
                        <div class="col-sm-8">
                            <input type="date" class="form-control mb-3" readonly>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">Gender</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control mb-3" readonly>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">CMND</label>
                        <div class="col-sm-8">
                            <input type="number" class="form-control mb-3" readonly>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">Address</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control mb-3" readonly>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">NumberPhone</label>
                        <div class="col-sm-8">
                            <input type="number" class="form-control mb-3" readonly>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row justify-content-center">
                <div class="col-sm-4">
                    <button type="submit" class="btn btn-outline-success w-100">Create</button>
                </div>
                <div class="col-sm-4">
                    <button type="button" class="btn btn-outline-danger w-100"
                            onclick="window.location.href='contract'">Exit
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}js/app.js"></script>

</body>
</html>
