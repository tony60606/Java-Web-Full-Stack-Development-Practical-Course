<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri="jakarta.tags.core" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>會員登入系統</h2>
	<c:if test = "$(not empty error)">
		<p style = "color : red">${error}</p>
	</c:if>
	
	<%-- 設定 attribute 內容 ：預設帳號密碼 --%>
	<c:set var = "userID" value= "admin"></c:set>
	<c:set var = "password" value= "1234"></c:set>
	
	<%-- EL 輸出預設帳號密碼 --%>
	<h3>${userid } ： ${userpw }</h3>
	
	<%-- JSTL 輸出  預設的帳號密碼 --%>
	<h3><c:out value = "${userID} : ${password}" ></c:out></h3>
	
	<hr>
	
	<h2>使用單向 c:if</h2>
	<c:if test="${param.username == userID && param.password == password}"><h3>單向：登入成功</h3></c:if>

	<hr>
	
	<h2>使用雙向 c:choose || c:when || c:otherwise</h2>
	<c:choose>
		<c:when test="${param.username == userID && param.password == password}">雙向：登入成功</c:when>
		<c:otherwise>雙向：登入失敗</c:otherwise>
	</c:choose>
	
	<hr>
	
	<%
		String[] myArray = new String[] {"Toyota","Honda","BMW","Mercedes-Benz","Ford","Tesla"} ;
		request.setAttribute("myArray", myArray) ;
	%>
	
	<h2>使用迴圈： c:forEach 取值</h2>
	<c:forEach var = "item" items = "${myArray}">
		<p>${item}</p>
	</c:forEach>
	
</body>
</html>