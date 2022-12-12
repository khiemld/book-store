<%--
  Created by IntelliJ IDEA.
  User: Trường Giang
  Date: 03-Dec-22
  Time: 6:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Dashboard</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
          rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="${pageContext.request.contextPath}/admin/assets/vendor/bootstrap/css/bootstrap.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/admin/assets/vendor/bootstrap-icons/bootstrap-icons.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/admin/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/admin/assets/vendor/quill/quill.snow.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/admin/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/admin/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/admin/assets/vendor/simple-datatables/style.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="${pageContext.request.contextPath}/admin/assets/css/style.css" rel="stylesheet">

    <!-- Logo -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/store/icon/paper-plane.ico">

    <!-- =======================================================
    * Template Name: NiceAdmin - v2.4.1
    * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== -->
    <style>
        .img-rectangle {
            width: 80px;
        }

        .recent-sales {
            width: 1160px;
        }

        .desciption-column-witdh {
            width: 300px;
            text-align: justify;
        }

        .action-column {
            display: flex;
            flex-direction: column;
            justify-content: center;
        }

        .margin-top-10 {
            margin-top: 10px;
        }

        .margin-top-30 {
            margin-top: 30px;
        }
    </style>
</head>

<body>

<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
        <a href="${pageContext.request.contextPath}/admin" class="logo d-flex align-items-center">
            <img src="${pageContext.request.contextPath}/store/icon/paper-plane.ico" alt="">
            <span class="d-none d-lg-block">Giấy Bookstore</span>
        </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <nav class="header-nav ms-auto">
        <ul class="d-flex align-items-center">

            <li class="nav-item dropdown pe-3">

                <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
                    <img src="
                                <c:if test="${sessionScope.acc.image.equals('')}">
                                    https://static.vecteezy.com/system/resources/thumbnails/001/840/618/small/picture-profile-icon-male-icon-human-or-people-sign-and-symbol-free-vector.jpg
                                </c:if>
                                <c:if test="${!sessionScope.acc.image.equals('')}">
                                    ${sessionScope.acc.image}
                                </c:if>
                            " alt="Profile"
                         class="rounded-circle">
                    <span class="d-none d-md-block dropdown-toggle ps-2">${sessionScope.acc.name}</span>
                </a><!-- End Profile Iamge Icon -->

                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                    <li class="dropdown-header">
                        <h6>${sessionScope.acc.name}</h6>
                        <c:if test="${sessionScope.acc.isRole==1}">
                            <span>Quản lý</span>
                        </c:if>
                        <c:if test="${sessionScope.acc.isRole==2}">
                            <span>Nhân viên</span>
                        </c:if>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="">
                            <i class="bi bi-person"></i>
                            <span>My Profile</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="">
                            <i class="bi bi-gear"></i>
                            <span>Account Settings</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="">
                            <i class="bi bi-question-circle"></i>
                            <span>Need Help?</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="/logout">
                            <i class="bi bi-box-arrow-right"></i>
                            <span>Đăng xuất</span>
                        </a>
                    </li>

                </ul><!-- End Profile Dropdown Items -->
            </li><!-- End Profile Nav -->

        </ul>
    </nav><!-- End Icons Navigation -->

