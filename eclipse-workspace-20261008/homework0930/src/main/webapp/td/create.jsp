<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增代辦事項</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

<h1>新增代辦事項</h1>

<form action="${pageContext.request.contextPath}/createqry" method="post">
	<p class = "formrow">
		<label>日期：</label>
		<input type="date" name="date" id="date" required>
	</p>
	<p class = "formrow">
		<label>代辦項目：</label>
		<input type = "text" name = "title" />
	</p>
	<p class = "formrow">
		<label>事項內容：</label>
		<textarea name = "content" rows="10" cols="100"></textarea>
	</p>
	<div class = "btn">
	<button type="submit">新增</button><button type="reset">取消</button>
	</div>
</form>

<p><a href ="To-do.jsp">回首頁</a></p>

<script src="${pageContext.request.contextPath}/js/create.js"></script>

</body>
</html>