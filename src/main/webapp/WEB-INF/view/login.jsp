<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"/>
<head>
    <title>登录页面</title>
</head>
<style>
    *{
        margin: 0px;
        clear:both;
    }
    div{
        text-align: left;
    }
    body{
        background-image: url("${BASE}/images/hills.jpg");
        width:100%;
        height:100%;
        background-size:cover;
    }
    #login_window{
        width: 30%;
        height: 50%;
        background-color: white;
        border-radius: 10px;
        margin: 10% 18% 12% 55%;
        vertical-align: middle;
        text-align:center;
        float:right;
        box-shadow: 0px 0px 5px #666;
        min-width: 350px;
        min-height: 319px;
        display: table-cell;
    }
    #login_inner{
        border-radius: 10px;
        margin: 20px 30px;
    }
    #login_window #login_inner h2{
        font-family: "微软雅黑";
        float: left;
        margin: 5px 10px;
        font-weight: 100;
    }

    #login_window #login_inner  p input{
        float: left;
        width: 260px;
        height: 35px;
        margin-left:10px ;
    }

    #login_window #login_inner h3{
        line-height: 30px;
        padding-top: 10px;
        padding-left: 10px;
        font-family: "微软雅黑";
        font-size: 14px;
        font-weight: 100;
    }

    #login_window #login_inner h3 label{
        font-size: 10px;
        color: red;
        text-align: right;
        float: right;
        vertical-align: middle;
        padding-right: 40px;
        display: none;
    }
    #login_window #login_inner  p input{
        float: left;
        width: 300px;
        height: 35px;
        margin-left:10px ;
    }
    .btn{
    width: 360px;
    height: 35px;
    border: 0px;
    border-radius: 5px;
    background: #ED145B;
    font-size: 20px;
    color: #FFF;
    margin-top: 40px;
   }
</style>
<body>
<div id="login_window">
    <div id="login_inner">
        <h2>密码登录</h2>
            <form action="${BASE}/user_login" method="post">
                <h3>账号：<label id="error_name">账号错误</label></h3>
                <p><input type="text" value="" name="username"></p>
                <h3>密码：<label id="error_pwd"></label></h3>
                <p><input type="password" value="" name="password"></p>
                <p><input type="submit" class="btn" value="提&nbsp;&nbsp;&nbsp;交" ></p>
            </form>
    </div>
</div>
</body>
