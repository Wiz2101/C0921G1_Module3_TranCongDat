<%--
  Created by IntelliJ IDEA.
  User: tranc
  Date: 12/23/2021
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Currency Converter</h1>
<form action="/converter">
  <label>Rate:</label>
  <input type="text" name="rate" value="22000">
  <label>USD:</label>
  <input type="text" name="usd" placeholder="Enter Rate">
  <input type="submit" id="submit" value="converter">
</form>
</body>
</html>
