<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/3/2025
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/WEB-INF/common/head_admin.jsp"/>
<body>
<jsp:include page="/WEB-INF/common/navbar_admin.jsp"/>
<!-- THỐNG KÊ DOANH THU -->
<div class="container container-section" id="thongKe">
    <h2 class="text-center mt-3 mb-4 text-danger">DORMITORY REVENUE STATISTICS</h2>
    <div>
        <canvas id="revenueChart" width="800" height="400"></canvas>
    </div>
</div>
<script>
    //ve so do thong ke
    const result = {
        labels: ["Quý 1", "Quý 2", "Quý 3", "Quý 4"],
        data: [3200000, 4500000, 2100000, 3800000]
    };
    const ctx = document.getElementById("revenueChart").getContext('2d');
    const revenueChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: result.labels,
            datasets: [{
                label: 'Doanh Thu (VND)',
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
