<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admint
  Date: 17/10/2022
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<form:form modelAttribute="MailBox" action="/mailbox/create" method="post">
    <table>
        <tr>
            <td>
                Languages :
            </td>
            <td>
                <form:input path="languages"/>
            </td>
        </tr>
        <tr>
            <td>Page size:</td>
            <td>
                <form:select path="page">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="25">25</form:option>
                    <form:option value="50">50</form:option>
                    <form:option value="100">100</form:option>
                </form:select>
            </td>
            <td>Emails per page</td>
        </tr>
        <tr>
            <td>Spams</td>
            <td>
                <form:radiobutton path="spams" value="1" label="True"></form:radiobutton>
                <form:radiobutton path="spams" value="0" label="False"></form:radiobutton>
            </td>
            <td>Enable spams filter</td>
        </tr>
        <tr>
            <td>
                Signature
            </td>
            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Create</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
