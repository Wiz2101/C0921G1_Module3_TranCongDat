<%--
  Created by IntelliJ IDEA.
  User: tranc
  Date: 12/23/2021
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2><%=request.getAttribute("usd")%> USD convert into VND </h2>
<h2>with rate: <%=request.getAttribute("rate")%> is: <span style="color: indianred"><%=request.getAttribute("vnd")%> VND</span></h2>
</body>
</html>
