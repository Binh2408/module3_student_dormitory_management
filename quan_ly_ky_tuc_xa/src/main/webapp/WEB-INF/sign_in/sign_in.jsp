<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Đăng Nhập</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="../../css/sign_in.css">
</head>
<body>

<div class="bg-image d-flex align-items-center justify-content-center vh-100">
  <div class="login-box text-center text-white shadow-lg">
    <h2 class="mb-3 fw-bold">Chào mừng trở lại</h2>
    <p class="mb-4">Hãy đăng nhập để tiếp tục</p>

    <!-- Thông báo lỗi -->
    <c:if test="${not empty error}">
      <div id="loginError" class="alert alert-danger text-center py-2" role="alert">
          ${error}
      </div>
    </c:if>

    <form action="" method="post">
      <div class="mb-3 text-start">
        <label for="username" class="form-label text-white">Tên đăng nhập</label>
        <input type="text" class="form-control bg-transparent text-white border-light"
               id="username" name="username"
               value="${savedUsername != null ? savedUsername : ''}"
               placeholder="Nhập tên đăng nhập">
      </div>
      <div class="mb-3 text-start position-relative">
        <label for="password" class="form-label text-white">Mật khẩu</label>
        <input type="password" class="form-control bg-transparent text-white border-light pe-5" id="password" name="password" placeholder="Nhập mật khẩu">
        <span class="eye-toggle position-absolute top-50 translate-middle-y" style="right: 1rem; cursor: pointer;padding-top: 30px">👁</span>
      </div>
      <button type="submit" value="sign_in" class="btn btn-light w-100 mb-3 fw-bold">ĐĂNG NHẬP</button>
      <div class="d-flex justify-content-between mb-3 small">
        <div class="form-check text-start">
          <input type="checkbox" class="form-check-input" id="remember" name="remember">
          <label class="form-check-label text-white" for="remember">Ghi nhớ đăng nhập</label>
        </div>
        <a href="#" class="text-white text-decoration-none">Quên mật khẩu?</a>
      </div>
      <p class="mb-2 small">— Hoặc đăng nhập bằng —</p>
      <div class="d-flex justify-content-center gap-3">
        <button type="button" class="btn btn-outline-light rounded-pill px-4">Facebook</button>
        <button type="button" class="btn btn-outline-light rounded-pill px-4">Twitter</button>
      </div>
    </form>
  </div>
</div>

<script>
  // Toggle hiển thị mật khẩu
  const eyeToggle = document.querySelector('.eye-toggle');
  const passwordInput = document.getElementById('password');

  eyeToggle.addEventListener('click', () => {
    const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
    passwordInput.setAttribute('type', type);
    eyeToggle.textContent = type === 'password' ? '👁' : '🙈';
  });

  // Tự động ẩn thông báo lỗi sau 3 giây
  window.addEventListener('DOMContentLoaded', () => {
    const alertBox = document.getElementById('loginError');
    if (alertBox) {
      setTimeout(() => {
        alertBox.style.transition = 'opacity 0.5s ease';
        alertBox.style.opacity = '0';
        setTimeout(() => alertBox.remove(), 500);
      }, 3000);
    }
  });
</script>

</body>
</html>
