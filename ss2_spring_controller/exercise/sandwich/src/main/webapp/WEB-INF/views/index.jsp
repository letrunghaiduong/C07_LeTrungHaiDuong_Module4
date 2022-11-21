<%--
  Created by IntelliJ IDEA.
  User: FPT
  Date: 11/21/2022
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
    <style>
        label{
            display: inline;
        }
    </style>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="" method="post">
    <lable><input type="checkbox" name="condiment" value="Lettuce">Lettuce</lable>
    <lable><input type="checkbox" name="condiment" value="Tomato">Tomato</lable>
    <lable><input type="checkbox" name="condiment" value="Mustard">Mustard</lable>
    <lable><input type="checkbox" name="condiment" value="Sprouts">Sprouts</lable>
    <input type="submit" value="SAVE">
</form>
<h1>${condimentList}</h1>
</body>
</html>
