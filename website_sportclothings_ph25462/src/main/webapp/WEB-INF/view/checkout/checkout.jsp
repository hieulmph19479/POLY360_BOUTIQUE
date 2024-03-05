<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>POLY360BOUTIQUE</title>
    <link rel="stylesheet" href="../../../css/index.css">
    <link href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" data-purpose="Layout StyleSheet" title="Web Awesome"
          href="/css/app-wa-612dd696ed96d6777d290343ca9cef9d.css?vsn=d">
    <link rel="stylesheet" href="../../../css/thuong-hieu.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/all.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-thin.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-solid.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-regular.css">
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.5.1/css/sharp-light.css">
    <link rel="icon" href="../../../svg/logohome.svg">
</head>
<body>
<header>
    <jsp:include page="../template_home/header.jsp"/>
</header>


<!--Nhập thông tin khách hàng-->
<div class="container">
<form action="#" id="checkoutForm" method="post" >
    <div class="row justify-content-between">
        <div class="col-12 col-lg-7 col-md-12">
            <!-- Checkout Form -->
            <!-- Add your existing form content here -->
            <h5 class="mb-4 ft-medium">Chi Tiết Thanh Toán </h5>
            <div class="row mb-2">

                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12">
                    <div class="form-group">
                        <label class="text-dark">Họ Và Tên</label>
                        <input disabled type="text" class="form-control" id="hienThiTen"/>
                    </div>
                </div>

                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="form-group">
                        <label class="text-dark">Email </label>
                        <input disabled type="email" class="form-control" />
                    </div>
                </div>

                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="form-group">
                        <label class="text-dark">Số Điện Thoại</label>
                        <input disabled type="text" class="form-control" id="hienThiSDT" value=""/>
                    </div>
                </div>

                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <label class="text-dark mr-2">Địa Chỉ Nhận Hàng</label>
                    <div class="form-group d-flex align-items-center">
                        <div class="flex-grow-1">

                            <select name="address" id="idDiaChi" class="form-control" >


                            </select>

                        </div>
                    </div>
                    <button type="button" id="openModalBtn">Thêm Địa Chỉ</button>
                    <button type="button" id="suaDiaChi" class="btn btn-danger">Sửa Địa Chỉ</button>


                </div>


            </div>

            <div class="row mb-4">
                <div class="col-12 d-block">
                    <input id="createaccount" class="checkbox-custom" name="createaccount" type="checkbox">
                    <!--                                <label for="createaccount" class="checkbox-custom-label">Thêm tài khoản mới</label>-->
                </div>
            </div>


        </div>
        <!--                Nhập thông tin khách hàng-->

        <!-- Sidebar -->
        <div class="col-12 col-lg-4 col-md-12">
            <div class="d-block mb-3">
                <h4 class="mb-4">Các mặt hàng:</h4>
                <ul class="list-group list-group-sm list-group-flush-y list-group-flush-x mb-4">
                    <li class="list-group-item" >
                        <div class="d-flex justify-content-between">
                            <div>
<%--                                <h5 class="mb-1" th:text="'Tên Sản Phẩm: '+ ${carts.productName}"></h5>--%>
<%--                                <p class="mb-1" th:text="'Số lượng: ' + ${carts.quantity}"></p>--%>
<%--                                <p class="mb-1" th:text="'Kích cỡ: ' + ${carts.productSize}"></p>--%>
<%--                                <p class="mb-1" th:text="'Màu sắc : ' + ${carts.productColor}"></p>--%>
<%--                                <p class="mb-1" th:text="'Đơn Giá : ' + ${carts.productPrice} + '.₫'"></p>--%>


                            </div>

                        </div>
                    </li>
                </ul>
            </div>

            <!-- Cart Summary -->
            <!-- Thêm thông tin tổng cộng sau danh sách sản phẩm -->
            <ul id="cartItemsList"
                class="list-group list-group-sm list-group-flush-y list-group-flush-x mb-4"></ul>

            <!-- Thêm thông tin tổng cộng -->
            <div class="card mb-4 gray">
                <div class="card-body">
                    <!-- Thông tin tổng cộng details -->
                    <ul class="list-group list-group-sm list-group-flush-y list-group-flush-x">
                        <!-- ... (danh sách sản phẩm giỏ hàng) ... -->
                    </ul>

                    <!-- Thêm thông tin tổng cộng vào đây -->
                    <li class="list-group-item d-flex justify-content-between text-dark fs-sm ft-regular">
                        <span>Tổng</span> <span class="ml-auto text-dark ft-medium" id="tongTien">100</span>
                        <input type="number" id="tongTienPC" value="999" style="display: none">

                    </li>

                    <li class="list-group-item d-flex justify-content-between text-dark fs-sm ft-regular">
                        <span>Phí vận chuyển</span> <span name="phiVanChuyen"
                                                          class="ml-auto text-dark ft-medium"
                                                          id="phiVanChuyen"> 30.000.đ </span>

                    </li>
                    <input name="shippingFee" id="shippingFee" style="display: none">

                    <li class="list-group-item d-flex justify-content-between text-dark fs-sm ft-regular">
                        <span>Ngày giao hàng dự Kiến </span>
                        <span class="ml-auto text-dark ft-medium"
                              id="ngayDuKienGiao"> Hãy Chọn Địa Chỉ </span>
                    </li>

                    <li class="list-group-item d-flex justify-content-between text-dark fs-sm ft-regular">
                        <span>Tổng Tiền</span>
                        <span class="ml-auto text-dark ft-medium"
                              id="hienThiTongTien" name="hienThiTongTien"></span>

                        <input name="tongTien" style="display: none"
                               value="6">
                    </li>


                </div>
            </div>


            <button type="button" class="btn btn-block btn-dark mb-3" onclick="validateAndSubmit()">Đặt Hàng</button>

            <!-- End Checkout Button -->

        </div>

    </div>
</form>
</div>

<jsp:include page="../template_home/footer.jsp"/>

<script type="text/javascript">
    let bigImg = document.querySelector('.big-img img');

    function showImg(pic) {
        bigImg.src = pic;
    }

</script>
</body>
</html>
