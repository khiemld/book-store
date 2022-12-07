<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <!-- Site meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Free Bootstrap 4 Ecommerce Template</title>
    <!-- CSS -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
    <link href="<c:url value = "/store/css/style.css" />" rel="stylesheet" type="text/css">
</head>
<body>

<!-- header -->
<%@ include file ="header.jsp" %>
<!-- end header -->
<form action="order" method="get">
<div class="container mb-4">
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead >
                        <tr>
                            <th scope="col" style="vertical-align: middle">Stt</th>
                            <th scope="col" style="vertical-align: middle; max-width: 64px" class="text-center">Image</th>
                            <th scope="col-sm-4" style="vertical-align: middle">Product</th>
                            <th scope="col" style="vertical-align: middle">Quantity</th>
                            <th scope="col" class="text-center" style="vertical-align: middle">Price</th>
                            <th scope="col" style="vertical-align: middle">Delete</th>
                            <th scope="col" style="vertical-align: middle">Sub-total</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:set var="tt" value="0"/>
                    <c:forEach items="${listItem}" var="i">
                        <c:set var="tt" value="${tt+1}"/>
                        <tr>
                            <td>${tt}</td>
                            <td><img class ="col-4" src="${i.product.image}"></td>
                            <td>${i.product.name}</td>
                            <td>
                                <button style="border: none; display:inline; width: 20px; background-color:#4285f4"><a href="process?num=-1&id=${i.idProduct}&u=${i.idUser}" style="text-decoration: none; color: white" >-</a></button>
                                <%--<input type="number" value="${i.quantity}" min="1" max="10">--%>
                                ${i.quantity}
                                <button style="border: none; float: right; width: 30px; background-color:#4285f4"><a href="process?num=1&id=${i.idProduct}&u=${i.idUser}" style="text-decoration: none; color: white">+</a></button>
                            </td>
                            <td class="text-right">${i.product.salePrice}</td>
                            <td class="text-right">
                                <a class="btn btn-sm btn-danger btn-number" href="deleteCart?pid=${i.idProduct}&uid=${i.idUser}"  style="text-decoration: none; color: white"><i class="fa fa-trash" style="margin-right: 4px"></i>Delete</a></button>
                            </td>
                            <td>${i.price}</td>
                        </tr>
                    </c:forEach>
                        <tr>
                            <td>Temporary Cost</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td class="text-right">${total}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-sm-12  col-md-6">
            <button class="btn btn-block btn-light" href="category?cid=0"><a href="category?cid=0">Continue Shopping</a></button>
        </div>
        <div class="col-sm-12 col-md-6 text-right">
            <input type="hidden" name="uid" value="${sessionScope.acc.id}">
            <button type="submit" class="btn btn-lg btn-block btn-success text-uppercase">Checkout</button>
        </div>

    </div>
</div>
</form>
<div class="container mb-4">
    <div class="row">
        <div class="col-12">
            <form action="order">
                <div class="col mb-2">
                    <div class="row">

                    </div>

                </div>
            </form>
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

</body>
</html>