</header><!-- End Header -->

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <c:if test="${sessionScope.acc.isRole==1}">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin">
                    <i class="bi bi-grid"></i>
                    <span>Dashboard</span>
                </a>
            </c:if>
        </li><!-- End Dashboard Nav -->

        <li class="nav-heading">Pages</li>

        <%--        <li class="nav-item">--%>
        <%--            <a class="nav-link collapsed" href="">--%>
        <%--                <i class="bi bi-person"></i>--%>
        <%--                <span>Profile</span>--%>
        <%--            </a>--%>
        <%--        </li><!-- End Profile Page Nav -->--%>
        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/customer">
                <i class="bi bi-emoji-sunglasses"></i>
                <span>Customer</span>
            </a>
        </li><!-- End Customer Page Nav -->

        <c:if test="${sessionScope.acc.isRole==1}">
            <li class="nav-item">
                <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/employee">
                    <i class="bi bi-emoji-expressionless"></i>
                    <span>Employee</span>
                </a>
            </li><!-- End Employee Page Nav -->
        </c:if>

        <c:if test="${sessionScope.acc.isRole==1}">
            <li class="nav-item">
                <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/book">
                    <i class="bi bi-journal-bookmark-fill"></i>
                    <span>Book</span>
                </a>
            </li><!-- End Book Page Nav -->
        </c:if>

        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/order">
                <i class="bi bi-receipt-cutoff"></i>
                <span>Order</span>
            </a>
        </li><!-- End Order Page Nav -->

        <c:if test="${sessionScope.acc.isRole==1}">
            <li class="nav-item">
                <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/category">
                    <i class="bi bi-grid-1x2"></i>
                    <span>Category</span>
                </a>
            </li><!-- End Category Page Nav -->
        </c:if>

        <c:if test="${sessionScope.acc.isRole==1}">
            <li class="nav-item">
                <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/paymethod">
                    <i class="bi bi-wallet2"></i>
                    <span>Pay method</span>
                </a>
            </li><!-- End Pay method Page Nav -->
        </c:if>

        <c:if test="${sessionScope.acc.isRole==1}">
            <li class="nav-item">
                <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/delivery">
                    <i class="bi bi-box-seam"></i>
                    <span>Delivery</span>
                </a>
            </li><!-- End Category Page Nav -->
        </c:if>
    </ul>

</aside><!-- End Sidebar-->

