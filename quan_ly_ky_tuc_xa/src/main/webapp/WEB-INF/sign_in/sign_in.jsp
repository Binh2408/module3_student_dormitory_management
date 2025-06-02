<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Sign In</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="../../css/sign_in.css">
</head>
<body>

<div class="bg-image d-flex align-items-center justify-content-center vh-100">
  <div class="login-box text-center text-white shadow-lg">
    <h2 class="mb-3 fw-bold">Welcome Back</h2>
    <p class="mb-4">Sign in to continue</p>
    <form>
      <div class="mb-3 text-start">
        <label for="username" class="form-label text-white">Username</label>
        <input type="text" class="form-control bg-transparent text-white border-light" id="username" placeholder="Enter username">
      </div>
      <div class="mb-3 text-start position-relative">
        <label for="password" class="form-label text-white">Password</label>
        <input type="password" class="form-control bg-transparent text-white border-light pe-5" id="password" placeholder="Enter password">
        <span class="eye-toggle position-absolute top-50 translate-middle-y" style="right: 1rem; cursor: pointer;padding-top: 30px">👁</span>
      </div>
      <button type="submit" class="btn btn-light w-100 mb-3 fw-bold">SIGN IN</button>
      <div class="d-flex justify-content-between mb-3 small">
        <div class="form-check text-start">
          <input type="checkbox" class="form-check-input" id="remember">
          <label class="form-check-label text-white" for="remember">Remember Me</label>
        </div>
        <a href="#" class="text-white text-decoration-none">Forgot Password?</a>
      </div>
      <p class="mb-2 small">— Or Sign In With —</p>
      <div class="d-flex justify-content-center gap-3">
        <button type="button" class="btn btn-outline-light rounded-pill px-4">Facebook</button>
        <button type="button" class="btn btn-outline-light rounded-pill px-4">Twitter</button>
      </div>
    </form>
  </div>
</div>

<script>
  // Toggle password visibility
  const eyeToggle = document.querySelector('.eye-toggle');
  const passwordInput = document.getElementById('password');

  eyeToggle.addEventListener('click', () => {
    const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
    passwordInput.setAttribute('type', type);
    eyeToggle.textContent = type === 'password' ? '👁' : '🙈';
  });
</script>

</body>
</html>
