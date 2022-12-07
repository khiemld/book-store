<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <!-- CSS -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">

    <link href="<c:url value ="/store/css/style.css" />" rel="stylesheet" type="text/css">
    <title>Your Profile</title>

    <link href="<c:url value = "/store/css/listOrder.css" />" rel="stylesheet" type="text/css">

</head>
<body>
<!-- header -->
<%@ include file ="header.jsp" %>
<!-- end header -->

<div class="container" >
    <div class="main-body">

        <!-- Breadcrumb -->
        <nav aria-label="breadcrumb" class="main-breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item"><a href="javascript:void(0)">User</a></li>
                <li class="breadcrumb-item active" aria-current="page">User Profile</li>
            </ol>
        </nav>
        <!-- /Breadcrumb -->

        <div class="row gutters-sm">
            <div class="col-md-4 mb-3">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex flex-column align-items-center text-center">
                            <c:if test="${sessionScope.acc.image != null}">
                                <img src="${sessionScope.acc.image}" alt="Admin" class="rounded-circle" width="150">
                            </c:if>
                            <div class="mt-3">
                                <h4>${sessionScope.acc.email}</h4>
                                <c:if test="${sessionScope.acc.isRole == 1}">
                                    <p class="text-secondary mb-1">Admin</p>
                                </c:if>
                                <c:if test="${sessionScope.acc.isRole == 2}">
                                    <p class="text-secondary mb-1">Employee</p>
                                </c:if>
                                <c:if test="${sessionScope.acc.isRole == 3}">
                                    <p class="text-secondary mb-1">Customer</p>
                                </c:if>
                                <p class="text-muted font-size-sm">${sessionScope.acc.address}</p>
                                <button class="btn btn-primary">Follow</button>
                                <button class="btn btn-outline-primary">Message</button>
                            </div>

                            <form action="orderProfile" method="post">
                              <input type="hidden" name="uid" value="${sessionScope.acc.id}">
                              <button type="submit" class="btn btn-outline-primary" style="margin-top: 8px">Đơn hàng của tôi</button>
                            </form>

                        </div>
                    </div>
                </div>

            </div>
            <div class="col-md-8">
                <div class="card mb-3">
                    <div class="card-body">
                        <div class="d-flex justify-content-center row">
                            <div class="col-md-10">
                                <div class="rounded">
                                    <div class="table-responsive table-borderless">
                                        <table class="table">
                                            <h4 style="font-size: 16px"><b>Mã đơn hàng: #${order.id}</b></h4>
                                            <h4 class="text-secondary" style="font-size: 16px"><b>Phương thức vận chuyển:</b> ${nameDelivery}</h4>
                                            <h4 class="text-secondary" style="font-size: 16px"><b>Phương thức thanh toán:</b> ${namePay}</h4>
                                            <div style="display: inline-block">
                                                <h4 class="text-secondary" style="font-size: 16px"><b>Trạng thái:</b></h4>
                                                <c:if test="${order.status == 1}">
                                                    <h4 style="font-size: 16px"><span class="badge badge-info">Chờ xác nhận</span></h4>
                                                </c:if>
                                                <c:if test="${order.status == 2}">
                                                    <h4 style="font-size: 16px"><span class="badge badge-warning">Chờ lấy hàng</span></h4>
                                                </c:if>
                                                <c:if test="${order.status == 3}">
                                                    <h4 style="font-size: 16px"><span class="badge badge-primary">Đang giao</span></h4>
                                                </c:if>
                                                <c:if test="${order.status == 4}">
                                                    <h4 style="font-size: 16px"><span class="badge badge-success">Đã giao</span></h4>
                                                </c:if>
                                                <c:if test="${order.status == 5}">
                                                    <h4 style="font-size: 16px"><span class="badge badge-danger">Đã hủy</span></h4>
                                                </c:if>

                                            </div>

                                            <thead>
                                            <tr>
                                                <th>Tên sản phẩm</th>
                                                <th>Số lượng</th>
                                                <th>Giá</th>
                                            </tr>
                                            </thead>
                                            <tbody class="table-body">
                                            <c:forEach items="${orderItems}" var="o">
                                                <tr class="cell-1">
                                                    <td>${o.product.name}</td>
                                                    <td>${o.quantity}</td>
                                                    <td>
                                                        <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${o.price}"/> đ
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            <tr class="cell-1">
                                                <td class="font-weight-bold">Phí vận chuyển</td>
                                                <td></td>
                                                <td class="font-weight-bold">
                                                    <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${fee}"/> đ
                                                </td>
                                            </tr>
                                            <tr class="cell-1">
                                                <td class="font-weight-bold">Tổng tiền</td>
                                                <td></td>
                                                <td class="font-weight-bold">
                                                    <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${order.totalPay}"/> đ
                                                </td>
                                            </tr>
                                            </tbody>

                                        </table>
                                        <c:if test="${order.status == 1}">
                                            <form action="deleteOrder" method="post">
                                                <input type="hidden" name="oid" value="${order.id}">
                                                <input type="hidden" name="uid" value="${sessionScope.acc.id}">
                                                <button type="submit" class="btn btn-danger" style="float: right">Hủy đơn hàng</button>
                                            </form>
                                        </c:if>
                                        <c:if test="${order.status == 3}">
                                            <form action="updateOrder" method="post">
                                                <input type="hidden" name="oid" value="${order.id}">
                                                <input type="hidden" name="uid" value="${sessionScope.acc.id}">
                                                <button type="submit" class="btn btn-success" style="float: right">Xác nhận đã giao</button>
                                            </form>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<!-- Modal -->


</div>

<!-- footer -->
<%@ include file="footer.jsp" %>
<!-- end footer -->

</body>
</html>