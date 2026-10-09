<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入頁面</title>

<link rel = "stylesheet" href = "css/style.css" type = "text/css">

</head>
<body>

<h1>歡迎使用代辦事項系統</h1>
<form action="Controller"  method = "post">
<div>登入帳號：</div>
<input type = "text" name = "username" required/>
<div>密碼：</div>
<input type = "text" name = "password" required/>
<br><br>
<div class = "btn">
<button type="submit">登入</button><button type="reset">取消</button>
</div>
</form>

</body>
</html>