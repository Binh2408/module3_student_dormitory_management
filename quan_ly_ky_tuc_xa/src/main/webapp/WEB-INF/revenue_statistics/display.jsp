<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/3/2025
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="/WEB-INF/common/head_admin.jsp"/>
<body>
<jsp:include page="/WEB-INF/common/navbar_admin.jsp"/>
<!-- THỐNG KÊ DOANH THU -->
<div class="container container-section" id="thongKe">
    <h2 class="text-center mt-3 mb-4 text-success">THỐNG KÊ DOANH THU KÝ TÚC XÁ</h2>
    <div>
        <canvas id="revenueChart" width="800" height="400"></canvas>
    </div>
</div>
<script>
    // Vẽ sơ đồ thống kê
    const result = {
        labels: ["Quý 1", "Quý 2", "Quý 3", "Quý 4"],
        data: <%=request.getAttribute("doanhThu")%>
    };
    const ctx = document.getElementById("revenueChart").getContext('2d');
    const revenueChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: result.labels,
            datasets: [{
                label: 'Doanh thu (VNĐ)',
                data: result.data,
                backgroundColor: ['#4caf50', '#2196f3', '#ff9800', '#f44336']
            }]
        },
        options: {
            responsive: true,
            scales: {
                y: {
                    beginAtZero: true,
                    ticks: {
                        callback: function (value) {
                            return value.toLocaleString('vi-VN') + ' VNĐ';
                        }
                    }
                }
            }
        }
    });
</script>
</body>
</html>
