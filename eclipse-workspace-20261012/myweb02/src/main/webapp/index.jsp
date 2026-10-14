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
	<hr>
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
	<hr>
	<p><a href = "SelectCourseServlet?name=Java&version=21&item=Web">多個參數</a></p>
	<hr>
	<p><a href = "SelectCourseServlet?name=Java&name=Python&name=SQL">參數帶多個值</a></p>
	<hr>
	<p><a href = "LoadOtherServlet?type=pdf">下載 PDF 檔案</a></p>
	<hr>
	<p><a href = "LoadOtherServlet?type=png">下載 PNG 檔案</a></p>
	<hr>
	<p><a href = "LifeSircleServlet">Servlet 生命週期</a></p>
	<hr>
	<p><a href = "ItemServlet">部屬具有初始化參數的Servlet(Web xml)</a></p>
	<hr>
	<p><a href = "CityServlet">部屬具有初始化參數的Servlet(@WebServlet)</a></p>
	<hr>
	<p><a href = "DepartmentParameterServle">Servlet init初始化 初始化參數提供其他Servlet使用</a></p>
	<hr>
	<p><a href = "GetDepartmentParameterServlet">取得ServletContext的資料(GetDepartmentParameterServle)</a></p>
	<hr>
	<p><a href = "GetContextParam">取得ContextParam的資料(GetContextParam)</a></p>
	<hr>
	<h3>RequestDispatcher介面應用</h3>
	<form action = "HelloControlServlet" method = "post">
		<p>請輸入您的資訊</p>
		<input type = "text" name = "message">
		<button>送出</button>
	</form>
	<hr>
	<h3>Filter 登入驗證</h3>
	<p><a href = "hr/hrpage.jsp">人事資料安全頁面</a></p>
	<p><a href = "login.jsp">系統登入(ValidController)</a></p>
</body>
</html>