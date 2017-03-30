<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"/>
<head>
    <title>客户管理 - 创建客户</title>
</head>
<script src="${BASE}/js/jquery-1.8.3.js"></script>
<body>
<h2 style="text-align:center;margin-top: 30px;">新增客户信息</h2>
<form id="customer_data" action="${BASE}/customer_create" method="post">
<table style="text-align:center;margin: 0 auto;border-color: black; ">
    <tr>
        <td style="text-align: right">客户名称:</td>
        <td style="text-align: left">
            <input type="text" name="name" value=""></td>
    </tr>
    <tr>
        <td style="text-align: right">联系人:</td>
        <td style="text-align: left"><input type="text" name="contact"  value=""></td>
    </tr>
    <tr>
        <td style="text-align: right">电话号码:</td>
        <td style="text-align: left"><input type="text" name="telephone" value=""></td>
    </tr>
    <tr>
        <td style="text-align: right">邮箱地址:</td>
        <td style="text-align: left"><input type="text" name="email"  value=""></td>
    </tr>
    <tr>
        <td style="text-align: right">备注:</td>
        <td style="text-align: left"><input type="text" name="remark" value=""></td>
    </tr>
    <tr>
        <td style="text-align:center;column-span:all;" colspan="2">
            <input type="submit"  value="提 交" style="border-radius:8px;margin-top: 15px;width:7.5em;height:3em;">
        </td>
    </tr>
</table>
</form>
</body>
