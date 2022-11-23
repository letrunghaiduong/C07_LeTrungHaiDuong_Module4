<%--
  Created by IntelliJ IDEA.
  User: FPT
  Date: 11/23/2022
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="forrm" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Setting</h2>

<form:form action="save" method="post" modelAttribute="email">
    <h4>Languages:
        <form:select path="languages">
            <form:option value="English">English</form:option>
            <form:option value="Vietnamese">Vietnamese</form:option>
            <form:option value="Japanese">Japanese</form:option>
            <form:option value="Chinese">Chinese</form:option>
        </form:select>
    </h4>
    <span>Page Size:</span><span>show</span>

    <form:select path="pageSize">
        <form:option value="5">5</form:option>
        <form:option value="10">10</form:option>
        <form:option value="15">15</form:option>
        <form:option value="25">25</form:option>
        <form:option value="50">50</form:option>
        <form:option value="100">100</form:option>
    </form:select><span>Email per page</span>
    <br>
    <span>Span filter:</span><form:checkbox path="spamsFilter" value="enableSpamsFilter" /> <span>Enable spams filter</span>
    <br>
    <span>Signature</span><form:textarea path="signature"/>
    <br>
    <form:button type="submit"> Update</form:button>
    <form:button type="reset"> Cancel</form:button>
</form:form>

</body>
</html>
