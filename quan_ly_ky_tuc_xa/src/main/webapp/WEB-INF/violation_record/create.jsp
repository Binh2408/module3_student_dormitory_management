<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="/WEB-INF/common/head_admin.jsp"/>
<body>
<div class="d-flex justify-content-center align-items-center container-fluid" style="height: 100vh">
    <div class="card shadow p-4" style="width: 50%">
        <h2 class="text-center text-success mb-4">Biên Bản Vi Phạm</h2>
        <form method="post" id="formViPham" class="needs-validation" novalidate>
            <div class="row">
                <div class="col-12">
                    <div class="mx-auto" style="max-width: 700px;">
                        <div class="row ">
                            <label class="form-label col-sm-4">Chọn Sinh Viên</label>
                            <div class="col-sm-8">
                                <div style="display: flex">
                                    <select name="tenSinhVien" id="sinhVien" required
                                            onchange="hienThiThongTinSinhVien(this)"
                                            data-size="5" class="form-control w-100">
                                        <option></option>
                                        <c:forEach items="${sinhVienDtoResponseList}" var="sinhVien" varStatus="status">
                                            <option value="${sinhVien.sinhVienId}"
                                                    data-tai-khoan="${sinhVien.userName}">
                                                SV: ${sinhVien.tenSinhVien}
                                            </option>
                                        </c:forEach>
                                    </select>
                                    <span id="sinhVienIcon"></span>
                                </div>
                                <p id="sinhVienLoi"></p>
                            </div>
                        </div>

                        <div class="row">
                            <label class="form-label col-sm-4">Tài Khoản SV</label>
                            <div class="col-sm-8">
                                <div style="display: flex">
                                    <input type="text" class="form-control" readonly id="taiKhoanSinhVien"
                                           onblur="kiemTraDuLieu()">
                                    <span id="taiKhoanSinhVienIcon"></span>
                                </div>
                                <p id="taiKhoanSinhVienLoi"></p>
                            </div>
                        </div>

                        <div class="row ">
                            <label class="form-label col-sm-4">Loại Vi Phạm</label>
                            <div class="col-sm-8">
                                <div style="display: flex">
                                    <select name="loaiViPham" class="form-select" required id="loaiViPham"
                                            onblur="kiemTraDuLieu()">
                                        <option></option>
                                        <c:forEach items="${loaiViPhamList}" var="loaiViPham">
                                            <option value="${loaiViPham.loaiViPhamId}"> ${loaiViPham.tenLoaiViPham}</option>
                                        </c:forEach>
                                    </select>
                                    <span id="loaiViPhamIcon"></span>
                                </div>
                                <p id="loaiViPhamLoi"></p>
                            </div>
                        </div>

                        <div class="row">
                            <label class="form-label col-sm-4">Mức độ vi phạm</label>
                            <div class="col-sm-8">
                                <div style="display: flex">
                                    <select name="mucDoViPham" class="form-select" required id="mucDoViPham"
                                            onblur="kiemTraDuLieu()">
                                        <option value="">-- Chọn mức độ --</option>
                                        <c:forEach items="${mucDoViPhamList}" var="mucDoViPham">
                                            <option value="${mucDoViPham.mucDoViPhamId}">${mucDoViPham.tenMucDoViPham}</option>
                                        </c:forEach>
                                    </select>
                                    <span id="mucDoViPhamIcon"></span>
                                </div>
                                <p id="mucDoViPhamLoi"></p>
                            </div>
                        </div>

                        <div class="row">
                            <label class="form-label col-sm-4">Thời Gian Vi Phạm</label>
                            <div class="col-sm-8">
                                <div style="display: flex">
                                    <input name="thoiGianViPham" type="date" class="form-control" required
                                           value="${contract.startDay}" id="thoiGianViPham" onblur="kiemTraDuLieu()">
                                    <span id="thoiGianViPhamIcon"></span>
                                </div>
                                <p id="thoiGianViPhamLoi"></p>
                            </div>
                        </div>

                        <div class="row mt-4 justify-content-center">
                            <div class="col-6 col-md-4">
                                <button type="submit" class="btn btn-outline-success w-100" id="taoMoiBienBan"
                                        disabled>Tạo Mới
                                </button>
                            </div>
                            <div class="col-6 col-md-4">
                                <button type="button" class="btn btn-outline-danger w-100"
                                        onclick="window.location.href='contract'">Thoát
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<script>


    function hienLoi(field, message) {
        document.getElementById(field + "Loi").innerText = message;
        document.getElementById(field + "Icon").innerHTML = `<i class="fa-solid fa-xmark"></i>`;
        document.getElementById(field + "Icon").style.color = 'red';
        document.getElementById(field + "Loi").style.color = 'red';
    }

    function hienThanhCong(field) {
        document.getElementById(field + "Loi").innerText = "";
        document.getElementById(field + "Icon").innerHTML = `<i class="fa-solid fa-check"></i>`;
        document.getElementById(field + "Icon").style.color = 'green';
    }

    function hienThiThongTinSinhVien(selectElement) {
        let option = selectElement.options[selectElement.selectedIndex];
        let taiKhoan = option ? option.getAttribute('data-tai-khoan') : "";
        document.getElementById("taiKhoanSinhVien").value = taiKhoan || "";
        kiemTraDuLieu();
    }

    function tinhSoThangGiuaHaiNgay(ngay1, ngay2) {
        let nam1 = ngay1.getFullYear();
        let thang1 = ngay1.getMonth(); // 0-11
        let nam2 = ngay2.getFullYear();
        let thang2 = ngay2.getMonth();

        return Math.abs((nam2 - nam1) * 12 + (thang2 - thang1));
    }

    function kiemTraDuLieu() {
        let sinhVien = document.getElementById("sinhVien").value;
        let taiKhoanSinhVien = document.getElementById("taiKhoanSinhVien").value;
        let loaiViPham = document.getElementById("loaiViPham").value;
        let mucDoViPham = document.getElementById("mucDoViPham").value;
        let thoiGianViPham = document.getElementById("thoiGianViPham").value;
        let thoiGianViPhamDate = new Date(thoiGianViPham);
        let thoiGianHienTai = new Date();

        if (sinhVien === "") {
            hienLoi("sinhVien", "Không được để trống")
        } else hienThanhCong("sinhVien");

        if (taiKhoanSinhVien === "") {
            hienLoi("taiKhoanSinhVien", "Không được để trống");
        } else hienThanhCong("taiKhoanSinhVien");

        if (loaiViPham === "") {
            hienLoi("loaiViPham", "Không được để trống");
        } else hienThanhCong("loaiViPham");

        if (mucDoViPham === "") {
            hienLoi("mucDoViPham", "Không được để trống");
        } else hienThanhCong("mucDoViPham");

        if (thoiGianViPham === "") {
            hienLoi("thoiGianViPham", "Không được để trống");
        } else if (thoiGianViPhamDate > thoiGianHienTai) {
            hienLoi("thoiGianViPham", "Thời gian vi phạm không thể lớn hơn thời gian hiện tại");
        } else if (
            thoiGianViPhamDate.getMonth() !== thoiGianHienTai.getMonth() ||
            thoiGianViPhamDate.getFullYear() !== thoiGianHienTai.getFullYear()
        ) {
            hienLoi("thoiGianViPham", "Thời gian vi phạm phải nằm trong tháng hiện tại");
        } else {
            hienThanhCong("thoiGianViPham");
        }

        let isValid = sinhVien !== "" && taiKhoanSinhVien !== "" && loaiViPham !== "" &&
            mucDoViPham !== "" && thoiGianViPham !== "" && thoiGianViPhamDate < thoiGianHienTai
        document.getElementById("taoMoiBienBan").disabled = !isValid;
    }


    document.addEventListener("DOMContentLoaded", function () {
        if (window.jQuery && $.fn.select2) {
            $('#sinhVien').select2({
                placeholder: "Chọn Sinh Viên",
                allowClear: true
            });
        }
    })

</script>
</body>
</html>
