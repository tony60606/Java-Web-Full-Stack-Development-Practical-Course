<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客戶資料查詢結果</title>
</head>
<body>

<!-- 將customer物件屬性取出顯示 -->

<fieldset>
	<legend>客戶資料</legend>
	<p>客戶編號：${customer.customerID}</p>
	<p>客戶名稱：${customer.firstName} - ${customer.lastName}</p>
	<p>客戶Email：${customer.email}</p>
</fieldset>

</body>
</html>