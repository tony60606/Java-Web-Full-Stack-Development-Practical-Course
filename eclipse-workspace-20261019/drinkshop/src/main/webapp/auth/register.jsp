<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員註冊</title>

<link rel = "stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>

	<%@ include file = "/common/header.jsp" %>
	<%@ include file = "/common/nav.jsp" %>
	
	<main class = "semantic-layout">
		<section>
			<h2>會員註冊</h2>
			
			<!-- 顯示錯誤訊息 -->
			<c:if test="${not empty error}">
				<p style = "color : red">"${error}"</p>
			</c:if>
			
			<!-- 註冊表單 -->
			<form action = "${pageContext.request.contextPath}/auth/register" method = "post">
				<div>
					帳號(Email)：<input type = "email" name = "email" value = "${email}" required maxlength="255" title = "請輸入正確Email格式">
				</div>
				<div>
					密碼：<input type = "password" name = "password" minlength="6" title = "密碼只少6碼">
				</div>
				<div>
					暱稱：<input type = "text" name = "displayname" value = "${displayname}" required maxlength="80" title = "暱稱不可超過80個字">
				</div>
				<div>
					電話：<input type = "tel" name = "phone" value = "${phone}" maxlength="30" pattern = "[0-9+\- ]*" title = "電話僅能包含數字、+、-、空白">
				</div>
				<button type = "submit">註冊</button>
			</form>
		
		</section>
	</main>

	<%@ include file = "/common/footer.jsp" %>
</body>
</html>