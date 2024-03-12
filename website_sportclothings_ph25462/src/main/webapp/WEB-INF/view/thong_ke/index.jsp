<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

    <style>

        body {
            font-family: Arial, sans-serif;
        }

        label {
            margin-right: 10px;
        }

        input[type="date"] {
            width: 150px;
            margin-right: 10px;
        }

        button {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 8px 15px;
            cursor: pointer;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

        [ng-show] {
            display: inline-block;
        }

        <%----%>
        body {
            font-family: Arial, sans-serif;
        }

        form {
            display: flex;
            flex-wrap: wrap;
            justify-content: flex-end;
            margin-bottom: 20px;
        }

        label {
            margin-bottom: 10px;
            display: block;
            margin-right: 10px;
        }

        select {
            padding: 8px;
            margin-bottom: 10px;
            width: 150px;
        }

        button {
            background-color: #709004;
            color: #fff;
            border: none;
            padding: 8px 15px;
            cursor: pointer;
            margin-bottom: 10px;
        }
    </style>

</head>
<body>
<div>
    <h1 style="text-align: center">Thống Kê Doanh Thu Theo Ngày Tháng Năm</h1>
    <div>

        <form action="/thong-ke/hien-thi" method="get">
            <label for="day">Ngày:</label>
            <select id="day" name="day">
                <c:forEach begin="1" end="31" var="d">
                    <option value="${d}">${d}</option>
                </c:forEach>
            </select>

            <label for="month">Tháng:</label>
            <select id="month" name="month">
                <c:forEach begin="1" end="12" var="m">
                    <option value="${m}">${m}</option>
                </c:forEach>
            </select>

            <label for="year">Năm:</label>
            <select id="year" name="year">
                <c:forEach begin="2015" end="2035" var="y">
                    <option value="${y}">${y}</option>
                </c:forEach>
            </select>

            <button type="submit">Load</button>
        </form>

                <div class="col-lg-3 col-sm-6 col-12 d-flex">
                    <div class="dash-count">
                        <div class="dash-counts">
                            <h4><c:out value="${totalDonHangWithTrangThai}"/></h4>
                            <h5>Tổng Đơn Hàng</h5>
                        </div>
                        <div class="dash-imgs">
                            <i class="fas fa-shopping-basket ng-binding" style="background: white;padding: 10px;
                    border-radius: 10px;
                    color: rgb(12 231 250);"> 0</i>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-sm-6 col-12 d-flex">
                    <div class="dash-count das1">
                        <div class="dash-counts">
                            <h4><c:out value="${totalQuantitySold}"/></h4>
                            <h5>Tổng sản phẩm</h5>
                        </div>
                        <div class="dash-imgs">
                            <i class="fas fa-wallet ng-binding" style="background: white;padding: 10px;
                    border-radius: 10px;
                    color: rgb(250 145 107);"> </i>
                        </div>
                    </div>
                </div>

        <div class="col-lg-3 col-sm-6 col-12 d-flex">
            <div class="dash-count das3">
                <div class="dash-counts">
                    <h4>
                        <c:if test="${doanhThuNgayThangNam != null}">
                            <span><c:out value="${doanhThuNgayThangNam}"/> VND</span>
                        </c:if>
                    </h4>
                    <h5>Doanh thu</h5>
                </div>
                <div class="dash-imgs">
                    <i class="fas fa-shopping-basket ng-binding" style="background: white;padding: 10px;
            border-radius: 10px;
            color: rgb(12 231 250);"> đ </i>
                </div>
            </div>
        </div>

        <!-- script doanh thu cot -->
        <div class="row" style="width: auto ; height: auto ">
            <div class="col-lg-7 col-sm-12 col-12 d-flex">
                <div class="card flex-fill">
                    <div class="card-header pb-0 d-flex justify-content-between align-items-center">
                        <h4>Thống kê doanh thu theo tháng</h4>

                    </div>
                    <div class="card-body">

                        <!-- Thành phần Canvas cho biểu đồ cột -->
                        <canvas id="barChart" width="800" height="400"></canvas>

                        <!-- Script để vẽ biểu đồ -->
                        <script th:inline="javascript">
                            var thongKeDoanhThuTheoThang = /*[[ ${thongKeDoanhThuTheoThang} ]]*/ {};

                            // Chuẩn bị dữ liệu cho biểu đồ
                            var labels = Object.keys(thongKeDoanhThuTheoThang);
                            var data = Object.values(thongKeDoanhThuTheoThang);

                            // Vẽ biểu đồ cột
                            var barChart = new Chart(document.getElementById('barChart'), {
                                type: 'bar',
                                data: {
                                    labels: labels,
                                    datasets: [{
                                        label: 'Doanh thu',
                                        data: data,
                                        backgroundColor: ["#FF6384", "#FF6384", "#FF6384", "#FF6384", "#FF6384"]
                                    }]
                                },
                                options: {
                                    scales: {
                                        y: {
                                            beginAtZero: true
                                        }
                                    }
                                }
                            });
                        </script>
                    </div>
                </div>
            </div>

            <div class="box-shadow-page">
                <div class="card-body">
                    <form:form action="/thong-ke/hien-thi" method="get">
                        <label for="startDate">Ngày Bắt Đầu:</label>
                        <input type="datetime-local" id="startDate" name="startDate" value="${startDate}" required>

                        <label for="endDate">Ngày Kết Thúc:</label>
                        <input type="datetime-local" id="endDate" name="endDate" value="${endDate}" required>

                        <button type="submit">Tìm kiếm</button>
                    </form:form>

                    <%--     tim kiem doanh thu theo ngay--%>
                    <table>
                        <thead>
                        <tr>
                            <th>Ngày</th>
                            <th>Số lượng hóa đơn</th>
                            <th>Số lượng sản phẩm</th>
                            <th>Tổng doanh thu</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                <c:if test="${startDate != null}"> Từ ngày <fmt:formatDate value="${startDate}" pattern="dd/MM/yyyy"/></c:if>
                                <c:if test="${endDate != null}"> Đến ngày <fmt:formatDate value="${endDate}"
                                                                                          pattern="dd/MM/yyyy"/></c:if>
                            </td>
                            <td><c:out value="${tongSoLuongHoaDon}"/></td>
                            <td><c:out value="${tongSoLuong}"/></td>
                            <td><c:if test="${totalIncome != null}"><c:out value="${totalIncome}"/></c:if></td>
                        </tr>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
</body>
</html>
