<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 設定是否處理例外，要搭配errorpage使用 --%>
<%@ page isErrorPage = "true"  %> <%-- isErrorPage要設定true,才可以存取隱含物件 exception --%>

<%@ page import = "java.io.PrintWriter" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.center-img {
		display : block ; /*將圖片設定成區塊，才能使margin置中*/
		width : 50% ;
		margin-left : auto ;
		margin-right: auto ;  
	}
</style>

</head>
<body>

<img src = "images/Error.jpg" alt = "Error" class="center-img">  

<hr>

<h3>網頁錯誤</h3>
<%= exception %>
<hr>
<h3>錯誤訊息</h3>
<%= exception.getMessage() %>
<hr>
<h3>詳細訊息</h3>
<% exception.printStackTrace(new PrintWriter(out)) ; %>

<p><a href="/myweb03/index.jsp">[ 回首頁 ]</a></p>

</body>
</html>