<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>客户管理</title>
</head>
<link rel="stylesheet" type="text/css" href="${BASE}/css/css.css" />
<link rel="stylesheet" type="text/css" href="${BASE}/css/component.css" />
<script src="${BASE}/js/jquery-1.8.3.js"></script>
<script src="${BASE}/js/jquery.ba-throttle-debounce.min.js"></script>
<script src="${BASE}/js/jquery.stickyheader.js"></script>
<body>
<h1 style="text-align: center;border-radius: 5px;">客户信息列表</h1>
<div class="component">
    <p><input type="button" onclick="creatAlabel();" id="btn_add" value="添&nbsp;加"></p>
<table>
    <thead>
     <tr>
         <th>客户名称</th>
         <th>联系人</th>
         <th>电话号码</th>
         <th>邮箱地址</th>
         <th>备注</th>
         <th>操作</th>
     </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customerList}">
        <tr>
            <td><a href="${BASE}/customer_show?id=${customer.id}&method=GET">${customer.name}</a></td>
            <td>${customer.contact}</td>
            <td>${customer.telephone}</td>
            <td>${customer.email}</td>
            <td>${customer.remark}</td>
            <td>
                <a href="${BASE}/customer_edit?id=${customer.id}&method=GET">编辑</a>
                <a href="${BASE}/customer_delete?id=${customer.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<script type="text/javascript">
   /* $(function(){

    });*/
    <%--function requestGetHtml() {--%>
        <%--var $aa = $('<a/>');--%>
        <%--$aa.html('新增客户信息');--%>
        <%--$('#btn_add').parent().append($aa);--%>
        <%--$aa.attr('href','${BASE}/customer_create');--%>
        <%--$aa.attr('target','_self');--%>
        <%--if(false) {--%>
            <%--$aa.get(0).click();--%>
        <%--}else {--%>
            <%--window.open($aa.attr('href'), $aa.attr('target'));--%>
        <%--}--%>
    <%--}--%>
    function creatAlabel(){
        var $a=$("<a/>");
        $a.attr('target','_self')
        $('#btn_label').parent().append($a);
        $a.attr("href","${BASE}/customer_create");
        $a.html('新增客户信息');
        window.open($a.attr('href'), $a.attr('target'));
    }
</script>
</body>
</html>