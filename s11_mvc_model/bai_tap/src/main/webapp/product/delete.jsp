<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting product</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back to Products list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <div class="form-group">
        <label>Product ID</label>
        <input type="text" class="form-control" name="id" placeholder="Enter Product ID">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>

</form>
</body>
</html>