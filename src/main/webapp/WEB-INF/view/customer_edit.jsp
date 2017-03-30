<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>客户管理 - 编辑客户</title>
</head>

<br>

<h1>编辑客户界面</h1>
<a href="${BASE}/customer">后退</a>
</br>
<form action="${BASE}/customer_edit" method="post">

    <input type="hidden" name="id" value="${customer.id}">
    <table>
        <tr>
            <td>客户名称：</td>
            <td>
                <input type="text" name="name" value="${customer.name}">
            </td>
        </tr>
        <tr>
            <td>联系人：</td>
            <td>
                <input type="text" name="contact" value="${customer.contact}">
            </td>
        </tr>
        <tr>
            <td>电话号码：</td>
            <td>
                <input type="text" name="telephone" value="${customer.telephone}">
            </td>
        </tr>
        <tr>
            <td>邮箱地址：</td>
            <td>
                <input type="text" name="email" value="${customer.email}">
            </td>
        </tr>
    </table>
    <button type="submit">保存</button>
</form>


</body>
</html>