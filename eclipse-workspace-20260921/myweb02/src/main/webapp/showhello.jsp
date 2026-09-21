<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>這是showhello.jsp</h1>

<%
	// 區塊內可撰寫純Java語法
	// 取得表單中的請求參數 message
	String message = request.getParameter("message") ;
	// 使用 JSP 的隱含物件 out 輸出資料
	out.println("<h2>message：" + message + "</h2>") ;
	out.println("<hr>") ;
	//取出 request 的 attribute 的 result
	String result = (String)request.getAttribute("result") ;
	out.println("<h2>result：" + result + "</h2>") ;
	out.println("<hr>") ;
%>

</body>
</html>