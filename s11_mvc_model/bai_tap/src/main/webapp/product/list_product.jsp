<%--
  Created by IntelliJ IDEA.
  User: tranc
  Date: 12/27/2021
  Time: 11:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">

<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Product Name</th>
        <th scope="col">Quality</th>
        <th scope="col">Price</th>
        <th scope="col">Description</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="productList" items="${productList}">
    <tr>
        <th scope="row">${productList.id}</th>
        <td>${productList.productName}</td>
        <td>${productList.quality}</td>
        <td>${productList.price}</td>
        <td>${productList.productDesc}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<a href="products?actionUser=create"><button class="btn btn-primary" type="submit">Create New Product</button></a>
<a href="products?actionUser=edit"><button class="btn btn-primary" type="submit">Edit the Product</button></a>
<a href="products?actionUser=delete"><button class="btn btn-primary" type="submit">Delete the Product</button></a>
</div>
</body>
</html>
