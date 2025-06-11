<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thông báo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <link rel="stylesheet" href="css/home_page.css">
</head>

<body>
<%@ include file="../header_navbar_footer/header.jsp" %>

<!-- Nội dung chính -->
<div class="container my-5 py-5 d-flex justify-content-center align-items-center" style="min-height: 60vh;">
    <div class="text-center">
        <h2 class="text-warning">🚧 Trang web đang phát triển</h2>
        <p>Chức năng này sẽ được cập nhật sau. Vui lòng quay lại sau!</p>
        <a href="../home_page.jsp" class="btn btn-primary mt-3">Quay lại Trang chủ</a>
    </div>
</div>

<%@ include file="../header_navbar_footer/footer.jsp" %>
</body>
</html>
