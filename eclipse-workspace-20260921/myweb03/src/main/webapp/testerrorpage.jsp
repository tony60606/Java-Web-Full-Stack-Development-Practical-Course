<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage = "Errorhandler.jsp" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>簡易計算器</h1>

<%
	//取得表單送過來的參數
	int a = Integer.parseInt(request.getParameter("a")) ;
	int b = Integer.parseInt(request.getParameter("b")) ;
	int c = a / b ;
%>

<h3><%= a %> / <%= b %> = <%= c %></h3>

</body>
</html>