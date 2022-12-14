<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 07/12/2022
  Time: 2:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Detail Order</title>
  <link rel="shortcut icon" href="./store/icon/paper-plane.ico">

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js" rel="stylesheet" type="text/css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" rel="stylesheet" type="text/css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="<c:url value = "/store/css/detailOrder.css" />" rel="stylesheet" type="text/css">
</head>
<body>
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body ">

        <div class="px-4">

          <h5 class="text-uppercase">${sessionScope.acc.name} #${oid}</h5>

          <h4 class="theme-color">Đặt hàng thành công</h4>

          <%--<c:forEach items="${listOrder}" var="i">
            <div style="display: inline-block">
              <small>${i.product.name} x ${i.quantity}</small>
              <small>${i.price}</small>
            </div>
          </c:forEach>--%>
            <div>
                <small style="display: block">Tên: ${name}</small>
                <small style="display: block">Địa chỉ: ${address}</small>
                <small style="display: block">Điện thoại: ${phone}</small>
                <%--<small>Ngày đặt: ${orderDate}</small>--%>
            </div>


<%--          <small>Ngày giao dự kiến: ${recieveDate}</small>--%>

          <div class="mb-3">
            <hr class="new1">
          </div>

          <div class="d-flex justify-content-between">
            <span class="font-weight-bold">Tổng tiền</span>
            <span class="text-muted">
                <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${total}"/> đ
            </span>
          </div>

          <div class="d-flex justify-content-between">
            <small>Tiền sách</small>
            <small>
                <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${sum}"/> đ
            </small>
          </div>

          <div class="d-flex justify-content-between">
            <small>Vận chuyển</small>
            <small>
                <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${fee}"/> đ
            </small>
          </div>

          <div class="d-flex justify-content-between mt-3">
            <span class="font-weight-bold theme-color">${nameDelivery}</span>
          </div>
          <div class="d-flex justify-content-between mt-3">
            <span class="font-weight-bold theme-color">${namePay}</span>
          </div>


          <div class="text-center mt-5">
            <a class="btn btn-primary" href="showDetail?oid=${oid}">Theo dõi đơn hàng</a>
          </div>

        </div>
      </div>
    </div>
  </div>

</body>
</html>
