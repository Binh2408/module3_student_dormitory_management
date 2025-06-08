<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/2/2025
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ký túc xá sinh viên</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
  <link rel="stylesheet" href="css/home_page.css">
</head>
<body>

<%@ include file="header_navbar_footer/header.jsp" %>

<!-- SLIDE-BAR -->
<div class="row">
    <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel" data-bs-interval="5000">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active"
                    aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1"
                    aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2"
                    aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active" data-bs-interval="5000">
                <div class="carousel-image-wrapper">
                    <img src="https://images.unsplash.com/photo-1600585154340-be6161a56a0c?ixlib=rb-4.0.3&q=85&fm=jpg&crop=entropy&cs=srgb&w=1920&h=1080" class="d-block w-100" alt="Ký túc xá hiện đại">
                </div>
            </div>
            <div class="carousel-item" data-bs-interval="5000">
                <div class="carousel-image-wrapper">
                    <img src="https://images.unsplash.com/photo-1709805619372-40de3f158e83?q=80&w=2095&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" class="d-block w-100" alt="Ký túc xá ban đêm">
                </div>
            </div>
            <div class="carousel-item" data-bs-interval="5000">
                <div class="carousel-image-wrapper">
                    <img src="http://oldquarterviewhanoihostel.com/images/upload/209202312370ATU04850%20copy.jpg" class="d-block w-100" alt="Khuôn viên ký túc xá">
                </div>
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>

<!--NOTIFICATION-->
<div class="container">
  <section class="container py-5">
    <h2 class="text-center fw-bold text-danger mb-4">TIN TỨC</h2>
    <div class="row">
      <!-- Cột bên trái -->
      <div class="col-md-8">
        <div class="row g-3">
          <!-- Bài viết 1 -->
          <div class="col-md-6">
            <div class="card h-100">
              <img src="https://fpt.edu.vn/images/banner/robotics.jpg" class="card-img-top"
                   style="height: 180px; object-fit: cover;" alt="...">
              <div class="card-body">
                <h6 class="card-title fw-bold">Danh sách bảng thi đấu vòng chung kết AI cuộc thi FPTU AI
                  & Robotics Challenge 2025</h6>
                <p class="card-text text-muted small">2 giờ trước</p>
              </div>
            </div>
          </div>
          <!-- Bài viết 2 -->
          <div class="col-md-6">
            <div class="card h-100">
              <img src="https://fpt.edu.vn/images/banner/genai.jpg" class="card-img-top"
                   style="height: 180px; object-fit: cover;" alt="...">
              <div class="card-body">
                <h6 class="card-title fw-bold">Điểm phân thi Video truyền thông với GenAI cuộc thi FPTU
                  AI & Robotics Challenge 2025</h6>
                <p class="card-text text-muted small">20 giờ trước</p>
              </div>
            </div>
          </div>
          <!-- Bài viết 3 -->
          <div class="col-md-6">
            <div class="card h-100">
              <img src="https://fpt.edu.vn/images/banner/odyssey.jpg" class="card-img-top"
                   style="height: 180px; object-fit: cover;" alt="...">
              <div class="card-body">
                <h6 class="card-title fw-bold">Khối Giáo dục FPT ký kết hợp tác chiến lược với tổ chức
                  giáo dục Odyssey (Pháp)</h6>
                <p class="card-text text-muted small">2 ngày trước</p>
              </div>
            </div>
          </div>
          <!-- Bài viết 4 -->
          <div class="col-md-6">
            <div class="card h-100">
              <img src="https://fpt.edu.vn/images/banner/hackathon.jpg" class="card-img-top"
                   style="height: 180px; object-fit: cover;" alt="...">
              <div class="card-body">
                <h6 class="card-title fw-bold">Thí sinh FPT Hackathon 2025 giải bài toán về AI và
                  logistics thông minh</h6>
                <p class="card-text text-muted small">2 ngày trước</p>
              </div>
            </div>
          </div>
        </div>
      </div>

      <!-- Cột bên phải -->
      <div class="col-md-4">
        <ul class="list-group list-group-flush">
          <li class="list-group-item border-0 px-0">
            <a href="https://www.facebook.com/share/p/1AXFawKQwC/" class="text-dark fw-bold d-block">26 HÀM
              JAVASCRIPT GIÚP CODE SẠCH NHƯ LẬP TRÌNH VIÊN CHUYÊN NGHIỆP – PHẦN 1</a>
            <small class="text-muted">28/05/2025</small>
          </li>
          <li class="list-group-item border-0 px-0">
            <a href="https://www.facebook.com/share/p/1Fm5nh5jSm/" class="text-dark fw-bold d-block">📣 BẢNG
              TIN TUYỂN DỤNG CẬP NHẬT HÀNG TUẦN</a>
            <small class="text-muted">24/05/2025</small>
          </li>
          <li class="list-group-item border-0 px-0">
            <a href="https://www.facebook.com/share/p/1Bp6cbWLHw/" class="text-dark fw-bold d-block">🚀 50
              CÂU HỎI GIT TỪ CƠ BẢN ĐẾN NÂNG CAO – PHẦN 2 ĐÃ LÊN KỆ!</a>
            <small class="text-muted">23/05/2025</small>
          </li>
        </ul>
      </div>
    </div>

    <!-- Nút xem thêm -->
    <div class="text-center mt-4">
      <a href="#" class="btn btn-outline-danger px-4">XEM THÊM TIN TỨC</a>
    </div>
  </section>
