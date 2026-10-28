<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel = "stylesheet" href="${pageContext.request.contextPath}/css/main.css">

<header>
	<div>
		<h1>爪哇飲料專賣店</h1>
	</div>
	
	<!-- 已登入 歡迎 *** 登出 -->
	<c:if test="${not empty loginMember}">
		<span class = "welcome">
			歡迎：${loginMember.displayName} 
		</span>
		<form action="${pageContext.request.contextPath}/auth/logout" method = "post" style = "display:inline;">
		<button type = "submit" class = "btn logout-btn">登出</button>	
		</form>
	</c:if>
	
	<c:if test="${empty loginMember}">
		<a href = "${pageContext.request.contextPath}/auth/login" class = "btn login-btn">登入</a>
		|
		<a href = "${pageContext.request.contextPath}/auth/register" class = "btn register-btn">註冊</a>
	</c:if>
	
</header>