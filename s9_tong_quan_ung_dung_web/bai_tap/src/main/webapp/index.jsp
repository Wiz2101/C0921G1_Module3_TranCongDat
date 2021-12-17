<%--
  Created by IntelliJ IDEA.
  User: tranc
  Date: 12/17/2021
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Product Discount</h1>
  <form action="/discount" method="post">
    <lable>Product Description</lable>
    <input type="text" name="description" placeholder="Description"/><br/>
    <lable>List Price</lable>
    <input type="text" name="price" placeholder="Price"/> <br/>
    <lable>Discount Rate</lable>
    <input type="text" name="discount" placeholder="Discount Rate"/><br/>
    <input type="submit" id="submit" value="Calculate"/>
  </form>

  </body>
</html>
