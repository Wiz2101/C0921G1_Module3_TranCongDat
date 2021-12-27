<%--
  Created by IntelliJ IDEA.
  User: tranc
  Date: 12/27/2021
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back to Products list</a>
</p>
<form method="post">
    <div class="form-group">
        <label>Product ID</label>
        <input type="text" class="form-control" name="id" placeholder="Enter Product ID">
    </div>
    <div class="form-group">
        <label>Product Name</label>
        <input type="text" class="form-control" name="productName" placeholder="Enter Product Name">
    </div>
    <div class="form-group">
        <label>Quality</label>
        <input type="text" class="form-control" name="quality" placeholder="Enter Quality">
    </div>
    <div class="form-group">
        <label>Product Price</label>
        <input type="text" class="form-control" name="productPrice" placeholder="Enter Product Price">
    </div>
    <div class="form-group">
        <label>Product Description</label>
        <input type="text" class="form-control" name="productDesc" placeholder="Enter Product Description">
    </div>


    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>

