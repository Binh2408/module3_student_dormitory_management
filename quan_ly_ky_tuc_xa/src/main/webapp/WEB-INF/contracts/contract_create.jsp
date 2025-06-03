<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/2/2025
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/WEB-INF/common/head_admin.jsp"/>
<body>
<div class="d-flex justify-content-center align-items-center container-fluid"
     style="height: 100vh">
    <div class="card shadow p-4" style="width: 60%">
        <h2 class="text-center text-success">Create Contract</h2>
        <form method="post" id="contractForm" class="needs-validation" novalidate>
            <div class="row">
                <!--               font hợp đồng-->
                <div class="col-sm-6">
                    <div class="row">
                        <label class="form-label col-sm-4">ContractCode</label>
                        <div class="col-sm-8">
                            <input name="contractCode" type="text" class="form-control mb-3" placeholder="ContractCode"
                                   required
                                   value="${contract.contractCode}" pattern="^HD-\d{3}$">
                            <div class="invalid-feedback">please enter the contract code in format SV-HD-XXX</div>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">StudentCode</label>
                        <div class="col-sm-8">
                            <input name="studentCode" type="text" class="form-control mb-3" placeholder="StudentCode"
                                   required
                                   value="${contract.studentCode}" pattern="^SV-\d{3}$">
                            <div class="invalid-feedback">Please enter the student code in format SV-XXX</div>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">RoomName</label>
                        <div class="col-sm-8">
                            <input name="roomName" type="text" class="form-control mb-3" placeholder="RoomName" required
                                   value="${contract.roomName}" pattern="^RO-\d{3}$">
                            <div class="invalid-feedback">Please enter the room name in format RO-XXX</div>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">StartDay</label>
                        <div class="col-sm-8">
                            <input name="startDay" type="date" class="form-control mb-3" required
                                   value="${contract.startDay}">
                            <div class="invalid-feedback">Please select start date</div>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">EndDay</label>
                        <div class="col-sm-8">
                            <input name="endDay" type="date" class="form-control mb-3" required
                                   value="${contract.endDay}">
                            <div class="invalid-feedback">Please select end date</div>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form-label col-sm-4">RentalCost</label>
                        <div class="col-sm-8">
                            <input name="rentalCost" type="number" class="form-control mb-3" required
                                   value="${contract.rentalCost}" min="0">
                            <div class="invalid-feedback">Please enter rental price</div>
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