</div>

<!--EVENT-->
<div class="row">
  <section class="py-5" style="background: linear-gradient(to bottom, #6a3093, #a044ff, #ff512f); color: white;">
    <div class="container">
      <h2 class="text-center fw-bold mb-5">SỰ KIỆN NỔI BẬT</h2>
      <div class="row g-4">
        <div class="col-md-4">
          <div class="card bg-transparent border-light text-white h-100">
            <img src="https://fpt.edu.vn/images/banner/event1.jpg" class="card-img-top" alt="Event 1" style="height: 180px; object-fit: cover;">
            <div class="card-body">
              <h5 class="card-title">Workshop GenAI & Ứng dụng thực tế</h5>
              <p class="card-text">Thời gian: 10/06/2025 - Địa điểm: Hà Nội</p>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="card bg-transparent border-light text-white h-100">
            <img src="https://fpt.edu.vn/images/banner/event2.jpg" class="card-img-top" alt="Event 2" style="height: 180px; object-fit: cover;">
            <div class="card-body">
              <h5 class="card-title">Cuộc thi Code Hackathon 2025</h5>
              <p class="card-text">Thời gian: 15/06/2025 - Địa điểm: TP. Hồ Chí Minh</p>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="card bg-transparent border-light text-white h-100">
            <img src="https://fpt.edu.vn/images/banner/event3.jpg" class="card-img-top" alt="Event 3" style="height: 180px; object-fit: cover;">
            <div class="card-body">
              <h5 class="card-title">Talkshow: Hành trình trở thành Dev quốc tế</h5>
              <p class="card-text">Thời gian: 20/06/2025 - Địa điểm: Đà Nẵng</p>
            </div>
          </div>
        </div>
      </div>
      <!-- Nút xem thêm -->
      <div class="text-center mt-4">
        <a href="#" class="btn btn-outline-light px-4">XEM THÊM SỰ KIỆN</a>
      </div>
    </div>
  </section>
</div>

<!--FOOTER-->
<%@include file="header_navbar_footer/footer.jsp"%>
<button id="backToTop" title="Lên đầu trang">↑</button>
</body>

<script>
  const backToTopBtn = document.getElementById("backToTop");

  window.onscroll = function () {
    if (document.body.scrollTop > 200 || document.documentElement.scrollTop > 200) {
      backToTopBtn.style.display = "block";
    } else {
      backToTopBtn.style.display = "none";
    }
  };

  backToTopBtn.addEventListener("click", function () {
    window.scrollTo({
      top: 0,
      behavior: "smooth"
    });
  });
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</html>