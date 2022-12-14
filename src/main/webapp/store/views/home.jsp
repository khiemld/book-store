<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Site meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Bookstore</title>
    <link rel="shortcut icon" href="./store/icon/paper-plane.ico">
    <!-- CSS -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
    <link href="<c:url value = "./store/css/style.css" />" rel="stylesheet" type="text/css">
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
<%@ include file ="header.jsp" %>
<!-- end header -->

<div class="container">
    <div class="row">
        <div class="col">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="https://cdn0.fahasa.com/media/magentothem/banner7/Branday_mainbanner_Slide_840x320.jpg" alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="https://cdn0.fahasa.com/media/magentothem/banner7/Trangdochoi_mainbanner_840X320.jpg" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="https://cdn0.fahasa.com/media/magentothem/banner7/Trang_Manga-Comic_Mainbanner_T10_Slide_840x320.jpg" alt="Third slide">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
        <div class="col-12 col-md-3">

            <div class="card">
                <div class="card-header bg-success text-white text-uppercase">
                    <i class="fa fa-heart"></i> Top product
                </div>
                <img class="img-fluid border-0" src="${list1product.image}" alt="${list1product.name}">
                <div class="card-body">
                    <h4 class="card-title text-center"><a href="<%=request.getContextPath()%>/detail?pid=${list1product.id}" title="View Product">${list1product.name}</a></h4>
                    <div class="row">
                        <div class="col">
                            <p class="btn btn-danger btn-block">
                                <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${list1product.salePrice}"/> đ
                            </p>
                        </div>
<%--                        <div class="col">--%>
<%--                            <a href="product" class="btn btn-success btn-block">View</a>--%>
<%--                        </div>--%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

      
<div class="container mt-3">
    <div class="row">
        <div class="col-sm">
            <div class="card">
                <div class="card-header bg-primary text-white text-uppercase">
                    <i class="fa fa-star"></i> Last products
                </div>
                <div class="card-body">
                    <div class="row">
                        <c:forEach items ="${list4last}" var = "p">
                         <div class="col-sm">
                            <div class="card">
                                <img class="card-img-top" src="${p.image}" alt="${p.name}">
                                <div class="card-body">
                                    <h4 class="card-title web-kit-2"><a href="<%=request.getContextPath()%>/detail?pid=${p.id}" title="View Product">${p.name}</a></h4>
                                    <p class="card-text web-kit-3">${p.discription}</p>
                                    <div class="row">
                                        <div class="col">
                                            <p class="btn btn-danger btn-block">
                                                <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${p.salePrice}"/> đ
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer -->
<%@ include file="footer.jsp" %>
<!-- end footer -->
<!-- JS -->
<script src="//code.jquery.com/jquery-3.2.1.slim.min.js" type="text/javascript"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</body>
</html>
    