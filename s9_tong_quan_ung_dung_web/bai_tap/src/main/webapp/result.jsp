<%--
  Created by IntelliJ IDEA.
  User: tranc
  Date: 12/23/2021
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2><%=request.getAttribute("productDescription")%> discounted <%=request.getAttribute("productDiscount")%>% is:</h2>
<h3>Discount Amount: <%=request.getAttribute("productPromotion")%> USD</h3>
<h3 style="color: indianred">The price after discount: <%=request.getAttribute("productDiscountPrice")%> USD</h3>
</body>
</html>
