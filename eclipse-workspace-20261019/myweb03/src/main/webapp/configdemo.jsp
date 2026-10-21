<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>初始化參數</h1>
	<%
		//取出初始化參數
		//config => JSP內建物建，對應ServletConfig物件
		String company = config.getInitParameter("company") ;
	%>
	<h2>公司名稱：<%= company %></h2>
</body>
</html>