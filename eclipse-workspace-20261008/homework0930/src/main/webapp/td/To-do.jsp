<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>代辦事項系統</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

<h1>歡迎使用代辦事項系統</h1>

<h2>請選擇要使用的服務</h2>

<nav>
	<a href = "create.jsp">新增代辦事項</a>
	<a href = "search.jsp">查詢代辦事項</a>	
	<a href = "update.jsp">修改代辦事項</a>
	<a href = "delete.jsp">刪除代辦事項</a>
	<a href = "#" onclick = "logout(); return false;">登出</a>
</nav>


<script>
    const contextPath = "${pageContext.request.contextPath}";
</script>

<script src ="${pageContext.request.contextPath}/js/jsstyle.js"></script>


</body>
</html>