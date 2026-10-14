<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri ="jakarta.tags.core"  %>
<%@ taglib prefix = "SQL" uri ="jakarta.tags.sql" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<!-- MySQL 8.0 以上版本的資料庫連接 com.mysql.cj.jdbc.Driver -->
<!-- MySQL 8.0 以上版本不需要建立 SSL 連接的，需要顯示關閉 -->
<!-- useUnicode=true&characterEncoding=utf-8 防止中文亂碼 -->
<SQL:setDataSource  var = "db"
					driver = "com.mysql.cj.jdbc.Driver"
					url = "jdbc:mysql://localhost:3306/sakila?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8" 
					user = "root"
					password = "zoobee00" />
<SQL:query var="result" dataSource="${db}">
	SELECT * FROM customer ;
</SQL:query>

<table border = "1" width = "100%">
	<tr>
		<th>ID</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
	</tr>
	<c:forEach var = "row" items = "${result.rows}">
		<tr>
			<td><c:out value = "${row.customer_id}"></c:out></td>
			<td><c:out value = "${row.first_name}"></c:out></td>
			<td><c:out value = "${row.last_name}"></c:out></td>
			<td><c:out value = "${row.email}"></c:out></td>
		</tr>
	</c:forEach>
</table>


</body>
</html>