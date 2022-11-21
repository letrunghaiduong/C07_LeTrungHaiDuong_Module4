<%--
  Created by IntelliJ IDEA.
  User: FPT
  Date: 11/21/2022
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Caculator</h1>
  <form action="" method="post">
    <span>
      <input type="number" name="number1" value="number1">
      <input type="number" name="number2" value="number2">
    </span>
    <br>
    <input type="submit" value="Addition(+)" name="calculation">
    <input type="submit" value="Subtraction(-)" name="calculation">
    <input type="submit" value="Multiplication(*)" name="calculation">
    <input type="submit" value="Division(/)" name="calculation">
  </form>
  <h3>${result}</h3>
  </body>
</html>
