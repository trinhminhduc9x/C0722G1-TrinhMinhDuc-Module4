<%--
  Created by IntelliJ IDEA.
  User: Admint
  Date: 18/11/2022
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> chuyen doi tien</title>
</head>
<body>
<h2>chuyen doi tien</h2>
<form action="/convert">
    <label>Rate: </label><br/>
    <input type="number" name="rate" value="${rate}"/><br/>
    <label>USD: </label><br/>
    <input type="number" name="usd" value="${usd}"/><br/>
    <label>convert </label><br/>
    <input type="submit" value="convert"/><br/>
</form>
<label>VND:</label>
<input type="number" value="${vnd}">
</body>
</html>