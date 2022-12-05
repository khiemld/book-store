<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
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
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
	<link href="<c:url value = "/store/css/register.css" />" rel="stylesheet" type="text/css">
	<title>Register Form</title>
</head>
<body>
<div id="logreg-forms">
	<div class="row">
		<div class="col">
			<c:if test="${not empty message}">
				<div class="alert alert-success">${message}</div>
			</c:if>
			<c:if test="${not empty error}">
				<div class="alert alert-danger">${error}</div>
			</c:if>
		</div>
	</div>

	<form class="form-signin" action="login" method="post">
		<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Sign in</h1>
		<div class="social-login">
			<button class="btn facebook-btn social-btn" type="button"><span><i class="fab fa-facebook-f"></i> Sign in with Facebook</span> </button>
			<button class="btn google-btn social-btn" type="button"><span><i class="fab fa-google-plus-g"></i> Sign in with Google+</span> </button>
		</div>
		<input name="user" type="text" class="form-control" placeholder="Email" style="margin-bottom: 8px">
		<input name="pass" type="password" class="form-control" placeholder="Password">

		<button class="btn btn-success btn-block" type="submit">
			<i class="fas fa-sign-in-alt"></i> Sign in
		</button>
		<a href="#" id="forgot_pswd">Forgot password?</a>
		<hr>
		<!-- <p>Don't have an account!</p>  -->
		<button class="btn btn-primary btn-block" type="button" id="btn-signup">
			<i class="fas fa-user-plus"></i> <a href="/register" style="display: inline-block; color: white">Sign up New Account</a>
		</button>
	</form>

	<form action="/reset" class="form-reset">
		<input type="email" id="resetEmail" class="form-control" placeholder="Email address" required="" autofocus="">
		<button class="btn btn-primary btn-block" type="submit">Reset Password</button>
		<a href="#" id="cancel_reset"><i class="fas fa-angle-left"></i> Back</a>
	</form>

	<form action="register" class="form-signup">
		<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Register</h1>
		<div class="form-group input-group" >
			<div class="input-group-prepend" >
				<span class="input-group-text"> <i class="fa fa-user"></i> </span>
			</div>
			<input name="" class="form-control" placeholder="Full name" type="text">
		</div> <!-- form-group// -->
		<div class="form-group input-group">
			<div class="input-group-prepend">
				<span class="input-group-text"> <i class="fa fa-building"></i> </span>
			</div>
			<input name="" class="form-control" placeholder="Address" type="text">
		</div> <!-- form-group end.// -->
		<div class="form-group input-group">
			<div class="input-group-prepend">
				<span class="input-group-text"> <i class="fa fa-phone"></i> </span>
			</div>
			<input name="" class="form-control" placeholder="Phone number" type="text">
		</div>
		<div class="form-group input-group">
			<div class="input-group-prepend">
				<span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
			</div>
			<input name="" class="form-control" placeholder="Email address" type="text">
		</div> <!-- form-group// -->
		<div class="form-group input-group">
			<div class="input-group-prepend">
				<span class="input-group-text"> <i class="fa fa-lock"></i> </span>
			</div>
			<input class="form-control" placeholder="Create password" type="password">
		</div> <!-- form-group// -->
		<div class="form-group input-group">
			<div class="input-group-prepend">
				<span class="input-group-text"> <i class="fa fa-lock"></i> </span>
			</div>
			<input class="form-control" placeholder="Repeat password" type="password">
		</div> <!-- form-group// -->
		<div class="form-group">
			<button type="submit" class="btn btn-primary btn-block"> Create Account  </button>
		</div> <!-- form-group// -->
		<p class="text-center">Have an account? <a href="">Log In</a> </p>
	</form>
	<br>

</div>
<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
<script>
	function toggleResetPswd(e){
		e.preventDefault();
		$('#logreg-forms .form-signin').toggle() // display:block or none
		$('#logreg-forms .form-reset').toggle() // display:block or none
	};

	function toggleSignUp(e){
		e.preventDefault();
		$('#logreg-forms .form-signin').toggle(); // display:block or none
		$('#logreg-forms .form-signup').toggle(); // display:block or none
	};

	$(()=>{
		// Login Register Form
		$('#logreg-forms #forgot_pswd').click(toggleResetPswd);
		$('#logreg-forms #cancel_reset').click(toggleResetPswd);
		$('#logreg-forms #btn-signup').click(toggleSignUp);
		$('#logreg-forms #cancel_signup').click(toggleSignUp);
	});
</script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</body>
</html>