<main id="main" class="main">

    <div class="pagetitle">
        <h1>Dashboard</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin">Home</a></li>
                <li class="breadcrumb-item active">Dashboard</li>
            </ol>
        </nav>
    </div><!-- End Page Title -->

    <section class="section dashboard">
        <div class="row">

            <!-- Left side columns -->
            <div class="col-lg-8">
                <div class="row">

                    <!-- Total books Card -->
                    <div class="col-xxl-4 col-md-6">
                        <div class="card info-card sales-card">

                            <div class="card-body">
                                <h5 class="card-title">Tổng <span>| Số sách</span></h5>

                                <div class="d-flex align-items-center">
                                    <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                        <i class="bi bi-cart"></i>
                                    </div>
                                    <div class="ps-3">
                                        <c:if test="${not empty bookList}">
                                            <h6>${bookList.size()} sách</h6>
                                        </c:if>
                                        <c:if test="${empty bookList}">
                                            <h6>0 sách</h6>
                                        </c:if>

                                    </div>
                                </div>
                            </div>

                        </div>
                    </div><!-- End Total books -->

                    <!-- Revenue Card -->
                    <div class="col-xxl-4 col-md-6">
                        <div class="card info-card revenue-card">

                            <div class="card-body">
                                <h5 class="card-title">Tổng <span>| Khách hàng</span></h5>

                                <div class="d-flex align-items-center">
                                    <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                        <i class="bi bi-currency-dollar"></i>
                                    </div>
                                    <div class="ps-3">
                                        <c:if test="${not empty customerList}">
                                            <h6>${customerList.size()} khách</h6>
                                        </c:if>
                                        <c:if test="${empty customerList}">
                                            <h6>0 khách</h6>
                                        </c:if>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div><!-- End Revenue Card -->

                    <!-- Customers Card -->
                    <div class="col-xxl-4 col-md-6">

                        <div class="card info-card customers-card">

                            <div class="card-body">
                                <h5 class="card-title">Tổng <span>| Nhân viên</span></h5>

                                <div class="d-flex align-items-center">
                                    <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                        <i class="bi bi-people"></i>
                                    </div>
                                    <div class="ps-3">
                                        <c:if test="${not empty employeeList}">
                                            <h6>${employeeList.size()} đứa</h6>
                                        </c:if>
                                        <c:if test="${empty employeeList}">
                                            <h6>0 đứa</h6>
                                        </c:if>
                                    </div>
                                </div>

                            </div>
                        </div>

                    </div><!-- End Customers Card -->


                    <!-- Recent Sales -->
                    <div class="col-12">
                        <div class="card overflow-auto">

                            <div class="card-body">
                                <h5 class="card-title">Đơn hàng gần đây</h5>

                                <table class="table table-borderless datatable">
                                    <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Customer name</th>
                                        <th scope="col">Create time</th>
                                        <th scope="col">Phone</th>
                                        <th scope="col">Total pay</th>
                                        <th scope="col">Status</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <c:forEach items="${orderList}" var="o">
                                        <tr>
                                            <th scope="row"><a
                                                    href="${pageContext.request.contextPath}/admin/order?action=edit&orderID=${o.id}">${o.id}</a>
                                            </th>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/admin/order?action=edit&orderID=${o.id}">${o.contactName}</a>
                                            </td>
                                            <td>${o.createTime}</td>
                                            <td>${o.phone}</td>
                                            <td><span><b>${o.totalPay}</b></span></td>
                                            <c:choose>

                                                <c:when test="${o.status == 1}">
                                                    <td><span class="badge bg-warning text-dark">Chờ xác nhận</span>
                                                    </td>
                                                </c:when>

                                                <c:when test="${o.status == 2}">
                                                    <td><span class="badge bg-info text-dark">Chờ giao hàng</span></td>
                                                </c:when>

                                                <c:when test="${o.status == 3}">
                                                    <td><span class="badge bg-light text-dark">Đang giao</span></td>
                                                </c:when>

                                                <c:when test="${o.status == 4}">
                                                    <td><span class="badge bg-success">Đã giao</span></td>
                                                </c:when>

                                                <c:when test="${o.status == 5}">
                                                    <td><span class="badge bg-danger">Đã hủy</span></td>
                                                </c:when>

                                                <c:otherwise>
                                                    <td><span class="badge bg-success">Đã giao</span></td>
                                                </c:otherwise>
                                            </c:choose>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>

                            </div>

                        </div>
                    </div><!-- End Recent Sales -->

                    <!-- Top Selling -->
                    <div class="col-12">
                        <div class="card top-selling overflow-auto">

                            <div class="card-body pb-0">
                                <h5 class="card-title">Sách mới nhất</h5>

                                <table class="table table-borderless datatable">
                                    <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Name</th>
                                        <th scope="col">Original Price</th>
                                        <th scope="col">Sale Price</th>
                                        <th scope="col">Image</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${book5List}" var="b">
                                        <tr>
                                            <th scope="row"><a
                                                    href="${pageContext.request.contextPath}/admin/book?action=edit&productID=${b.id}">${b.id}</a>
                                            </th>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/admin/book?action=edit&productID=${b.id}">${b.name}</a>
                                            </td>
                                            <td>${b.originalPrice}</td>
                                            <td><b>${b.salePrice}</b></td>
                                            <td><img alt="" class="img-rectangle" src="${b.image}"/></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>

                            </div>

                        </div>
                    </div><!-- End Top Selling -->


                    <%--                    Tỉ lệ bán các loại sách --%>
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body"><h5 class="card-title">Tỉ lệ bán các loại sách</h5>
                                <canvas id="pieChart"
                                        style="max-height: 400px; display: block; box-sizing: border-box; height: 400px; width: 528px;"
                                        width="660" height="500"></canvas>
                                <script>
                                    document.addEventListener("DOMContentLoaded", () => {
                                        new Chart(document.querySelector('#pieChart'), {
                                            type: 'pie',
                                            data: {
                                                labels: [
                                                    <c:forEach items="${categoryList}" var="category">
                                                    '${category.name}',
                                                    </c:forEach>
                                                    // 'Red',
                                                    // 'Blue',
                                                    // 'Yellow'
                                                ],
                                                datasets: [{
                                                    label: 'My First Dataset',
                                                    data: [
                                                        <c:forEach items="${totalSaleOfCartegory}" var="categoryTotal">
                                                        ${categoryTotal},
                                                        </c:forEach>
                                                    ],
                                                    backgroundColor: [
                                                        'rgb(255, 99, 132)',
                                                        'rgb(54, 162, 235)',
                                                        'rgb(255, 205, 86)'
                                                    ],
                                                    hoverOffset: 4
                                                }]
                                            }
                                        });
                                    });</script>
                            </div>
                        </div>
                    </div>

                    <%--                    Doanh thu tuần vừa qua --%>
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body"><h5 class="card-title">Doanh thu tuần vừa qua</h5>
                                <canvas id="lineChart"
                                        style="max-height: 400px; display: block; box-sizing: border-box; height: 264px; width: 528px;"
                                        width="660" height="330"></canvas>
                                <script>
                                    document.addEventListener("DOMContentLoaded", () => {
                                        new Chart(document.querySelector('#lineChart'), {
                                            type: 'line',
                                            data: {
                                                labels: [
                                                    <c:forEach items="${lastWeekFromNow}" var="date">
                                                    '${date.toLocalDate().getDayOfMonth()}/${date.toLocalDate().getMonthValue()}/${date.toLocalDate().getYear()}',
                                                    </c:forEach>
                                                    // 'January', 'February', 'March', 'April', 'May', 'June', 'July'
                                                ],
                                                datasets: [{
                                                    label: 'Doanh thu',
                                                    data: [
                                                        <c:forEach items="${incomeLastWeek}" var="icome">
                                                        ${icome},
                                                        </c:forEach>
                                                    ],
                                                    fill: false,
                                                    borderColor: 'rgb(75, 192, 192)',
                                                    tension: 0.1
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
                                    });</script>
                            </div>
                        </div>
                    </div>

                </div>
            </div><!-- End Left side columns -->

            <!-- Right side columns -->
            <div class="col-lg-4">

                <!-- Budget Report -->
                <div class="card">
                    <div class="card-body pb-0">
                        <h5 class="card-title">Sách bán chạy nhất</h5>
                        <c:if test="${not empty bestSellerBook}">
                            <img style="width: 400px;" src="${bestSellerBook.image}" class="img-fluid rounded-start"
                                 alt="...">
                            <h5 class="card-text margin-top-10"
                                style="margin-bottom: 20px; text-align: center; margin-top: 20px"><b><a
                                    href="${pageContext.request.contextPath}/admin/book?action=edit&productID=${bestSellerBook.id}">${bestSellerBook.name}</a></b>
                            </h5>
                        </c:if>
                        <c:if test="${empty bestSellerBook}">
                            <h5 class="card-text margin-top-10" style="margin-bottom: 10px;">Chưa có sách!</h5>
                        </c:if>
                    </div>
                </div><!-- End Budget Report -->

                <!-- News & Updates Traffic -->
                <div class="card">

                    <div class="card-body pb-0">
                        <h5 class="card-title">Khách hàng thân thiết</h5>
                        <c:if test="${not empty bestCustomerByPrice}">
                            <img style="width: 400px;" src="
                            <c:if test="${bestCustomerByPrice.image.equals('')}">
                                https://static.vecteezy.com/system/resources/thumbnails/001/840/618/small/picture-profile-icon-male-icon-human-or-people-sign-and-symbol-free-vector.jpg
                            </c:if>
                            <c:if test="${!bestCustomerByPrice.image.equals('')}">
                                ${bestCustomerByPrice.image}
                            </c:if>"
                                 class="img-fluid rounded-start"
                                 alt="Ảnh khách hàng">
                            <h5 class="card-text margin-top-10"
                                style="margin-bottom: 20px; text-align: center; margin-top: 20px"><b><a
                                    href="${pageContext.request.contextPath}/admin/customer?action=edit&customerID=${bestCustomerByPrice.id}">${bestCustomerByPrice.name}</a></b>
                            </h5>
                        </c:if>
                        <c:if test="${empty bestCustomerByPrice}">
                            <h5 class="card-text margin-top-10" style="margin-bottom: 10px;">Chưa có khách hàng!</h5>
                        </c:if>
                        <div class="news">


                        </div><!-- End sidebar recent posts-->

                    </div>
                </div><!-- End News & Updates -->

            </div><!-- End Right side columns -->


        </div>
    </section>

</main><!-- End #main -->

<!-- ======= Footer ======= -->
<footer id="footer" class="footer">
    <div class="copyright">
        &copy; Copyright <strong><span>NiceAdmin</span></strong>. All Rights Reserved
    </div>
    <div class="credits">
        <!-- All the links in the footer should remain intact. -->
        <!-- You can delete the links only if you purchased the pro version. -->
        <!-- Licensing information: https://bootstrapmade.com/license/ -->
        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
        Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
    </div>
</footer><!-- End Footer -->

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>

<!-- Vendor JS Files -->
<script src="${pageContext.request.contextPath}/admin/assets/vendor/apexcharts/apexcharts.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/assets/vendor/chart.js/chart.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/assets/vendor/echarts/echarts.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/assets/vendor/quill/quill.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/assets/vendor/simple-datatables/simple-datatables.js"></script>
<script src="${pageContext.request.contextPath}/admin/assets/vendor/tinymce/tinymce.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/assets/vendor/php-email-form/validate.js"></script>

<!-- Template Main JS File -->
<script src="${pageContext.request.contextPath}/admin/assets/js/main.js"></script>

</body>

</html>