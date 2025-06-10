<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gửi thông báo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container py-4">
<h2 class="mb-4">Gửi Thông Báo Cho Sinh Viên</h2>

<form method="post" action="thongbao" class="mb-4">
    <div  class="mb-3">
        <label class="form-label">Mã thông báo</label>
        <input name="maThongBao" class="form-control" required>
    </div>
    <div class="mb-3">
        <label class="form-label">Tiêu đề</label>
        <input name="tieuDe" class="form-control" required>
    </div>
    <div hidden="hidden" class="mb-3">
        <label  class="form-label">Thời gian</label>
        <input name="thoiGianGui" class="form-control" required>
    </div>
    <div class="mb-3">
        <label class="form-label">Nội dung</label>
        <textarea name="noiDung" class="form-control" rows="4" required></textarea>
    </div>
    <button type="submit" class="btn btn-success">Gửi Thông Báo</button>
</form>
</body>
</html>


