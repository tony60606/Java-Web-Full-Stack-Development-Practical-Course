<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品列表</title>

<link rel = "stylesheet" href="css/main.css">
</head>
<body>

<%@ include file = "common/header.jsp" %>
<%@ include file = "common/nav.jsp" %>



<main class = "semantic-layout">
	<section>
		<h2>商品列表</h2>
		<c:if test = "${empty products}">
		</c:if>
		<c:if test="${not empty products}">
			<div class = "products">
				<c:forEach var = "p" items = "${products}">
					<article class = "product-card">
						<img src = "${pageContext.request.contextPath}/image/${p.sku}.png"
							 alt = "${p.name}"
							 class = "product-img">
						<h3>${p.name}</h3>
						<p>${p.description}</p>
						<p>價格：${p.price}</p>
						<p>庫存量：${p.stock}</p>
					</article>
				</c:forEach>
			</div>
		</c:if>
	</section>
</main>
	


<%@ include file = "common/footer.jsp" %>
</body>
</html>