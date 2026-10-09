<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢代辦事項</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

<h1>查詢代辦事項</h1>
<br>
<button type="button" onclick="Search()">查詢全部</button>
<br><br>
<div class = "tbox">
	<table border="1">
	    <tr>
	        <th>日期</th>
	        <th>代辦項目</th>
	        <th>事項內容</th>
	        <th>建立者</th>
	        <th>建立日期</th>
	        <th>修改者</th>
	        <th>修改日期</th>
	        <th>刪除者</th>
	        <th>刪除日期</th>
	    </tr>
	
	    <tbody id="todoList"></tbody>
	</table>
</div>

<p><a href ="To-do.jsp">回首頁</a></p>

<script>
    const contextPath = "${pageContext.request.contextPath}";
</script>

<script src="${pageContext.request.contextPath}/js/search.js"></script>


</body>
</html>