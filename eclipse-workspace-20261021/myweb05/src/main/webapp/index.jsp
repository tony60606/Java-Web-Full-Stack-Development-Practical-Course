<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>RESTful Web Service</h1>
<p><a href = "http://localhost:8080/myweb05/v1/Hello/helloworld">端點一：基本無參數服務</a></p>
<p><a href = "http://localhost:8080/myweb05/v1/Hello/hihello?w=Tony">端點二：使用 Query String (查詢字串) 傳遞參數</a></p>
<p><a href = "http://localhost:8080/myweb05/v1/Hello/hihello?w=">端點二：使用 Query String (查詢字串) 傳遞參數</a></p>
<p><a href = "http://localhost:8080/myweb05/v1/Hello/webhello/大寶/rawdate">端點三：使用 Path(動態路徑/路徑參數) 傳遞參數</a></p>
<p><a href = "products_all.html">查詢所有產品</a></p>
<p><a href="product_qryid.html">產品編號查詢 (product_qryid.html)</a></p>
</body>
</html>