<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Servlet 請求與回應</h1>
<p><a href = "HelloServlet">Hello Servlet(HelloServlet)</a></p>
<p><a href = "Hello.view">Hello Servlet(HelloServlet)</a></p>
<p><a href = "WebHello.view">Web Hello Servlet(HelloServlet)</a></p>
<p><a href = "WebHelloServlet.view">Web Hello Servlet(HelloServlet)</a></p>

<form action="SelectCourseServlet" method = "get">
	<h3>選取選修課程</h3>
	<select name = "course">
		<option>Java Web</option>
		<option>Python AI</option>
		<option>C# ASP.net</option>
		<option>php Web</option>
		<option>MySQL</option>
	</select>
	<p><button>送出</button></p>
</form>

<p><a href = "SelectCourseServlet?name=Java&version=21&item=Web">多個參數</a></p>

<p><a href = "SelectCourseServlet?name=Java&name=Python&name=SQL">參數帶多個值</a></p>

<p><a href = "LoadOtherServlet?type=pdf">下載 PDF 檔案</a></p>
<p><a href = "LoadOtherServlet?type=png">下載 PNG 檔案</a></p>
<hr>

<p><a href = "LifeSircleServlet">Servlet 生命週期</a></p>

</body>
</html>