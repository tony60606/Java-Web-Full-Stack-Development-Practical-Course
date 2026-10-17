<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員登入</title>

<link rel = "stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>

	<%@ include file = "/common/header.jsp" %>
	<%@ include file = "/common/nav.jsp" %>
	
	<main class = "semantic-layout">
		<section>
			<h2>會員登入</h2>
			
			<!-- 顯示錯誤訊息 -->
			<c:if test="${not empty error}">
				<p style = "color : red">"${error}"</p>
			</c:if>
			
			<form action = "${pageContext.request.contextPath}/auth/login" method = "post">
				<div>
					帳號(Email)：<input type="email" name="email" value="${email}" required>
				</div>
				<div>
					密碼：<input type="password" name="password" required>
				</div>
				
				<button type="submit">登入</button>				
			</form>	
			<p>
				尚未註冊? <a href="${pageContext.request.contextPath}/auth/register">[ 前往註冊 ]</a>
			</p>
		</section>
	</main>
	
	<%@ include file = "/common/footer.jsp" %>

</body>
</html>