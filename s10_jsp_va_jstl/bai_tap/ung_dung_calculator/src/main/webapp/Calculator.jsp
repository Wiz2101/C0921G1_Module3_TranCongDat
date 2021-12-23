<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        label {
            margin: 10px 0;
        }

        form {
            width: 100%;
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }

        .form-control {
            position: relative;
            box-sizing: border-box;
            height: auto;
            padding: 10px;
            font-size: 16px;
        }


    </style>
</head>
<body>
<h1>Simple Calculator</h1>
<form class="form-control text-center" action="/calculator" method="post">
    <label class="mt-2 fw-bold">First operand:</label>
    <input class="form-control" type="text" name="firstOperand" placeholder="Enter the number">
    <br>
    <label class="mt-2 fw-bold">Operator:</label>
    <select name="operator" id="operand">
        <option value="+">Add</option>
        <option value="-">Minus</option>
        <option value="*">Multiple</option>
        <option value="/">Divide</option>
    </select>
    <br>
    <label class="mt-2 fw-bold">Second operand:</label>
    <input class="form-control" type="text" name="secondOperand" placeholder="Enter the number">
    <br>
    <input class="form-control mt-4 calculate" type="submit" value="Calculate" onclick="change_visibility()">
</form>

<h2 id="result">The result
    of: <%=request.getAttribute("firstOperand")%> <%=request.getAttribute("operand")%> <%=request.getAttribute("secondOperand")%>
    = <span style="color: #cd5c5c"><%=request.getAttribute("result")%></span></h2>

</body>
</html>
