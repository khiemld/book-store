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
    <link href=${pageContext.request.contextPath}"/admin/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/admin/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/admin/assets/vendor/simple-datatables/style.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="${pageContext.request.contextPath}/admin/assets/css/style.css" rel="stylesheet">

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
            <a class="nav-link" href="${pageContext.request.contextPath}/admin">
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
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/employee">
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
                <li class="breadcrumb-item active">Dashboard</li>
            </ol>
        </nav>
    </div><!-- End Page Title -->

    <section class="section dashboard">
        <div class="row">

            <!-- Left side columns -->
            <div class="col-lg-8">
                <div class="row">

                    <!-- Sales Card -->
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
                                            <h6>${bookList.size()}</h6>
                                        </c:if>
                                        <c:if test="${empty bookList}">
                                            <h6>0</h6>
                                        </c:if>

                                    </div>
                                </div>
                            </div>

                        </div>
                    </div><!-- End Sales Card -->

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
                                            <h6>${customerList.size()}</h6>
                                        </c:if>
                                        <c:if test="${empty customerList}">
                                            <h6>0</h6>
                                        </c:if>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div><!-- End Revenue Card -->

                    <!-- Customers Card -->
                    <div class="col-xxl-4 col-xl-12">

                        <div class="card info-card customers-card">

                            <div class="card-body">
                                <h5 class="card-title">Tổng <span>| Nhân viên</span></h5>

                                <div class="d-flex align-items-center">
                                    <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                        <i class="bi bi-people"></i>
                                    </div>
                                    <div class="ps-3">
                                        <c:if test="${not empty employeeList}">
                                            <h6>${employeeList.size()}</h6>
                                        </c:if>
                                        <c:if test="${empty employeeList}">
                                            <h6>0</h6>
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
                                                    href="${pageContext.request.contextPath}/admin/order?action=edit&orderID=${o.id}">${o.id}</a></th>
                                            <td><a href="${pageContext.request.contextPath}/admin/order?action=edit&orderID=${o.id}">${o.contactName}</a>
                                            </td>
                                            <td>${o.createTime}</td>
                                            <td>${o.phone}</td>
                                            <td><span>${o.totalPay}</span></td>
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
                                                    href="${pageContext.request.contextPath}/admin/book?action=edit&productID=${b.id}">${b.id}</a></th>
                                            <td><a href="${pageContext.request.contextPath}/admin/book?action=edit&productID=${b.id}">${b.name}</a></td>
                                            <td>${b.originalPrice}</td>
                                            <td>${b.salePrice}</td>
                                            <td><img alt="" class="img-rectangle" src="${b.image}"/></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>

                            </div>

                        </div>
                    </div><!-- End Top Selling -->

                    <div class="col-12">
                        <div class="card">
                            <div class="card-body pb-0">
                                <h5 class="card-title">Pie Chart</h5>

                                <!-- Pie Chart -->
                                <div id="pieChart" style="min-height: 352.7px;">
                                    <div id="apexchartsof7o2oob"
                                         class="apexcharts-canvas apexchartsof7o2oob apexcharts-theme-light"
                                         style="width: 528px; height: 352.7px;">
                                        <svg id="SvgjsSvg2591" width="528" height="352.7"
                                             xmlns="http://www.w3.org/2000/svg"
                                             <%--xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:svgjs="http://svgjs.dev"--%>
                                             class="apexcharts-svg" <%--xmlns:data="ApexChartsNS"--%>
                                             transform="translate(0, 0)" style="background: transparent;">
                                            <foreignObject x="0" y="0" width="528" height="352.7">
                                                <div class="apexcharts-legend apexcharts-align-center apx-legend-position-right"
                                                     xmlns="http://www.w3.org/1999/xhtml"
                                                     style="position: absolute; left: auto; top: 24px; right: 5px;">
                                                    <div class="apexcharts-legend-series" rel="1" seriesname="TeamxA"
                                                         data:collapsed="false" style="margin: 2px 5px;"><span
                                                            class="apexcharts-legend-marker" rel="1"
                                                            data:collapsed="false"
                                                            style="background: rgb(0, 143, 251) !important; color: rgb(0, 143, 251); height: 12px; width: 12px; left: 0px; top: 0px; border-width: 0px; border-color: rgb(255, 255, 255); border-radius: 12px;"></span><span
                                                            class="apexcharts-legend-text" rel="1" i="0"
                                                            data:default-text="Team%20A" data:collapsed="false"
                                                            style="color: rgb(55, 61, 63); font-size: 12px; font-weight: 400; font-family: Helvetica, Arial, sans-serif;">Team A</span>
                                                    </div>
                                                    <div class="apexcharts-legend-series" rel="2" seriesname="TeamxB"
                                                         data:collapsed="false" style="margin: 2px 5px;"><span
                                                            class="apexcharts-legend-marker" rel="2"
                                                            data:collapsed="false"
                                                            style="background: rgb(0, 227, 150) !important; color: rgb(0, 227, 150); height: 12px; width: 12px; left: 0px; top: 0px; border-width: 0px; border-color: rgb(255, 255, 255); border-radius: 12px;"></span><span
                                                            class="apexcharts-legend-text" rel="2" i="1"
                                                            data:default-text="Team%20B" data:collapsed="false"
                                                            style="color: rgb(55, 61, 63); font-size: 12px; font-weight: 400; font-family: Helvetica, Arial, sans-serif;">Team B</span>
                                                    </div>
                                                    <div class="apexcharts-legend-series" rel="3" seriesname="TeamxC"
                                                         data:collapsed="false" style="margin: 2px 5px;"><span
                                                            class="apexcharts-legend-marker" rel="3"
                                                            data:collapsed="false"
                                                            style="background: rgb(254, 176, 25) !important; color: rgb(254, 176, 25); height: 12px; width: 12px; left: 0px; top: 0px; border-width: 0px; border-color: rgb(255, 255, 255); border-radius: 12px;"></span><span
                                                            class="apexcharts-legend-text" rel="3" i="2"
                                                            data:default-text="Team%20C" data:collapsed="false"
                                                            style="color: rgb(55, 61, 63); font-size: 12px; font-weight: 400; font-family: Helvetica, Arial, sans-serif;">Team C</span>
                                                    </div>
                                                    <div class="apexcharts-legend-series" rel="4" seriesname="TeamxD"
                                                         data:collapsed="false" style="margin: 2px 5px;"><span
                                                            class="apexcharts-legend-marker" rel="4"
                                                            data:collapsed="false"
                                                            style="background: rgb(255, 69, 96) !important; color: rgb(255, 69, 96); height: 12px; width: 12px; left: 0px; top: 0px; border-width: 0px; border-color: rgb(255, 255, 255); border-radius: 12px;"></span><span
                                                            class="apexcharts-legend-text" rel="4" i="3"
                                                            data:default-text="Team%20D" data:collapsed="false"
                                                            style="color: rgb(55, 61, 63); font-size: 12px; font-weight: 400; font-family: Helvetica, Arial, sans-serif;">Team D</span>
                                                    </div>
                                                    <div class="apexcharts-legend-series" rel="5" seriesname="TeamxE"
                                                         data:collapsed="false" style="margin: 2px 5px;"><span
                                                            class="apexcharts-legend-marker" rel="5"
                                                            data:collapsed="false"
                                                            style="background: rgb(119, 93, 208) !important; color: rgb(119, 93, 208); height: 12px; width: 12px; left: 0px; top: 0px; border-width: 0px; border-color: rgb(255, 255, 255); border-radius: 12px;"></span><span
                                                            class="apexcharts-legend-text" rel="5" i="4"
                                                            data:default-text="Team%20E" data:collapsed="false"
                                                            style="color: rgb(55, 61, 63); font-size: 12px; font-weight: 400; font-family: Helvetica, Arial, sans-serif;">Team E</span>
                                                    </div>
                                                </div>
                                                <style type="text/css">

                                                    .apexcharts-legend {
                                                        display: flex;
                                                        overflow: auto;
                                                        padding: 0 10px;
                                                    }

                                                    .apexcharts-legend.apx-legend-position-bottom, .apexcharts-legend.apx-legend-position-top {
                                                        flex-wrap: wrap
                                                    }

                                                    .apexcharts-legend.apx-legend-position-right, .apexcharts-legend.apx-legend-position-left {
                                                        flex-direction: column;
                                                        bottom: 0;
                                                    }

                                                    .apexcharts-legend.apx-legend-position-bottom.apexcharts-align-left, .apexcharts-legend.apx-legend-position-top.apexcharts-align-left, .apexcharts-legend.apx-legend-position-right, .apexcharts-legend.apx-legend-position-left {
                                                        justify-content: flex-start;
                                                    }

                                                    .apexcharts-legend.apx-legend-position-bottom.apexcharts-align-center, .apexcharts-legend.apx-legend-position-top.apexcharts-align-center {
                                                        justify-content: center;
                                                    }

                                                    .apexcharts-legend.apx-legend-position-bottom.apexcharts-align-right, .apexcharts-legend.apx-legend-position-top.apexcharts-align-right {
                                                        justify-content: flex-end;
                                                    }

                                                    .apexcharts-legend-series {
                                                        cursor: pointer;
                                                        line-height: normal;
                                                    }

                                                    .apexcharts-legend.apx-legend-position-bottom .apexcharts-legend-series, .apexcharts-legend.apx-legend-position-top .apexcharts-legend-series {
                                                        display: flex;
                                                        align-items: center;
                                                    }

                                                    .apexcharts-legend-text {
                                                        position: relative;
                                                        font-size: 14px;
                                                    }

                                                    .apexcharts-legend-text *, .apexcharts-legend-marker * {
                                                        pointer-events: none;
                                                    }

                                                    .apexcharts-legend-marker {
                                                        position: relative;
                                                        display: inline-block;
                                                        cursor: pointer;
                                                        margin-right: 3px;
                                                        border-style: solid;
                                                    }

                                                    .apexcharts-legend.apexcharts-align-right .apexcharts-legend-series, .apexcharts-legend.apexcharts-align-left .apexcharts-legend-series {
                                                        display: inline-block;
                                                    }

                                                    .apexcharts-legend-series.apexcharts-no-click {
                                                        cursor: auto;
                                                    }

                                                    .apexcharts-legend .apexcharts-hidden-zero-series, .apexcharts-legend .apexcharts-hidden-null-series {
                                                        display: none !important;
                                                    }

                                                    .apexcharts-inactive-legend {
                                                        opacity: 0.45;
                                                    }</style>
                                            </foreignObject>
                                            <g id="SvgjsG2593" class="apexcharts-inner apexcharts-graphical"
                                               transform="translate(22, 0)">
                                                <defs id="SvgjsDefs2592">
                                                    <clipPath id="gridRectMaskof7o2oob">
                                                        <rect id="SvgjsRect2595" width="401" height="352" x="-3" y="-1"
                                                              rx="0" ry="0" opacity="1" stroke-width="0" stroke="none"
                                                              stroke-dasharray="0" fill="#fff"></rect>
                                                    </clipPath>
                                                    <clipPath id="forecastMaskof7o2oob"></clipPath>
                                                    <clipPath id="nonForecastMaskof7o2oob"></clipPath>
                                                    <clipPath id="gridRectMarkerMaskof7o2oob">
                                                        <rect id="SvgjsRect2596" width="399" height="354" x="-2" y="-2"
                                                              rx="0" ry="0" opacity="1" stroke-width="0" stroke="none"
                                                              stroke-dasharray="0" fill="#fff"></rect>
                                                    </clipPath>
                                                    <filter id="SvgjsFilter2604" filterUnits="userSpaceOnUse"
                                                            width="200%" height="200%" x="-50%" y="-50%">
                                                        <feFlood id="SvgjsFeFlood2605" flood-color="#000000"
                                                                 flood-opacity="0.45" result="SvgjsFeFlood2605Out"
                                                                 in="SourceGraphic"></feFlood>
                                                        <feComposite id="SvgjsFeComposite2606" in="SvgjsFeFlood2605Out"
                                                                     in2="SourceAlpha" operator="in"
                                                                     result="SvgjsFeComposite2606Out"></feComposite>
                                                        <feOffset id="SvgjsFeOffset2607" dx="1" dy="1"
                                                                  result="SvgjsFeOffset2607Out"
                                                                  in="SvgjsFeComposite2606Out"></feOffset>
                                                        <feGaussianBlur id="SvgjsFeGaussianBlur2608" stdDeviation="1 "
                                                                        result="SvgjsFeGaussianBlur2608Out"
                                                                        in="SvgjsFeOffset2607Out"></feGaussianBlur>
                                                        <feMerge id="SvgjsFeMerge2609" result="SvgjsFeMerge2609Out"
                                                                 in="SourceGraphic">
                                                            <feMergeNode id="SvgjsFeMergeNode2610"
                                                                         in="SvgjsFeGaussianBlur2608Out"></feMergeNode>
                                                            <feMergeNode id="SvgjsFeMergeNode2611"
                                                                         in="[object Arguments]"></feMergeNode>
                                                        </feMerge>
                                                        <feBlend id="SvgjsFeBlend2612" in="SourceGraphic"
                                                                 in2="SvgjsFeMerge2609Out" mode="normal"
                                                                 result="SvgjsFeBlend2612Out"></feBlend>
                                                    </filter>
                                                    <filter id="SvgjsFilter2617" filterUnits="userSpaceOnUse"
                                                            width="200%" height="200%" x="-50%" y="-50%">
                                                        <feFlood id="SvgjsFeFlood2618" flood-color="#000000"
                                                                 flood-opacity="0.45" result="SvgjsFeFlood2618Out"
                                                                 in="SourceGraphic"></feFlood>
                                                        <feComposite id="SvgjsFeComposite2619" in="SvgjsFeFlood2618Out"
                                                                     in2="SourceAlpha" operator="in"
                                                                     result="SvgjsFeComposite2619Out"></feComposite>
                                                        <feOffset id="SvgjsFeOffset2620" dx="1" dy="1"
                                                                  result="SvgjsFeOffset2620Out"
                                                                  in="SvgjsFeComposite2619Out"></feOffset>
                                                        <feGaussianBlur id="SvgjsFeGaussianBlur2621" stdDeviation="1 "
                                                                        result="SvgjsFeGaussianBlur2621Out"
                                                                        in="SvgjsFeOffset2620Out"></feGaussianBlur>
                                                        <feMerge id="SvgjsFeMerge2622" result="SvgjsFeMerge2622Out"
                                                                 in="SourceGraphic">
                                                            <feMergeNode id="SvgjsFeMergeNode2623"
                                                                         in="SvgjsFeGaussianBlur2621Out"></feMergeNode>
                                                            <feMergeNode id="SvgjsFeMergeNode2624"
                                                                         in="[object Arguments]"></feMergeNode>
                                                        </feMerge>
                                                        <feBlend id="SvgjsFeBlend2625" in="SourceGraphic"
                                                                 in2="SvgjsFeMerge2622Out" mode="normal"
                                                                 result="SvgjsFeBlend2625Out"></feBlend>
                                                    </filter>
                                                    <filter id="SvgjsFilter2630" filterUnits="userSpaceOnUse"
                                                            width="200%" height="200%" x="-50%" y="-50%">
                                                        <feFlood id="SvgjsFeFlood2631" flood-color="#000000"
                                                                 flood-opacity="0.45" result="SvgjsFeFlood2631Out"
                                                                 in="SourceGraphic"></feFlood>
                                                        <feComposite id="SvgjsFeComposite2632" in="SvgjsFeFlood2631Out"
                                                                     in2="SourceAlpha" operator="in"
                                                                     result="SvgjsFeComposite2632Out"></feComposite>
                                                        <feOffset id="SvgjsFeOffset2633" dx="1" dy="1"
                                                                  result="SvgjsFeOffset2633Out"
                                                                  in="SvgjsFeComposite2632Out"></feOffset>
                                                        <feGaussianBlur id="SvgjsFeGaussianBlur2634" stdDeviation="1 "
                                                                        result="SvgjsFeGaussianBlur2634Out"
                                                                        in="SvgjsFeOffset2633Out"></feGaussianBlur>
                                                        <feMerge id="SvgjsFeMerge2635" result="SvgjsFeMerge2635Out"
                                                                 in="SourceGraphic">
                                                            <feMergeNode id="SvgjsFeMergeNode2636"
                                                                         in="SvgjsFeGaussianBlur2634Out"></feMergeNode>
                                                            <feMergeNode id="SvgjsFeMergeNode2637"
                                                                         in="[object Arguments]"></feMergeNode>
                                                        </feMerge>
                                                        <feBlend id="SvgjsFeBlend2638" in="SourceGraphic"
                                                                 in2="SvgjsFeMerge2635Out" mode="normal"
                                                                 result="SvgjsFeBlend2638Out"></feBlend>
                                                    </filter>
                                                    <filter id="SvgjsFilter2643" filterUnits="userSpaceOnUse"
                                                            width="200%" height="200%" x="-50%" y="-50%">
                                                        <feFlood id="SvgjsFeFlood2644" flood-color="#000000"
                                                                 flood-opacity="0.45" result="SvgjsFeFlood2644Out"
                                                                 in="SourceGraphic"></feFlood>
                                                        <feComposite id="SvgjsFeComposite2645" in="SvgjsFeFlood2644Out"
                                                                     in2="SourceAlpha" operator="in"
                                                                     result="SvgjsFeComposite2645Out"></feComposite>
                                                        <feOffset id="SvgjsFeOffset2646" dx="1" dy="1"
                                                                  result="SvgjsFeOffset2646Out"
                                                                  in="SvgjsFeComposite2645Out"></feOffset>
                                                        <feGaussianBlur id="SvgjsFeGaussianBlur2647" stdDeviation="1 "
                                                                        result="SvgjsFeGaussianBlur2647Out"
                                                                        in="SvgjsFeOffset2646Out"></feGaussianBlur>
                                                        <feMerge id="SvgjsFeMerge2648" result="SvgjsFeMerge2648Out"
                                                                 in="SourceGraphic">
                                                            <feMergeNode id="SvgjsFeMergeNode2649"
                                                                         in="SvgjsFeGaussianBlur2647Out"></feMergeNode>
                                                            <feMergeNode id="SvgjsFeMergeNode2650"
                                                                         in="[object Arguments]"></feMergeNode>
                                                        </feMerge>
                                                        <feBlend id="SvgjsFeBlend2651" in="SourceGraphic"
                                                                 in2="SvgjsFeMerge2648Out" mode="normal"
                                                                 result="SvgjsFeBlend2651Out"></feBlend>
                                                    </filter>
                                                    <filter id="SvgjsFilter2656" filterUnits="userSpaceOnUse"
                                                            width="200%" height="200%" x="-50%" y="-50%">
                                                        <feFlood id="SvgjsFeFlood2657" flood-color="#000000"
                                                                 flood-opacity="0.45" result="SvgjsFeFlood2657Out"
                                                                 in="SourceGraphic"></feFlood>
                                                        <feComposite id="SvgjsFeComposite2658" in="SvgjsFeFlood2657Out"
                                                                     in2="SourceAlpha" operator="in"
                                                                     result="SvgjsFeComposite2658Out"></feComposite>
                                                        <feOffset id="SvgjsFeOffset2659" dx="1" dy="1"
                                                                  result="SvgjsFeOffset2659Out"
                                                                  in="SvgjsFeComposite2658Out"></feOffset>
                                                        <feGaussianBlur id="SvgjsFeGaussianBlur2660" stdDeviation="1 "
                                                                        result="SvgjsFeGaussianBlur2660Out"
                                                                        in="SvgjsFeOffset2659Out"></feGaussianBlur>
                                                        <feMerge id="SvgjsFeMerge2661" result="SvgjsFeMerge2661Out"
                                                                 in="SourceGraphic">
                                                            <feMergeNode id="SvgjsFeMergeNode2662"
                                                                         in="SvgjsFeGaussianBlur2660Out"></feMergeNode>
                                                            <feMergeNode id="SvgjsFeMergeNode2663"
                                                                         in="[object Arguments]"></feMergeNode>
                                                        </feMerge>
                                                        <feBlend id="SvgjsFeBlend2664" in="SourceGraphic"
                                                                 in2="SvgjsFeMerge2661Out" mode="normal"
                                                                 result="SvgjsFeBlend2664Out"></feBlend>
                                                    </filter>
                                                </defs>
                                                <g id="SvgjsG2597" class="apexcharts-pie">
                                                    <g id="SvgjsG2598" transform="translate(0, 0) scale(1)">
                                                        <g id="SvgjsG2599" class="apexcharts-slices">
                                                            <g id="SvgjsG2600"
                                                               class="apexcharts-series apexcharts-pie-series"
                                                               seriesName="TeamxA" rel="1" data:realIndex="0">
                                                                <path id="SvgjsPath2601"
                                                                      d="M 197.5 10.268292682926813 A 164.7317073170732 164.7317073170732 0 0 1 362.2252204115186 173.53809850725656 L 197.5 175 L 197.5 10.268292682926813"
                                                                      fill="rgba(0,143,251,1)" fill-opacity="1"
                                                                      stroke-opacity="1" stroke-linecap="butt"
                                                                      stroke-width="2" stroke-dasharray="0"
                                                                      class="apexcharts-pie-area apexcharts-pie-slice-0"
                                                                      index="0" j="0" data:angle="89.49152542372882"
                                                                      data:startAngle="0" data:strokeWidth="2"
                                                                      data:value="44"
                                                                      data:pathOrig="M 197.5 10.268292682926813 A 164.7317073170732 164.7317073170732 0 0 1 362.2252204115186 173.53809850725656 L 197.5 175 L 197.5 10.268292682926813"
                                                                      stroke="#ffffff"></path>
                                                            </g>
                                                            <g id="SvgjsG2613"
                                                               class="apexcharts-series apexcharts-pie-series"
                                                               seriesName="TeamxB" rel="2" data:realIndex="1">
                                                                <path id="SvgjsPath2614"
                                                                      d="M 362.2252204115186 173.53809850725656 A 164.7317073170732 164.7317073170732 0 0 1 137.51120670103506 328.42059859788037 L 197.5 175 L 362.2252204115186 173.53809850725656"
                                                                      fill="rgba(0,227,150,1)" fill-opacity="1"
                                                                      stroke-opacity="1" stroke-linecap="butt"
                                                                      stroke-width="2" stroke-dasharray="0"
                                                                      class="apexcharts-pie-area apexcharts-pie-slice-1"
                                                                      index="0" j="1" data:angle="111.86440677966102"
                                                                      data:startAngle="89.49152542372882"
                                                                      data:strokeWidth="2" data:value="55"
                                                                      data:pathOrig="M 362.2252204115186 173.53809850725656 A 164.7317073170732 164.7317073170732 0 0 1 137.51120670103506 328.42059859788037 L 197.5 175 L 362.2252204115186 173.53809850725656"
                                                                      stroke="#ffffff"></path>
                                                            </g>
                                                            <g id="SvgjsG2626"
                                                               class="apexcharts-series apexcharts-pie-series"
                                                               seriesName="TeamxC" rel="3" data:realIndex="2">
                                                                <path id="SvgjsPath2627"
                                                                      d="M 137.51120670103506 328.42059859788037 A 164.7317073170732 164.7317073170732 0 0 1 75.47254096040673 285.66089930927836 L 197.5 175 L 137.51120670103506 328.42059859788037"
                                                                      fill="rgba(254,176,25,1)" fill-opacity="1"
                                                                      stroke-opacity="1" stroke-linecap="butt"
                                                                      stroke-width="2" stroke-dasharray="0"
                                                                      class="apexcharts-pie-area apexcharts-pie-slice-2"
                                                                      index="0" j="2" data:angle="26.440677966101703"
                                                                      data:startAngle="201.35593220338984"
                                                                      data:strokeWidth="2" data:value="13"
                                                                      data:pathOrig="M 137.51120670103506 328.42059859788037 A 164.7317073170732 164.7317073170732 0 0 1 75.47254096040673 285.66089930927836 L 197.5 175 L 137.51120670103506 328.42059859788037"
                                                                      stroke="#ffffff"></path>
                                                            </g>
                                                            <g id="SvgjsG2639"
                                                               class="apexcharts-series apexcharts-pie-series"
                                                               seriesName="TeamxD" rel="4" data:realIndex="3">
                                                                <path id="SvgjsPath2640"
                                                                      d="M 75.47254096040673 285.66089930927836 A 164.7317073170732 164.7317073170732 0 0 1 81.53510473688851 58.001374101173965 L 197.5 175 L 75.47254096040673 285.66089930927836"
                                                                      fill="rgba(255,69,96,1)" fill-opacity="1"
                                                                      stroke-opacity="1" stroke-linecap="butt"
                                                                      stroke-width="2" stroke-dasharray="0"
                                                                      class="apexcharts-pie-area apexcharts-pie-slice-3"
                                                                      index="0" j="3" data:angle="87.4576271186441"
                                                                      data:startAngle="227.79661016949154"
                                                                      data:strokeWidth="2" data:value="43"
                                                                      data:pathOrig="M 75.47254096040673 285.66089930927836 A 164.7317073170732 164.7317073170732 0 0 1 81.53510473688851 58.001374101173965 L 197.5 175 L 75.47254096040673 285.66089930927836"
                                                                      stroke="#ffffff"></path>
                                                            </g>
                                                            <g id="SvgjsG2652"
                                                               class="apexcharts-series apexcharts-pie-series"
                                                               seriesName="TeamxE" rel="5" data:realIndex="4">
                                                                <path id="SvgjsPath2653"
                                                                      d="M 81.53510473688851 58.001374101173965 A 164.7317073170732 164.7317073170732 0 0 1 197.4712488933948 10.268295191934186 L 197.5 175 L 81.53510473688851 58.001374101173965"
                                                                      fill="rgba(119,93,208,1)" fill-opacity="1"
                                                                      stroke-opacity="1" stroke-linecap="butt"
                                                                      stroke-width="2" stroke-dasharray="0"
                                                                      class="apexcharts-pie-area apexcharts-pie-slice-4"
                                                                      index="0" j="4" data:angle="44.745762711864415"
                                                                      data:startAngle="315.25423728813564"
                                                                      data:strokeWidth="2" data:value="22"
                                                                      data:pathOrig="M 81.53510473688851 58.001374101173965 A 164.7317073170732 164.7317073170732 0 0 1 197.4712488933948 10.268295191934186 L 197.5 175 L 81.53510473688851 58.001374101173965"
                                                                      stroke="#ffffff"></path>
                                                            </g>
                                                            <g id="SvgjsG2602" class="apexcharts-datalabels">
                                                                <text id="SvgjsText2603"
                                                                      font-family="Helvetica, Arial, sans-serif"
                                                                      x="290.2719162104893" y="81.4010992809392"
                                                                      text-anchor="middle" dominant-baseline="auto"
                                                                      font-size="12px" font-weight="600" fill="#ffffff"
                                                                      class="apexcharts-text apexcharts-pie-label"
                                                                      filter="url(#SvgjsFilter2604)"
                                                                      style="font-family: Helvetica, Arial, sans-serif;">
                                                                    20%
                                                                </text>
                                                            </g>
                                                            <g id="SvgjsG2615" class="apexcharts-datalabels">
                                                                <text id="SvgjsText2616"
                                                                      font-family="Helvetica, Arial, sans-serif"
                                                                      x="272.28856383017427" y="283.5083101582666"
                                                                      text-anchor="middle" dominant-baseline="auto"
                                                                      font-size="12px" font-weight="600" fill="#ffffff"
                                                                      class="apexcharts-text apexcharts-pie-label"
                                                                      filter="url(#SvgjsFilter2617)"
                                                                      style="font-family: Helvetica, Arial, sans-serif;">
                                                                    36%
                                                                </text>
                                                            </g>
                                                            <g id="SvgjsG2628" class="apexcharts-datalabels">
                                                                <text id="SvgjsText2629"
                                                                      font-family="Helvetica, Arial, sans-serif"
                                                                      x="122.71143616982566" y="283.50831015826657"
                                                                      text-anchor="middle" dominant-baseline="auto"
                                                                      font-size="12px" font-weight="600" fill="#ffffff"
                                                                      class="apexcharts-text apexcharts-pie-label"
                                                                      filter="url(#SvgjsFilter2630)"
                                                                      style="font-family: Helvetica, Arial, sans-serif;">
                                                                    7.3%
                                                                </text>
                                                            </g>
                                                            <g id="SvgjsG2641" class="apexcharts-datalabels">
                                                                <text id="SvgjsText2642"
                                                                      font-family="Helvetica, Arial, sans-serif"
                                                                      x="65.76133741409171" y="171.49180484310756"
                                                                      text-anchor="middle" dominant-baseline="auto"
                                                                      font-size="12px" font-weight="600" fill="#ffffff"
                                                                      class="apexcharts-text apexcharts-pie-label"
                                                                      filter="url(#SvgjsFilter2643)"
                                                                      style="font-family: Helvetica, Arial, sans-serif;">
                                                                    24.3%
                                                                </text>
                                                            </g>
                                                            <g id="SvgjsG2654" class="apexcharts-datalabels">
                                                                <text id="SvgjsText2655"
                                                                      font-family="Helvetica, Arial, sans-serif"
                                                                      x="147.33817547964932" y="53.13460698798785"
                                                                      text-anchor="middle" dominant-baseline="auto"
                                                                      font-size="12px" font-weight="600" fill="#ffffff"
                                                                      class="apexcharts-text apexcharts-pie-label"
                                                                      filter="url(#SvgjsFilter2656)"
                                                                      style="font-family: Helvetica, Arial, sans-serif;">
                                                                    12.4%
                                                                </text>
                                                            </g>
                                                        </g>
                                                    </g>
                                                </g>
                                                <line id="SvgjsLine2665" x1="0" y1="0" x2="395" y2="0" stroke="#b6b6b6"
                                                      stroke-dasharray="0" stroke-width="1" stroke-linecap="butt"
                                                      class="apexcharts-ycrosshairs"></line>
                                                <line id="SvgjsLine2666" x1="0" y1="0" x2="395" y2="0"
                                                      stroke-dasharray="0" stroke-width="0" stroke-linecap="butt"
                                                      class="apexcharts-ycrosshairs-hidden"></line>
                                            </g>
                                            <g id="SvgjsG2594" class="apexcharts-annotations"></g>
                                        </svg>
                                        <div class="apexcharts-tooltip apexcharts-theme-dark"
                                             style="left: 74.8187px; top: 221.4px;">
                                            <div class="apexcharts-tooltip-series-group apexcharts-active"
                                                 style="order: 1; display: flex; background-color: rgb(255, 69, 96);">
                                                <span class="apexcharts-tooltip-marker"
                                                      style="background-color: rgb(255, 69, 96); display: none;"></span>
                                                <div class="apexcharts-tooltip-text"
                                                     style="font-family: Helvetica, Arial, sans-serif; font-size: 12px;">
                                                    <div class="apexcharts-tooltip-y-group"><span
                                                            class="apexcharts-tooltip-text-y-label">Team D: </span><span
                                                            class="apexcharts-tooltip-text-y-value">43</span></div>
                                                    <div class="apexcharts-tooltip-goals-group"><span
                                                            class="apexcharts-tooltip-text-goals-label"></span><span
                                                            class="apexcharts-tooltip-text-goals-value"></span></div>
                                                    <div class="apexcharts-tooltip-z-group"><span
                                                            class="apexcharts-tooltip-text-z-label"></span><span
                                                            class="apexcharts-tooltip-text-z-value"></span></div>
                                                </div>
                                            </div>
                                            <div class="apexcharts-tooltip-series-group"
                                                 style="order: 2; display: none; background-color: rgb(255, 69, 96);">
                                                <span class="apexcharts-tooltip-marker"
                                                      style="background-color: rgb(255, 69, 96); display: none;"></span>
                                                <div class="apexcharts-tooltip-text"
                                                     style="font-family: Helvetica, Arial, sans-serif; font-size: 12px;">
                                                    <div class="apexcharts-tooltip-y-group"><span
                                                            class="apexcharts-tooltip-text-y-label">Team D: </span><span
                                                            class="apexcharts-tooltip-text-y-value">43</span></div>
                                                    <div class="apexcharts-tooltip-goals-group"><span
                                                            class="apexcharts-tooltip-text-goals-label"></span><span
                                                            class="apexcharts-tooltip-text-goals-value"></span></div>
                                                    <div class="apexcharts-tooltip-z-group"><span
                                                            class="apexcharts-tooltip-text-z-label"></span><span
                                                            class="apexcharts-tooltip-text-z-value"></span></div>
                                                </div>
                                            </div>
                                            <div class="apexcharts-tooltip-series-group"
                                                 style="order: 3; display: none; background-color: rgb(255, 69, 96);">
                                                <span class="apexcharts-tooltip-marker"
                                                      style="background-color: rgb(255, 69, 96); display: none;"></span>
                                                <div class="apexcharts-tooltip-text"
                                                     style="font-family: Helvetica, Arial, sans-serif; font-size: 12px;">
                                                    <div class="apexcharts-tooltip-y-group"><span
                                                            class="apexcharts-tooltip-text-y-label">Team D: </span><span
                                                            class="apexcharts-tooltip-text-y-value">43</span></div>
                                                    <div class="apexcharts-tooltip-goals-group"><span
                                                            class="apexcharts-tooltip-text-goals-label"></span><span
                                                            class="apexcharts-tooltip-text-goals-value"></span></div>
                                                    <div class="apexcharts-tooltip-z-group"><span
                                                            class="apexcharts-tooltip-text-z-label"></span><span
                                                            class="apexcharts-tooltip-text-z-value"></span></div>
                                                </div>
                                            </div>
                                            <div class="apexcharts-tooltip-series-group"
                                                 style="order: 4; display: none; background-color: rgb(255, 69, 96);">
                                                <span class="apexcharts-tooltip-marker"
                                                      style="background-color: rgb(255, 69, 96); display: none;"></span>
                                                <div class="apexcharts-tooltip-text"
                                                     style="font-family: Helvetica, Arial, sans-serif; font-size: 12px;">
                                                    <div class="apexcharts-tooltip-y-group"><span
                                                            class="apexcharts-tooltip-text-y-label">Team D: </span><span
                                                            class="apexcharts-tooltip-text-y-value">43</span></div>
                                                    <div class="apexcharts-tooltip-goals-group"><span
                                                            class="apexcharts-tooltip-text-goals-label"></span><span
                                                            class="apexcharts-tooltip-text-goals-value"></span></div>
                                                    <div class="apexcharts-tooltip-z-group"><span
                                                            class="apexcharts-tooltip-text-z-label"></span><span
                                                            class="apexcharts-tooltip-text-z-value"></span></div>
                                                </div>
                                            </div>
                                            <div class="apexcharts-tooltip-series-group"
                                                 style="order: 5; display: none; background-color: rgb(255, 69, 96);">
                                                <span class="apexcharts-tooltip-marker"
                                                      style="background-color: rgb(255, 69, 96); display: none;"></span>
                                                <div class="apexcharts-tooltip-text"
                                                     style="font-family: Helvetica, Arial, sans-serif; font-size: 12px;">
                                                    <div class="apexcharts-tooltip-y-group"><span
                                                            class="apexcharts-tooltip-text-y-label">Team D: </span><span
                                                            class="apexcharts-tooltip-text-y-value">43</span></div>
                                                    <div class="apexcharts-tooltip-goals-group"><span
                                                            class="apexcharts-tooltip-text-goals-label"></span><span
                                                            class="apexcharts-tooltip-text-goals-value"></span></div>
                                                    <div class="apexcharts-tooltip-z-group"><span
                                                            class="apexcharts-tooltip-text-z-label"></span><span
                                                            class="apexcharts-tooltip-text-z-value"></span></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="apexcharts-toolbar" style="top: 0px; right: 3px;">
                                            <div class="apexcharts-menu-icon" title="Menu">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                                     viewBox="0 0 24 24">
                                                    <path fill="none" d="M0 0h24v24H0V0z"></path>
                                                    <path d="M3 18h18v-2H3v2zm0-5h18v-2H3v2zm0-7v2h18V6H3z"></path>
                                                </svg>
                                            </div>
                                            <div class="apexcharts-menu">
                                                <div class="apexcharts-menu-item exportSVG" title="Download SVG">
                                                    Download SVG
                                                </div>
                                                <div class="apexcharts-menu-item exportPNG" title="Download PNG">
                                                    Download PNG
                                                </div>
                                                <div class="apexcharts-menu-item exportCSV" title="Download CSV">
                                                    Download CSV
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <script>
                                    document.addEventListener("DOMContentLoaded", () => {
                                        new ApexCharts(document.querySelector("#pieChart"), {
                                            series: [44, 55, 13, 43, 22],
                                            chart: {
                                                height: 350,
                                                type: 'pie',
                                                toolbar: {
                                                    show: true
                                                }
                                            },
                                            labels: ['Team A', 'Team B', 'Team C', 'Team D', 'Team E']
                                        }).render();
                                    });
                                </script>
                                <!-- End Pie Chart -->

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

                <!-- Website Traffic -->
                <div class="card">
                    <div class="card-body pb-0">
                        <h5 class="card-title">Loại sách bán chạy</h5>
                    </div>
                </div><!-- End Website Traffic -->

                <!-- News & Updates Traffic -->
                <div class="card">

                    <div class="card-body pb-0">
                        <h5 class="card-title">Khách hàng thân thiết</h5>

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
