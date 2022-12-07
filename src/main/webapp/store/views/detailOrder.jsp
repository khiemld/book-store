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
        <div class="text-right"> <i class="fa fa-close close" data-dismiss="modal"></i> </div>

        <div class="px-4">

          <h5 class="text-uppercase">Jonathan Adler</h5>



          <h4 class="mt-5 theme-color">Thanks for your order</h4>

          <span class="theme-color">Payment Summary</span>
          <div class="mb-3">
            <hr class="new1">
          </div>

          <div class="d-flex justify-content-between">
            <span class="font-weight-bold">Ether Chair(Qty:1)</span>
            <span class="text-muted">$1750.00</span>
          </div>

          <div class="d-flex justify-content-between">
            <small>Shipping</small>
            <small>$175.00</small>
          </div>


          <div class="d-flex justify-content-between">
            <small>Tax</small>
            <small>$200.00</small>
          </div>

          <div class="d-flex justify-content-between mt-3">
            <span class="font-weight-bold">Total</span>
            <span class="font-weight-bold theme-color">${total}</span>
          </div>



          <div class="text-center mt-5">


            <button class="btn btn-primary">Track your order</button>



          </div>

        </div>


      </div>
    </div>
  </div>

</body>
</html>
