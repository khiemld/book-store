<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Trường Giang
  Date: 03-Dec-22
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<table id="example" class="table table-striped table-bordered" style="width:100%">
    <thead>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Address</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Password</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userList}" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.name}</td>
            <td>${u.address}</td>
            <td>${u.email}</td>
            <td>${u.phone}</td>
            <td>${u.password}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
