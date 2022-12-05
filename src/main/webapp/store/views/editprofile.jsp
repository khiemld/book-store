<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="reset-password" class="form-reset" method="post">
		    Old pass: <input type="password" name="opass">
		    New pass: <input type="password" name="pass">
		     <input name="user" value="${sessionScope.account.email}" class="form-control" required>
			<button class="btn btn-primary btn-block" type="submit">Reset Password</button>
			<a href="#" id="cancel_reset"><i class="fas fa-angle-left"></i> Back</a>
		</form>
</body>
</html>