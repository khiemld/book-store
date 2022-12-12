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

    <!-- Chỗ này hong biết sao nó hong ăn bên file style.css nên phải để ở đây :>> -->
    <style>
        .img-rectangle {
            width: 250px;
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
        .full-column-width{
            width: 100%;
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
            <img src="${pageContext.request.contextPath}/admin/assets/img/logo.png" alt="">
            <span class="d-none d-lg-block">Giấy Bookstore</span>
        </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <nav class="header-nav ms-auto">
        <ul class="d-flex align-items-center">

            <li class="nav-item dropdown pe-3">

                <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
                    <img src="${pageContext.request.contextPath}/admin/assets/img/profile-img.jpg" alt="Profile" class="rounded-circle">
                    <span class="d-none d-md-block dropdown-toggle ps-2">K. Anderson</span>
                </a><!-- End Profile Iamge Icon -->

                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                    <li class="dropdown-header">
                        <h6>Kevin Anderson</h6>
                        <span>Web Designer</span>
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
                        <a class="dropdown-item d-flex align-items-center" href="#">
                            <i class="bi bi-box-arrow-right"></i>
                            <span>Sign Out</span>
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
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin">
                <i class="bi bi-grid"></i>
                <span>Dashboard</span>
            </a>
        </li><!-- End Dashboard Nav -->

        <li class="nav-heading">Pages</li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="">
                <i class="bi bi-person"></i>
                <span>Profile</span>
            </a>
        </li><!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/customer">
                <i class="bi bi-emoji-sunglasses"></i>
                <span>Customer</span>
            </a>
        </li><!-- End Customer Page Nav -->

        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/admin/employee">
                <i class="bi bi-emoji-laughing-fill"></i>
                <span>Employee</span>
            </a>
        </li><!-- End Employee Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/book">
                <i class="bi bi-journal-bookmark-fill"></i>
                <span>Book</span>
            </a>
        </li><!-- End Book Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/order">
                <i class="bi bi-receipt-cutoff"></i>
                <span>Order</span>
            </a>
        </li><!-- End Order Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="">
                <i class="bi bi-grid-1x2"></i>
                <span>Category</span>
            </a>
        </li><!-- End Category Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/paymethod">
                <i class="bi bi-wallet2"></i>
                <span>Pay method</span>
            </a>
        </li><!-- End Pay method Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/delivery">
                <i class="bi bi-box-seam"></i>
                <span>Delivery</span>
            </a>
        </li><!-- End Category Page Nav -->

    </ul>

</aside><!-- End Sidebar-->

<main id="main" class="main">

    <div class="pagetitle">
        <h1>Dashboard</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin">Home</a></li>
                <li class="breadcrumb-item active">Employee</li>
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
                                <h5 class="card-title">Tổng <span>| Nhân viên</span></h5>

                                <div class="d-flex align-items-center">
                                    <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                        <i class="bi bi-cart"></i>
                                    </div>
                                    <div class="ps-3">
                                        <h6>${employeeList.size()} nhân viên</h6>

                                    </div>
                                </div>
                            </div>

                        </div>
                    </div><!-- End Sales Card -->

                    <!-- Revenue Card -->
                    <div class="col-xxl-4 col-md-6">
                        <div class="card info-card revenue-card">

                            <div class="card-body">
                                <h5 class="card-title">Top <span>| Chốt quá chời tiền</span></h5>

                                <div class="d-flex align-items-center">
                                    <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                        <i class="bi bi-currency-dollar"></i>
                                    </div>
                                    <div class="ps-3">
                                        <h6>${BestEmployeeByPrice.name}</h6>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div><!-- End Revenue Card -->

                    <!-- Customers Card -->
                    <div class="col-xxl-4 col-xl-12">

                        <div class="card info-card customers-card">

                            <div class="card-body">
                                <h5 class="card-title">Top <span>| Chốt nhiều sách nhất</span></h5>

                                <div class="d-flex align-items-center">
                                    <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                        <i class="bi bi-people"></i>
                                    </div>
                                    <div class="ps-3">
                                        <h6>${BestEmployeeByBooks.name}</h6>
                                    </div>
                                </div>

                            </div>
                        </div>

                    </div><!-- End Customers Card -->

                    <!-- Add button -->
                    <form action="${pageContext.request.contextPath}/admin/employee" method="get">
                        <input type="hidden" name="action" value="insert">
                        <input type="submit" class="btn btn-success" value="Add employee">
                        <%--<a href="/admin/book?action=insert" class="btn btn-success">Add book</a>--%>
                    </form>

                    <!-- Book List -->
                    <div class="col-12">
                        <div class="card overflow-auto margin-top-30">

                            <div class="card-body">
                                <h5 class="card-title">Nhân viên</h5>

                                <table class="table table-borderless datatable">
                                    <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Name</th>
                                        <th scope="col">Address</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Image</th>
                                        <th scope="col">Phone</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${employeeList}" var="e">
                                        <tr>
                                            <th scope="row"><a href="#">${e.id}</a></th>
                                            <td><a href="">${e.name}</a></td>
                                            <td>${e.address}</td>
                                            <td>${e.email}</td>
                                            <td><img alt="" class="img-rectangle" src="${e.image}"/></td>
                                            <td><span>${e.phone}</span></td>
                                            <td class="action-column">
                                                <a href="${pageContext.request.contextPath}/admin/employee?action=edit&employeeID=${e.id}"
                                                   class="btn btn-primary full-column-width">Edit</a>
                                                <form action="" method="post">
                                                    <input type="hidden" name="employeeID" value="${e.id}">
                                                    <input type="hidden" name="action" value="delete">
                                                    <input class="btn btn-danger margin-top-10 full-column-width" type="submit"
                                                           value="Delete"
                                                           onclick="if (confirm('Bạn có chắc chắn muốn xóa nhân viên này?')) { form.action='${pageContext.request.contextPath}/admin/employee'; } else { return false; }"/>
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