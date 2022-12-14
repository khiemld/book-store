<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <!-- CSS -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
    <<<<<<< HEAD
    <link href="<c:url value ="/store/css/style.css" />" rel="stylesheet" type="text/css">
    <title>Your Profile</title>
    =======
    <link href="<c:url value = "/store/css/style.css" />" rel="stylesheet" type="text/css">
    <title>Insert title here</title>
    >>>>>>> e0668993a5a58b1fbedfe08033b1a1ab0e09b8ce
</head>
<body>
<!-- header -->
<%@ include file ="header.jsp" %>
<!-- end header -->

<div class="container" >
    <div class="main-body">
        <!-- Breadcrumb -->
        <nav aria-label="breadcrumb" class="main-breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item"><a href="javascript:void(0)">User</a></li>
                <li class="breadcrumb-item active" aria-current="page">User Profile</li>
            </ol>
        </nav>
        <!-- /Breadcrumb -->

        <div class="row gutters-sm">
            <div class="col-md-4 mb-3">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex flex-column align-items-center text-center">
                            <c:if test="${sessionScope.acc.image != null}">
                                <img src="${sessionScope.acc.image}" alt="Admin" class="rounded-circle" width="150">
                            </c:if>
                            <div class="mt-3">
                                <h4>${sessionScope.acc.email}</h4>
                                <c:if test="${sessionScope.acc.isRole == 1}">
                                    <p class="text-secondary mb-1">Admin</p>
                                </c:if>
                                <c:if test="${sessionScope.acc.isRole == 2}">
                                    <p class="text-secondary mb-1">Employee</p>
                                </c:if>
                                <c:if test="${sessionScope.acc.isRole == 3}">
                                    <p class="text-secondary mb-1">Customer</p>
                                </c:if>
                                <p class="text-muted font-size-sm">${sessionScope.acc.address}</p>
                                <button class="btn btn-primary">Follow</button>
                                <button class="btn btn-outline-primary">Message</button>
                            </div>
                            <form action="orderProfile" method="post">
                                <input type="hidden" name="uid" value="${sessionScope.acc.id}">
                                <button type="submit" class="btn btn-outline-primary" style="margin-top: 8px">Đơn hàng của tôi</button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-8">
                <c:if test="${not empty update_error}">
                    <div class="alert alert-danger">${update_error}</div>
                </c:if>
                <c:if test="${not empty message}">
                    <div class="alert alert-success">${message}</div>
                </c:if>
                <div class="card mb-3">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Full Name</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${sessionScope.acc.name}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Email</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${sessionScope.acc.email}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Phone</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${sessionScope.acc.phone}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Password</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${sessionScope.acc.password}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Address</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${sessionScope.acc.address}
                            </div>
                        </div>
                        <hr>
                        <hr>
                        <div class="row">
                            <div class="col-sm-12">
                                <a class="btn btn-info " data-toggle="modal" data-target="#editUser">Edit</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<!-- Modal -->

<div id="editUser" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="profile" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Profile</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>

                <div class="modal-body">
                    <div class="form-group">
                        <label>Full Name</label>
                        <input name="name" value="${sessionScope.acc.name}" type="text" class="form-control"
                               required>
                    </div>
                    <div class="form-group">
                        <label>Email:</label>
                        <input name="email" type="text" value="${sessionScope.acc.email}" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Phone</label>
                        <input name="phone" type="text" value="${sessionScope.acc.phone}" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Address</label>
                        <input name="address" value="${sessionScope.acc.address}" type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Avatar</label>
                        <c:if test="${sessionScope.acc.image != null}">
                            <input name="image" value="${sessionScope.acc.image}" type="image" class="form-control">
                        </c:if>
                        <c:if test="${sessionScope.acc.image == null}">
                            <input name="image" value="${sessionScope.acc.image}" type="image" class="form-control">
                        </c:if>
                        <input  name="image" type="file" id="fileImage" value="upload" accept="image/*">
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success" value="Edit">
                </div>
            </form>
        </div>
    </div>
</div>

<!-- footer -->
<%@ include file="footer.jsp" %>
<!-- end footer -->

</body>
</html>