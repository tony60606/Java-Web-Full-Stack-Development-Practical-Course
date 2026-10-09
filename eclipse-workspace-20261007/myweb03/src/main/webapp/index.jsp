<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>JSP</h1>

<p><a href = "Hello.jsp">Hello JSP</a></p>
<p><a href = "directives.jsp">directives JSP</a></p>

<h3>指示元素 errorPage、isErrorPage</h3>
<div>
	<form action="testerrorpage.jsp" method="get">
		<p>a：<input type="text" name="a"></p>
		<p>b：<input type="text" name="b"></p>
		<p><button>計算</button></p>
	</form>
</div>

<hr>

<p><a href = "config.jsp">取出JSP初始化(configdemo.jsp+.web.xml)</a></p>

<p><a href = "scope_1.jsp">JSP可視範圍的物件操作(scope_1.jsp)</a></p>
<p><a href = "scope_2.jsp">JSP可視範圍的物件操作(scope_2.jsp)</a></p>

<fieldset>
	<legend>EL 運算式語言</legend>
	<form action="division.jsp" method="get">
		<p>a：<input type="text" name="a"></p>
		<p>b：<input type="text" name="b"></p>
		<p><button>計算</button></p>
	</form>
</fieldset>

<p><a href = "myELfunction.jsp">EL自訂函數(myELfunction.jsp)</a></p>

<fieldset>
	<legend>登入系統 (Login.jsp)</legend>
	<form action="Login.jsp" method="post">
		<p>帳號：<input type="text" name="username"></p>
		<p>密碼：<input type="password" name="password"></p>
		<button>登入</button>
	</form>
</fieldset>

<p><a href = "JSTLSQL.jsp">連線資料庫(JSTLSQL.jsp)</a></p>

</body>
</html>