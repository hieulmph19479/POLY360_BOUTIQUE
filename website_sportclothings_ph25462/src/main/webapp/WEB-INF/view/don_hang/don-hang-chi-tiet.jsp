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


    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>


</head>
<body>
<header>
    <jsp:include page="../template_home/header.jsp"/>
</header>
<div><h3>Chi Tiết Đơn Hàng</h3>
<br>
</div>

<div class="ord_list_wrap border mb-4 mfliud">
    <div class="ord_list_head gray d-flex align-items-center justify-content-between px-3 py-3">
        <div class="olh_flex">
            <p class="m-0 p-0"><span class="text-muted">Mã Đơn Hàng</span></p>
            <h6 class="mb-0 ft-medium"><c:out value="${maDonHang}"/> </h6>
        </div>

        <div class="olh_flex">
            <p class="m-0 p-0"><span class="text-muted">Tổng Tiền</span></p>
            <h6 class="mb-0 ft-medium"><c:out value="${tongTien}"/> đ</h6>
        </div>


    </div>
</div>


<div class="ord_list_body text-left">
    <!-- First Product -->
    <c:forEach var="donHangChiTiet" items="${donHangChiTietList}">
        <div class="row align-items-center justify-content-center m-0 py-4 br-bottom">
            <div class="col-xl-5 col-lg-5 col-md-5 col-12">
                <div class="cart_single d-flex align-items-start mfliud-bot">
                    <div class="cart_selected_single_thumb">
                            <%--                        <a href="/products/${donHangChiTiet.chiTietSanPham.sanPham.id}">--%>
                            <%--                            <img src="${donHangChiTiet.chiTietSanPham.sanPham.hinhNen}" width="75" class="img-fluid rounded" alt="">--%>
                            <%--                        </a>--%>
                    </div>
                    <div class="cart_single_caption pl-3">
                        <p class="mb-0">Số Lượng: <span class="text-muted small"><c:out
                                value="${donHangChiTiet.soLuong}"/></span></p>
                        <h4 class="product_title fs-sm ft-medium mb-1 lh-1">
                            <a href="/products/${donHangChiTiet.chiTietSanPham.sanPham.id}"
                               th:text="${donHangChiTiet.chiTietSanPham.sanPham.ten}"></a>
                        </h4>
                        <p class="mb-2">
                            <span class="text-dark medium"><c:out
                                    value="${donHangChiTiet.chiTietSanPham.kichCo.ten}"/></span>,
                            <span class="text-dark medium"><c:out
                                    value="${donHangChiTiet.chiTietSanPham.mauSac.ten}"/></span>
                        </p>
                        <h4 class="fs-sm ft-bold mb-0 lh-1">${donHangChiTiet.donGia * donHangChiTiet.soLuong} đ</h4>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-lg-3 col-md-3 col-6">
                <p class="mb-1 p-0"><span class="text-muted">Trạng Thái</span></p>
                <div class="delv_status">
                    <c:choose>
                        <c:when test="${donHangChiTiet.hoaDon.trangThai eq 0}">
                            <span class="badges bg-lighthuy">Đã Hủy</span>
                        </c:when>
                        <c:when test="${donHangChiTiet.hoaDon.trangThai eq 1}">
                            <span class="badges bg-lightgreen">Thành Công</span>
                        </c:when>
                        <c:when test="${donHangChiTiet.hoaDon.trangThai eq 2}">
                            <span class="badges bg-lightblue">Chờ xác Nhận</span>
                        </c:when>
                        <c:when test="${donHangChiTiet.hoaDon.trangThai eq 3}">
                            <span class="badges bg-lightviolet">Đã Xác Nhận</span>
                        </c:when>
                        <c:when test="${donHangChiTiet.hoaDon.trangThai eq 4}">
                            <span class="badges bg-lightyellow">Đang Vận Chuyển</span>
                        </c:when>
                        <c:otherwise>
                            <span class="badges bg-lightblack">Trạng thái không hợp lệ</span>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div class="col-xl-4 col-lg-4 col-md-4 col-6">
                <p class="mb-1 p-0"><span class="text-muted">Ngày Đặt Hàng </span></p>
                <h6 class="mb-0 ft-medium fs-sm"><c:out value="${donHangChiTiet.hoaDon.ngayTao}"/></h6>
            </div>

            <div class="col-xl-4 col-lg-4 col-md-4 col-6">
                <p class="mb-1 p-0"><span class="text-muted">Hủy Đơn </span></p>

            </div>
        </div>
    </c:forEach>
</div>


<jsp:include page="../template_home/footer.jsp"/>

<script type="text/javascript">
    let bigImg = document.querySelector('.big-img img');


    function showImg(pic) {

        function showImg(pic) {

            bigImg.src = pic;
        }
    }

</script>
</body>
</html>
