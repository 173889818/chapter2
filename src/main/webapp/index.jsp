

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   /* String path = request.getServerName()+":"+request.getServerPort()+request.getRequestURI()+"user_login";
     System.out.print(path);*/
   // request.getRequestDispatcher("/user_login").forward(request,response);
    response.sendRedirect(request.getRequestURI()+"user_login");
%>
