<%--
  Created by IntelliJ IDEA.
  User: HAU TRAN
  Date: 12/12/2022
  Time: 8:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="./store/css/style3.css">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
          crossorigin="anonymous">
    <link href="<c:url value = "/store/css/style2.css" />"
          rel="stylesheet" type="text/css">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet"
          id="bootstrap-css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
    <title>Nhập OTP</title>
    <link rel="shortcut icon" href="./store/icon/paper-plane.ico">
</head>
<body>
<div class="container">
    <form action="forgot" method="post" class="form-enterOTP">
        <h2>Nhập mã OTP</h2>
        <div class="message">Đã gửi mã OTP qua email: ${resetEmail}</div>
        <div class="message">Kiểm tra và nhập mã vào ô phía dưới</div>
        <div class="forgot__button">
            <input id="inputOTP" name="inputOTP" class="forgot-input" placeholder="Enter OTP" required="" autofocus="">
            <p id="remindInputOTP" class="remind">Mã OTP không hợp lệ. Vui lòng kiểm tra và nhập lại.</p>
            <button name="action" value="checkOTP" class="btn btn-primary btn-block" type="submit" onclick="return isValidOTP(${otp});">Xác nhận</button>
        </div>
<%--        <a href="#" id="cancel_reset"><i class="fas fa-angle-left"></i> Back</a>--%>
    </form>
</div>

<script>
    function isValidOTP(otp){
        if(document.getElementById('inputOTP').value != otp){
            document.getElementById('remindInputOTP').style.visibility = 'visible';
            return false;
        }
        document.getElementById('remindInputOTP').style.visibility = 'hidden';
        return true;
    }
</script>
</body>
</html>
