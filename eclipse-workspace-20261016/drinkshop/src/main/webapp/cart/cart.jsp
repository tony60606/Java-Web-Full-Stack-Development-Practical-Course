<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購物車</title>
<link rel = "stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<style>
.cart-wrap {
	max-width: 100%;
	margin: 0 auto;
}

.cart-item {
	display: flex;
	gap: 12px;
	align-items: center;
	padding: 10px;
	border-bottom: 1px solid #eee;
}

.cart-item img {
	width: 60px;
	height: 60px;
	object-fit: cover;
	border-radius: 6px;
}

.cart-item .name {
	flex: 1;
}

.cart-item .price, .cart-item .subtotal {
	width: 120px;
	text-align: right;
}

.cart-item .qty {
	width: 90px;
}

.cart-actions {
	display: flex;
	gap: 10px;
	justify-content: flex-end;
	margin-top: 12px;
}

.total {
	text-align: right;
	font-size: 18px;
	font-weight: bold;
	margin-top: 12px;
}

button {
	cursor: pointer;
}
</style>

</head>
<body>

	<%@ include file = "/common/header.jsp" %>
	<%@ include file = "/common/nav.jsp" %>
	
	<main class = "semantic-layout">
		<section class = "cart-wrap">
			<h2>購物車</h2>
			<div id = "cart-list"></div>
		</section>
	</main>
	
	
	<%@ include file = "/common/footer.jsp" %>
</body>
</html>