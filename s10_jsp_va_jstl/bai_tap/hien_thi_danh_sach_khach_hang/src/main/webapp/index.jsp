<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="text-center">DANH SÁCH KHÁCH HÀNG</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Date of Birth</th>
            <th scope="col">Gender</th>
            <th scope="col">Address</th>
            <th scope="col">Avatar</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customerList}" varStatus="idList">
            <tr>
                <td>${idList.count}</td>
                <td><c:out value="${customer.name}"/></td>
                <td><c:out value="${customer.dOB}"/></td>
                <td>
                    <c:if test="${customer.gender == 0}">Female</c:if>
                    <c:if test="${customer.gender == 1}">Male</c:if>
                </td>
                <td><c:out value="${customer.address}"/></td>
                <td><img width="40px" src="${customer.img}" alt="avatar"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
