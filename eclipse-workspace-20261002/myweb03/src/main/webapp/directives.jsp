<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 指示元素 <%@ %> --%> 
<%-- <%@ page %> --%> 
<%-- info:設定JSP基本頁面，可以使用Servlet的getServletInfo()取得 --%>
<%@ page info = "這是JSP網頁，由pcSchool設計" %>

<%-- import 引用套件 --%>
<%@ page import = "java.util.ArrayList , java.util.Arrays" %>   
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<%-- <%@include：告知容器，包括指定的JSP頁面 --%>
<%@ include file = "WEB-INF/jspf/menu.jspf" %>

<h1>@ page directives 指示元素directives</h1>

<p>取出info：<%= this.getServletInfo() %></p>

<%
	//宣告Array.list集合
	ArrayList<String> list = new ArrayList(Arrays.asList("Java","Python")) ;
	list.add(1,"MSQL") ;
%>

<h3><%= list %></h3>

<% for (String a : list) { %>
	<p><%= a %></p>
<% } %>


</body>

</html>