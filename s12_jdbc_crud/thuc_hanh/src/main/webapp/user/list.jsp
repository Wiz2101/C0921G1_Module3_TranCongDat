<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>

</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/users">Add New User</a>
    </h2>

    <form class="row g-3" method="get" action="/users">
        <div class="col-auto">
            <label class="visually-hidden">Country</label>
            <input type="text" name="country" class="form-control-plaintext" placeholder="Entry the Country">
        </div>
        <br>
        <div class="col-auto">
            <button type="submit" class="btn btn-primary mb-3" name="action" value="search">Search</button>
        </div>
    </form>
    <form action="/users">
        <select name="sort" class="custom-select">
            <option selected>Sort the list</option>
            <option value="ASC">Ascending Sort</option>
            <option value="DESC">Descending Sort</option>
        </select>
        <button type="submit" class="btn btn-primary mb-3" name="action" value="sort">Sort</button>
    </form>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">Edit</a>
                    <a href="/users?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script>
    $(document).ready(function(){
        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();

        // Select/Deselect checkboxes
        var checkbox = $('table tbody input[type="checkbox"]');
        $("#selectAll").click(function(){
            if(this.checked){
                checkbox.each(function(){
                    this.checked = true;
                });
            } else{
                checkbox.each(function(){
                    this.checked = false;
                });
            }
        });
        checkbox.click(function(){
            if(!this.checked){
                $("#selectAll").prop("checked", false);
            }
        });
    });
</script>
</body>
</html>