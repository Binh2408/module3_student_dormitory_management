<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="/WEB-INF/common/head_admin.jsp"/>
<body>
<div class="d-flex justify-content-center align-items-center container-fluid" style="height: 100vh">
    <div class="card shadow p-4" style="width: 50%">
        <h2 class="text-center text-success mb-4">Thay Đổi Thông Tin Hợp Đồng </h2>
        <form method="post" id="hop_dong_form" class="needs-validation" novalidate action="contract?action=update">
            <input type="hidden" name="hop_dong_id" value="${hopDongDtoResponse.maHopDong}">
            <div class="row">
                <div class="col-12">
                    <div class="mx-auto" style="max-width: 700px;">
                        <div class="row mb-3">
                            <label class="form-label col-sm-4">Chọn Sinh Viên</label>
                            <div class="col-sm-8">
                                <div style="display: flex">
                                    <select name="ma_sinh_vien" id="sinhVien" required
                                            onchange="hienThiTaiKhoanSinhVien(this)"
                                            data-size="5" class="form-control w-100">
                                        <option></option>
                                        <c:forEach items="${sinhVienDtoResponseList}" var="sinhVien" varStatus="status">
                                            <option value="${sinhVien.sinhVienId}"
                                                    data-tai-khoan="${sinhVien.userName}"
                                                    <c:if test="${sinhVien.tenSinhVien==hopDongDtoResponse.tenSinhVien}">
                                                        selected
                                                    </c:if>>>
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

                        <div class="row">
                            <label class="form-label col-sm-4">Tên Phòng</label>
                            <div class="col-sm-8">
                                <div style="display: flex">
                                    <select name="ma_phong" class="form-select" required id="tenPhong"
                                            onblur="kiemTraDuLieu()" onchange="hienThiGiaPhongMoiThang(this)">
                                        <option value="">-- Chọn phòng --</option>
                                        <c:forEach items="${phongList}" var="phong">
                                            <option value="${phong.phongId}"
                                                    data-gia_moi_thang="${phong.giaMoiThang}"
                                                    <c:if test="${phong.tenPhong==hopDongDtoResponse.tenPhong}">
                                                        selected
                                                    </c:if>>
                                                    ${phong.tenPhong}
                                            </option>
                                        </c:forEach>
                                    </select>
                                    <span id="tenPhongIcon"></span>
                                </div>
                                <p id="tenPhongLoi"></p>
                            </div>
                        </div>

                        <div class="row">
                            <label class="form-label col-sm-4">Ngày Bắt Đầu</label>
                            <div class="col-sm-8">
                                <div style="display: flex">
                                    <input name="ngay_bat_dau" type="date" class="form-control" required
                                           value="${contract.startDay}" id="ngayBatDau" onblur="kiemTraDuLieu()">
                                    <span id="ngayBatDauIcon"></span>
                                </div>
                                <p id="ngayBatDauLoi"></p>
                            </div>
                        </div>

                        <div class="row ">
                            <label class="form-label col-sm-4">Ngày Kết Thúc</label>
                            <div class="col-sm-8">
                                <div style="display: flex">
                                    <input name="ngay_ket_thuc" type="date" class="form-control" required
                                           value="${contract.endDay}" id="ngayKetThuc" onblur="kiemTraDuLieu()">
                                    <span id="ngayKetThucIcon"></span>
                                </div>
                                <p id="ngayKetThucLoi"></p>
                            </div>
                        </div>

                        <div class="row">
                            <label class="form-label col-sm-4">Giá Thuê</label>
                            <div class="col-sm-8">
                                <div style="display: flex">
                                    <input name="gia_thue" type="number" class="form-control" required
                                           value="${contract.rentalCost}" id="giaThue" onblur="kiemTraDuLieu()" min="0"
                                           readonly>
                                    <span id="giaThueIcon"></span>
                                </div>
                                <p id="giaThueLoi"></p>
                            </div>
                        </div>

                        <div class="row mt-4 justify-content-center">
                            <div class="col-6 col-md-4">
                                <button type="submit" class="btn btn-outline-success w-100" id="btnTaoMoi" disabled>Thay
                                    Đổi
                                </button>
                            </div>
                            <div class="col-6 col-md-4">
                                <button type="reset" class="btn btn-outline-danger w-100" id="reset-button">Reset
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

    function hienThiGiaPhongMoiThang(selectElement) {
        let option = selectElement.options[selectElement.selectedIndex];
        let giaMoiThang = option ? option.getAttribute('data-gia_moi_thang') : "";
        document.getElementById("giaThue").value = giaMoiThang || "";
    }


    function hienThiTaiKhoanSinhVien(selectElement) {
        let option = selectElement.options[selectElement.selectedIndex];
        let taiKhoan = option ? option.getAttribute('data-tai-khoan') : "";
        document.getElementById("taiKhoanSinhVien").value = taiKhoan || "";
    }

    function kiemTraDuLieu() {
        let sinhVien = document.getElementById("sinhVien").value;
        let taiKhoanSinhVien = document.getElementById("taiKhoanSinhVien").value;
        let tenPhong = document.getElementById("tenPhong").value;
        let ngayBatDau = document.getElementById("ngayBatDau").value;
        let ngayKetThuc = document.getElementById("ngayKetThuc").value;
        let giaThue = document.getElementById("giaThue").value;

        if (sinhVien === "") {
            hienLoi("sinhVien", "Vui lòng chọn sinh viên");
        } else {
            hienThanhCong("sinhVien");
        }

        if (taiKhoanSinhVien === "") {
            hienLoi("taiKhoanSinhVien", "Tài khoản sinh viên không được để trống");
        } else {
            hienThanhCong("taiKhoanSinhVien");
        }

        if (tenPhong === "") {
            hienLoi("tenPhong", "Vui lòng chọn tên phòng");
        } else {
            hienThanhCong("tenPhong");
        }

        if (ngayBatDau === "") {
            hienLoi("ngayBatDau", "Không được để trống");
        } else {
            hienThanhCong("ngayBatDau");
        }

        if (ngayKetThuc === "") {
            hienLoi("ngayKetThuc", "Không được để trống");
        } else {
            hienThanhCong("ngayKetThuc");
        }

        if (giaThue === "" || parseInt(giaThue) < 0) {
            hienLoi("giaThue", "Giá thuê phải lớn hơn hoặc bằng 0");
        } else {
            hienThanhCong("giaThue");
        }
        let isValid = sinhVien !== "" && taiKhoanSinhVien !== "" && tenPhong !== ""
            && ngayBatDau !== "" && ngayKetThuc !== "" && giaThue >= 0 && giaThue !== "";
        document.getElementById("btnTaoMoi").disabled = !isValid;
    }

    
    document.addEventListener("DOMContentLoaded", function () {
        if (window.jQuery && $.fn.select2) {
            $('#sinhVien').select2({
                placeholder: "Chọn Sinh Viên",
                allowClear: true
            });
        }
        // 👉 Gọi hàm để hiển thị lại tài khoản và giá thuê nếu có sẵn
        let sinhVienSelect = document.getElementById("sinhVien");
        if (sinhVienSelect.value) {
            hienThiTaiKhoanSinhVien(sinhVienSelect);
        }

        let phongSelect = document.getElementById("tenPhong");
        if (phongSelect.value) {
            hienThiGiaPhongMoiThang(phongSelect);
        }
        document.getElementById("ngayBatDau").value = `${hopDongDtoResponse.thoiGianBatDau}`
        document.getElementById("ngayKetThuc").value = `${hopDongDtoResponse.thoiGianKetThuc}`
        kiemTraDuLieu();
    });

</script>
</body>
</html>
