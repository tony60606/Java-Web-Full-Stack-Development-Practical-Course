<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>scope_2.jsp</h1>

<fieldset>
	<legend>
		讀取page scope資料
	</legend>
	<p>使用表達式pageContext的company： <%= pageContext.getAttribute("company") %></p>
	<P>使用EL pageScope.company：${pageScope.company}</P>
</fieldset>
<fieldset>
	<legend>
		讀取request scope資料
	</legend>
	<p>使用表達式request的company：<%= request.getAttribute("company") %></p>
	<P>使用EL requestScope.company：${requestScope.company}</P>
	
</fieldset>
<fieldset>
	<legend>
		讀取session scope資料
	</legend>
	<p>使用表達式session的company：<%= session.getAttribute("company") %></p>
	<P>使用EL sessionScope.company：${sessionScope.company}</P>
</fieldset>
<fieldset>
	<legend>
		讀取application scope資料
	</legend>
	<p>使用表達式applicationn的company：<%= application.getAttribute("company") %></p>
	<P>使用EL applicationScope.company：${applicationScope.company}</P>
</fieldset>

<p><a href = "index.jsp">回首頁</a></p>


</body>
</html>