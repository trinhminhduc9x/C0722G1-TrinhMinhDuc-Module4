<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Converter</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Translate</h2>
<form action="/save" method="post">
    <input name="name" type="checkbox" value="Lettuce">
    Lettuce
    <input name="name" type="checkbox" value="Tomato">
    Tomato
    <input name="name" type="checkbox" value="Mustard">
    Mustard
    <input name="name" type="checkbox" value="Sprouts">
    Sprouts
    <button type="submit" value="save">save</button>
</form>
<form>
    result :
    <c:forEach iteams="${name}" var="name">${name}</c:forEach>
</form>
</body>
</html>