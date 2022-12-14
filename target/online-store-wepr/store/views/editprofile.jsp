<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
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
	<title>Đổi mật khẩu</title>
	<link rel="shortcut icon" href="./store/icon/paper-plane.ico">
	<link rel="stylesheet" href=".\store\css\style3.css">
</head>
<body>
<%--	reset-container--%>
<div class="container">
	<form action="reset" class="form-reset" method="post">
		<h2 class="reset-title">ĐỔI MẬT KHẨU</h2>
		<%--		Nếu từ Forgot passowrd thì ẩn Input "Mật khẩu hiện tại"--%>
		<c:if test="${not empty emailReset}">
			<input name="emailReset" value="${emailReset}">
			<div class="">Đặt lại mật khẩu cho email: ${emailReset}</div>
		</c:if>

		<c:if test="${not empty acc}">
			<c:if test="${not empty error}">
				<div class="alert alert-danger">${error}</div>
			</c:if>
			<c:if test="${not empty message}">
				<div class="alert alert-success">${message}</div>
			</c:if>
			<label>Mật khẩu hiện tại: </label><input type="password" name="opass" autocomplete="off"> <br>
		</c:if>

		<label>Mật khẩu mới: </label><input type="password" name="npass" id="npass" required> <br>
		<label>Xác nhận mật khẩu: </label><input type="password" name="confirm-npass" id="confirm-npass" required> <br>
		<p id="remind" class="remind">Xác nhận mật khẩu không chính xác, vui lòng nhập lại.</p>
		<button class="btn btn-primary btn-block" type="submit" name="action" value="reset-password"
				onclick="return isValidConfirmPassoword();">
			Thay đổi
		</button> <br>
		<a href="home" id="cancel_reset"><i class="fas fa-angle-left"></i> Trở về</a> <br>
	</form>
</div>

<script>
	function isValidConfirmPassoword(){
		var npass = document.getElementById('npass').value;
		var cpass = document.getElementById('confirm-npass').value;

		if(npass != cpass){
			document.getElementById('remind').style.visibility = 'visible';
			return false;
		}
		document.getElementById('remind').style.visibility = 'hidden';
		return true;
	}
</script>
</body>
</html>