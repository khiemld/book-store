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
    <link href="${pageContext.request.contextPath}/admin/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/admin/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/admin/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/admin/assets/vendor/quill/quill.snow.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/admin/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/admin/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/admin/assets/vendor/simple-datatables/style.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="${pageContext.request.contextPath}/admin/assets/css/style.css" rel="stylesheet">

    <!-- Logo -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/store/icon/paper-plane.ico">

    <!-- Chỗ này hong biết sao nó hong ăn bên file style.css nên phải để ở đây :>> -->
    <style>
        .img-rectangle {
            width: 200px;
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

    <!-- =======================================================
    * Template Name: NiceAdmin - v2.4.1
    * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== -->
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
                        <a class="dropdown-item d-flex align-items-center" href="${pageContext.request.contextPath}/admin/employee?action=edit&employeeID=${sessionScope.acc.id}">
                            <i class="bi bi-person"></i>
                            <span>Tài khoản</span>
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
                <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin">
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
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/book">
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
                <li class="breadcrumb-item active">Book</li>
            </ol>
        </nav>
    </div><!-- End Page Title -->

    <section class="section dashboard">
        <div class="row">

            <!-- Left side columns -->
            <div class="col-lg-8 recent-sales">
                <div class="row">
                    <c:if test="${not empty message}">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            <i class="bi bi-exclamation-triangle me-1"></i>
                                ${message}
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                    </c:if>
                    <!-- Sales Card -->
                    <div class="col-xxl-4 col-md-6">
                        <div class="card info-card sales-card">

                            <div class="card-body">
                                <h5 class="card-title">Tổng <span>| Đầu sách</span></h5>

                                <div class="d-flex align-items-center">
                                    <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                        <i class="bi bi-cart"></i>
                                    </div>
                                    <div class="ps-3">
                                        <h6>${bookList.size()} đầu sách</h6>

                                    </div>
                                </div>
                            </div>

                        </div>
                    </div><!-- End Sales Card -->

                    <!-- Revenue Card -->
                    <div class="col-xxl-4 col-md-6">
                        <div class="card info-card revenue-card">

                            <div class="card-body">
                                <h5 class="card-title">Tổng <span>| Còn lại</span></h5>

                                <div class="d-flex align-items-center">
                                    <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                        <i class="bi bi-currency-dollar"></i>
                                    </div>
                                    <div class="ps-3">
                                        <h6>${total} quyển</h6>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div><!-- End Revenue Card -->

                    <!-- Customers Card -->
                    <div class="col-xxl-4 col-xl-12">

                        <div class="card info-card customers-card">

                            <div class="card-body">
                                <h5 class="card-title">Tổng <span>| Đã bán</span></h5>

                                <div class="d-flex align-items-center">
                                    <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                        <i class="bi bi-people"></i>
                                    </div>
                                    <div class="ps-3">
                                        <h6>${sell} quyển</h6>

                                    </div>
                                </div>

                            </div>
                        </div>

                    </div><!-- End Customers Card -->

                    <!-- Add button -->
                    <form action="${pageContext.request.contextPath}/admin/book" method="get">
                        <input type="hidden" name="action" value="insert">
                        <input type="submit" class="btn btn-success" value="Add book">
                        <%--<a href="/admin/book?action=insert" class="btn btn-success">Add book</a>--%>
                    </form>

                    <ul class="nav nav-tabs nav-tabs-bordered margin-top-30" id="borderedTab" role="tablist">
                        <li class="nav-item" role="presentation">
                            <a class="nav-link ${category.id==0?"active":""}" id="home-tab"
                               type="button" role="tab" aria-controls="home"
                               aria-selected="true" href="${pageContext.request.contextPath}/admin/book?cID=0">Tất cả
                            </a>
                        </li>
                        <c:forEach items="${categoryList}" var="c">
                            <li class="nav-item" role="presentation">
                                <a class="nav-link ${category.id==c.id?"active":""}" id="profile-tab"
                                   type="button" role="tab" aria-controls="profile"
                                   aria-selected="false" tabindex="-1" href="${pageContext.request.contextPath}/admin/book?cID=${c.id}">${c.name}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>

                    <!-- Book List -->
                    <div class="col-12">
                        <div class="card overflow-auto margin-top-30">

                            <div class="card-body">
                                <h5 class="card-title">${category.name}</h5>

                                <table class="table table-borderless datatable">
                                    <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Name</th>
                                        <th scope="col">Original Price</th>
                                        <th scope="col">Sale Price</th>
                                        <th scope="col">Describe</th>
                                        <th scope="col">Image</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${bookList}" var="b">
                                        <tr>
                                            <th scope="row"><a href="#">${b.id}</a></th>
                                            <td><a href="">${b.name}</a></td>
                                            <td>${b.originalPrice}</td>
                                            <td>${b.salePrice}</td>
                                            <td class="desciption-column-witdh"><span>${b.discription}</span></td>
                                            <td><img alt="" class="img-rectangle" src="${b.image}"/></td>
                                            <td class="action-column">
                                                <a href="${pageContext.request.contextPath}/admin/book?action=edit&productID=${b.id}"
                                                   class="btn btn-primary">Sửa</a>
                                                <form action="" method="post">
                                                    <input type="hidden" name="productID" value="${b.id}">
                                                    <input type="hidden" name="action" value="delete">
                                                    <input class="btn btn-danger margin-top-10" type="submit"
                                                           value="Xóa"
                                                           onclick="if (confirm('Bạn có chắc chắn muốn xóa món hàng này?')) { form.action='${pageContext.request.contextPath}/admin/book'; } else { return false; }"/>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>

                            </div>

                        </div>
                    </div><!-- End Book List-->

                </div>
            </div><!-- End Left side columns -->

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