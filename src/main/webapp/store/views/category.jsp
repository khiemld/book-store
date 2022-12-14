<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<!-- Site meta -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Free Bootstrap 4 Ecommerce Template</title>
	<link rel="shortcut icon" href="./store/icon/paper-plane.ico">

	<!-- CSS -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/store/css/style.css"/>" rel="stylesheet" type="text/css"/>"
<style>
	.web-kit-3{
		display: -webkit-box;
		-webkit-line-clamp: 3;
		-webkit-box-orient: vertical;
		overflow: hidden;
		text-overflow: ellipsis;
		word-break: break-all;
	}
	.web-kit-2{
		display: -webkit-box;
		-webkit-line-clamp: 1;
		-webkit-box-orient: vertical;
		overflow: hidden;
		text-overflow: ellipsis;
		word-break: break-all;
	}
</style>
</head>
<body>
	<!-- header -->
	<%@ include file="header.jsp"%>
	<!-- end header -->

	<div class="container">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="home">Home</a></li>
						<li class="breadcrumb-item"><a href="category?cid=0">Category</a></li>
						<li class="breadcrumb-item active" aria-current="page">Sub-category</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-12 col-sm-3">
				<div class="card bg-light mb-3">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-list"></i> Categories
					</div>
					<ul class="list-group category_block">
						<c:forEach items="${listCategory}" var="c">
							<li class="list-group-item ${tag == c.id ? "active":""}">
								<a href="category?cid=${c.id}">${c.name}</a>
							</li>
						</c:forEach>
					</ul>
				</div>
				<div class="card bg-light mb-3">
					<div class="card-header bg-success text-white text-uppercase">Last product</div>
					<div class="card-body">
						<img class="img-fluid" src="${lastProduct.image}" />
						<h5 class="card-title">${lastProduct.name}</h5>
						<p class="card-text web-kit-3">${lastProduct.discription}</p>
						<p class="bloc_left_price">
							<fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${lastProduct.salePrice}"/> đ
						</p>
					</div>
				</div>
			</div>
			<div class="col">
				<div id="content" class="row">
					<c:forEach items="${listProduct}" var="o">
						<div class="col-12 col-md-6 col-lg-4">
							<div class="card" style="margin-top: 32px">
								<img class="card-img-top" src="${o.image}"
									alt="${o.name}">
								<div class="card-body">
									<h4 class="card-title web-kit-2">
										<a href="detail?pid=${o.id}" title="View Product" style="font-size: 24px; word-break: break-all">${o.name}</a>
									</h4>
									<div class="web-kit-3">
										<p>${o.discription}</p>
									</div>
									<div class="row" style="margin-top: 8px">
										<div class="col">
											<p class="btn btn-danger btn-block">
												<fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${o.salePrice}"/> đ
											</p>
										</div>
										<%--<div class="col">
											<a href="cart?pid=${o.id}"
												class="btn btn-success btn-block">Add to cart</a>
										</div>--%>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					<div class="col-12">
						<nav aria-label="...">
							<ul class="pagination">
								<li class="page-item disabled"><a class="page-link"
									href="#" tabindex="-1">Previous</a></li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>
								<li class="page-item active"><a class="page-link" href="#">2
										<span class="sr-only">(current)</span>
								</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#">Next</a>
								</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
		function loadMore() {
			//var amount = document.getElementsByClassName("product").length;
			$.ajax({
				url : "/BanHang/load", //send to Controller
				type : "get", //send it through get method
				success : function(data) {
					//$("#content").append(data);
					var row = document.getElementsById("content");
					row.innerHTML +=data;
				},
				error : function(xhr) {
					//Do Something to handle error
				}
			});
		}

	</script>
	<!-- Footer -->
	<%@ include file="footer.jsp"%>
	<!-- end footer -->


	<!-- JS -->
	<script src="//code.jquery.com/jquery-3.2.1.slim.min.js"
		type="text/javascript"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		type="text/javascript"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		type="text/javascript"></script>

</body>
</html>
