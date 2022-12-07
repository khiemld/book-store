<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
	<a class="navbar-brand" href="#">Navbar</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">

			<li class="nav-item active"><a class="nav-link" href="home">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="category?cid=0">Product</a>
			</li>
			<%--<c:if test="${sessionScope.account.role == 'ADMIN' }">
				<li class="nav-item"><a class="nav-link" href="#">Management
						role</a></li>
			</c:if>
			<c:if test="${sessionScope.account.role == 'SELLER' }">
				<li class="nav-item"><a class="nav-link" href="#">Seller
						role</a></li>
			</c:if>--%>
			<li class="nav-item"><a class="nav-link" href="contact">Contact</a></li>
		</ul>

		<form action="login" method="post" class="form-inline my-2 my-lg-0">
			<c:if test="${sessionScope.acc == null}">
				<li class="nav-item" style='margin-right: 16px; list-style: none'>
					<a aria-haspopup="true" aria-expanded="false" style='font-size: 16px; color: white' href="login"> Sign in | Sign up
					</a>
				</li>
			</c:if>
			<c:if test="${sessionScope.acc != null}">
				<li class="nav-item dropdown" style="list-style: none">
					<a aria-haspopup="true" aria-expanded="false" style='font-size: 16px; color: white' href="#">${sessionScope.acc.name}</a>
					<a class="fa fa-fw fa-user"
					href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"
					style='font-size: 32px; color: #28A745;'></a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown"
						style="float: right;">
						<a class="dropdown-item " href="<%=request.getContextPath()%>/profile">Your profile</a>
						<a class="dropdown-item " href="<%=request.getContextPath()%>/reset">Reset Password</a>
						<a class="dropdown-item " href="logout">Logout</a>
					</div></li>
			</c:if>
		</form>
		<form action="search" method="post" class="form-inline my-2 my-lg-0">
			<div class="input-group input-group-sm">
				<input value="${txtSearch}" name="txt" type="text" class="form-control">
				<div class="input-group-append">
					<button type="submit" class="btn btn-secondary btn-number">
						<i class="fa fa-search"></i>
					</button>
				</div>
			</div>
		</form>
		<form class="form-inline my-2 my-lg-0">
			<a class="btn btn-success btn-sm ml-3" href="cart"> <i
				class="fa fa-shopping-cart"></i>Cart <span class="badge badge-light">3</span>
			</a>
		</form>

	</div>
</nav>
<section class="jumbotron text-center">
	<div class="container">
		<h1 class="jumbotron-heading">E-COMMERCE BOOTSTRAP THEME</h1>
		<p class="lead text-muted mb-0">Simple theme for e-commerce buid
			with Bootstrap 4.0.0. Pages available : home, category, product, cart
			& contact</p>
	</div>
</section>