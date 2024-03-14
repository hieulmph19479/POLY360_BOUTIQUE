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
    <script>

        // thông báo Xác nhận  form add to Card
        document.addEventListener("DOMContentLoaded", function () {

            var form = document.getElementById("formThemGioHang");

            form.addEventListener("submit", function (event) {


                // Kiểm tra các trường cần thiết ở đây (màu sắc, kích thước, số lượng)
                var selectedColor = document.querySelector('input[name="mauSac"]:checked');
                var selectedSize = document.querySelector('input[name="size"]:checked');
                var quantity = document.getElementById("soLuong").value;


                // Kiểm tra xem có trường nào bỏ trống không
                if (!selectedColor || !selectedSize || quantity.trim() === "") {
                    console.log('Validation failed');
                    Swal.fire({
                        icon: 'error',
                        title: 'Lỗi!',
                        text: 'Vui Lòng Chọn Màu Sắc, Size Sản Phẩm. ',
                    });
                    event.preventDefault(); // Ngăn chặn sự kiện submit
                } else {
                    console.log('Validation passed');
                    event.preventDefault();
                    // Hiển thị hộp thoại xác nhận
                    Swal.fire({
                        icon: 'question',
                        title: 'Xác nhận',
                        text: 'Bạn có chắc chắn muốn thêm sản phẩm vào giỏ hàng?',
                        showCancelButton: true,
                        confirmButtonText: 'Đồng ý',
                        cancelButtonText: 'Hủy bỏ',
                    }).then((result) => {
                        if (result.isConfirmed) {
                            // Người dùng đã xác nhận, có thể submit form

                            // form.submit();
                            Swal.fire({
                                icon: 'success',
                                title: 'Thành Công',
                                text: 'Đã thêm sản phẩm vào giỏ hàng. ',
                            }).then((result) => {
                                form.submit().then((result) => {
                                    window.location.reload();
                                })

                            });

                        } else {
                            event.preventDefault(); // Ngăn chặn sự kiện submit nếu người dùng không xác nhận
                            console.log('Form submission canceled');
                        }
                    });
                }
            });
        });


    </script>

</head>
<body>
<header>
    <jsp:include page="../template_home/header.jsp"/>
</header>
<div class="flex-box">
    <div class="left">
        <div class="big-img">
            <img src="../../../img/sp12ao.png">
        </div>
        <div class="images">
            <div class="small-img">
                <img class="img-th" src="../../../img/ctsp12.2ao.png" onclick="showImg(this.src)">
            </div>
            <div class="small-img">
                <<<<<<< HEAD
                <img class="img-th" src="../../../img/ctsp12.2ao.png" onclick="showImg(this.src)">
            </div>
            <div class="small-img">
                <img class="img-th" src="../../../img/ctsp12.3ao.png" onclick="showImg(this.src)">
                =======
                <img class="img-th" src="../../../img/ctsp12.2ao.png" onclick="showImg(this.src)">
            </div>
            <div class="small-img">
                <img class="img-th" src="../../../img/ctsp12.3ao.png" onclick="showImg(this.src)">
                >>>>>>> Dung_Test
            </div>
            <div class="small-img">
                <img class="img-th" src="../../../img/ctsp12.4ao.png" onclick="showImg(this.src)">
            </div>
        </div>
    </div>

    <div class="right">

        <div class="pname">${sanPham.ten}</div>


        <div class="ratings">
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star-half-alt"></i>
        </div>

        <div class="price">${sanPham.gia} .đ</div>


        <form id="formThemGioHang" method="post" action="/add-to-cart/${sanPham.id}">


            <div class="size">
                <p class="d-flex align-items-center mb-0 text-dark ft-medium">Màu:</p>
                <div class="product-color text-left">
                    <c:forEach var="color" items="${listMauSac}" varStatus="colorState">
                        <div class="form-check size-option form-option form-check-inline mb-2">

                            <input type="radio" class="form-check-input " id="mauSac" name="mauSac" value="${color.id}">
                            <span>
                                    ${color.ten}
                            </span>

                        </div>
                    </c:forEach>
                </div>
            </div>


            <div class="size">
                <p class="d-flex align-items-center mb-0 text-dark ft-medium">Size:</p>
                <div class="text-left pb-0 pt-2">
                    <c:forEach var="size" items="${listKichCo}" varStatus="sizeState">
                        <div class="form-check size-option form-option form-check-inline mb-2">
                            <input class="psize" type="radio" id="size" name="size" value="${size.id}">
                            <span>${size.ten}</span>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="quantity">
                <p>Quantity :</p>

                <select class="mb-2 custom-select" id="soLuong" name="soLuong">
                    <option value="1" selected="">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>


            </div>
            <div class="btn-box">
                <button type="submit" id="addToCard" class="cart-btn">Add to Cart</button>
                <%--                <button type="button" class="buy-btn">Buy Now</button>--%>
            </div>

        </form>


    </div>
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






















<%--<!DOCTYPE html>--%>

<%--<html lang="en" dir="ltr">--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">--%>


<%--<head>--%>
<%--    <meta charset="utf-8">--%>
<%--    <title>Product Card Poly360Boutique</title>--%>
<%--    <link rel="stylesheet" href="../../../css/cart.css">--%>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>--%>
<%--    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>--%>
<%--    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>--%>
<%--    <link rel="icon" href="../../../svg/logohome.svg">--%>
<%--</head>--%>
<%--<body>--%>


<%--<div class="row">--%>
<%--    <div class="col-3 mt-3">--%>
<%--        <div class="card">--%>
<%--            <div id="cartItems">--%>

<%--                <img src="" class="card-img-top mx-auto d-block"--%>
<%--                     alt="" style="min-width: 319px; min-height: 319px"> ${detail.url}--%>

<%--                <div class="card-body">--%>
<%--                    <h5 class="card-title">${detail.sanPham.ten}</h5>--%>
<%--                </div>--%>

<%--                <ul class="list-group list-group-flush">--%>

<%--                    <li class="list-group-item">Gía tiền:${detail.sanPham.gia}--%>
<%--                        <fmt:formatNumber--%>
<%--                                pattern="###,### VNĐ">--%>
<%--                        </fmt:formatNumber>--%>
<%--                    </li>--%>

<%--                    <li class="list-group-item">Mô tả: ${detail.sanPham.moTa }--%>
<%--                    </li>--%>
<%--                </ul>--%>

<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--</div>--%>

<%--<script src="src/main/webapp/js/cart.js"></script>--%>
<%--</body>--%>
<%--</html>--%>
