<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ page import = "com.sample.modal.Customer" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 建立Customer物件 ： 等同於Java語法 Customer customer = new Customer() -->
<jsp:useBean id="customer" class = "com.sample.modal.Customer"></jsp:useBean>

<jsp:setProperty property="*" name="customer"/>

<fieldset>
	<legend>客戶資料</legend>
	<p>客戶編號：${customer.customerID}</p>
	<p>客戶名稱：${customer.firstName} - ${customer.lastName}</p>
	<p>客戶Email：${customer.email}</p>
</fieldset>
</body>
</html>